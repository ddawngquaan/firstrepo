package jp.co.tcc.ecs.e_asproMaster.MS101SupEntry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.tcc.ecs.e_asproComm.common.CommonServlet;
import jp.co.tcc.ecs.e_asproComm.common.Constants;
import jp.co.tcc.ecs.e_asproComm.framework.base.ManageUtils;
import jp.co.tcc.ecsolution.framework.otherUtils.StringUtil;

/**
 * [概 要]:仕入先マスタ（登録）Servlet<br>
 * [説 明]:仕入先マスタ（登録）Servlet<br>
 * [備 考]:<br>
 * 著作権: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupEntryServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
	// 仕入先マスタ（登録）サービス
	SupEntryService service = new SupEntryService();

	/**
	 * [概 要]:仕入先マスタ（登録）主処理フロー<br>
	 * [説 明]:処理分岐<br>
	 * [備 考]:
	 * 
	 * @param request
	 * @param response
	 * @return 遷移先
	 * @throws Exception
	 */
	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 共通処理ｊｓｐの値beanに設定
		SupEntryBean bean = new SupEntryBean();
		setRequest2Bean(request, bean);
		String returnStr = "";
		ManageUtils manageUtils = bean.getManageUtils(request);
		manageUtils.setReturnURL2Request(request);

		// ログインユーザーの会社No
		setLoginUser(request, bean);
		bean.setCoNo((Integer) request.getSession().getAttribute(Constants.SESSION_CONO));
		// 初期化
		if (StringUtil.stringEquals("", bean.getProcessType())) {
			returnStr = doInit(request, response, bean);
		}
		// 登録処理(新規)
		// else if (StringUtil.stringEquals(Constants.PAGE_INSERT,
		// bean.getProcessType())) {
		// returnStr = insert(request, response, bean);
		// }
		// 登録処理(更新)
		else if (StringUtil.stringEquals(Constants.PAGE_UPDATE, bean.getProcessType())) {
			returnStr = update(request, response, bean);

		}
		// 登録処理(削除)
		// else if (StringUtil.stringEquals(Constants.PAGE_DELETE,
		// bean.getProcessType())) {
		// returnStr = delete(request, response, bean);
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
	 *            仕入先マスタ（登録）bean
	 * @return 遷移先
	 * @throws Exception
	 */
	public String doInit(HttpServletRequest request, HttpServletResponse response, SupEntryBean bean) throws Exception {

		if (Constants.PAGE_SEARCH.equals(bean.getProcessKbn())) {
			service.search(bean);
		}
		return SupEntryBean.FORWARD_URL;
	}

	/**
	 * [概 要]:追加。<br>
	 * [説 明]:追加を行う。<br>
	 * [備 考]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            仕入先マスタ（登録）bean
	 * @return 遷移先
	 * @throws Exception
	 */
	public String insert(HttpServletRequest request, HttpServletResponse response, SupEntryBean bean) throws Exception {
		// 入力チェック
		String errMsg = service.validator(false, bean);
		if (!StringUtil.stringEquals("", errMsg)) {
			bean.setStrErrMsg(errMsg);
			bean.setStrFromPageId(bean.getStrFromPageId());
			return SupEntryBean.FORWARD_URL;
		}
		service.insert(bean);
		// 一覧画面に遷移
		ManageUtils manageUtils = bean.getManageUtils(request);
		String str = manageUtils.getReturnURL2RequestStr();
		return setRedirectUrl(str);
	}

	/**
	 * [概 要]:更新。<br>
	 * [説 明]:更新を行う。<br>
	 * [備 考]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            仕入先マスタ（登録）bean
	 * @return 遷移先
	 * @throws Exception
	 */
	public String update(HttpServletRequest request, HttpServletResponse response, SupEntryBean bean) throws Exception {
		// 入力チェック
		String errMsg = service.validator(true, bean);
		if (!StringUtil.stringEquals("", errMsg)) {
			bean.setStrErrMsg(errMsg);
			bean.setStrFromPageId(bean.getStrFromPageId());
			return SupEntryBean.FORWARD_URL;
		}
		service.update(bean);
		// 一覧画面に遷移
		ManageUtils manageUtils = bean.getManageUtils(request);
		String str = manageUtils.getReturnURL2RequestStr();
		return setRedirectUrl(str);
	}

	/**
	 * [概 要]:削除。<br>
	 * [説 明]:削除を行う。<br>
	 * [備 考]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            仕入先マスタ（登録）bean
	 * @return 遷移先
	 * @throws Exception
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response, SupEntryBean bean) throws Exception {
		service.delete(bean);
		// 一覧画面に遷移
		ManageUtils manageUtils = bean.getManageUtils(request);
		String str = manageUtils.getReturnURL2RequestStr();
		return setRedirectUrl(str);
	}

}
