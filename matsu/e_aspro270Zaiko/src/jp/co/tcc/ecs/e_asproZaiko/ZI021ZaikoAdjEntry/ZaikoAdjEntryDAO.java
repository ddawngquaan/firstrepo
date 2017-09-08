package jp.co.tcc.ecs.e_asproZaiko.ZI021ZaikoAdjEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecsolution.framework.dbUtils.DBHelper;

/**
 * [�T �v]:�݌ɒ�������DAO<br>
 * [�� ��]:�݌ɒ�������DAO<br>
 * [�� �l]:<br>
 * ���쌠: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class ZaikoAdjEntryDAO {

	/**
	 * [�T �v]:�݌ɏڍ׏��擾�B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �݌ɒ������� bean
	 * @return bean �݌ɏڍ׏�� map
	 * @throws Exception
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map<String, String> search(ZaikoAdjEntryBean bean) throws Exception {
		ArrayList<Object> listParams = new ArrayList<Object>();

		StringBuilder sb = new StringBuilder();
		sb.append("call ZI021.search(");
		sb.append("?,?,?,");
		sb.append("?,?)");

		// ���NO
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getCoNo()));
		// ���i�R�[�h
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoItemNo()));
		// �q�ɃR�[�h
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getWhCd()));
		// �݌ɏ�ԋ敪
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoJoutaiKbn()));

		listParams.add(DBHelper.createSQLOutParamCursor("LIST"));

		HashMap result = DBHelper.executeCallableStatement(sb.toString(), listParams);
		Vector<Map<String, String>> list = (Vector<Map<String, String>>) result.get("LIST");

		return list.get(0);
	}

	/**
	 * [�T �v]:�݌ɒ������͒����B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �݌ɒ������� bean
	 * @throws Exception
	 */
	public void adjust(ZaikoAdjEntryBean bean) throws Exception {
		ArrayList<Object> listParams = new ArrayList<Object>();

		StringBuilder sb = new StringBuilder();
		sb.append("call ZI021.adjust(");
		sb.append("?,?,?,");
		sb.append("?,?,?,");
		sb.append("?,?,?)");

		// ���NO
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getCoNo()));
		// ���i�R�[�h
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoItemNo()));
		// �q�ɃR�[�h
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getWhCd()));
		// �݌ɏ�ԋ敪
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoJoutaiKbn()));
		// �����敪
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getAdjustKbn()));
		// ������ԋ敪
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getAdjZaikoJoutai()));
		// ������
		listParams.add(DBHelper.createSQLParamInteger(bean.getAdjustQty()));
		// /���O�C�����[�U
		listParams.add(DBHelper.createSQLParamVarchar2(String.valueOf(bean.getLoginUser().getUserNo())));
		//�R�����g
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getBiko()));
		DBHelper.executeCallableStatement(sb.toString(), listParams);
	}

	/**
	 * [�T�v]:�݌ɒ������͂̔r���`�F�b�N����<br>
	 * [�� ��]:<br>
	 * 
	 * @param bean �݌ɒ�������Bean
	 * @return �r���`�F�b�N����
	 * @throws Exception
	 */
	public boolean checkExcl(ZaikoAdjEntryBean bean) throws Exception {
		// �e�[�u����
		String tableName = "F_EA101_ZAIKO";
		// ��L�[�J����
		ArrayList<String> tableKeyList = new ArrayList<String>();
		tableKeyList.add(0, "CO_NO");
		tableKeyList.add(1, "WH_CD");
		tableKeyList.add(2, "S_ZAIKO_ITEM_NO");
		tableKeyList.add(3, "ZAIKO_JOUTAI_KBN");
		// �J�����ɑ΂���f�[�^
		ArrayList<Object> listParams = new ArrayList<Object>();
		// ���No
		listParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		// �q��CD
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getWhCd()));
		// �����p�݌ɏ��i�R�[�h
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoItemNo()));
		// �݌ɏ�ԋ敪
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoJoutaiKbn()));
		// �r���J�E���^
		return DBHelper.twoFaseCommitCheck(tableName, Integer.parseInt(bean.getExclCnt()), tableKeyList, listParams);
	}

}
