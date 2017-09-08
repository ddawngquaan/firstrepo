package jp.co.tcc.ecs.e_asproZaiko.ZI021ZaikoAdjEntry;

import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecs.e_asproComm.common.BaseBean;

/**
 * [�T �v]:�݌ɒ�������bean<br>
 * [�� ��]:�݌ɒ�������bean<br>
 * [�� �l]:<br>
 * ���쌠: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author chengj
 * @version 1.0
 * @since 1.0
 */
public class ZaikoAdjEntryBean extends BaseBean {

	// �J�ڐ��JSP
	public static final String RETRUN_URL = "zaiko/ZI021ZaikoAdjEntry.jsp";
	// �J�ڐ��ACTION
	public static final String RETRUN_URL2 = "/e_asproZaiko/ZI021ZaikoAdjEntry";
	// �݌Ɉꗗ��ʁiZI020ZaikoAdjList�j�֑J�ڂ�ACTION
	public static final String RETRUN_URL3 = "/e_asproZaiko/ZI020ZaikoAdjList";
	// �N��
	private String processType = "";
	// �����敪
	private String searchKbn = "";
	// ���NO
	private String coNo = "";
	// �G���[���Z�b�W
	private String strErrMsg = "";
	// �r���J�E���^
	private String exclCnt = "";
	// ��������
	// ���i�R�[�h
	private String zaikoItemNo = "";
	// �q�ɃR�[�h
	private String whCd = "";
	// �݌ɏ��
	private String zaikoJoutaiKbn = "";
	// �݌ɏڍ׏��
	// ���i��
	private String zaikoItemNm = "";
	// �q�ɖ�
	private String whNm = "";
	// �݌ɏ�Ԗ�
	private String zaikoJoutaiNm = "";
	// ���݌�
	private String qty = "";
	// ������
	private String hikiQty = "";
	// �L���݌�
	private String realQty = "";
	// �݌ɒ���
	// �����敪
	private String adjustKbn = "";
	// �U�֐�@�݌ɏ��
	private String adjZaikoJoutai = "";
	// ������
	private String adjustQty = "";
	// �R�����g
	private String biko = "";	
	// �����敪���X�g
	private Vector<Map<String, String>> adjustKbnList = null;
	// �U�֐�@�݌ɏ�ԃ��X�g
	private Vector<Map<String, String>> adjZaikoJoutaiList = null;

	/**
	 * [�T �v]:�ԉ�p�Q��Map�B<br>
	 * [�� ��]:���͂��ꂽ�����������l�����ɐݒ肵�d����������ʂ���߂�p�B<br>
	 * [�� �l]:
	 */
	protected void setSearchParamMap() {
		super.setSearchParamMap();
		this.addParamMap("processType", this.processType);
		this.addParamMap("coNo", this.coNo);
		this.addParamMap("exclCnt", this.exclCnt);
		this.addParamMap("zaikoItemNo", this.zaikoItemNo);
		this.addParamMap("whCd", this.whCd);
		this.addParamMap("zaikoJoutaiKbn", this.zaikoJoutaiKbn);
		this.addParamMap("zaikoItemNm", this.zaikoItemNm);
		this.addParamMap("whNm", this.whNm);
		this.addParamMap("zaikoJoutaiNm", this.zaikoJoutaiNm);
		this.addParamMap("qty", this.qty);
		this.addParamMap("hikiQty", this.hikiQty);
		this.addParamMap("realQty", this.realQty);
		this.addParamMap("adjustKbn", this.adjustKbn);
		this.addParamMap("adjZaikoJoutai", this.adjZaikoJoutai);
		this.addParamMap("adjustQty", this.adjustQty);
		this.addParamMap("biko", this.biko);
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return processType
	 */
	public String getProcessType() {
		return processType;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param processType ��ݒ肷��
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return searchKbn
	 */
	public String getSearchKbn() {
		return searchKbn;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param searchKbn ��ݒ肷��
	 */
	public void setSearchKbn(String searchKbn) {
		this.searchKbn = searchKbn;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return coNo
	 */
	public String getCoNo() {
		return coNo;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param coNo ��ݒ肷��
	 */
	public void setCoNo(String coNo) {
		this.coNo = coNo;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param strErrMsg ��ݒ肷��
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return exclCnt
	 */
	public String getExclCnt() {
		return exclCnt;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param exclCnt ��ݒ肷��
	 */
	public void setExclCnt(String exclCnt) {
		this.exclCnt = exclCnt;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return zaikoItemNo
	 */
	public String getZaikoItemNo() {
		return zaikoItemNo;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param zaikoItemNo ��ݒ肷��
	 */
	public void setZaikoItemNo(String zaikoItemNo) {
		this.zaikoItemNo = zaikoItemNo;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return whCd
	 */
	public String getWhCd() {
		return whCd;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param whCd ��ݒ肷��
	 */
	public void setWhCd(String whCd) {
		this.whCd = whCd;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return zaikoJoutaiKbn
	 */
	public String getZaikoJoutaiKbn() {
		return zaikoJoutaiKbn;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param zaikoJoutaiKbn ��ݒ肷��
	 */
	public void setZaikoJoutaiKbn(String zaikoJoutaiKbn) {
		this.zaikoJoutaiKbn = zaikoJoutaiKbn;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return zaikoItemNm
	 */
	public String getZaikoItemNm() {
		return zaikoItemNm;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param zaikoItemNm ��ݒ肷��
	 */
	public void setZaikoItemNm(String zaikoItemNm) {
		this.zaikoItemNm = zaikoItemNm;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return whNm
	 */
	public String getWhNm() {
		return whNm;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param whNm ��ݒ肷��
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return zaikoJoutaiNm
	 */
	public String getZaikoJoutaiNm() {
		return zaikoJoutaiNm;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param zaikoJoutaiNm ��ݒ肷��
	 */
	public void setZaikoJoutaiNm(String zaikoJoutaiNm) {
		this.zaikoJoutaiNm = zaikoJoutaiNm;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return qty
	 */
	public String getQty() {
		return qty;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param qty ��ݒ肷��
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return hikiQty
	 */
	public String getHikiQty() {
		return hikiQty;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param hikiQty ��ݒ肷��
	 */
	public void setHikiQty(String hikiQty) {
		this.hikiQty = hikiQty;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return realQty
	 */
	public String getRealQty() {
		return realQty;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param realQty ��ݒ肷��
	 */
	public void setRealQty(String realQty) {
		this.realQty = realQty;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return adjustKbn
	 */
	public String getAdjustKbn() {
		return adjustKbn;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param adjustKbn ��ݒ肷��
	 */
	public void setAdjustKbn(String adjustKbn) {
		this.adjustKbn = adjustKbn;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return adjZaikoJoutai
	 */
	public String getAdjZaikoJoutai() {
		return adjZaikoJoutai;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param adjZaikoJoutai ��ݒ肷��
	 */
	public void setAdjZaikoJoutai(String adjZaikoJoutai) {
		this.adjZaikoJoutai = adjZaikoJoutai;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return adjustQty
	 */
	public String getAdjustQty() {
		return adjustQty;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param comment��ݒ肷��
	 */
	public void setBiko(String biko) {
		this.biko = biko;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return comment
	 */
	public String getBiko() {
		return biko;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param adjustQty ��ݒ肷��
	 */
	public void setAdjustQty(String adjustQty) {
		this.adjustQty = adjustQty;
	}	
	
	/**
	 * [�T �v]:<br>
	 * 
	 * @return adjustList
	 */
	public Vector<Map<String, String>> getAdjustKbnList() {
		return adjustKbnList;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param adjustKbnList ��ݒ肷��
	 */
	public void setAdjustKbnList(Vector<Map<String, String>> adjustKbnList) {
		this.adjustKbnList = adjustKbnList;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @return zaikoJoutaiList
	 */
	public Vector<Map<String, String>> getAdjZaikoJoutaiList() {
		return adjZaikoJoutaiList;
	}

	/**
	 * [�T �v]:<br>
	 * 
	 * @param adjZaikoJoutaiList ��ݒ肷��
	 */
	public void setAdjZaikoJoutaiList(Vector<Map<String, String>> adjZaikoJoutaiList) {
		this.adjZaikoJoutaiList = adjZaikoJoutaiList;
	}

}
