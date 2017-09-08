create or replace package MS101 is
	/**
    * [概 要]:仕入先マスタ(登録)
    * [説 明]:仕入先マスタ(登録)のデータ検索、更新、削除処理など行う
    * [備 考]:
    * 著作権:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author Liu
    * @version 1.0
    * @since 1.0
    */
	/**
    * [概 要]:仕入先マスタ(登録)のデータ検索処理の作成
    * [説 明]:入力された条件より検索SQLの作成
    */
	procedure search
	(
		wn_co_no             in M_EA600_MD_SHIIRE.CO_NO%type, --会社NO
		wv_shiire_saki_cd    in M_EA600_MD_SHIIRE.SHIIRESAKICD%type, --仕入先コード
		wc_cur_ret           out SYS_REFCURSOR --レコードリスト
	);
	/**
    * [概 要]:仕入先マスタ(登録)の追加処理
    * [説 明]:入力値をDBに追加を行う
    */
	procedure insertData
	(
		wn_co_no            in M_EA124_SIIRE.CO_NO%type, --会社NO
		wv_siire_cd         in M_EA124_SIIRE.SIIRE_CD%type, --仕入先コード
		wv_siire_nm1        in M_EA124_SIIRE.SIIRE_NM1%type, --仕入先名１
		wv_siire_nm2        in M_EA124_SIIRE.SIIRE_NM2%type, --仕入先名２
		wv_siire_zip1       in M_EA124_SIIRE.SIIRE_ZIP%type, --仕入先郵便番号１
		wv_siire_zip2       in M_EA124_SIIRE.SIIRE_ZIP%type, --仕入先郵便番号２
		wv_siire_addr1      in M_EA124_SIIRE.SIIRE_ADDR1%type, --仕入先住所１
		wv_siire_addr2      in M_EA124_SIIRE.SIIRE_Addr2%type, --仕入先住所２
		wv_siire_addr3      in M_EA124_SIIRE.SIIRE_Addr3%type, --仕入先住所３
		wv_siire_tel        in M_EA124_SIIRE.SIIRE_TEL%type, --仕入先電話番号
		wv_siire_fax        in M_EA124_SIIRE.SIIRE_FAX%type, --仕入先FAX
		wv_siire_tanto_nm   in M_EA124_SIIRE.SIIRE_TANTO_NM%type, --仕入先担当者名
		wv_siire_tanto_mail in M_EA124_SIIRE.SIIRE_TANTO_MAIL%type, --仕入先担当者メールアドレス
		wn_user_no          in M_EA124_SIIRE.MAKE_USER%type --ユーザコード
	);
	/**
    * [概 要]:仕入先マスタ(登録)の更新処理
    * [説 明]:入力値をDBに更新を行う
    */
	procedure updateData
	(
		wn_co_no                    in M_EA600_MD_SHIIRE.CO_NO%type, --会社NO
		wv_shiire_saki_cd           in M_EA600_MD_SHIIRE.SHIIRESAKICD%type, --仕入先コード
		wv_shiire_saki_nm           in M_EA600_MD_SHIIRE.SHIIRESAKINM%type, --仕入先名１
		wv_shiire_saki_sn_nm        in M_EA600_MD_SHIIRE.SHIIRESAKI_SN_NM%type, --仕入先名２
		wv_mainuser_nm              in M_EA600_MD_SHIIRE.MAINUSERNM%type, --代表者名
		wv_manager_nm               in M_EA600_MD_SHIIRE.MANAGERNM%type, --仕入先担当者名
		wv_shiire_saki_nm_kana      in M_EA600_MD_SHIIRE.SHIIRESAKINMKANA%type, --仕入先名（カナ
		wn_disp_flg                 in M_EA600_MD_SHIIRE.DISP_FLG%type, --表示フラグ
		wn_user_no                  in M_EA600_MD_SHIIRE.MAKE_USER%type --ユーザコード
	);
	/**
    * [概 要]:仕入先マスタ(登録)の更新処理
    * [説 明]:入力値をDBから倫理削除を行う
    */
	procedure deleteData
	(
			wn_co_no    in M_EA124_SIIRE.CO_NO%type, --会社NO
			wv_siire_cd in M_EA124_SIIRE.SIIRE_CD%type, --仕入先コード
			wn_user_no  in M_EA124_SIIRE.MAKE_USER%type --ユーザコード
	);

	/**
    * [概 要]:仕入先マスタ（登録）の仕入先コード存在チェック
    * [説 明]:仕入先コード条件より、存在件数を取得
    * [備 考]:
    */
	procedure checkSiireCdExists
	(
		wn_co_no    in M_EA124_SIIRE.CO_NO%type, --会社no
		wv_siire_cd in M_EA124_SIIRE.SIIRE_CD%type, --分類コード
		wn_out_cnt  out number
	);

end MS101;
/
create or replace package body MS101 is
	/**
    * [概 要]:仕入先マスタ(登録)
    * [説 明]:仕入先マスタ(登録)のデータ検索、更新、削除処理など行う
    * [備 考]:
    * 著作権:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author Liu
    * @version 1.0
    * @since 1.0
    */
	/**
    * [概 要]:仕入先マスタ(登録)のデータ検索処理の作成
    * [説 明]:入力された条件より検索SQLの作成
    */
	procedure search
	(
		wn_co_no             in M_EA600_MD_SHIIRE.CO_NO%type, --会社NO
		wv_shiire_saki_cd    in M_EA600_MD_SHIIRE.SHIIRESAKICD%type, --仕入先コード
		wc_cur_ret           out SYS_REFCURSOR --レコードリスト
	) is
	begin
		open wc_cur_ret for
			select MB.SHIIRESAKICD
				  ,MB.EFFECTIVEDT
				  ,MB.INEFFECTIVEDT
				  ,MB.CHOAITOCD
				  ,MB.SHIIRESAKINM
				  ,MB.SHIIRESAKINMKANA
				  ,MB.SHIIRESAKI_SN_NM
				  ,MB.MAINUSERNM
				  ,MB.MANAGERNM
				  ,MB.BUSHOMEI
				  ,MB.POSTNO
				  ,MB.ADR
				  ,MB.TELNO
				  ,MB.FAXNO
				  ,MB.TORIHIKISTARTDT
				  ,MB.TORIHIKIENDDT
				  ,MA.DISP_FLG
				  ,MB.EXCL_CNT
			 from M_EA124_SIIRE MA, M_EA600_MD_SHIIRE MB
			 where MA.SIIRE_CD = MB.SHIIRESAKICD and MA.CO_NO = MB.CO_NO
			   and MA.SIIRE_CD = wv_shiire_saki_cd
			   and MA.CO_NO = wn_co_no;
	
	exception
		when others then
			DEBUG_LOG('MS101.search', '0', sqlerrm);
			raise;
	end search;
	/**
    * [概 要]:仕入先マスタ(登録)の追加処理
    * [説 明]:入力値をDBに追加を行う
    */
	procedure insertData
	(
		wn_co_no            in M_EA124_SIIRE.CO_NO%type, --会社NO
		wv_siire_cd         in M_EA124_SIIRE.SIIRE_CD%type, --仕入先コード
		wv_siire_nm1        in M_EA124_SIIRE.SIIRE_NM1%type, --仕入先名１
		wv_siire_nm2        in M_EA124_SIIRE.SIIRE_NM2%type, --仕入先名２
		wv_siire_zip1       in M_EA124_SIIRE.SIIRE_ZIP%type, --仕入先郵便番号１
		wv_siire_zip2       in M_EA124_SIIRE.SIIRE_ZIP%type, --仕入先郵便番号２
		wv_siire_addr1      in M_EA124_SIIRE.SIIRE_ADDR1%type, --仕入先住所１
		wv_siire_addr2      in M_EA124_SIIRE.SIIRE_Addr2%type, --仕入先住所２
		wv_siire_addr3      in M_EA124_SIIRE.SIIRE_Addr3%type, --仕入先住所３
		wv_siire_tel        in M_EA124_SIIRE.SIIRE_TEL%type, --仕入先電話番号
		wv_siire_fax        in M_EA124_SIIRE.SIIRE_FAX%type, --仕入先FAX
		wv_siire_tanto_nm   in M_EA124_SIIRE.SIIRE_TANTO_NM%type, --仕入先担当者名
		wv_siire_tanto_mail in M_EA124_SIIRE.SIIRE_TANTO_MAIL%type, --仕入先担当者メールアドレス
		wn_user_no          in M_EA124_SIIRE.MAKE_USER%type --ユーザコード
	) is
		ln_no_sort number(9) := 0;
		--NO_SORTのMAX取得
		cursor cur_sort_max is
			select max(NO_SORT) NO_SORT
			  from M_EA124_SIIRE
			 where CO_NO = wn_co_no
			   and DISP_FLG = 0;
	
	begin
		for l_data in cur_sort_max loop
			ln_no_sort := l_data.NO_SORT;
		end loop;
		if (ln_no_sort is null) then
			ln_no_sort := 0;
		end if;
		insert into M_EA124_SIIRE
			(CO_NO
			,SIIRE_CD
			,SIIRE_NM1
			,SIIRE_NM2
			,SIIRE_ZIP
			,SIIRE_ADDR1
			,SIIRE_ADDR2
			,SIIRE_ADDR3
			,SIIRE_TEL
			,SIIRE_FAX
			,SIIRE_TANTO_NM
			,NO_SORT
			,SIIRE_TANTO_MAIL
			,EXCL_CNT
			,DISP_FLG
			,MAKE_DATE
			,MAKE_USER
			,REP_DATE
			,REP_USER)
		values
			(wn_co_no
			,wv_siire_cd
			,replace(wv_siire_nm1, '''', '’')
			,replace(wv_siire_nm2, '''', '’')
			,wv_siire_zip1 || '-' || wv_siire_zip2
			,replace(wv_siire_addr1, '''', '’')
			,replace(wv_siire_addr2, '''', '’')
			,replace(wv_siire_addr3, '''', '’')
			,wv_siire_tel
			,wv_siire_fax
			,replace(wv_siire_tanto_nm, '''', '’')
			,ln_no_sort + 1
			,wv_siire_tanto_mail
			,1
			,0
			,sysdate
			,wn_user_no
			,sysdate
			,wn_user_no);
	
	exception
		when others then
			DEBUG_LOG('MS101.insertData', '0', sqlerrm);
			raise;
	end insertData;
	/**
    * [概 要]:仕入先マスタ(登録)の更新処理
    * [説 明]:入力値をDBに更新を行う
    */
  procedure updateData
	(
		wn_co_no                    in M_EA600_MD_SHIIRE.CO_NO%type, --会社NO
		wv_shiire_saki_cd           in M_EA600_MD_SHIIRE.SHIIRESAKICD%type, --仕入先コード
		wv_shiire_saki_nm           in M_EA600_MD_SHIIRE.SHIIRESAKINM%type, --仕入先名１
		wv_shiire_saki_sn_nm        in M_EA600_MD_SHIIRE.SHIIRESAKI_SN_NM%type, --仕入先名２
		wv_mainuser_nm              in M_EA600_MD_SHIIRE.MAINUSERNM%type, --代表者名
		wv_manager_nm               in M_EA600_MD_SHIIRE.MANAGERNM%type, --仕入先担当者名
		wv_shiire_saki_nm_kana      in M_EA600_MD_SHIIRE.SHIIRESAKINMKANA%type, --仕入先名（カナ
		wn_disp_flg                 in M_EA600_MD_SHIIRE.DISP_FLG%type, --表示フラグ
		wn_user_no                  in M_EA600_MD_SHIIRE.MAKE_USER%type --ユーザコード
	) is
	begin
		update M_EA124_SIIRE
		   set SIIRE_NM1        = wv_shiire_saki_nm
			  ,SIIRE_NM2        = wv_shiire_saki_sn_nm
			  ,SIIRE_TANTO_NM   = wv_manager_nm
			  ,DISP_FLG         = wn_disp_flg
			  ,EXCL_CNT         = EXCL_CNT + 1
			  ,REP_USER         = wn_user_no
			  ,REP_DATE         = sysdate
		 where CO_NO = wn_co_no
		   and SIIRE_CD = wv_shiire_saki_cd;
		update M_EA600_MD_SHIIRE
		   set SHIIRESAKINM   = wv_shiire_saki_nm
			  ,SHIIRESAKI_SN_NM = wv_shiire_saki_sn_nm
			  ,MAINUSERNM       = wv_mainuser_nm
			  ,MANAGERNM        = wv_manager_nm
			  ,SHIIRESAKINMKANA = wv_shiire_saki_nm_kana
			  ,EXCL_CNT         = EXCL_CNT + 1
			  ,REP_USER         = wn_user_no
			  ,REP_DATE         = sysdate
		 where CO_NO = wn_co_no
		   and SHIIRESAKICD = wv_shiire_saki_cd;  
	exception
		when others then
			DEBUG_LOG('MS101.updateData', '0', sqlerrm);
			raise;
	end updateData;
	/**
    * [概 要]:仕入先マスタ(登録)の更新処理
    * [説 明]:入力値をDBから倫理削除を行う
    */
	procedure deleteData
	(
		wn_co_no    in M_EA124_SIIRE.CO_NO%type, --会社NO
		wv_siire_cd in M_EA124_SIIRE.SIIRE_CD%type, --仕入先コード
		wn_user_no  in M_EA124_SIIRE.MAKE_USER%type --ユーザコード
	) is
	begin
		update M_EA124_SIIRE
		   set DISP_FLG = 1
			  ,EXCL_CNT = EXCL_CNT + 1
			  ,REP_USER = wn_user_no
			  ,REP_DATE = sysdate
		 where CO_NO = wn_co_no
		   and SIIRE_CD = wv_siire_cd;
	exception
		when others then
			DEBUG_LOG('MS101.deleteData', '0', sqlerrm);
			raise;
	end deleteData;

	/**
    * [概 要]:仕入先マスタ（登録）の仕入先コード存在チェック
    * [説 明]:仕入先コード条件より、存在件数を取得
    * [備 考]:
    */
	procedure checkSiireCdExists
	(
		wn_co_no    in M_EA124_SIIRE.CO_NO%type, --会社no
		wv_siire_cd in M_EA124_SIIRE.SIIRE_CD%type, --分類コード
		wn_out_cnt  out number
	) is
		--件数
		ln_count number default 0;
		cursor cur_siire is
			select count(1) COUNTNUM
			  from M_EA124_SIIRE
			 where CO_NO = wn_co_no
			   and SIIRE_CD = wv_siire_cd
			--and DISP_FLG = 0 -- 仕入先CDは再利用出来ないため、論理削除されたCDもチェック対象にする
			;
	begin
		for lc_data in cur_siire loop
			ln_count := lc_data.COUNTNUM;
		end loop;
		wn_out_cnt := ln_count;
	
	exception
		when others then
			DEBUG_LOG('MS101.checkSiireCdExists', '0', sqlerrm);
			raise;
	end checkSiireCdExists;

end MS101;
/
