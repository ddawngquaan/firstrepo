package jp.co.tcc.ecs.e_asproMaster.MS101SupEntry;

import java.util.Date;
import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecs.e_asproComm.common.BaseBean;

public class SupEntryBean extends BaseBean {

	// 遷移先URL*/
	public static final String FORWARD_URL = "master/MS101SupEntry.jsp";
	// 処理区分
	private String processType = "";
	// 排他カウンタ
	private String exclCnt = "";
	// 前画面URL
	private String backUrl = "";
	// 画面処理区分
	private String processKbn = "";
	// ログインユーザーNo
	private String loginUserNo = "";
	// エラーメッセージ
	private String strErrMsg = "";
	// 会社No
	private Integer coNo;
	
	// 仕入先コード
	private String shiiresakiCd = "";
	// 発効日
	private String effectiveDate= "";
	// 失効日
	private String  ineffectiveDate= "";
	// 帳合先コード
	private String choaitoCd = "";
	// 仕入先名
	private String shiiresakiNm = "";
	// 仕入先名（カナ）
	private String shiiresakiNmKana = "";
	// 仕入先短縮名
	private String shiiresakiSnNm = "";
	// 代表者名
	private String mainuserNm = "";
	// 担当者名
	private String managerNm = "";
	// 部署名
	private String bushomei = "";
	// 郵便番号 
	private String postNo = "";
	// 住所
	private String adr = "";
	// 電話番号
	private String telNo = "";
	// ＦＡＸ番号
	private String faxNo = "";
	// 取引開始日
	private String torihikistartDate = "";
	// 取引終了日
	private String torihikiendDate = "";
	// 表示フラグ
	private String dispFlg = "";
	
	// 仕入先コード
	private String siireCd = "";
	// 仕入先名１
	private String siireNm1 = "";
	// 仕入先名2
	private String siireNm2 = "";
	// 郵便番号1(フォームデータ)
	private String siireZip1 = "";
	// 郵便番号2(フォームデータ)
	private String siireZip2 = "";
	// 住所1(フォームデータ)
	private String siireAddr1 = "";
	// 住所2(フォームデータ)
	private String siireAddr2 = "";
	// 住所3(フォームデータ)
	private String siireAddr3 = "";
	// 電話番号(フォームデータ)
	private String siireTel = "";
	// FAX
	private String siireFax = "";
	// 仕入先担当者
	private String siireTantoNm = "";
	// メール
	private String siireTantoMail = "";
	
	/**
	 * [概 要]:shiiresakiCdを取得する<br>
	 * 
	 * @return shiiresakiCd
	 */
	public String getShiiresakiCd() {
		return shiiresakiCd;
	}

	/**
	 * [概 要]:shiiresakiCdを設定する<br>
	 * 
	 * @param shiiresakiCd
	 */
	public void setShiiresakiCd(String shiiresakiCd) {
		this.shiiresakiCd = shiiresakiCd;
	}

	/**
	 * [概 要]:choaitoCdを取得する<br>
	 * 
	 * @return choaitoCd
	 */
	public String getChoaitoCd() {
		return choaitoCd;
	}

	/**
	 * [概 要]:choaitoCdを設定する<br>
	 * 
	 * @param choaitoCd
	 */	 
	public void setChoaitoCd(String choaitoCd) {
		this.choaitoCd = choaitoCd;
	}

	/**
	 * [概 要]:shiiresakiNmを取得する<br>
	 * 
	 * @return shiiresakiNm
	 */
	public String getShiiresakiNm() {
		return shiiresakiNm;
	}

	/**
	 * [概 要]:shiiresakiNmを設定する<br>
	 * 
	 * @param shiiresakiNm
	 */	 
	public void setShiiresakiNm(String shiiresakiNm) {
		this.shiiresakiNm = shiiresakiNm;
	}

	/**
	 * [概 要]:shiiresakiNmKanaを取得する<br>
	 * 
	 * @return shiiresakiNmKana
	 */
	public String getShiiresakiNmKana() {
		return shiiresakiNmKana;
	}

	/**
	 * [概 要]:shiiresakiNmKanaを設定する<br>
	 * 
	 * @param shiiresakiNmKana
	 */	 
	public void setShiiresakiNmKana(String shiiresakiNmKana) {
		this.shiiresakiNmKana = shiiresakiNmKana;
	}

	/**
	 * [概 要]:shiiresakiSnNmを取得する<br>
	 * 
	 * @return shiiresakiSnNm
	 */
	public String getShiiresakiSnNm() {
		return shiiresakiSnNm;
	}

	/**
	 * [概 要]:shiiresakiSnNmを設定する<br>
	 * 
	 * @param shiiresakiSnNm
	 */	 
	public void setShiiresakiSnNm(String shiiresakiSnNm) {
		this.shiiresakiSnNm = shiiresakiSnNm;
	}

	/**
	 * [概 要]:mainuserNmを取得する<br>
	 * 
	 * @return mainuserNm
	 */
	public String getMainuserNm() {
		return mainuserNm;
	}

	/**
	 * [概 要]:mainuserNmを設定する<br>
	 * 
	 * @param mainuserNm
	 */	 
	public void setMainuserNm(String mainuserNm) {
		this.mainuserNm = mainuserNm;
	}

	/**
	 * [概 要]:managerNmを取得する<br>
	 * 
	 * @return managerNm
	 */
	public String getManagerNm() {
		return managerNm;
	}

	/**
	 * [概 要]:managerNmを設定する<br>
	 * 
	 * @param managerNm
	 */	 
	public void setManagerNm(String managerNm) {
		this.managerNm = managerNm;
	}

	/**
	 * [概 要]:bushomeiを取得する<br>
	 * 
	 * @return bushomei
	 */
	public String getBushomei() {
		return bushomei;
	}

	/**
	 * [概 要]:bushomeiを設定する<br>
	 * 
	 * @param bushomei
	 */	 
	public void setBushomei(String bushomei) {
		this.bushomei = bushomei;
	}

	/**
	 * [概 要]:postNoを取得する<br>
	 * 
	 * @return postNo
	 */
	public String getPostNo() {
		return postNo;
	}

	/**
	 * [概 要]:postNoを設定する<br>
	 * 
	 * @param postNo
	 */	 
	public void setPostNo(String postNo) {
		this.postNo = postNo;
	}

	/**
	 * [概 要]:adrを取得する<br>
	 * 
	 * @return adr
	 */
	public String getAdr() {
		return adr;
	}

	/**
	 * [概 要]:adrを設定する<br>
	 * 
	 * @param adr
	 */	
	public void setAdr(String adr) {
		this.adr = adr;
	}

	/**
	 * [概 要]:telNoを取得する<br>
	 * 
	 * @return telNo
	 */
	public String getTelNo() {
		return telNo;
	}

	/**
	 * [概 要]:telNoを設定する<br>
	 * 
	 * @param telNo
	 */	 
	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}

	/**
	 * [概 要]:faxNoを取得する<br>
	 * 
	 * @return faxNo
	 */
	public String getFaxNo() {
		return faxNo;
	}

	/**
	 * [概 要]:faxNoを設定する<br>
	 * 
	 * @param faxNo
	 */
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}

	/**
	 * [概 要]:dispFlgを取得する<br>
	 * 
	 * @return dispFlg
	 */
	public String getDispFlg() {
		return dispFlg;
	}

	/**
	 * [概 要]:dispFlgを設定する<br>
	 * 
	 * @param dispFlg
	 */	 
	public void setDispFlg(String dispFlg) {
		this.dispFlg = dispFlg;
	}
	
	/**
	 * [概 要]:effectiveDateを取得する<br>
	 * 
	 * @return effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * [概 要]:effectiveDateを設定する<br>
	 * 
	 * @param effectiveDate
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	/**
	 * [概 要]:ineffectiveDateを取得する<br>
	 * 
	 * @return ineffectiveDate
	 */
	public String getIneffectiveDate() {
		return ineffectiveDate;
	}

	/**
	 * [概 要]:ineffectiveDateを設定する<br>
	 * 
	 * @param ineffectiveDate
	 */	
	public void setIneffectiveDate(String ineffectiveDate) {
		this.ineffectiveDate = ineffectiveDate;
	}

	/**
	 * [概 要]:torihikistartDateを取得する<br>
	 * 
	 * @return torihikistartDate
	 */
	public String getTorihikistartDate() {
		return torihikistartDate;
	}

	/**
	 * [概 要]:torihikistartDateを設定する<br>
	 * 
	 * @param torihikistartDate
	 */	 
	public void setTorihikistartDate(String torihikistartDate) {
		this.torihikistartDate = torihikistartDate;
	}

	/**
	 * [概 要]:torihikiendDateを取得する<br>
	 * 
	 * @return torihikiendDate
	 */
	public String getTorihikiendDate() {
		return torihikiendDate;
	}

	/**
	 * [概 要]:torihikiendDateを設定する<br>
	 * 
	 * @param torihikiendDate
	 */
	public void setTorihikiendDate(String torihikiendDate) {
		this.torihikiendDate = torihikiendDate;
	}

	/**
	 * [概 要]:processTypeを取得する<br>
	 * 
	 * @return processType
	 */
	public String getProcessType() {
		return processType;
	}

	/**
	 * [概 要]:processType<br>
	 * 
	 * @param processTypeを設定する
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	/**
	 * [概 要]:excl_Cntを取得する<br>
	 * 
	 * @return excl_Cnt
	 */
	public String getExclCnt() {
		return exclCnt;
	}

	/**
	 * [概 要]:excl_Cntを設定する<br>
	 * 
	 * @param excl_Cnt
	 */
	public void setExclCnt(String exclCnt) {
		this.exclCnt = exclCnt;
	}

	/**
	 * [概 要]:backUrlを取得する<br>
	 * 
	 * @return backUrl
	 */
	public String getBackUrl() {
		return backUrl;
	}

	/**
	 * [概 要]:backUrlを設定する<br>
	 * 
	 * @param backUrl
	 */
	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	/**
	 * [概 要]:processKbnを取得する<br>
	 * 
	 * @return processKbn
	 */
	public String getProcessKbn() {
		return processKbn;
	}

	/**
	 * [概 要]:processKbnを設定する<br>
	 * 
	 * @param processKbn
	 */
	public void setProcessKbn(String processKbn) {
		this.processKbn = processKbn;
	}

	/**
	 * [概 要]:loginUserNoを取得する<br>
	 * 
	 * @return loginUserNo
	 */
	public String getLoginUserNo() {
		return loginUserNo;
	}

	/**
	 * [概 要]:loginUserNoを設定する<br>
	 * 
	 * @param loginUserNo
	 */
	public void setLoginUserNo(String loginUserNo) {
		this.loginUserNo = loginUserNo;
	}

	/**
	 * [概 要]:strErrMsgを取得する<br>
	 * 
	 * @return strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * [概 要]:strErrMsgを設定する<br>
	 * 
	 * @param strErrMsg
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * [概 要]:coNoを取得する<br>
	 * 
	 * @return coNo
	 */
	public Integer getCoNo() {
		return coNo;
	}

	/**
	 * [概 要]:coNoを設定する<br>
	 * 
	 * @param coNo
	 */
	public void setCoNo(Integer coNo) {
		this.coNo = coNo;
	}

	/**
	 * [概 要]:siireCdを取得する<br>
	 * 
	 * @return siireCd
	 */
	public String getSiireCd() {
		return siireCd;
	}

	/**
	 * [概 要]:siireCdを設定する<br>
	 * 
	 * @param siireCd
	 */
	public void setSiireCd(String siireCd) {
		this.siireCd = siireCd;
	}

	/**
	 * [概 要]:siireNm1を取得する<br>
	 * 
	 * @return siireNm1
	 */
	public String getSiireNm1() {
		return siireNm1;
	}

	/**
	 * [概 要]:siireNm1を設定する<br>
	 * 
	 * @param siireNm1
	 */
	public void setSiireNm1(String siireNm1) {
		this.siireNm1 = siireNm1;
	}

	/**
	 * [概 要]:siireNm2を取得する<br>
	 * 
	 * @return siireNm2
	 */
	public String getSiireNm2() {
		return siireNm2;
	}

	/**
	 * [概 要]:siireNm2を設定する<br>
	 * 
	 * @param siireNm2
	 */
	public void setSiireNm2(String siireNm2) {
		this.siireNm2 = siireNm2;
	}

	/**
	 * [概 要]:siireZip1を取得する<br>
	 * 
	 * @return siireZip1
	 */
	public String getSiireZip1() {
		return siireZip1;
	}

	/**
	 * [概 要]:siireZip1を設定する<br>
	 * 
	 * @param siireZip1
	 */
	public void setSiireZip1(String siireZip1) {
		this.siireZip1 = siireZip1;
	}

	/**
	 * [概 要]:siireZip2を取得する<br>
	 * 
	 * @return siireZip2
	 */
	public String getSiireZip2() {
		return siireZip2;
	}

	/**
	 * [概 要]:siireZip2を設定する<br>
	 * 
	 * @param siireZip2
	 */
	public void setSiireZip2(String siireZip2) {
		this.siireZip2 = siireZip2;
	}

	/**
	 * [概 要]:siireAddr1を取得する<br>
	 * 
	 * @return siireAddr1
	 */
	public String getSiireAddr1() {
		return siireAddr1;
	}

	/**
	 * [概 要]:siireAddr1を設定する<br>
	 * 
	 * @param siireAddr1
	 */
	public void setSiireAddr1(String siireAddr1) {
		this.siireAddr1 = siireAddr1;
	}

	/**
	 * [概 要]:siireAddr2を取得する<br>
	 * 
	 * @return siireAddr2
	 */
	public String getSiireAddr2() {
		return siireAddr2;
	}

	/**
	 * [概 要]:siireAddr2を設定する<br>
	 * 
	 * @param siireAddr2
	 */
	public void setSiireAddr2(String siireAddr2) {
		this.siireAddr2 = siireAddr2;
	}

	/**
	 * [概 要]:siireAddr3を取得する<br>
	 * 
	 * @return siireAddr3
	 */
	public String getSiireAddr3() {
		return siireAddr3;
	}

	/**
	 * [概 要]:siireAddr3を設定する<br>
	 * 
	 * @param siireAddr3
	 */
	public void setSiireAddr3(String siireAddr3) {
		this.siireAddr3 = siireAddr3;
	}

	/**
	 * [概 要]:siireTelを取得する<br>
	 * 
	 * @return siireTel
	 */
	public String getSiireTel() {
		return siireTel;
	}

	/**
	 * [概 要]:siireTelを設定する<br>
	 * 
	 * @param siireTel
	 */
	public void setSiireTel(String siireTel) {
		this.siireTel = siireTel;
	}

	/**
	 * [概 要]:siireFaxを取得する<br>
	 * 
	 * @return siireFax
	 */
	public String getSiireFax() {
		return siireFax;
	}

	/**
	 * [概 要]:siireFaxを設定する<br>
	 * 
	 * @param siireFax
	 */
	public void setSiireFax(String siireFax) {
		this.siireFax = siireFax;
	}

	/**
	 * [概 要]:siireTantoNmを取得する<br>
	 * 
	 * @return siireTantoNm
	 */
	public String getSiireTantoNm() {
		return siireTantoNm;
	}

	/**
	 * [概 要]:siireTantoNmを設定する<br>
	 * 
	 * @param siireTantoNm
	 */
	public void setSiireTantoNm(String siireTantoNm) {
		this.siireTantoNm = siireTantoNm;
	}

	/**
	 * [概 要]:siireTantoMailを取得する<br>
	 * 
	 * @return siireTantoMail
	 */
	public String getSiireTantoMail() {
		return siireTantoMail;
	}

	/**
	 * [概 要]:siireTantoMailを設定する<br>
	 * 
	 * @param siireTantoMail
	 */
	public void setSiireTantoMail(String siireTantoMail) {
		this.siireTantoMail = siireTantoMail;
	}

}
