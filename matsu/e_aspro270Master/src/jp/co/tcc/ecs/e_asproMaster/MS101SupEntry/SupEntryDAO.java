package jp.co.tcc.ecs.e_asproMaster.MS101SupEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecsolution.framework.dbUtils.DBHelper;
import jp.co.tcc.ecsolution.framework.dbUtils.SQLParamType;
import jp.co.tcc.ecsolution.framework.otherUtils.StringUtil;

/**
 * [�T �v]:�d����}�X�^�i�o�^�jDAO<br>
 * [�� ��]:�d����}�X�^�i�o�^�jDAO<br>
 * [�� �l]:<br>
 * ���쌠: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupEntryDAO {
	/**
	 * [�T �v]:�d����o�^�擾�B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^�i�o�^�j bean
	 * @return bean �d����}�X�^�i�o�^�j bean
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Vector<Map<String, String>>> search(SupEntryBean bean) throws Exception {

		ArrayList<Object> listParams = new ArrayList<Object>();
		String strCallProc = "{call MS101.search(?,?,?)}";

		listParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getShiiresakiCd()));
		listParams.add(DBHelper.createSQLOutParamCursor("wc_cur_ret"));

		return DBHelper.executeCallableStatement(strCallProc, listParams);
	}

	/**
	 * [�T �v]:�ǉ����s���B<br>
	 * [�� ��]:���͒l���DB�̒ǉ����s��<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^�i�o�^�j bean
	 * @throws Exception
	 */
	public void insert(SupEntryBean bean) throws Exception {
		// �V�K
		ArrayList<Object> listParams = new ArrayList<Object>();

		StringBuilder sb = new StringBuilder();
		sb.append("{call MS101.insertData(");
		sb.append("?,?,?,?,?,");
		sb.append("?,?,?,?,?,");
		sb.append("?,?,?,?)}");
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getCoNo())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireCd())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireNm1())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireNm2())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireZip1())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireZip2())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireAddr1())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireAddr2())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireAddr3())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireTel())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireFax())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireTantoNm())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireTantoMail())));
		// ���[�U�[No
		listParams.add(DBHelper.createSQLParamInteger(bean.getLoginUser().getUserNo()));

		DBHelper.executeCallableStatement(sb.toString(), listParams);
	}

	/**
	 * [�T �v]:�X�V���s���B<br>
	 * [�� ��]:���͒l���DB�̍X�V���s��<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^�i�o�^�j bean
	 * @throws Exception
	 */
	public void update(SupEntryBean bean) throws Exception {
		// �X�V
		ArrayList<Object> listParams = new ArrayList<Object>();
		StringBuilder sb = new StringBuilder();
		sb.append("{call MS101.updateData(");
		sb.append("?,?,?,?,");
		sb.append("?,?,?,?,?)");
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getCoNo())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getShiiresakiCd())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getShiiresakiNm())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getShiiresakiSnNm())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getMainuserNm())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getManagerNm())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getShiiresakiNmKana())));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getDispFlg())));
		// ���[�U�[No
		listParams.add(DBHelper.createSQLParamInteger(bean.getLoginUser().getUserNo()));		
		
		DBHelper.executeCallableStatement(sb.toString(), listParams);
	}

	/**
	 * [�T �v]:�폜���s���B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^�i�o�^�j bean
	 * @throws Exception
	 */
	public void delete(SupEntryBean bean) throws Exception {
		// �폜
		ArrayList<Object> listParams = new ArrayList<Object>();
		String strCallProc = "{call MS101.deleteData(?,?,?)}";
		listParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireCd())));
		// ���[�U�[No
		listParams.add(DBHelper.createSQLParamInteger(bean.getLoginUser().getUserNo()));

		DBHelper.executeCallableStatement(strCallProc, listParams);
	}
	/**
	 * 
	 * [�T �v]:�w�b�_�[�̔r���`�F�b�N�����B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^Bean
	 * @return �r���`�F�b�N���� true�FOK�Afalse�FNG
	 * @throws Exception
	 */
	public boolean checkExcl(SupEntryBean bean) throws Exception {
		// �e�[�u����
		String tableName = "M_EA124_SIIRE";
		// ��L�[�J����
		String tableColCoNo = "CO_NO";
		String tableColBunruiCd = "SIIRE_CD";

		ArrayList<String> tableKeyColumns = new ArrayList<String>();
		tableKeyColumns.add(0, tableColCoNo);
		tableKeyColumns.add(1, tableColBunruiCd);
		// �J�����ɑ΂���f�[�^
		List<SQLParamType> exclcntParams = new ArrayList<SQLParamType>();

		exclcntParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		exclcntParams.add(DBHelper.createSQLParamVarchar2(bean.getShiiresakiCd()));

		return DBHelper.twoFaseCommitCheck(tableName, Integer.parseInt(bean.getExclCnt()), tableKeyColumns,
				exclcntParams);
	}
	
	/**
	 * 
	 * [�T �v]:�w�b�_�[�̔r���`�F�b�N�����B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^Bean
	 * @return �r���`�F�b�N���� true�FOK�Afalse�FNG
	 * @throws Exception
	 */
	public boolean checkExcl2(SupEntryBean bean) throws Exception {
		// �e�[�u����
		String tableName = "M_EA600_MD_SHIIRE";
		// ��L�[�J����
		String tableColCoNo = "CO_NO";
		String tableColBunruiCd = "SHIIRESAKICD";

		ArrayList<String> tableKeyColumns = new ArrayList<String>();
		tableKeyColumns.add(0, tableColCoNo);
		tableKeyColumns.add(1, tableColBunruiCd);
		// �J�����ɑ΂���f�[�^
		List<SQLParamType> exclcntParams = new ArrayList<SQLParamType>();

		exclcntParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		exclcntParams.add(DBHelper.createSQLParamVarchar2(bean.getShiiresakiCd()));

		return DBHelper.twoFaseCommitCheck(tableName, Integer.parseInt(bean.getExclCnt()), tableKeyColumns,
				exclcntParams);
	}

	/**
	 * [�T �v]:�V�K�o�^���A�d����R�[�h�����łɑ��݂��Ă��邩�`�F�b�N����B<br>
	 * [�� ��]:�V�K�o�^���A�d����R�[�h�����łɑ��݂��Ă��邩�`�F�b�N����B<br>
	 * [�� �l]:
	 * @param bean
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public boolean checkSiireCdExists(SupEntryBean bean) throws Exception {

		ArrayList<Object> listParams = new ArrayList<Object>();
		String strCallProc = "{call MS101.checkSiireCdExists(?,?,?)}";

		listParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getSiireCd()));
		listParams.add(DBHelper.createSQLOutParamInteger("CNT"));

		HashMap result = DBHelper.executeCallableStatement(strCallProc, listParams);
		String strCnt = (String)result.get("CNT");
		return Integer.parseInt(strCnt) > 0;

	}
}
