create or replace package MS100 is
	/**
    * [概 要]:仕入先マスタ(一覧)
    * [説 明]:仕入先マスタ(一覧)のデータ検索、更新処理など行う
    * [備 考]:
    * 著作権:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author Liu
    * @version 1.0
    * @since 1.0
    */
	/**
    * [概 要]:仕入先マスタ(一覧)のデータ検索処理の作成
    * [説 明]:入力された条件より検索SQLの作成
    */
	procedure search
	(
		wn_co_no          in M_EA124_SIIRE.CO_NO%type, --会社NO
		wv_siire_cd       in M_EA124_SIIRE.SIIRE_CD%type, --仕入れコード
		wv_siire_nm       in M_EA124_SIIRE.SIIRE_NM1%type, --仕入れ名
		wv_disp_flg       in M_EA124_SIIRE.DISP_FLG%type, --表示フラグ
		wn_page           in number, -- 当ページ
		wn_page_size      in number, -- ページごとレコード数
		wc_out_ret        out page_feed.REFCURSOR, -- 結果リスト
		wn_out_total_cnt  out number, -- 抽出データ数
		wn_out_total_page out number -- ページカウント
	);
	/**
    * [概 要]:仕入先マスタ(一覧)のデータ更新処理の作成
    * [説 明]:ソート順の更新を行う
    */
	procedure sortUpdate
	(
		wn_co_no         in M_EA124_SIIRE.CO_NO%type, --会社NO
		wv_siire_cd_moto in M_EA124_SIIRE.SIIRE_CD%type, --元仕入れコード
		wv_siire_cd_chg  in M_EA124_SIIRE.SIIRE_CD%type, --変更仕入れコード
		wn_user_no       in M_EA124_SIIRE.REP_USER%type --ユーザNO
	);

end MS100;
/
create or replace package body MS100 is
	/**
    * [概 要]:仕入先マスタ(一覧)
    * [説 明]:仕入先マスタ(一覧)のデータ検索、更新処理など行う
    * [備 考]:
    * 著作権:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author Liu
    * @version 1.0
    * @since 1.0
    */
	/**
    * [概 要]:仕入先マスタ(一覧)のデータ検索処理の作成
    * [説 明]:入力された条件より検索SQLの作成
    */
	procedure search
	(
		wn_co_no          in M_EA124_SIIRE.CO_NO%type, --会社NO
		wv_siire_cd       in M_EA124_SIIRE.SIIRE_CD%type, --仕入れコード
		wv_siire_nm       in M_EA124_SIIRE.SIIRE_NM1%type, --仕入れ名
		wv_disp_flg       in M_EA124_SIIRE.DISP_FLG%type, --表示フラグ
		wn_page           in number, -- 当ページ
		wn_page_size      in number, -- ページごとレコード数
		wc_out_ret        out page_feed.REFCURSOR, -- 結果リスト
		wn_out_total_cnt  out number, -- 抽出データ数
		wn_out_total_page out number -- ページカウント
	) is
		--動的SQL
		--SQL格納エリア
		lv_SQL_AREA  varchar2(13000);
		lv_SQL_FROM  varchar2(2000);
		lv_SQL_WHERE varchar2(10000);
		lv_SQL_ORDER varchar2(100);
	begin
		--動的ＳＱＬの作成
		lv_SQL_AREA := 'SELECT M_EA124.SIIRE_CD ,
					  M_EA124.SIIRE_NM1 ,
					  M_EA124.SIIRE_ADDR1 ,
					  M_EA124.SIIRE_ADDR2 ,
					  M_EA124.SIIRE_ADDR3 ,
					  M_EA124.SIIRE_TEL ,
					  M_EA124.SIIRE_TANTO_NM ,
					  M_EA124.NO_SORT ,
					  M_EA124.DISP_FLG ,
					  row_number() over(order by M_EA124.NO_SORT,M_EA124.SIIRE_CD) ROW_NO,
					  lead(M_EA124.SIIRE_CD) over(order by M_EA124.NO_SORT,M_EA124.SIIRE_CD) NEXT_SIIRE_CD,
					  lag(M_EA124.SIIRE_CD) over(order by M_EA124.NO_SORT,M_EA124.SIIRE_CD) PREV_SIIRE_CD ';

		lv_SQL_FROM := '  FROM M_EA124_SIIRE M_EA124 ';

		lv_SQL_WHERE := 'WHERE M_EA124.CO_NO = ' || wn_co_no;

		--仕入先CD
		if wv_siire_cd is not null then
			lv_SQL_WHERE := lv_SQL_WHERE || ' AND M_EA124.SIIRE_CD ' || COMMON.sql_escape(wv_siire_cd, 2);
		end if;

		--仕入先名
		if wv_siire_nm is not null then
			lv_SQL_WHERE := lv_SQL_WHERE || ' AND M_EA124.SIIRE_NM1 ' || COMMON.sql_escape(wv_siire_nm, 1);
		end if;
    
	--表示フラグ
		if wv_disp_flg is not null then
			lv_SQL_WHERE := lv_SQL_WHERE || ' AND M_EA124.DISP_FLG = ' || wv_disp_flg;
		end if;

		lv_SQL_ORDER := ' ORDER BY M_EA124.NO_SORT ASC ';

		--ＳＱＬ文作成
		lv_SQL_AREA := lv_SQL_AREA || lv_SQL_FROM || lv_SQL_WHERE || lv_SQL_ORDER;


		page_feed.turn_page(wcur_rec      => wc_out_ret,
							wv_sql        => lv_SQL_AREA,
							wn_now_page   => wn_page,
							wn_page_size  => wn_page_size,
							wn_record_cnt => wn_out_total_cnt,
							wn_total_page => wn_out_total_page);

	exception
		when others then
			DEBUG_LOG('MS100.search', '0', lv_SQL_AREA);
			DEBUG_LOG('MS100.search', '0', sqlerrm);
			raise;

	end search;
	/**
    * [概 要]:仕入先マスタ(一覧)のデータ更新処理の作成
    * [説 明]:ソート順の更新を行う
    */
	procedure sortUpdate
	(
		wn_co_no         in M_EA124_SIIRE.CO_NO%type, --会社NO
		wv_siire_cd_moto in M_EA124_SIIRE.SIIRE_CD%type, --元仕入れコード
		wv_siire_cd_chg  in M_EA124_SIIRE.SIIRE_CD%type, --変更仕入れコード
		wn_user_no       in M_EA124_SIIRE.REP_USER%type --ユーザNO
	) is
		ln_moto_sort_no number := 0;
		ln_chg_sort_no  number := 0;
		--元NO_SORT
		cursor cur_moto_sort is
			select NO_SORT
			  from M_EA124_SIIRE
			 where SIIRE_CD = wv_siire_cd_moto
			   and CO_NO = wn_co_no
			   and DISP_FLG = 0;

		--変更NO_SORT
		cursor cur_chg_sort is
			select NO_SORT
			  from M_EA124_SIIRE
			 where SIIRE_CD = wv_siire_cd_chg
			   and CO_NO = wn_co_no
			   and DISP_FLG = 0;
	begin
		--元NO_SORT取得
		for l_data in cur_moto_sort loop
			ln_moto_sort_no := l_data.NO_SORT;
		end loop;

		--変更NO_SORT取得
		for l_data in cur_chg_sort loop
			ln_chg_sort_no := l_data.NO_SORT;
		end loop;

		--変更NO_SORTを元の仕入コードに更新
		update M_EA124_SIIRE
		   set NO_SORT  = ln_chg_sort_no
			  ,EXCL_CNT = EXCL_CNT + 1
			  ,REP_DATE = sysdate
			  ,REP_USER = wn_user_no
		 where SIIRE_CD = wv_siire_cd_moto
		   and CO_NO = wn_co_no
		   and DISP_FLG = 0;

		--元NO_SORTを変更の仕入コードに更新
		update M_EA124_SIIRE
		   set NO_SORT  = ln_moto_sort_no
			  ,EXCL_CNT = EXCL_CNT + 1
			  ,REP_DATE = sysdate
			  ,REP_USER = wn_user_no
		 where SIIRE_CD = wv_siire_cd_chg
		   and CO_NO = wn_co_no
		   and DISP_FLG = 0;

	exception
		when others then
			DEBUG_LOG('MS100.sortUpdate', '0', sqlerrm);
			raise;

	end sortUpdate;
end MS100;
/
