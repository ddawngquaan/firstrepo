package jp.co.tcc.ecs.e_asproMaster.MS101SupEntry;

import java.util.Date;
import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecs.e_asproComm.common.BaseBean;

public class SupEntryBean extends BaseBean {

	// �J�ڐ�URL*/
	public static final String FORWARD_URL = "master/MS101SupEntry.jsp";
	// �����敪
	private String processType = "";
	// �r���J�E���^
	private String exclCnt = "";
	// �O���URL
	private String backUrl = "";
	// ��ʏ����敪
	private String processKbn = "";
	// ���O�C�����[�U�[No
	private String loginUserNo = "";
	// �G���[���b�Z�[�W
	private String strErrMsg = "";
	// ���No
	private Integer coNo;
	
	// �d����R�[�h
	private String shiiresakiCd = "";
	// ������
	private String effectiveDate= "";
	// ������
	private String  ineffectiveDate= "";
	// ������R�[�h
	private String choaitoCd = "";
	// �d���於
	private String shiiresakiNm = "";
	// �d���於�i�J�i�j
	private String shiiresakiNmKana = "";
	// �d����Z�k��
	private String shiiresakiSnNm = "";
	// ��\�Җ�
	private String mainuserNm = "";
	// �S���Җ�
	private String managerNm = "";
	// ������
	private String bushomei = "";
	// �X�֔ԍ� 
	private String postNo = "";
	// �Z��
	private String adr = "";
	// �d�b�ԍ�
	private String telNo = "";
	// �e�`�w�ԍ�
	private String faxNo = "";
	// ����J�n��
	private String torihikistartDate = "";
	// ����I����
	private String torihikiendDate = "";
	// �\���t���O
	private String dispFlg = "";
	
	// �d����R�[�h
	private String siireCd = "";
	// �d���於�P
	private String siireNm1 = "";
	// �d���於2
	private String siireNm2 = "";
	// �X�֔ԍ�1(�t�H�[���f�[�^)
	private String siireZip1 = "";
	// �X�֔ԍ�2(�t�H�[���f�[�^)
	private String siireZip2 = "";
	// �Z��1(�t�H�[���f�[�^)
	private String siireAddr1 = "";
	// �Z��2(�t�H�[���f�[�^)
	private String siireAddr2 = "";
	// �Z��3(�t�H�[���f�[�^)
	private String siireAddr3 = "";
	// �d�b�ԍ�(�t�H�[���f�[�^)
	private String siireTel = "";
	// FAX
	private String siireFax = "";
	// �d����S����
	private String siireTantoNm = "";
	// ���[��
	private String siireTantoMail = "";
	
	/**
	 * [�T �v]:shiiresakiCd���擾����<br>
	 * 
	 * @return shiiresakiCd
	 */
	public String getShiiresakiCd() {
		return shiiresakiCd;
	}

	/**
	 * [�T �v]:shiiresakiCd��ݒ肷��<br>
	 * 
	 * @param shiiresakiCd
	 */
	public void setShiiresakiCd(String shiiresakiCd) {
		this.shiiresakiCd = shiiresakiCd;
	}

	/**
	 * [�T �v]:choaitoCd���擾����<br>
	 * 
	 * @return choaitoCd
	 */
	public String getChoaitoCd() {
		return choaitoCd;
	}

	/**
	 * [�T �v]:choaitoCd��ݒ肷��<br>
	 * 
	 * @param choaitoCd
	 */	 
	public void setChoaitoCd(String choaitoCd) {
		this.choaitoCd = choaitoCd;
	}

	/**
	 * [�T �v]:shiiresakiNm���擾����<br>
	 * 
	 * @return shiiresakiNm
	 */
	public String getShiiresakiNm() {
		return shiiresakiNm;
	}

	/**
	 * [�T �v]:shiiresakiNm��ݒ肷��<br>
	 * 
	 * @param shiiresakiNm
	 */	 
	public void setShiiresakiNm(String shiiresakiNm) {
		this.shiiresakiNm = shiiresakiNm;
	}

	/**
	 * [�T �v]:shiiresakiNmKana���擾����<br>
	 * 
	 * @return shiiresakiNmKana
	 */
	public String getShiiresakiNmKana() {
		return shiiresakiNmKana;
	}

	/**
	 * [�T �v]:shiiresakiNmKana��ݒ肷��<br>
	 * 
	 * @param shiiresakiNmKana
	 */	 
	public void setShiiresakiNmKana(String shiiresakiNmKana) {
		this.shiiresakiNmKana = shiiresakiNmKana;
	}

	/**
	 * [�T �v]:shiiresakiSnNm���擾����<br>
	 * 
	 * @return shiiresakiSnNm
	 */
	public String getShiiresakiSnNm() {
		return shiiresakiSnNm;
	}

	/**
	 * [�T �v]:shiiresakiSnNm��ݒ肷��<br>
	 * 
	 * @param shiiresakiSnNm
	 */	 
	public void setShiiresakiSnNm(String shiiresakiSnNm) {
		this.shiiresakiSnNm = shiiresakiSnNm;
	}

	/**
	 * [�T �v]:mainuserNm���擾����<br>
	 * 
	 * @return mainuserNm
	 */
	public String getMainuserNm() {
		return mainuserNm;
	}

	/**
	 * [�T �v]:mainuserNm��ݒ肷��<br>
	 * 
	 * @param mainuserNm
	 */	 
	public void setMainuserNm(String mainuserNm) {
		this.mainuserNm = mainuserNm;
	}

	/**
	 * [�T �v]:managerNm���擾����<br>
	 * 
	 * @return managerNm
	 */
	public String getManagerNm() {
		return managerNm;
	}

	/**
	 * [�T �v]:managerNm��ݒ肷��<br>
	 * 
	 * @param managerNm
	 */	 
	public void setManagerNm(String managerNm) {
		this.managerNm = managerNm;
	}

	/**
	 * [�T �v]:bushomei���擾����<br>
	 * 
	 * @return bushomei
	 */
	public String getBushomei() {
		return bushomei;
	}

	/**
	 * [�T �v]:bushomei��ݒ肷��<br>
	 * 
	 * @param bushomei
	 */	 
	public void setBushomei(String bushomei) {
		this.bushomei = bushomei;
	}

	/**
	 * [�T �v]:postNo���擾����<br>
	 * 
	 * @return postNo
	 */
	public String getPostNo() {
		return postNo;
	}

	/**
	 * [�T �v]:postNo��ݒ肷��<br>
	 * 
	 * @param postNo
	 */	 
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	/**
	 * [�T �v]:adr���擾����<br>
	 * 
	 * @return adr
	 */
	public String getAdr() {
		return adr;
	}

	/**
	 * [�T �v]:adr��ݒ肷��<br>
	 * 
	 * @param adr
	 */	
	public void setAdr(String adr) {
		this.adr = adr;
	}

	/**
	 * [�T �v]:telNo���擾����<br>
	 * 
	 * @return telNo
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * [�T �v]:telNo��ݒ肷��<br>
	 * 
	 * @param telNo
	 */	 
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * [�T �v]:faxNo���擾����<br>
	 * 
	 * @return faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}

	/**
	 * [�T �v]:faxNo��ݒ肷��<br>
	 * 
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	/**
	 * [�T �v]:dispFlg���擾����<br>
	 * 
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return dispFlg;
	}

	/**
	 * [�T �v]:dispFlg��ݒ肷��<br>
	 * 
	 * @param dispFlg
	 */	 
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
	}
	
	/**
	 * [�T �v]:effectiveDate���擾����<br>
	 * 
	 * @return effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * [�T �v]:effectiveDate��ݒ肷��<br>
	 * 
	 * @param effectiveDate
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * [�T �v]:ineffectiveDate���擾����<br>
	 * 
	 * @return ineffectiveDate
	 */
	public String getIneffectiveDate() {
		return ineffectiveDate;
	}

	/**
	 * [�T �v]:ineffectiveDate��ݒ肷��<br>
	 * 
	 * @param ineffectiveDate
	 */	
	public void setIneffectiveDate(String ineffectiveDate) {
		this.ineffectiveDate = ineffectiveDate;
	}

	/**
	 * [�T �v]:torihikistartDate���擾����<br>
	 * 
	 * @return torihikistartDate
	 */
	public String getTorihikistartDate() {
		return torihikistartDate;
	}

	/**
	 * [�T �v]:torihikistartDate��ݒ肷��<br>
	 * 
	 * @param torihikistartDate
	 */	 
	public void setTorihikistartDate(String torihikistartDate) {
		this.torihikistartDate = torihikistartDate;
	}

	/**
	 * [�T �v]:torihikiendDate���擾����<br>
	 * 
	 * @return torihikiendDate
	 */
	public String getTorihikiendDate() {
		return torihikiendDate;
	}

	/**
	 * [�T �v]:torihikiendDate��ݒ肷��<br>
	 * 
	 * @param torihikiendDate
	 */
	public void setTorihikiendDate(String torihikiendDate) {
		this.torihikiendDate = torihikiendDate;
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
	 * [�T �v]:processType<br>
	 * 
	 * @param processType��ݒ肷��
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	/**
	 * [�T �v]:excl_Cnt���擾����<br>
	 * 
	 * @return excl_Cnt
	 */
	public String getExclCnt() {
		return exclCnt;
	}

	/**
	 * [�T �v]:excl_Cnt��ݒ肷��<br>
	 * 
	 * @param excl_Cnt
	 */
	public void setExclCnt(String exclCnt) {
		this.exclCnt = exclCnt;
	}

	/**
	 * [�T �v]:backUrl���擾����<br>
	 * 
	 * @return backUrl
	 */
	public String getBackUrl() {
		return backUrl;
	}

	/**
	 * [�T �v]:backUrl��ݒ肷��<br>
	 * 
	 * @param backUrl
	 */
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	/**
	 * [�T �v]:processKbn���擾����<br>
	 * 
	 * @return processKbn
	 */
	public String getProcessKbn() {
		return processKbn;
	}

	/**
	 * [�T �v]:processKbn��ݒ肷��<br>
	 * 
	 * @param processKbn
	 */
	public void setProcessKbn(String processKbn) {
		this.processKbn = processKbn;
	}

	/**
	 * [�T �v]:loginUserNo���擾����<br>
	 * 
	 * @return loginUserNo
	 */
	public String getLoginUserNo() {
		return loginUserNo;
	}

	/**
	 * [�T �v]:loginUserNo��ݒ肷��<br>
	 * 
	 * @param loginUserNo
	 */
	public void setLoginUserNo(String loginUserNo) {
		this.loginUserNo = loginUserNo;
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
	 * [�T �v]:coNo���擾����<br>
	 * 
	 * @return coNo
	 */
	public Integer getCoNo() {
		return coNo;
	}

	/**
	 * [�T �v]:coNo��ݒ肷��<br>
	 * 
	 * @param coNo
	 */
	public void setCoNo(Integer coNo) {
		this.coNo = coNo;
	}

	/**
	 * [�T �v]:siireCd���擾����<br>
	 * 
	 * @return siireCd
	 */
	public String getSiireCd() {
		return siireCd;
	}

	/**
	 * [�T �v]:siireCd��ݒ肷��<br>
	 * 
	 * @param siireCd
	 */
	public void setSiireCd(String siireCd) {
		this.siireCd = siireCd;
	}

	/**
	 * [�T �v]:siireNm1���擾����<br>
	 * 
	 * @return siireNm1
	 */
	public String getSiireNm1() {
		return siireNm1;
	}

	/**
	 * [�T �v]:siireNm1��ݒ肷��<br>
	 * 
	 * @param siireNm1
	 */
	public void setSiireNm1(String siireNm1) {
		this.siireNm1 = siireNm1;
	}

	/**
	 * [�T �v]:siireNm2���擾����<br>
	 * 
	 * @return siireNm2
	 */
	public String getSiireNm2() {
		return siireNm2;
	}

	/**
	 * [�T �v]:siireNm2��ݒ肷��<br>
	 * 
	 * @param siireNm2
	 */
	public void setSiireNm2(String siireNm2) {
		this.siireNm2 = siireNm2;
	}

	/**
	 * [�T �v]:siireZip1���擾����<br>
	 * 
	 * @return siireZip1
	 */
	public String getSiireZip1() {
		return siireZip1;
	}

	/**
	 * [�T �v]:siireZip1��ݒ肷��<br>
	 * 
	 * @param siireZip1
	 */
	public void setSiireZip1(String siireZip1) {
		this.siireZip1 = siireZip1;
	}

	/**
	 * [�T �v]:siireZip2���擾����<br>
	 * 
	 * @return siireZip2
	 */
	public String getSiireZip2() {
		return siireZip2;
	}

	/**
	 * [�T �v]:siireZip2��ݒ肷��<br>
	 * 
	 * @param siireZip2
	 */
	public void setSiireZip2(String siireZip2) {
		this.siireZip2 = siireZip2;
	}

	/**
	 * [�T �v]:siireAddr1���擾����<br>
	 * 
	 * @return siireAddr1
	 */
	public String getSiireAddr1() {
		return siireAddr1;
	}

	/**
	 * [�T �v]:siireAddr1��ݒ肷��<br>
	 * 
	 * @param siireAddr1
	 */
	public void setSiireAddr1(String siireAddr1) {
		this.siireAddr1 = siireAddr1;
	}

	/**
	 * [�T �v]:siireAddr2���擾����<br>
	 * 
	 * @return siireAddr2
	 */
	public String getSiireAddr2() {
		return siireAddr2;
	}

	/**
	 * [�T �v]:siireAddr2��ݒ肷��<br>
	 * 
	 * @param siireAddr2
	 */
	public void setSiireAddr2(String siireAddr2) {
		this.siireAddr2 = siireAddr2;
	}

	/**
	 * [�T �v]:siireAddr3���擾����<br>
	 * 
	 * @return siireAddr3
	 */
	public String getSiireAddr3() {
		return siireAddr3;
	}

	/**
	 * [�T �v]:siireAddr3��ݒ肷��<br>
	 * 
	 * @param siireAddr3
	 */
	public void setSiireAddr3(String siireAddr3) {
		this.siireAddr3 = siireAddr3;
	}

	/**
	 * [�T �v]:siireTel���擾����<br>
	 * 
	 * @return siireTel
	 */
	public String getSiireTel() {
		return siireTel;
	}

	/**
	 * [�T �v]:siireTel��ݒ肷��<br>
	 * 
	 * @param siireTel
	 */
	public void setSiireTel(String siireTel) {
		this.siireTel = siireTel;
	}

	/**
	 * [�T �v]:siireFax���擾����<br>
	 * 
	 * @return siireFax
	 */
	public String getSiireFax() {
		return siireFax;
	}

	/**
	 * [�T �v]:siireFax��ݒ肷��<br>
	 * 
	 * @param siireFax
	 */
	public void setSiireFax(String siireFax) {
		this.siireFax = siireFax;
	}

	/**
	 * [�T �v]:siireTantoNm���擾����<br>
	 * 
	 * @return siireTantoNm
	 */
	public String getSiireTantoNm() {
		return siireTantoNm;
	}

	/**
	 * [�T �v]:siireTantoNm��ݒ肷��<br>
	 * 
	 * @param siireTantoNm
	 */
	public void setSiireTantoNm(String siireTantoNm) {
		this.siireTantoNm = siireTantoNm;
	}

	/**
	 * [�T �v]:siireTantoMail���擾����<br>
	 * 
	 * @return siireTantoMail
	 */
	public String getSiireTantoMail() {
		return siireTantoMail;
	}

	/**
	 * [�T �v]:siireTantoMail��ݒ肷��<br>
	 * 
	 * @param siireTantoMail
	 */
	public void setSiireTantoMail(String siireTantoMail) {
		this.siireTantoMail = siireTantoMail;
	}

}
