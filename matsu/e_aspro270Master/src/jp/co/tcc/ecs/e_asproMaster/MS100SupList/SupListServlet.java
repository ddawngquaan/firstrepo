package jp.co.tcc.ecs.e_asproMaster.MS100SupList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.tcc.ecs.e_asproComm.common.CommonService;
import jp.co.tcc.ecs.e_asproComm.common.CommonServlet;
import jp.co.tcc.ecs.e_asproComm.common.Constants;
import jp.co.tcc.ecs.e_asproComm.framework.base.ManageUtils;
import jp.co.tcc.ecsolution.framework.otherUtils.StringUtil;

/**
 * [�T �v]:�d����}�X�^�i�ꗗ�jServlet<br>
 * [�� ��]:�d����}�X�^�i�ꗗ�jServlet<br>
 * [�� �l]:<br>
 * ���쌠: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupListServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
	// �d����}�X�^�i�ꗗ�j�T�[�r�X
	SupListService service = new SupListService();
	// ���ʃT�[�r�X
	CommonService commonService = new CommonService();

	/**
	 * [�T �v]:�d����}�X�^�i�ꗗ�j�又���t���[<br>
	 * [�� ��]:��������<br>
	 * [�� �l]:
	 * 
	 * @param request
	 * @param response
	 * @return �J�ڐ�
	 * @throws Exception
	 */
	public String doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ���ʏ����������̒lbean�ɐݒ�
		SupListBean bean = new SupListBean();
		setRequest2Bean(request, bean);
		// ���O�C�����[�U�[�̉��No
		bean.setCoNo(StringUtil.nvl(request.getSession().getAttribute(Constants.SESSION_CONO)));
		setLoginUser(request, bean);

		String returnStr = "";
		// ���y�[�W���Ȃ��悤�ɁA�y�[�WNO�ƃy�[�W�T�C�Y�ݒ�
		bean.setIntPageNo(1);
		bean.setIntPageSize(999999);
		// ������
		if (StringUtil.stringEquals("", bean.getProcessType())) {
			ManageUtils manageUtils = bean.getManageUtils(request);
			manageUtils.addListReturnURL(SupListBean.RETRUN_URL2, bean.getSearchParamMap());
			returnStr = doInit(request, response, bean);
			// ����
		} else if (StringUtil.stringEquals(Constants.POWER_SEARCH, bean.getProcessType())) {
			ManageUtils manageUtils = bean.getManageUtils(request);
			manageUtils.addListReturnURL(SupListBean.RETRUN_URL2, bean.getSearchParamMap());

			returnStr = doSubmit(request, response, bean);
			// �X�V
		} // else {
			// returnStr = doUpdate(request, response, bean);
			// }
		request.setAttribute("bean", bean);
		return returnStr;
	}

	/**
	 * [�T �v]:�������B<br>
	 * [�� ��]:���������s���B<br>
	 * [�� �l]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            �d����}�X�^�i�ꗗ�jbean
	 * @return �J�ڐ�
	 * @throws Exception
	 */
	public String doInit(HttpServletRequest request, HttpServletResponse response, SupListBean bean) throws Exception {

		bean.setStrFromPageId(SupListBean.PAGE_ID);
		return SupListBean.RETRUN_URL;
	}

	/**
	 * [�T �v]�����B<br>
	 * [�� ��]:�������s���B<br>
	 * [�� �l]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            �d����}�X�^�i�ꗗ�jbean
	 * @return �J�ڐ�
	 * @throws Exception
	 */
	public String doSubmit(HttpServletRequest request, HttpServletResponse response, SupListBean bean)
			throws Exception {

		// ���̓`�F�b�N
		String errMsg = service.validator(bean);
		if (!StringUtil.stringEquals("", errMsg)) {
			bean.setStrErrMsg(errMsg);
		}
		// ��������
		if (StringUtil.stringEquals("", bean.getStrErrMsg())) {
			bean.setSearchKbn("2");
			bean = service.search(bean);
		}

		bean.setStrFromPageId(SupListBean.PAGE_ID);
		return SupListBean.RETRUN_URL;
	}

	/**
	 * [�T �v]�X�V�B<br>
	 * [�� ��]:�X�V���s���B<br>
	 * [�� �l]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 * @return �J�ڐ�
	 * @throws Exception
	 */
	public String doUpdate(HttpServletRequest request, HttpServletResponse response, SupListBean bean)
			throws Exception {
		// ���d����R�[�h�ƕύX�d����R�[�h�̎擾
		bean.setChgSiireCd(StringUtil.nvl(request.getParameter("chgSiireCd")));
		bean.setMotoSiireCd(StringUtil.nvl(request.getParameter("motoSiireCd")));

		service.sortUpdate(bean);
		return doSubmit(request, response, bean);
	}
}
