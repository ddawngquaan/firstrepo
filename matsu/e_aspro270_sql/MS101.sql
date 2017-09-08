create or replace package MS101 is
	/**
    * [�T �v]:�d����}�X�^(�o�^)
    * [�� ��]:�d����}�X�^(�o�^)�̃f�[�^�����A�X�V�A�폜�����ȂǍs��
    * [�� �l]:
    * ���쌠:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author Liu
    * @version 1.0
    * @since 1.0
    */
	/**
    * [�T �v]:�d����}�X�^(�o�^)�̃f�[�^���������̍쐬
    * [�� ��]:���͂��ꂽ������茟��SQL�̍쐬
    */
	procedure search
	(
		wn_co_no             in M_EA600_MD_SHIIRE.CO_NO%type, --���NO
		wv_shiire_saki_cd    in M_EA600_MD_SHIIRE.SHIIRESAKICD%type, --�d����R�[�h
		wc_cur_ret           out SYS_REFCURSOR --���R�[�h���X�g
	);
	/**
    * [�T �v]:�d����}�X�^(�o�^)�̒ǉ�����
    * [�� ��]:���͒l��DB�ɒǉ����s��
    */
	procedure insertData
	(
		wn_co_no            in M_EA124_SIIRE.CO_NO%type, --���NO
		wv_siire_cd         in M_EA124_SIIRE.SIIRE_CD%type, --�d����R�[�h
		wv_siire_nm1        in M_EA124_SIIRE.SIIRE_NM1%type, --�d���於�P
		wv_siire_nm2        in M_EA124_SIIRE.SIIRE_NM2%type, --�d���於�Q
		wv_siire_zip1       in M_EA124_SIIRE.SIIRE_ZIP%type, --�d����X�֔ԍ��P
		wv_siire_zip2       in M_EA124_SIIRE.SIIRE_ZIP%type, --�d����X�֔ԍ��Q
		wv_siire_addr1      in M_EA124_SIIRE.SIIRE_ADDR1%type, --�d����Z���P
		wv_siire_addr2      in M_EA124_SIIRE.SIIRE_Addr2%type, --�d����Z���Q
		wv_siire_addr3      in M_EA124_SIIRE.SIIRE_Addr3%type, --�d����Z���R
		wv_siire_tel        in M_EA124_SIIRE.SIIRE_TEL%type, --�d����d�b�ԍ�
		wv_siire_fax        in M_EA124_SIIRE.SIIRE_FAX%type, --�d����FAX
		wv_siire_tanto_nm   in M_EA124_SIIRE.SIIRE_TANTO_NM%type, --�d����S���Җ�
		wv_siire_tanto_mail in M_EA124_SIIRE.SIIRE_TANTO_MAIL%type, --�d����S���҃��[���A�h���X
		wn_user_no          in M_EA124_SIIRE.MAKE_USER%type --���[�U�R�[�h
	);
	/**
    * [�T �v]:�d����}�X�^(�o�^)�̍X�V����
    * [�� ��]:���͒l��DB�ɍX�V���s��
    */
	procedure updateData
	(
		wn_co_no                    in M_EA600_MD_SHIIRE.CO_NO%type, --���NO
		wv_shiire_saki_cd           in M_EA600_MD_SHIIRE.SHIIRESAKICD%type, --�d����R�[�h
		wv_shiire_saki_nm           in M_EA600_MD_SHIIRE.SHIIRESAKINM%type, --�d���於�P
		wv_shiire_saki_sn_nm        in M_EA600_MD_SHIIRE.SHIIRESAKI_SN_NM%type, --�d���於�Q
		wv_mainuser_nm              in M_EA600_MD_SHIIRE.MAINUSERNM%type, --��\�Җ�
		wv_manager_nm               in M_EA600_MD_SHIIRE.MANAGERNM%type, --�d����S���Җ�
		wv_shiire_saki_nm_kana      in M_EA600_MD_SHIIRE.SHIIRESAKINMKANA%type, --�d���於�i�J�i
		wn_disp_flg                 in M_EA600_MD_SHIIRE.DISP_FLG%type, --�\���t���O
		wn_user_no                  in M_EA600_MD_SHIIRE.MAKE_USER%type --���[�U�R�[�h
	);
	/**
    * [�T �v]:�d����}�X�^(�o�^)�̍X�V����
    * [�� ��]:���͒l��DB����ϗ��폜���s��
    */
	procedure deleteData
	(
			wn_co_no    in M_EA124_SIIRE.CO_NO%type, --���NO
			wv_siire_cd in M_EA124_SIIRE.SIIRE_CD%type, --�d����R�[�h
			wn_user_no  in M_EA124_SIIRE.MAKE_USER%type --���[�U�R�[�h
	);

	/**
    * [�T �v]:�d����}�X�^�i�o�^�j�̎d����R�[�h���݃`�F�b�N
    * [�� ��]:�d����R�[�h�������A���݌������擾
    * [�� �l]:
    */
	procedure checkSiireCdExists
	(
		wn_co_no    in M_EA124_SIIRE.CO_NO%type, --���no
		wv_siire_cd in M_EA124_SIIRE.SIIRE_CD%type, --���ރR�[�h
		wn_out_cnt  out number
	);

end MS101;
/
create or replace package body MS101 is
	/**
    * [�T �v]:�d����}�X�^(�o�^)
    * [�� ��]:�d����}�X�^(�o�^)�̃f�[�^�����A�X�V�A�폜�����ȂǍs��
    * [�� �l]:
    * ���쌠:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author Liu
    * @version 1.0
    * @since 1.0
    */
	/**
    * [�T �v]:�d����}�X�^(�o�^)�̃f�[�^���������̍쐬
    * [�� ��]:���͂��ꂽ������茟��SQL�̍쐬
    */
	procedure search
	(
		wn_co_no             in M_EA600_MD_SHIIRE.CO_NO%type, --���NO
		wv_shiire_saki_cd    in M_EA600_MD_SHIIRE.SHIIRESAKICD%type, --�d����R�[�h
		wc_cur_ret           out SYS_REFCURSOR --���R�[�h���X�g
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
    * [�T �v]:�d����}�X�^(�o�^)�̒ǉ�����
    * [�� ��]:���͒l��DB�ɒǉ����s��
    */
	procedure insertData
	(
		wn_co_no            in M_EA124_SIIRE.CO_NO%type, --���NO
		wv_siire_cd         in M_EA124_SIIRE.SIIRE_CD%type, --�d����R�[�h
		wv_siire_nm1        in M_EA124_SIIRE.SIIRE_NM1%type, --�d���於�P
		wv_siire_nm2        in M_EA124_SIIRE.SIIRE_NM2%type, --�d���於�Q
		wv_siire_zip1       in M_EA124_SIIRE.SIIRE_ZIP%type, --�d����X�֔ԍ��P
		wv_siire_zip2       in M_EA124_SIIRE.SIIRE_ZIP%type, --�d����X�֔ԍ��Q
		wv_siire_addr1      in M_EA124_SIIRE.SIIRE_ADDR1%type, --�d����Z���P
		wv_siire_addr2      in M_EA124_SIIRE.SIIRE_Addr2%type, --�d����Z���Q
		wv_siire_addr3      in M_EA124_SIIRE.SIIRE_Addr3%type, --�d����Z���R
		wv_siire_tel        in M_EA124_SIIRE.SIIRE_TEL%type, --�d����d�b�ԍ�
		wv_siire_fax        in M_EA124_SIIRE.SIIRE_FAX%type, --�d����FAX
		wv_siire_tanto_nm   in M_EA124_SIIRE.SIIRE_TANTO_NM%type, --�d����S���Җ�
		wv_siire_tanto_mail in M_EA124_SIIRE.SIIRE_TANTO_MAIL%type, --�d����S���҃��[���A�h���X
		wn_user_no          in M_EA124_SIIRE.MAKE_USER%type --���[�U�R�[�h
	) is
		ln_no_sort number(9) := 0;
		--NO_SORT��MAX�擾
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
			,replace(wv_siire_nm1, '''', '�f')
			,replace(wv_siire_nm2, '''', '�f')
			,wv_siire_zip1 || '-' || wv_siire_zip2
			,replace(wv_siire_addr1, '''', '�f')
			,replace(wv_siire_addr2, '''', '�f')
			,replace(wv_siire_addr3, '''', '�f')
			,wv_siire_tel
			,wv_siire_fax
			,replace(wv_siire_tanto_nm, '''', '�f')
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
    * [�T �v]:�d����}�X�^(�o�^)�̍X�V����
    * [�� ��]:���͒l��DB�ɍX�V���s��
    */
  procedure updateData
	(
		wn_co_no                    in M_EA600_MD_SHIIRE.CO_NO%type, --���NO
		wv_shiire_saki_cd           in M_EA600_MD_SHIIRE.SHIIRESAKICD%type, --�d����R�[�h
		wv_shiire_saki_nm           in M_EA600_MD_SHIIRE.SHIIRESAKINM%type, --�d���於�P
		wv_shiire_saki_sn_nm        in M_EA600_MD_SHIIRE.SHIIRESAKI_SN_NM%type, --�d���於�Q
		wv_mainuser_nm              in M_EA600_MD_SHIIRE.MAINUSERNM%type, --��\�Җ�
		wv_manager_nm               in M_EA600_MD_SHIIRE.MANAGERNM%type, --�d����S���Җ�
		wv_shiire_saki_nm_kana      in M_EA600_MD_SHIIRE.SHIIRESAKINMKANA%type, --�d���於�i�J�i
		wn_disp_flg                 in M_EA600_MD_SHIIRE.DISP_FLG%type, --�\���t���O
		wn_user_no                  in M_EA600_MD_SHIIRE.MAKE_USER%type --���[�U�R�[�h
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
    * [�T �v]:�d����}�X�^(�o�^)�̍X�V����
    * [�� ��]:���͒l��DB����ϗ��폜���s��
    */
	procedure deleteData
	(
		wn_co_no    in M_EA124_SIIRE.CO_NO%type, --���NO
		wv_siire_cd in M_EA124_SIIRE.SIIRE_CD%type, --�d����R�[�h
		wn_user_no  in M_EA124_SIIRE.MAKE_USER%type --���[�U�R�[�h
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
    * [�T �v]:�d����}�X�^�i�o�^�j�̎d����R�[�h���݃`�F�b�N
    * [�� ��]:�d����R�[�h�������A���݌������擾
    * [�� �l]:
    */
	procedure checkSiireCdExists
	(
		wn_co_no    in M_EA124_SIIRE.CO_NO%type, --���no
		wv_siire_cd in M_EA124_SIIRE.SIIRE_CD%type, --���ރR�[�h
		wn_out_cnt  out number
	) is
		--����
		ln_count number default 0;
		cursor cur_siire is
			select count(1) COUNTNUM
			  from M_EA124_SIIRE
			 where CO_NO = wn_co_no
			   and SIIRE_CD = wv_siire_cd
			--and DISP_FLG = 0 -- �d����CD�͍ė��p�o���Ȃ����߁A�_���폜���ꂽCD���`�F�b�N�Ώۂɂ���
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
