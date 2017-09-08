package jp.co.tcc.ecs.e_asproZaiko.ZI021ZaikoAdjEntry;

import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecs.e_asproComm.common.BaseBean;

/**
 * [ŠT —v]:İŒÉ’²®“ü—Íbean<br>
 * [à –¾]:İŒÉ’²®“ü—Íbean<br>
 * [”õ l]:<br>
 * ’˜ìŒ : Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author chengj
 * @version 1.0
 * @since 1.0
 */
public class ZaikoAdjEntryBean extends BaseBean {

	// ‘JˆÚæ‚ÌJSP
	public static final String RETRUN_URL = "zaiko/ZI021ZaikoAdjEntry.jsp";
	// ‘JˆÚæ‚ÌACTION
	public static final String RETRUN_URL2 = "/e_asproZaiko/ZI021ZaikoAdjEntry";
	// İŒÉˆê——‰æ–ÊiZI020ZaikoAdjListj‚Ö‘JˆÚ‚ÌACTION
	public static final String RETRUN_URL3 = "/e_asproZaiko/ZI020ZaikoAdjList";
	// ‹N“®
	private String processType = "";
	// ŒŸõ‹æ•ª
	private String searchKbn = "";
	// ‰ïĞNO
	private String coNo = "";
	// ƒGƒ‰[ƒƒZƒbƒW
	private String strErrMsg = "";
	// ”r‘¼ƒJƒEƒ“ƒ^
	private String exclCnt = "";
	// ŒŸõğŒ
	// ¤•iƒR[ƒh
	private String zaikoItemNo = "";
	// ‘qŒÉƒR[ƒh
	private String whCd = "";
	// İŒÉó‘Ô
	private String zaikoJoutaiKbn = "";
	// İŒÉÚ×î•ñ
	// ¤•i–¼
	private String zaikoItemNm = "";
	// ‘qŒÉ–¼
	private String whNm = "";
	// İŒÉó‘Ô–¼
	private String zaikoJoutaiNm = "";
	// Œ»İŒÉ
	private String qty = "";
	// ˆø“–”
	private String hikiQty = "";
	// —LŒøİŒÉ
	private String realQty = "";
	// İŒÉ’²®
	// ’²®‹æ•ª
	private String adjustKbn = "";
	// U‘Öæ@İŒÉó‘Ô
	private String adjZaikoJoutai = "";
	// ’²®”
	private String adjustQty = "";
	// ƒRƒƒ“ƒg
	private String biko = "";	
	// ’²®‹æ•ªƒŠƒXƒg
	private Vector<Map<String, String>> adjustKbnList = null;
	// U‘Öæ@İŒÉó‘ÔƒŠƒXƒg
	private Vector<Map<String, String>> adjZaikoJoutaiList = null;

	/**
	 * [ŠT —v]:•Ô‰ñ—pQ”MapB<br>
	 * [à –¾]:“ü—Í‚³‚ê‚½ŒŸõğŒ‚ğ‚l‚‚‚Éİ’è‚µ‚d‚‚”‚’‚™‰æ–Ê‚©‚ç–ß‚é—pB<br>
	 * [”õ l]:
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
	 * [ŠT —v]:<br>
	 * 
	 * @return processType
	 */
	public String getProcessType() {
		return processType;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param processType ‚ğİ’è‚·‚é
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return searchKbn
	 */
	public String getSearchKbn() {
		return searchKbn;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param searchKbn ‚ğİ’è‚·‚é
	 */
	public void setSearchKbn(String searchKbn) {
		this.searchKbn = searchKbn;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return coNo
	 */
	public String getCoNo() {
		return coNo;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param coNo ‚ğİ’è‚·‚é
	 */
	public void setCoNo(String coNo) {
		this.coNo = coNo;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param strErrMsg ‚ğİ’è‚·‚é
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return exclCnt
	 */
	public String getExclCnt() {
		return exclCnt;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param exclCnt ‚ğİ’è‚·‚é
	 */
	public void setExclCnt(String exclCnt) {
		this.exclCnt = exclCnt;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return zaikoItemNo
	 */
	public String getZaikoItemNo() {
		return zaikoItemNo;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param zaikoItemNo ‚ğİ’è‚·‚é
	 */
	public void setZaikoItemNo(String zaikoItemNo) {
		this.zaikoItemNo = zaikoItemNo;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return whCd
	 */
	public String getWhCd() {
		return whCd;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param whCd ‚ğİ’è‚·‚é
	 */
	public void setWhCd(String whCd) {
		this.whCd = whCd;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return zaikoJoutaiKbn
	 */
	public String getZaikoJoutaiKbn() {
		return zaikoJoutaiKbn;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param zaikoJoutaiKbn ‚ğİ’è‚·‚é
	 */
	public void setZaikoJoutaiKbn(String zaikoJoutaiKbn) {
		this.zaikoJoutaiKbn = zaikoJoutaiKbn;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return zaikoItemNm
	 */
	public String getZaikoItemNm() {
		return zaikoItemNm;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param zaikoItemNm ‚ğİ’è‚·‚é
	 */
	public void setZaikoItemNm(String zaikoItemNm) {
		this.zaikoItemNm = zaikoItemNm;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return whNm
	 */
	public String getWhNm() {
		return whNm;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param whNm ‚ğİ’è‚·‚é
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return zaikoJoutaiNm
	 */
	public String getZaikoJoutaiNm() {
		return zaikoJoutaiNm;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param zaikoJoutaiNm ‚ğİ’è‚·‚é
	 */
	public void setZaikoJoutaiNm(String zaikoJoutaiNm) {
		this.zaikoJoutaiNm = zaikoJoutaiNm;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return qty
	 */
	public String getQty() {
		return qty;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param qty ‚ğİ’è‚·‚é
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return hikiQty
	 */
	public String getHikiQty() {
		return hikiQty;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param hikiQty ‚ğİ’è‚·‚é
	 */
	public void setHikiQty(String hikiQty) {
		this.hikiQty = hikiQty;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return realQty
	 */
	public String getRealQty() {
		return realQty;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param realQty ‚ğİ’è‚·‚é
	 */
	public void setRealQty(String realQty) {
		this.realQty = realQty;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return adjustKbn
	 */
	public String getAdjustKbn() {
		return adjustKbn;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param adjustKbn ‚ğİ’è‚·‚é
	 */
	public void setAdjustKbn(String adjustKbn) {
		this.adjustKbn = adjustKbn;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return adjZaikoJoutai
	 */
	public String getAdjZaikoJoutai() {
		return adjZaikoJoutai;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param adjZaikoJoutai ‚ğİ’è‚·‚é
	 */
	public void setAdjZaikoJoutai(String adjZaikoJoutai) {
		this.adjZaikoJoutai = adjZaikoJoutai;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return adjustQty
	 */
	public String getAdjustQty() {
		return adjustQty;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param comment‚ğİ’è‚·‚é
	 */
	public void setBiko(String biko) {
		this.biko = biko;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return comment
	 */
	public String getBiko() {
		return biko;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param adjustQty ‚ğİ’è‚·‚é
	 */
	public void setAdjustQty(String adjustQty) {
		this.adjustQty = adjustQty;
	}	
	
	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return adjustList
	 */
	public Vector<Map<String, String>> getAdjustKbnList() {
		return adjustKbnList;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param adjustKbnList ‚ğİ’è‚·‚é
	 */
	public void setAdjustKbnList(Vector<Map<String, String>> adjustKbnList) {
		this.adjustKbnList = adjustKbnList;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @return zaikoJoutaiList
	 */
	public Vector<Map<String, String>> getAdjZaikoJoutaiList() {
		return adjZaikoJoutaiList;
	}

	/**
	 * [ŠT —v]:<br>
	 * 
	 * @param adjZaikoJoutaiList ‚ğİ’è‚·‚é
	 */
	public void setAdjZaikoJoutaiList(Vector<Map<String, String>> adjZaikoJoutaiList) {
		this.adjZaikoJoutaiList = adjZaikoJoutaiList;
	}

}
