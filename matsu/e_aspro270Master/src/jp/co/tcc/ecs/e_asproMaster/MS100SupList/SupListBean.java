package jp.co.tcc.ecs.e_asproMaster.MS100SupList;

import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecs.e_asproComm.common.BaseBean;

/**
 * [�T �v]:�d����}�X�^�i�ꗗ�jbean<br>
 * [�� ��]:�d����}�X�^�i�ꗗ�jbean<br>
 * [�� �l]:<br>
 * ���쌠: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupListBean extends BaseBean {

	/** �J�ڐ��JSP */
	public static final String RETRUN_URL = "master/MS100SupList.jsp";
	/** �J�ڐ��ACTION */
	public static final String RETRUN_URL2 = "/e_asproMaster/MS100SupList";
	/** �p�[�WID */
	public static final String PAGE_ID = "MS100";
	// �N��
	private String processType = "";
	// �r���J�E���^
	private String exclCnt = "";
	// ���[�UCo_no
	private String coNo = "";
	// ���[�UCo_no
	private String userNo = "";
	// �G���[���b�Z�[�W
	private String strErrMsg = "";
	// ����
	private String searchKbn = "1";
	// �����d����CD
	private String searchSiireCd = "";
	// �����d���於
	private String searchSiireNm = "";
	// �\���t���O
	private String searchDispFlg ="";
	// ��������
	private Vector<Map<String, String>> list = null;
	// �\�[�gNo�X�V�p
	private String motoSiireCd = "";
	private String chgSiireCd = "";
	private String sortKbn = "";

	/**
	 * [�T �v]:�ԉ�p�Q��Map�B<br>
	 * [�� ��]:���͂��ꂽ�����������l�����ɐݒ肵�d����������ʂ���߂�p�B<br>
	 * [�� �l]:
	 */
	protected void setSearchParamMap() {
		super.setSearchParamMap();
		this.addParamMap("processType", this.processType);
		this.addParamMap("searchKbn", this.searchKbn);
		this.addParamMap("searchSiireCd", this.searchSiireCd);
		this.addParamMap("searchSiireNm", this.searchSiireNm);
		this.addParamMap("searchDispFlg", this.searchDispFlg);
		this.addParamMap("coNo", this.coNo);
	}

	/**
	 * [�T �v]:processType���擾����<br>
	 * 
	 * @return processType
	 */
	public String getProcessType() {
		return processType;
	}

	/**
	 * [�T �v]:processType��ݒ肷��<br>
	 * 
	 * @param processType
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	/**
	 * [�T �v]:exclCnt���擾����<br>
	 * 
	 * @return exclCnt
	 */
	public String getExclCnt() {
		return exclCnt;
	}

	/**
	 * [�T �v]:exclCnt��ݒ肷��<br>
	 * 
	 * @param exclCnt
	 */
	public void setExclCnt(String exclCnt) {
		this.exclCnt = exclCnt;
	}

	/**
	 * [�T �v]:coNo���擾����<br>
	 * 
	 * @return coNo
	 */
	public String getCoNo() {
		return coNo;
	}

	/**
	 * [�T �v]:coNo��ݒ肷��<br>
	 * 
	 * @param coNo
	 */
	public void setCoNo(String coNo) {
		this.coNo = coNo;
	}

	/**
	 * [�T �v]:userNo���擾����<br>
	 * 
	 * @return userNo
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * [�T �v]:userNo��ݒ肷��<br>
	 * 
	 * @param userNo
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	/**
	 * [�T �v]:strErrMsg���擾����<br>
	 * 
	 * @return strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * [�T �v]:strErrMsg��ݒ肷��<br>
	 * 
	 * @param strErrMsg
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * [�T �v]:searchKbn���擾����<br>
	 * 
	 * @return searchKbn
	 */
	public String getSearchKbn() {
		return searchKbn;
	}

	/**
	 * [�T �v]:searchKbn��ݒ肷��<br>
	 * 
	 * @param searchKbn
	 */
	public void setSearchKbn(String searchKbn) {
		this.searchKbn = searchKbn;
	}

	/**
	 * [�T �v]:siireCd���擾����<br>
	 * 
	 * @return siireCd
	 */
	public String getSearchSiireCd() {
		return searchSiireCd;
	}

	/**
	 * [�T �v]:siireCd��ݒ肷��<br>
	 * 
	 * @param siireCd
	 */
	public void setSearchSiireCd(String searchSiireCd) {
		this.searchSiireCd = searchSiireCd;
	}

	/**
	 * [�T �v]:siireNm���擾����<br>
	 * 
	 * @return siireNm
	 */
	public String getSearchSiireNm() {
		return searchSiireNm;
	}

	/**
	 * [�T �v]:siireNm��ݒ肷��<br>
	 * 
	 * @param siireNm
	 */
	public void setSearchSiireNm(String searchSiireNm) {
		this.searchSiireNm = searchSiireNm;
	}

	/**
	 * [�T �v]:dispFlg���擾����<br>
	 * 
	 * @return dispFlg
	 */
	public String getSearchDispFlg() {
		return searchDispFlg;
	}

	/**
	 * [�T �v]:dispFlg��ݒ肷��<br>
	 * 
	 * @param dispFlg
	 */
	public void setSearchDispFlg(String searchDispFlg) {
		this.searchDispFlg = searchDispFlg;
	}

	/**
	 * [�T �v]:list���擾����<br>
	 * 
	 * @return list
	 */
	public Vector<Map<String, String>> getList() {
		return list;
	}

	/**
	 * [�T �v]:list��ݒ肷��<br>
	 * 
	 * @param list
	 */
	public void setList(Vector<Map<String, String>> list) {
		this.list = list;
	}

	/**
	 * [�T �v]:motoSiireCd���擾����<br>
	 * 
	 * @return motoSiireCd
	 */
	public String getMotoSiireCd() {
		return motoSiireCd;
	}

	/**
	 * [�T �v]:motoSiireCd��ݒ肷��<br>
	 * 
	 * @param motoSiireCd
	 */
	public void setMotoSiireCd(String motoSiireCd) {
		this.motoSiireCd = motoSiireCd;
	}

	/**
	 * [�T �v]:chgSiireCd���擾����<br>
	 * 
	 * @return chgSiireCd
	 */
	public String getChgSiireCd() {
		return chgSiireCd;
	}

	/**
	 * [�T �v]:chgSiireCd��ݒ肷��<br>
	 * 
	 * @param chgSiireCd
	 */
	public void setChgSiireCd(String chgSiireCd) {
		this.chgSiireCd = chgSiireCd;
	}

	/**
	 * [�T �v]:sortKbn���擾����<br>
	 * 
	 * @return sortKbn
	 */
	public String getSortKbn() {
		return sortKbn;
	}

	/**
	 * [�T �v]:sortKbn��ݒ肷��<br>
	 * 
	 * @param sortKbn
	 */
	public void setSortKbn(String sortKbn) {
		this.sortKbn = sortKbn;
	}

}
