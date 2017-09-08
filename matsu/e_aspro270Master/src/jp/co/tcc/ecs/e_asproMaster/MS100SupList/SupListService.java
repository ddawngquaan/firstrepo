package jp.co.tcc.ecs.e_asproMaster.MS100SupList;

import jp.co.tcc.ecs.e_asproComm.common.InputChecker;
import jp.co.tcc.ecsolution.framework.otherUtils.StringUtil;

/**
 * [概 要]:仕入先マスタ（一覧）サービス<br>
 * [説 明]:仕入先マスタ（一覧）サービス<br>
 * [備 考]:<br>
 * 著作権: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupListService {

	/**
	 * [概 要]:検索。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（一覧） bean
	 * @return bean
	 * @throws Exception
	 */
	public SupListBean search(SupListBean bean) throws Exception {
		SupListDAO dao = new SupListDAO();
		return dao.search(bean);
	}

	/**
	 * [概 要]:更新。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（一覧） bean
	 * @throws Exception
	 */
	public void sortUpdate(SupListBean bean) throws Exception {
		SupListDAO dao = new SupListDAO();
		dao.sortUpdate(bean);
	}

	/**
	 * [概 要]:検索項目チェック。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（一覧） bean
	 * @return エラーメッセージ
	 * @throws Exception
	 */
	public String validator(SupListBean bean) throws Exception {

		StringBuffer sb = new StringBuffer();
		// 仕入先コード チェック
		if (!StringUtil.isNull(bean.getSearchSiireCd())) {
			sb.append(InputChecker.checkEisuji(bean.getSearchSiireCd(), "仕入先コード", 0, "30"));
		}
		// 仕入先名チェック
		if (!StringUtil.isNull(bean.getSearchSiireNm())) {
			sb.append(InputChecker.checkMulti(bean.getSearchSiireNm(), "仕入先名", 0, "100", ""));
		}

		return sb.toString();
	}

}
