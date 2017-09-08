package jp.co.tcc.ecs.e_asproMaster.MS101SupEntry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.tcc.ecs.e_asproComm.common.CommonServlet;
import jp.co.tcc.ecs.e_asproComm.common.Constants;
import jp.co.tcc.ecs.e_asproComm.framework.base.ManageUtils;
import jp.co.tcc.ecsolution.framework.otherUtils.StringUtil;

/**
 * [�T �v]:�d����}�X�^�i�o�^�jServlet<br>
 * [�� ��]:�d����}�X�^�i�o�^�jServlet<br>
 * [�� �l]:<br>
 * ���쌠: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupEntryServlet extends CommonServlet {
	private static final long serialVersionUID = 1L;
	// �d����}�X�^�i�o�^�j�T�[�r�X
	SupEntryService service = new SupEntryService();

	/**
	 * [�T �v]:�d����}�X�^�i�o�^�j�又���t���[<br>
	 * [�� ��]:��������<br>
	 * [�� �l]:
	 * 
	 * @param request
	 * @param response
	 * @return �J�ڐ�
	 * @throws Exception
	 */
	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// ���ʏ����������̒lbean�ɐݒ�
		SupEntryBean bean = new SupEntryBean();
		setRequest2Bean(request, bean);
		String returnStr = "";
		ManageUtils manageUtils = bean.getManageUtils(request);
		manageUtils.setReturnURL2Request(request);

		// ���O�C�����[�U�[�̉��No
		setLoginUser(request, bean);
		bean.setCoNo((Integer) request.getSession().getAttribute(Constants.SESSION_CONO));
		// ������
		if (StringUtil.stringEquals("", bean.getProcessType())) {
			returnStr = doInit(request, response, bean);
		}
		// �o�^����(�V�K)
		// else if (StringUtil.stringEquals(Constants.PAGE_INSERT,
		// bean.getProcessType())) {
		// returnStr = insert(request, response, bean);
		// }
		// �o�^����(�X�V)
		else if (StringUtil.stringEquals(Constants.PAGE_UPDATE, bean.getProcessType())) {
			returnStr = update(request, response, bean);

		}
		// �o�^����(�폜)
		// else if (StringUtil.stringEquals(Constants.PAGE_DELETE,
		// bean.getProcessType())) {
		// returnStr = delete(request, response, bean);
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
	 *            �d����}�X�^�i�o�^�jbean
	 * @return �J�ڐ�
	 * @throws Exception
	 */
	public String doInit(HttpServletRequest request, HttpServletResponse response, SupEntryBean bean) throws Exception {

		if (Constants.PAGE_SEARCH.equals(bean.getProcessKbn())) {
			service.search(bean);
		}
		return SupEntryBean.FORWARD_URL;
	}

	/**
	 * [�T �v]:�ǉ��B<br>
	 * [�� ��]:�ǉ����s���B<br>
	 * [�� �l]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            �d����}�X�^�i�o�^�jbean
	 * @return �J�ڐ�
	 * @throws Exception
	 */
	public String insert(HttpServletRequest request, HttpServletResponse response, SupEntryBean bean) throws Exception {
		// ���̓`�F�b�N
		String errMsg = service.validator(false, bean);
		if (!StringUtil.stringEquals("", errMsg)) {
			bean.setStrErrMsg(errMsg);
			bean.setStrFromPageId(bean.getStrFromPageId());
			return SupEntryBean.FORWARD_URL;
		}
		service.insert(bean);
		// �ꗗ��ʂɑJ��
		ManageUtils manageUtils = bean.getManageUtils(request);
		String str = manageUtils.getReturnURL2RequestStr();
		return setRedirectUrl(str);
	}

	/**
	 * [�T �v]:�X�V�B<br>
	 * [�� ��]:�X�V���s���B<br>
	 * [�� �l]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            �d����}�X�^�i�o�^�jbean
	 * @return �J�ڐ�
	 * @throws Exception
	 */
	public String update(HttpServletRequest request, HttpServletResponse response, SupEntryBean bean) throws Exception {
		// ���̓`�F�b�N
		String errMsg = service.validator(true, bean);
		if (!StringUtil.stringEquals("", errMsg)) {
			bean.setStrErrMsg(errMsg);
			bean.setStrFromPageId(bean.getStrFromPageId());
			return SupEntryBean.FORWARD_URL;
		}
		service.update(bean);
		// �ꗗ��ʂɑJ��
		ManageUtils manageUtils = bean.getManageUtils(request);
		String str = manageUtils.getReturnURL2RequestStr();
		return setRedirectUrl(str);
	}

	/**
	 * [�T �v]:�폜�B<br>
	 * [�� ��]:�폜���s���B<br>
	 * [�� �l]:
	 * 
	 * @param request
	 * @param response
	 * @param bean
	 *            �d����}�X�^�i�o�^�jbean
	 * @return �J�ڐ�
	 * @throws Exception
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response, SupEntryBean bean) throws Exception {
		service.delete(bean);
		// �ꗗ��ʂɑJ��
		ManageUtils manageUtils = bean.getManageUtils(request);
		String str = manageUtils.getReturnURL2RequestStr();
		return setRedirectUrl(str);
	}

}
