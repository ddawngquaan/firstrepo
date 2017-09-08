package jp.co.tcc.ecs.e_asproMaster.MS100SupList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecsolution.framework.dbUtils.DBHelper;
import jp.co.tcc.ecsolution.framework.otherUtils.StringUtil;

/**
 * [概 要]:仕入先マスタ（一覧）DAO<br>
 * [説 明]:仕入先マスタ（一覧）DAO<br>
 * [備 考]:<br>
 * 著作権: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupListDAO {

	/**
	 * [概 要]:仕入先一覧取得。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（一覧） bean
	 * @return bean 仕入先マスタ（一覧） bean
	 * @throws Exception
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public SupListBean search(SupListBean bean) throws Exception {

		ArrayList<Object> listParams = new ArrayList<Object>();
		String strCallProc = "{call MS100.search(?,?,?,?,?,?,?,?,?)}";

		listParams.add(DBHelper.createSQLParamVarchar2(bean.getCoNo()));
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getSearchSiireCd()));
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getSearchSiireNm()));
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getSearchDispFlg()));
		
		listParams.add(DBHelper.createSQLParamInteger(bean.getIntPageNo()));
		listParams.add(DBHelper.createSQLParamInteger(bean.getIntPageSize()));
		listParams.add(DBHelper.createSQLOutParamCursor("LIST"));
		listParams.add(DBHelper.createSQLOutParamInteger("PAGECNT"));
		listParams.add(DBHelper.createSQLOutParamInteger("PAGENO"));
		
		HashMap result = DBHelper.executeCallableStatement(strCallProc, listParams);

		Vector<Map<String, String>> list = (Vector<Map<String, String>>) result.get("LIST");
		String strPageCnt = (String) result.get("PAGECNT");
		String strPageNo = (String) result.get("PAGENO");
		int pageCnt = 0;
		int pageNo = 0;
		if (!StringUtil.isNull(strPageCnt)) {
			pageCnt = Integer.parseInt(strPageCnt);
		}
		if (!StringUtil.isNull(strPageNo)) {
			pageNo = Integer.parseInt(strPageNo);
		}

		bean.setList(list);
		bean.setIntRecordCount(pageCnt);
		bean.setIntPageCount(pageNo);
		return bean;
	}

	/**
	 * [概 要]:更新を行う。<br>
	 * [説 明]:入力値よりDBの更新を行う<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（一覧） bean
	 * @throws Exception
	 */
	public void sortUpdate(SupListBean bean) throws Exception {

		ArrayList<Object> listParams = new ArrayList<Object>();
		String strCallProc = "{call MS100.sortUpdate(?,?,?,?)}";

		listParams.add(DBHelper.createSQLParamVarchar2(bean.getCoNo()));
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getMotoSiireCd()));
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getChgSiireCd()));
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getUserNo()));

		DBHelper.executeCallableStatement(strCallProc, listParams);
	}
}
