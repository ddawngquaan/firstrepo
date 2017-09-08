package jp.co.tcc.ecs.e_asproMaster.MS101SupEntry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;

import jp.co.tcc.ecs.e_asproComm.common.Constants;
import jp.co.tcc.ecs.e_asproComm.common.InputChecker;
import jp.co.tcc.ecs.e_asproComm.common.Properties;
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
public class SupEntryService {
	/**
	 * [�T �v]:�����B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^�i�ꗗ�j bean
	 * @return bean
	 * @throws Exception
	 */
	public SupEntryBean search(SupEntryBean bean) throws Exception {
		SupEntryDAO dao = new SupEntryDAO();
		HashMap<String, Vector<Map<String, String>>> map = dao.search(bean);
		Vector<Map<String, String>> headerData = map.get("wc_cur_ret");
		Map<String, String> row = headerData.get(0);
				
		bean.setShiiresakiCd(StringUtil.nvl(row.get("SHIIRESAKICD")));
		if(!StringUtils.isBlank(row.get("EFFECTIVEDT"))){
			bean.setEffectiveDate(changeStringToDate(StringUtil.nvl(row.get("EFFECTIVEDT"))));
		}
		if(!StringUtils.isBlank(row.get("INEFFECTIVEDT"))){
		bean.setIneffectiveDate(changeStringToDate(StringUtil.nvl(row.get("INEFFECTIVEDT"))));
		}
		bean.setChoaitoCd(StringUtil.nvl(row.get("CHOAITOCD")));
		bean.setShiiresakiNm(StringUtil.nvl(row.get("SHIIRESAKINM")));
		bean.setShiiresakiNmKana(StringUtil.nvl(row.get("SHIIRESAKINMKANA")));
		bean.setShiiresakiSnNm(StringUtil.nvl(row.get("SHIIRESAKI_SN_NM")));
		bean.setMainuserNm(StringUtil.nvl(row.get("MAINUSERNM")));
		bean.setManagerNm(StringUtil.nvl(row.get("MANAGERNM")));
		bean.setBushomei(StringUtil.nvl(row.get("BUSHOMEI")));
		bean.setPostNo(StringUtil.nvl(row.get("POSTNO")));
		bean.setAdr(StringUtil.nvl(row.get("ADR")));
		bean.setTelNo(StringUtil.nvl(row.get("TELNO")));
		bean.setFaxNo(StringUtil.nvl(row.get("FAXNO")));
		bean.setTorihikistartDate(changeStringToDate(StringUtil.nvl(row.get("TORIHIKISTARTDT"))));
		bean.setTorihikiendDate(changeStringToDate(StringUtil.nvl(row.get("TORIHIKIENDDT"))));
		bean.setDispFlg(StringUtil.nvl(row.get("DISP_FLG")));
		bean.setExclCnt(StringUtil.nvl(row.get("EXCL_CNT")));
		
		return bean;
	}

	/**
	 * [�T �v]:�ǉ��B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean �d����}�X�^�i�ꗗ�j bean
	 * @throws Exception
	 */
	public void insert(SupEntryBean bean) throws Exception {
		// DAO�擾
		SupEntryDAO dao = new SupEntryDAO();
		dao.insert(bean);
	}

	/**
	 * [�T �v]:�X�V�B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean 
	 * @throws Exception
	 */
	public void update(SupEntryBean bean) throws Exception {
		// DAO�擾
		SupEntryDAO dao = new SupEntryDAO();
		dao.update(bean);
	}

	/**
	 * [�T �v]:�폜�B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean 
	 * @throws Exception
	 */
	public void delete(SupEntryBean bean) throws Exception {
		// DAO�擾
		SupEntryDAO dao = new SupEntryDAO();
		dao.delete(bean);
	}

	/**
	 * [�T �v]:�r���`�F�b�N<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean 
	 * @return boolean
	 * @throws Exception
	 */
	public boolean checkExcl(SupEntryBean bean) throws Exception {
		// �r���`�F�b�N
		SupEntryDAO dao = new SupEntryDAO();
		return dao.checkExcl(bean);
	}

	/**
	 * [�T �v]:�r���`�F�b�N<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean 
	 * @return boolean
	 * @throws Exception
	 */
	public boolean checkExcl2(SupEntryBean bean) throws Exception {
		// �r���`�F�b�N
		SupEntryDAO dao = new SupEntryDAO();
		return dao.checkExcl2(bean);
	}
	
	/**
	 * [�T �v]:���͍��ڃ`�F�b�N�B<br>
	 * [�� ��]:<br>
	 * [�� �l]:
	 * 
	 * @param bean 
	 * @return �G���[���b�Z�[�W
	 * @throws Exception
	 */
	public String validator(boolean exclFlg, SupEntryBean bean) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		// �r���`�F�b�N
		if (exclFlg && !checkExcl(bean)  && !checkExcl2(bean) ) {
			return Properties.getMsg(Constants.EXCL_ERROR, true);
		}
		
		/*// �d����R�[�h���̓`�F�b�N
		String siireMsg = InputChecker.checkEisuji(bean.getSiireCd(), "�d����R�[�h", 1, "20");
		if (!StringUtil.isNull(siireMsg)) {
			sb.append(siireMsg);
		} else {
			// �V�K���A���łɑ��݃`�F�b�N
			if (!exclFlg && checkSiireCdExists(bean)) {
				sb.append(Properties.getMsg("ERROR.HA.036", new String[]{"�d����R�[�h"}, true));
			}
		}*/
		// �d���於���̓`�F�b�N
		sb.append(InputChecker.checkMulti(bean.getShiiresakiNm(), "�d���於", 1, "20", ""));
		// �d���於�i�J�i�j���̓`�F�b�N
		sb.append(InputChecker.checkHalf(bean.getShiiresakiNmKana(), "�d���於�i�J�i�j", 1, "25"));
		//�d����Z�k��
		sb.append(InputChecker.checkMulti(bean.getShiiresakiSnNm(), "�d����Z�k��", 1, "8", ""));
		// ��\�Җ�
		sb.append(InputChecker.checkMulti(bean.getMainuserNm(), "��\�Җ�", 0, "20", ""));
		// �S���Җ�
		sb.append(InputChecker.checkMulti(bean.getManagerNm(), "�S���Җ�", 0, "20", ""));
		
		/*// �d���於1���̓`�F�b�N
		sb.append(InputChecker.checkMulti(bean.getSiireNm1(), "�d���於1", 1, "20", ""));
		// �d���於2���̓`�F�b�N
		sb.append(InputChecker.checkMulti(bean.getSiireNm2(), "�d���於2", 0, "20", ""));
		// �X�֔ԍ��K�{���̓`�F�b�N
		sb.append(InputChecker.checkNumber(bean.getSiireZip1(), "�X�֔ԍ��P", 1, "3", null, 0));
		sb.append(InputChecker.checkNumber(bean.getSiireZip2(), "�X�֔ԍ��Q", 1, "4", null, 0));
		// �d����Z��1���̓`�F�b�N
		sb.append(InputChecker.checkMulti(bean.getSiireAddr1(), "�d����Z���P", 1, null, "50"));
		// �d����Z��2���̓`�F�b�N
		sb.append(InputChecker.checkMulti(bean.getSiireAddr2(), "�d����Z���Q", 0, null, "50"));
		// �d����Z��3���̓`�F�b�N
		sb.append(InputChecker.checkMulti(bean.getSiireAddr3(), "�d����Z���R", 0, null, "50"));
		// �d����d�b�ԍ����̓`�F�b�N
		sb.append(InputChecker.checkTel(bean.getSiireTel(), "�d�b�ԍ�", 1, "15"));
		// FAX���̓`�F�b�N
		sb.append(InputChecker.checkTel(bean.getSiireFax(), "FAX", 0, "50"));
		// �d����S����
		sb.append(InputChecker.checkMulti(bean.getSiireTantoNm(), "�d����S����", 0, "20", ""));
		// ���[���A�h���X�̃`�F�b�N
		sb.append(InputChecker.checkMail(bean.getSiireTantoMail(), "���[���A�h���X", 0, "250"));*/
		
		return sb.toString();
	}

	/**
	 * [�T �v]:�V�K�o�^���A�d����R�[�h�����łɑ��݂��Ă��邩�`�F�b�N����B<br>
	 * [�� ��]:�V�K�o�^���A�d����R�[�h�����łɑ��݂��Ă��邩�`�F�b�N����B<br>
	 * [�� �l]:
	 * @param bean
	 * @return �`�F�b�N����
	 */
	private boolean checkSiireCdExists(SupEntryBean bean) throws Exception {
		SupEntryDAO dao = new SupEntryDAO();
		return dao.checkSiireCdExists(bean);
	}
	
	/**
	 * [�T �v]:�`����yyyyMMdd����yyyy/MM/dd�ɕϊ��B<br>
	 * [�� ��]:�`����yyyyMMdd����yyyy/MM/dd�ɕϊ��B<br>
	 * [�� �l]:
	 * @param strDate
	 * @return date
	 */
	public static String changeStringToDate(String strDate) throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdfNew = new SimpleDateFormat("yyyy/MM/dd");
		String date = sdfNew.format(sdf.parse(strDate));
	return date;
	}
}
