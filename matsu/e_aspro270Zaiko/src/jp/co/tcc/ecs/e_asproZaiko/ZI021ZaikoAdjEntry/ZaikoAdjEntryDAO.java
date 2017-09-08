package jp.co.tcc.ecs.e_asproZaiko.ZI021ZaikoAdjEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecsolution.framework.dbUtils.DBHelper;

/**
 * [概 要]:在庫調整入力DAO<br>
 * [説 明]:在庫調整入力DAO<br>
 * [備 考]:<br>
 * 著作権: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class ZaikoAdjEntryDAO {

	/**
	 * [概 要]:在庫詳細情報取得。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 在庫調整入力 bean
	 * @return bean 在庫詳細情報 map
	 * @throws Exception
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	public Map<String, String> search(ZaikoAdjEntryBean bean) throws Exception {
		ArrayList<Object> listParams = new ArrayList<Object>();

		StringBuilder sb = new StringBuilder();
		sb.append("call ZI021.search(");
		sb.append("?,?,?,");
		sb.append("?,?)");

		// 会社NO
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getCoNo()));
		// 商品コード
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoItemNo()));
		// 倉庫コード
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getWhCd()));
		// 在庫状態区分
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoJoutaiKbn()));

		listParams.add(DBHelper.createSQLOutParamCursor("LIST"));

		HashMap result = DBHelper.executeCallableStatement(sb.toString(), listParams);
		Vector<Map<String, String>> list = (Vector<Map<String, String>>) result.get("LIST");

		return list.get(0);
	}

	/**
	 * [概 要]:在庫調整入力調整。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 在庫調整入力 bean
	 * @throws Exception
	 */
	public void adjust(ZaikoAdjEntryBean bean) throws Exception {
		ArrayList<Object> listParams = new ArrayList<Object>();

		StringBuilder sb = new StringBuilder();
		sb.append("call ZI021.adjust(");
		sb.append("?,?,?,");
		sb.append("?,?,?,");
		sb.append("?,?,?)");

		// 会社NO
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getCoNo()));
		// 商品コード
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoItemNo()));
		// 倉庫コード
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getWhCd()));
		// 在庫状態区分
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoJoutaiKbn()));
		// 調整区分
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getAdjustKbn()));
		// 調整状態区分
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getAdjZaikoJoutai()));
		// 調整数
		listParams.add(DBHelper.createSQLParamInteger(bean.getAdjustQty()));
		// /ログインユーザ
		listParams.add(DBHelper.createSQLParamVarchar2(String.valueOf(bean.getLoginUser().getUserNo())));
		//コメント
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getBiko()));
		DBHelper.executeCallableStatement(sb.toString(), listParams);
	}

	/**
	 * [概要]:在庫調整入力の排他チェック処理<br>
	 * [説 明]:<br>
	 * 
	 * @param bean 在庫調整入力Bean
	 * @return 排他チェック結果
	 * @throws Exception
	 */
	public boolean checkExcl(ZaikoAdjEntryBean bean) throws Exception {
		// テーブル名
		String tableName = "F_EA101_ZAIKO";
		// 主キーカラム
		ArrayList<String> tableKeyList = new ArrayList<String>();
		tableKeyList.add(0, "CO_NO");
		tableKeyList.add(1, "WH_CD");
		tableKeyList.add(2, "S_ZAIKO_ITEM_NO");
		tableKeyList.add(3, "ZAIKO_JOUTAI_KBN");
		// カラムに対するデータ
		ArrayList<Object> listParams = new ArrayList<Object>();
		// 会社No
		listParams.add(DBHelper.createSQLParamInteger(bean.getCoNo()));
		// 倉庫CD
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getWhCd()));
		// 検索用在庫商品コード
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoItemNo()));
		// 在庫状態区分
		listParams.add(DBHelper.createSQLParamVarchar2(bean.getZaikoJoutaiKbn()));
		// 排他カウンタ
		return DBHelper.twoFaseCommitCheck(tableName, Integer.parseInt(bean.getExclCnt()), tableKeyList, listParams);
	}

}
