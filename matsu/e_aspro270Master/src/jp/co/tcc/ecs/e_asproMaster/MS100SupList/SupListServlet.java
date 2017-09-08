package jp.co.tcc.ecs.e_asproMaster.MS100SupList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.tcc.ecs.e_asproComm.common.CommonService;
import jp.co.tcc.ecs.e_asproComm.common.CommonServlet;
import jp.co.tcc.ecs.e_asproComm.common.Constants;
import jp.co.tcc.ecs.e_asproComm.framework.base.ManageUtils;
import jp.co.tcc.ecsolution.framework.otherUtils.StringUtil;

/**
 * [概 要]:仕入先マスタ（一覧）Servlet<br>
 * [説 明]:仕入先マスタ（一覧）Servlet<br>
 * [備 考]:<br>
 * 著作権: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupListServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
	// 仕入先マスタ（一覧）サービス
	SupListService service = new SupListService();
	// 共通サービス
	CommonService commonService = new CommonService();

	/**
	 * [概 要]:仕入先マスタ（一覧）主処理フロー<br>
	 * [説 明]:処理分岐<br>
	 * [備 考]:
	 * 
	 * @param request
	 * @param response
	 * @return 遷移先
	 * @throws Exception
	 */
	public String doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 共通処理ｊｓｐの値beanに設定
		SupListBean bean = new SupListBean();
		setRequest2Bean(request, bean);
		// ログインユーザーの会社No
		bean.setCoNo(StringUtil.nvl(request.getSession().getAttribute(Constants.SESSION_CONO)));
		setLoginUser(request, bean);

		String returnStr = "";
		// 改ページしないように、ページNOとページサイズ設定
		bean.setIntPageNo(1);
		bean.setIntPageSize(999999);
		// 初期化
		if (StringUtil.stringEquals("", bean.getProcessType())) {
			ManageUtils manageUtils = bean.getManageUtils(request);
			manageUtils.addListReturnURL(SupListBean.RETRUN_URL2, bean.getSearchParamMap());
			returnStr = doInit(request, response, bean);
			// 検索
		} else if (StringUtil.stringEquals(Constants.POWER_SEARCH, bean.getProcessType())) {
			ManageUtils manageUtils = bean.getManageUtils(request);
			manageUtils.addListReturnURL(SupListBean.RETRUN_URL2, bean.getSearchParamMap());

			returnStr = doSubmit(request, response, bean);
			// 更新
		} // else {
			// returnStr = doUpdate(request, response, bean);
			// }
		request.setAttribute("bean", bean);
		return returnStr;
	}

	/**
	 * [概 要]:初期化。<br>
	 * [説 明]:初期化を行う。<br>
	 * [備 考]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            仕入先マスタ（一覧）bean
	 * @return 遷移先
	 * @throws Exception
	 */
	public String doInit(HttpServletRequest request, HttpServletResponse response, SupListBean bean) throws Exception {

		bean.setStrFromPageId(SupListBean.PAGE_ID);
		return SupListBean.RETRUN_URL;
	}

	/**
	 * [概 要]検索。<br>
	 * [説 明]:検索を行う。<br>
	 * [備 考]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            仕入先マスタ（一覧）bean
	 * @return 遷移先
	 * @throws Exception
	 */
	public String doSubmit(HttpServletRequest request, HttpServletResponse response, SupListBean bean)
			throws Exception {

		// 入力チェック
		String errMsg = service.validator(bean);
		if (!StringUtil.stringEquals("", errMsg)) {
			bean.setStrErrMsg(errMsg);
		}
		// 検索処理
		if (StringUtil.stringEquals("", bean.getStrErrMsg())) {
			bean.setSearchKbn("2");
			bean = service.search(bean);
		}

		bean.setStrFromPageId(SupListBean.PAGE_ID);
		return SupListBean.RETRUN_URL;
	}

	/**
	 * [概 要]更新。<br>
	 * [説 明]:更新を行う。<br>
	 * [備 考]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 * @return 遷移先
	 * @throws Exception
	 */
	public String doUpdate(HttpServletRequest request, HttpServletResponse response, SupListBean bean)
			throws Exception {
		// 元仕入先コードと変更仕入先コードの取得
		bean.setChgSiireCd(StringUtil.nvl(request.getParameter("chgSiireCd")));
		bean.setMotoSiireCd(StringUtil.nvl(request.getParameter("motoSiireCd")));

		service.sortUpdate(bean);
		return doSubmit(request, response, bean);
	}
}
