create or replace package ZI021 is
	/**
    * [�T �v]:�݌ɒ�������
    * [�� ��]:�Ώۏ��i�̍݌ɒ�����o�^����
    * [�� �l]:
    * ���쌠:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author chengj
    * @version 1.0
    * @since 1.0
    */

	/**
    * [�T �v]:�݌ɒ������̓f�[�^����
    * [�� ��]:�݌ɒ������͏����\���f�[�^�̎擾���s���B
    */
	procedure search
	(
		wn_co_no            in number, --���O�C�����[�U�[�̉��no
		wv_s_zaiko_item_no  in varchar2, --�����p�݌ɏ��i�R�[�h
		wv_wh_cd            in varchar2, --�q��cd
		wv_zaiko_joutai_kbn in varchar2, --j�݌ɏ�ԋ敪
		wc_out_ret          out page_feed.refcursor -- ���ʃ��X�g
	);

	/**
    * [�T �v]:�݌ɒ������͒���
    * [�� ��]:�݌ɒ������͒���
    */
	procedure adjust
	(
		wn_co_no             in number, --���O�C�����[�U�[�̉��no
		wv_s_zaiko_item_no   in varchar2, --�����p�݌ɏ��i�R�[�h
		wv_wh_cd             in varchar2, --�q��cd
		wv_zaiko_joutai_kbn  in varchar2, --�݌ɏ�ԋ敪
		wv_adjust_kbn        in varchar2, -- �����敪
		wv_adjust_joutai_kbn in varchar2, -- ������ԋ敪
		wn_adjust_qty        in number, --������
		wn_user_no           in number,
		wv_biko              in clob
	);

end ZI021;
/
create or replace package body ZI021 is
	/**
    * [�T �v]:�݌ɒ�������
    * [�� ��]:�Ώۏ��i�̍݌ɒ�����o�^����
    * [�� �l]:
    * ���쌠:   Copyright (c) 2014
    * @author Toukei Computer Company
    * @author chengj
    * @version 1.0
    * @since 1.0
    */

	/**
    * [�T �v]:�݌ɒ������̓f�[�^����
    * [�� ��]:�݌ɒ������͏����\���f�[�^�̎擾���s���B
    */
	procedure search
	(
		wn_co_no            in number, --���O�C�����[�U�[�̉��no
		wv_s_zaiko_item_no  in varchar2, --�����p�݌ɏ��i�R�[�h
		wv_wh_cd            in varchar2, --�q��cd
		wv_zaiko_joutai_kbn in varchar2, --j�݌ɏ�ԋ敪
		wc_out_ret          out page_feed.refcursor -- ���ʃ��X�g
	) is
	begin
		open wc_out_ret for
			select M_EA015.ZAIKO_ITEM_NM1 || M_EA015.ZAIKO_ITEM_NM2 || M_EA501.STD as ZAIKO_ITEM_NM
				  ,M_EA002.WH_NM1 || M_EA002.WH_NM2 as WH_NM
				  ,M_EA993.MARK_NM as ZAIKO_JOUTAI_NM
				  ,decode(M_EA015.SYOMI_KIGEN_FLG, 1, '����', '���Ȃ�') as SYOMI_KIGEN_FLG
				  ,F_EA101.QTY
				  ,F_EA101.HIKI_QTY
				  ,F_EA101.QTY - F_EA101.HIKI_QTY as REAL_QTY
				  ,F_EA101.EXCL_CNT
			  from F_EA101_ZAIKO      F_EA101
				  ,M_EA002_SOUKO      M_EA002
				  ,M_EA993_KBN        M_EA993
				  ,M_EA015_ITEM_ZAIKO M_EA015
				  ,M_EA501_MD_ITEM    M_EA501
			 where F_EA101.CO_NO = M_EA002.CO_NO
			   and F_EA101.WH_CD = M_EA002.WH_CD
			   and F_EA101.ZAIKO_JOUTAI_KBN = M_EA993.MARK_CD
			   and M_EA993.FIELD_NM = 'ZAIKO_JOUTAI_KBN'
			   and F_EA101.CO_NO = M_EA015.CO_NO
			   and F_EA101.S_ZAIKO_ITEM_NO = M_EA015.S_ZAIKO_ITEM_NO
			   and F_EA101.DISP_FLG = 0
			   and F_EA101.CO_NO = wn_co_no
			   and F_EA101.S_ZAIKO_ITEM_NO = wv_s_zaiko_item_no
			   and F_EA101.WH_CD = wv_wh_cd
			   and F_EA101.ZAIKO_JOUTAI_KBN = wv_zaiko_joutai_kbn
			   and F_EA101.CO_NO = M_EA501.CO_NO(+)
			   anD F_EA101.S_ZAIKO_ITEM_NO = M_EA501.SHOHIN_CD(+);

	exception
		when others then
			DEBUG_LOG('ZI021.search', '0', sqlerrm, wn_co_no);
			raise;
	end search;

	/**
    * [�T �v]:�݌ɒ������͒���
    * [�� ��]:�݌ɒ������͒���
    */
	procedure adjust
	(
		wn_co_no             in number, --���O�C�����[�U�[�̉��no
		wv_s_zaiko_item_no   in varchar2, --�����p�݌ɏ��i�R�[�h
		wv_wh_cd             in varchar2, --�q��cd
		wv_zaiko_joutai_kbn  in varchar2, --�݌ɏ�ԋ敪
		wv_adjust_kbn        in varchar2, -- �����敪
		wv_adjust_joutai_kbn in varchar2, -- ������ԋ敪
		wn_adjust_qty        in number, --������
		wn_user_no           in number,
		wv_biko              in clob
	) is
		lv_parm_mark M_EA993_KBN.PARAM_MARK%type;
	begin
		--�݌ɒ����̏���V�K�o�^����B
		insert into F_EA105_ZAIKO_ADJUST
			(CO_NO
			,ADJUST_CD
			,PLUS_MINUS_FLG
			,ADJUST_KBN
			,ADJUST_YMD
			,ADJUST_HMS
			,ADJUST_BIKOU
			,WH_CD
			,S_ZAIKO_ITEM_NO
			,ZAIKO_ITEM_NO
			,COLOR_CD
			,SIZE_CD
			,ZAIKO_JOUTAI_KBN
			,SYOKIGEN
			,QTY
			,BIKO
			,EXCL_CNT
			,DISP_FLG
			,MAKE_DATE
			,MAKE_USER
			,REP_DATE
			,REP_USER)
			select wn_co_no
				  ,GET_NUMBER_CONFIG(p_co_no        => wn_co_no,
									 p_count_col_nm => 'ADJUST_CD',
									 p_count_key    => 'ADJUST_CD',
									 p_id_user      => 0)
				  ,decode(wv_adjust_kbn, '20', 1, 0)
				  ,wv_adjust_kbn
				  ,to_char(sysdate, 'yyyy/mm/dd')
				  ,to_char(sysdate, 'hh24:mi:ss')
				  ,null
				  ,wv_wh_cd
				  ,wv_s_zaiko_item_no
				  ,ZAIKO_ITEM_NO
				  ,COLOR_CD
				  ,SIZE_CD
				  ,wv_zaiko_joutai_kbn
				  ,SYOKIGEN
				  ,wn_adjust_qty
				  ,wv_biko
				  ,1
				  ,0
				  ,sysdate
				  ,wn_user_no
				  ,sysdate
				  ,wn_user_no
			  from F_EA101_ZAIKO
			 where CO_NO = wn_co_no
			   and S_ZAIKO_ITEM_NO = wv_s_zaiko_item_no
			   and WH_CD = wv_wh_cd
			   and ZAIKO_JOUTAI_KBN = wv_zaiko_joutai_kbn
			   and DISP_FLG = 0;

		--�݌ɂ̏����X�V����B
		update F_EA101_ZAIKO
		   set QTY      = decode(wv_adjust_kbn, '20', QTY + wn_adjust_qty, QTY - wn_adjust_qty)
			  ,WMS_ZAIKO_FLG = 0
			  ,MALL_ZAIKO_RENKEI_FLG = 1
			  ,EXCL_CNT = EXCL_CNT + 1
			  ,REP_DATE = sysdate
			  ,REP_USER = wn_user_no
		 where CO_NO = wn_co_no
		   and S_ZAIKO_ITEM_NO = wv_s_zaiko_item_no
		   and WH_CD = wv_wh_cd
		   and ZAIKO_JOUTAI_KBN = wv_zaiko_joutai_kbn
		   and DISP_FLG = 0;

		--�����敪=30�i�݌ɐU�ցj�̏ꍇ
		if wv_adjust_kbn = '30' then
			--�U�֐�̍݌ɒ����̏���V�K�o�^����B
			insert into F_EA105_ZAIKO_ADJUST
				(CO_NO
				,ADJUST_CD
				,PLUS_MINUS_FLG
				,ADJUST_KBN
				,ADJUST_YMD
				,ADJUST_HMS
				,ADJUST_BIKOU
				,WH_CD
				,S_ZAIKO_ITEM_NO
				,ZAIKO_ITEM_NO
				,COLOR_CD
				,SIZE_CD
				,ZAIKO_JOUTAI_KBN
				,SYOKIGEN
				,QTY
				,BIKO
				,EXCL_CNT
				,DISP_FLG
				,MAKE_DATE
				,MAKE_USER
				,REP_DATE
				,REP_USER)
				select wn_co_no
					  ,GET_NUMBER_CONFIG(p_co_no        => wn_co_no,
										  p_count_col_nm => 'ADJUST_CD',
										  p_count_key    => 'ADJUST_CD',
										  p_id_user      => 0)
					  ,1
					  ,wv_adjust_kbn
					  ,to_char(sysdate, 'yyyy/mm/dd')
					  ,to_char(sysdate, 'hh24:mi:ss')
					  ,null
					  ,wv_wh_cd
					  ,wv_s_zaiko_item_no
					  ,ZAIKO_ITEM_NO
					  ,COLOR_CD
					  ,SIZE_CD
					  ,wv_adjust_joutai_kbn
					  ,SYOKIGEN
					  ,wn_adjust_qty
					  ,wv_biko
					  ,1
					  ,0
					  ,sysdate
					  ,wn_user_no
					  ,sysdate
					  ,wn_user_no
				  from F_EA101_ZAIKO
				 where CO_NO = wn_co_no
				   and S_ZAIKO_ITEM_NO = wv_s_zaiko_item_no
				   and WH_CD = wv_wh_cd
				   and ZAIKO_JOUTAI_KBN = wv_zaiko_joutai_kbn
				   and DISP_FLG = 0;

			--�U�֐�̍݌ɂ̏����X�V����B
			update F_EA101_ZAIKO
			   set QTY      = QTY + wn_adjust_qty
				  ,WMS_ZAIKO_FLG = 0
				  ,MALL_ZAIKO_RENKEI_FLG = 1
				  ,EXCL_CNT = EXCL_CNT + 1
				  ,REP_DATE = sysdate
				  ,REP_USER = wn_user_no
			 where CO_NO = wn_co_no
			   and S_ZAIKO_ITEM_NO = wv_s_zaiko_item_no
			   and WH_CD = wv_wh_cd
			   and ZAIKO_JOUTAI_KBN = wv_adjust_joutai_kbn
			   and DISP_FLG = 0;

			if sql%rowcount = 0 then
				begin
					select NVL(PARAM_MARK, '0')
					  into lv_parm_mark
					  from M_EA993_KBN
					 where FIELD_NM = 'ZAIKO_JOUTAI_KBN'
					   and MARK_CD = wv_adjust_joutai_kbn;
				exception
				when no_data_found then
				    lv_parm_mark := '0';
				end;

				insert into F_EA101_ZAIKO
					(CO_NO
					,WH_CD
					,S_ZAIKO_ITEM_NO
					,ZAIKO_JOUTAI_KBN
					,ZAIKO_ITEM_NO
					,COLOR_CD
					,SIZE_CD
					,SYOKIGEN
					,QTY
					,HIKI_QTY
					,HIKI_FLG
					,WMS_ZAIKO_FLG
					,MALL_ZAIKO_RENKEI_FLG
					,EXCL_CNT
					,DISP_FLG
					,MAKE_DATE
					,MAKE_USER
					,REP_DATE
					,REP_USER)
					select wn_co_no
						  ,wv_wh_cd
						  ,wv_s_zaiko_item_no
						  ,wv_adjust_joutai_kbn
						  ,F_EA101.ZAIKO_ITEM_NO
						  ,F_EA101.COLOR_CD
						  ,F_EA101.SIZE_CD
						  ,F_EA101.SYOKIGEN
						  ,wn_adjust_qty
						  ,0
						  ,lv_parm_mark
						  ,0
						  ,1
						  ,1
						  ,0
						  ,sysdate
						  ,wn_user_no
						  ,sysdate
						  ,wn_user_no
					  from F_EA101_ZAIKO F_EA101
						  ,M_EA993_KBN   M_EA993
					 where F_EA101.ZAIKO_JOUTAI_KBN = M_EA993.MARK_CD
					   and M_EA993.FIELD_NM = 'ZAIKO_JOUTAI_KBN'
					   and F_EA101.CO_NO = wn_co_no
					   and F_EA101.S_ZAIKO_ITEM_NO = wv_s_zaiko_item_no
					   and F_EA101.WH_CD = wv_wh_cd
					   and F_EA101.ZAIKO_JOUTAI_KBN = wv_zaiko_joutai_kbn
					   and F_EA101.DISP_FLG = 0;
			end if;
		end if;
	exception
		when others then
			DEBUG_LOG('ZI021.adjust', '0', sqlerrm, wn_co_no);
			raise;
	end adjust;

end ZI021;
/
