package jp.co.tcc.ecs.e_asproMaster.MS100SupList;

import jp.co.tcc.ecs.e_asproComm.common.InputChecker;
import jp.co.tcc.ecsolution.framework.otherUtils.StringUtil;

/**
 * [�T �v]:�d����}�X�^�i�ꗗ�j�T�[�r�X<br>
 * [�� ��]:�d����}�X�^�i�ꗗ�j�T�[�r�X<br>
 * [�� �l]:<br>
 * ���쌠: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupListService {

	/**
	 * [�T �v]:�����B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^�i�ꗗ�j bean
	 * @return bean
	 * @throws Exception
	 */
	public SupListBean search(SupListBean bean) throws Exception {
		SupListDAO dao = new SupListDAO();
		return dao.search(bean);
	}

	/**
	 * [�T �v]:�X�V�B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^�i�ꗗ�j bean
	 * @throws Exception
	 */
	public void sortUpdate(SupListBean bean) throws Exception {
		SupListDAO dao = new SupListDAO();
		dao.sortUpdate(bean);
	}

	/**
	 * [�T �v]:�������ڃ`�F�b�N�B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^�i�ꗗ�j bean
	 * @return �G���[���b�Z�[�W
	 * @throws Exception
	 */
	public String validator(SupListBean bean) throws Exception {

		StringBuffer sb = new StringBuffer();
		// �d����R�[�h �`�F�b�N
		if (!StringUtil.isNull(bean.getSearchSiireCd())) {
			sb.append(InputChecker.checkEisuji(bean.getSearchSiireCd(), "�d����R�[�h", 0, "30"));
		}
		// �d���於�`�F�b�N
		if (!StringUtil.isNull(bean.getSearchSiireNm())) {
			sb.append(InputChecker.checkMulti(bean.getSearchSiireNm(), "�d���於", 0, "100", ""));
		}

		return sb.toString();
	}

}
