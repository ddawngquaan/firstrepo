create or replace package MS100 is
	/**
    * [�T �v]:�d����}�X�^(�ꗗ)
    * [�� ��]:�d����}�X�^(�ꗗ)�̃f�[�^�����A�X�V�����ȂǍs��
    * [�� �l]:
    * ���쌠:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author Liu
    * @version 1.0
    * @since 1.0
    */
	/**
    * [�T �v]:�d����}�X�^(�ꗗ)�̃f�[�^���������̍쐬
    * [�� ��]:���͂��ꂽ������茟��SQL�̍쐬
    */
	procedure search
	(
		wn_co_no          in M_EA124_SIIRE.CO_NO%type, --���NO
		wv_siire_cd       in M_EA124_SIIRE.SIIRE_CD%type, --�d����R�[�h
		wv_siire_nm       in M_EA124_SIIRE.SIIRE_NM1%type, --�d���ꖼ
		wv_disp_flg       in M_EA124_SIIRE.DISP_FLG%type, --�\���t���O
		wn_page           in number, -- ���y�[�W
		wn_page_size      in number, -- �y�[�W���ƃ��R�[�h��
		wc_out_ret        out page_feed.REFCURSOR, -- ���ʃ��X�g
		wn_out_total_cnt  out number, -- ���o�f�[�^��
		wn_out_total_page out number -- �y�[�W�J�E���g
	);
	/**
    * [�T �v]:�d����}�X�^(�ꗗ)�̃f�[�^�X�V�����̍쐬
    * [�� ��]:�\�[�g���̍X�V���s��
    */
	procedure sortUpdate
	(
		wn_co_no         in M_EA124_SIIRE.CO_NO%type, --���NO
		wv_siire_cd_moto in M_EA124_SIIRE.SIIRE_CD%type, --���d����R�[�h
		wv_siire_cd_chg  in M_EA124_SIIRE.SIIRE_CD%type, --�ύX�d����R�[�h
		wn_user_no       in M_EA124_SIIRE.REP_USER%type --���[�UNO
	);

end MS100;
/
create or replace package body MS100 is
	/**
    * [�T �v]:�d����}�X�^(�ꗗ)
    * [�� ��]:�d����}�X�^(�ꗗ)�̃f�[�^�����A�X�V�����ȂǍs��
    * [�� �l]:
    * ���쌠:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author Liu
    * @version 1.0
    * @since 1.0
    */
	/**
    * [�T �v]:�d����}�X�^(�ꗗ)�̃f�[�^���������̍쐬
    * [�� ��]:���͂��ꂽ������茟��SQL�̍쐬
    */
	procedure search
	(
		wn_co_no          in M_EA124_SIIRE.CO_NO%type, --���NO
		wv_siire_cd       in M_EA124_SIIRE.SIIRE_CD%type, --�d����R�[�h
		wv_siire_nm       in M_EA124_SIIRE.SIIRE_NM1%type, --�d���ꖼ
		wv_disp_flg       in M_EA124_SIIRE.DISP_FLG%type, --�\���t���O
		wn_page           in number, -- ���y�[�W
		wn_page_size      in number, -- �y�[�W���ƃ��R�[�h��
		wc_out_ret        out page_feed.REFCURSOR, -- ���ʃ��X�g
		wn_out_total_cnt  out number, -- ���o�f�[�^��
		wn_out_total_page out number -- �y�[�W�J�E���g
	) is
		--���ISQL
		--SQL�i�[�G���A
		lv_SQL_AREA  varchar2(13000);
		lv_SQL_FROM  varchar2(2000);
		lv_SQL_WHERE varchar2(10000);
		lv_SQL_ORDER varchar2(100);
	begin
		--���I�r�p�k�̍쐬
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

		--�d����CD
		if wv_siire_cd is not null then
			lv_SQL_WHERE := lv_SQL_WHERE || ' AND M_EA124.SIIRE_CD ' || COMMON.sql_escape(wv_siire_cd, 2);
		end if;

		--�d���於
		if wv_siire_nm is not null then
			lv_SQL_WHERE := lv_SQL_WHERE || ' AND M_EA124.SIIRE_NM1 ' || COMMON.sql_escape(wv_siire_nm, 1);
		end if;
    
	--�\���t���O
		if wv_disp_flg is not null then
			lv_SQL_WHERE := lv_SQL_WHERE || ' AND M_EA124.DISP_FLG = ' || wv_disp_flg;
		end if;

		lv_SQL_ORDER := ' ORDER BY M_EA124.NO_SORT ASC ';

		--�r�p�k���쐬
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
    * [�T �v]:�d����}�X�^(�ꗗ)�̃f�[�^�X�V�����̍쐬
    * [�� ��]:�\�[�g���̍X�V���s��
    */
	procedure sortUpdate
	(
		wn_co_no         in M_EA124_SIIRE.CO_NO%type, --���NO
		wv_siire_cd_moto in M_EA124_SIIRE.SIIRE_CD%type, --���d����R�[�h
		wv_siire_cd_chg  in M_EA124_SIIRE.SIIRE_CD%type, --�ύX�d����R�[�h
		wn_user_no       in M_EA124_SIIRE.REP_USER%type --���[�UNO
	) is
		ln_moto_sort_no number := 0;
		ln_chg_sort_no  number := 0;
		--��NO_SORT
		cursor cur_moto_sort is
			select NO_SORT
			  from M_EA124_SIIRE
			 where SIIRE_CD = wv_siire_cd_moto
			   and CO_NO = wn_co_no
			   and DISP_FLG = 0;

		--�ύXNO_SORT
		cursor cur_chg_sort is
			select NO_SORT
			  from M_EA124_SIIRE
			 where SIIRE_CD = wv_siire_cd_chg
			   and CO_NO = wn_co_no
			   and DISP_FLG = 0;
	begin
		--��NO_SORT�擾
		for l_data in cur_moto_sort loop
			ln_moto_sort_no := l_data.NO_SORT;
		end loop;

		--�ύXNO_SORT�擾
		for l_data in cur_chg_sort loop
			ln_chg_sort_no := l_data.NO_SORT;
		end loop;

		--�ύXNO_SORT�����̎d���R�[�h�ɍX�V
		update M_EA124_SIIRE
		   set NO_SORT  = ln_chg_sort_no
			  ,EXCL_CNT = EXCL_CNT + 1
			  ,REP_DATE = sysdate
			  ,REP_USER = wn_user_no
		 where SIIRE_CD = wv_siire_cd_moto
		   and CO_NO = wn_co_no
		   and DISP_FLG = 0;

		--��NO_SORT��ύX�̎d���R�[�h�ɍX�V
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
