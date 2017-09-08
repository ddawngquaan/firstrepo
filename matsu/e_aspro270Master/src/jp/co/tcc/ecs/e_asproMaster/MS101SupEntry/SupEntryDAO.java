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
 * [概 要]:仕入先マスタ（登録）DAO<br>
 * [説 明]:仕入先マスタ（登録）DAO<br>
 * [備 考]:<br>
 * 著作権: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupEntryDAO {
	/**
	 * [概 要]:仕入先登録取得。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（登録） bean
	 * @return bean 仕入先マスタ（登録） bean
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
	 * [概 要]:追加を行う。<br>
	 * [説 明]:入力値よりDBの追加を行う<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（登録） bean
	 * @throws Exception
	 */
	public void insert(SupEntryBean bean) throws Exception {
		// 新規
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
		// ユーザーNo
		listParams.add(DBHelper.createSQLParamInteger(bean.getLoginUser().getUserNo()));

		DBHelper.executeCallableStatement(sb.toString(), listParams);
	}

	/**
	 * [概 要]:更新を行う。<br>
	 * [説 明]:入力値よりDBの更新を行う<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（登録） bean
	 * @throws Exception
	 */
	public void update(SupEntryBean bean) throws Exception {
		// 更新
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
		// ユーザーNo
		listParams.add(DBHelper.createSQLParamInteger(bean.getLoginUser().getUserNo()));		
		
		DBHelper.executeCallableStatement(sb.toString(), listParams);
	}

	/**
	 * [概 要]:削除を行う。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（登録） bean
	 * @throws Exception
	 */
	public void delete(SupEntryBean bean) throws Exception {
		// 削除
		ArrayList<Object> listParams = new ArrayList<Object>();
		String strCallProc = "{call MS101.deleteData(?,?,?)}";
		listParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		listParams.add(DBHelper.createSQLParamVarchar2(StringUtil.nvl(bean.getSiireCd())));
		// ユーザーNo
		listParams.add(DBHelper.createSQLParamInteger(bean.getLoginUser().getUserNo()));

		DBHelper.executeCallableStatement(strCallProc, listParams);
	}
	/**
	 * 
	 * [概 要]:ヘッダーの排他チェック処理。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタBean
	 * @return 排他チェック結果 true：OK、false：NG
	 * @throws Exception
	 */
	public boolean checkExcl(SupEntryBean bean) throws Exception {
		// テーブル名
		String tableName = "M_EA124_SIIRE";
		// 主キーカラム
		String tableColCoNo = "CO_NO";
		String tableColBunruiCd = "SIIRE_CD";

		ArrayList<String> tableKeyColumns = new ArrayList<String>();
		tableKeyColumns.add(0, tableColCoNo);
		tableKeyColumns.add(1, tableColBunruiCd);
		// カラムに対するデータ
		List<SQLParamType> exclcntParams = new ArrayList<SQLParamType>();

		exclcntParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		exclcntParams.add(DBHelper.createSQLParamVarchar2(bean.getShiiresakiCd()));

		return DBHelper.twoFaseCommitCheck(tableName, Integer.parseInt(bean.getExclCnt()), tableKeyColumns,
				exclcntParams);
	}
	
	/**
	 * 
	 * [概 要]:ヘッダーの排他チェック処理。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタBean
	 * @return 排他チェック結果 true：OK、false：NG
	 * @throws Exception
	 */
	public boolean checkExcl2(SupEntryBean bean) throws Exception {
		// テーブル名
		String tableName = "M_EA600_MD_SHIIRE";
		// 主キーカラム
		String tableColCoNo = "CO_NO";
		String tableColBunruiCd = "SHIIRESAKICD";

		ArrayList<String> tableKeyColumns = new ArrayList<String>();
		tableKeyColumns.add(0, tableColCoNo);
		tableKeyColumns.add(1, tableColBunruiCd);
		// カラムに対するデータ
		List<SQLParamType> exclcntParams = new ArrayList<SQLParamType>();

		exclcntParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		exclcntParams.add(DBHelper.createSQLParamVarchar2(bean.getShiiresakiCd()));

		return DBHelper.twoFaseCommitCheck(tableName, Integer.parseInt(bean.getExclCnt()), tableKeyColumns,
				exclcntParams);
	}

	/**
	 * [概 要]:新規登録時、仕入先コードがすでに存在しているかチェックする。<br>
	 * [説 明]:新規登録時、仕入先コードがすでに存在しているかチェックする。<br>
	 * [備 考]:
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
