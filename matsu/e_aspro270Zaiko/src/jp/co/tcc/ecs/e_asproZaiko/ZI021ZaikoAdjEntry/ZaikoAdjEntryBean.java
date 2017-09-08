package jp.co.tcc.ecs.e_asproZaiko.ZI021ZaikoAdjEntry;

import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecs.e_asproComm.common.BaseBean;

/**
 * [概 要]:在庫調整入力bean<br>
 * [説 明]:在庫調整入力bean<br>
 * [備 考]:<br>
 * 著作権: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author chengj
 * @version 1.0
 * @since 1.0
 */
public class ZaikoAdjEntryBean extends BaseBean {

	// 遷移先のJSP
	public static final String RETRUN_URL = "zaiko/ZI021ZaikoAdjEntry.jsp";
	// 遷移先のACTION
	public static final String RETRUN_URL2 = "/e_asproZaiko/ZI021ZaikoAdjEntry";
	// 在庫一覧画面（ZI020ZaikoAdjList）へ遷移のACTION
	public static final String RETRUN_URL3 = "/e_asproZaiko/ZI020ZaikoAdjList";
	// 起動
	private String processType = "";
	// 検索区分
	private String searchKbn = "";
	// 会社NO
	private String coNo = "";
	// エラーメセッジ
	private String strErrMsg = "";
	// 排他カウンタ
	private String exclCnt = "";
	// 検索条件
	// 商品コード
	private String zaikoItemNo = "";
	// 倉庫コード
	private String whCd = "";
	// 在庫状態
	private String zaikoJoutaiKbn = "";
	// 在庫詳細情報
	// 商品名
	private String zaikoItemNm = "";
	// 倉庫名
	private String whNm = "";
	// 在庫状態名
	private String zaikoJoutaiNm = "";
	// 現在庫
	private String qty = "";
	// 引当数
	private String hikiQty = "";
	// 有効在庫
	private String realQty = "";
	// 在庫調整
	// 調整区分
	private String adjustKbn = "";
	// 振替先　在庫状態
	private String adjZaikoJoutai = "";
	// 調整数
	private String adjustQty = "";
	// コメント
	private String biko = "";	
	// 調整区分リスト
	private Vector<Map<String, String>> adjustKbnList = null;
	// 振替先　在庫状態リスト
	private Vector<Map<String, String>> adjZaikoJoutaiList = null;

	/**
	 * [概 要]:返回用参数Map。<br>
	 * [説 明]:入力された検索条件をＭａｐに設定しＥｎｔｒｙ画面から戻る用。<br>
	 * [備 考]:
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
	 * [概 要]:<br>
	 * 
	 * @return processType
	 */
	public String getProcessType() {
		return processType;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param processType を設定する
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return searchKbn
	 */
	public String getSearchKbn() {
		return searchKbn;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param searchKbn を設定する
	 */
	public void setSearchKbn(String searchKbn) {
		this.searchKbn = searchKbn;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return coNo
	 */
	public String getCoNo() {
		return coNo;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param coNo を設定する
	 */
	public void setCoNo(String coNo) {
		this.coNo = coNo;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return strErrMsg
	 */
	public String getStrErrMsg() {
		return strErrMsg;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param strErrMsg を設定する
	 */
	public void setStrErrMsg(String strErrMsg) {
		this.strErrMsg = strErrMsg;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return exclCnt
	 */
	public String getExclCnt() {
		return exclCnt;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param exclCnt を設定する
	 */
	public void setExclCnt(String exclCnt) {
		this.exclCnt = exclCnt;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return zaikoItemNo
	 */
	public String getZaikoItemNo() {
		return zaikoItemNo;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param zaikoItemNo を設定する
	 */
	public void setZaikoItemNo(String zaikoItemNo) {
		this.zaikoItemNo = zaikoItemNo;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return whCd
	 */
	public String getWhCd() {
		return whCd;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param whCd を設定する
	 */
	public void setWhCd(String whCd) {
		this.whCd = whCd;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return zaikoJoutaiKbn
	 */
	public String getZaikoJoutaiKbn() {
		return zaikoJoutaiKbn;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param zaikoJoutaiKbn を設定する
	 */
	public void setZaikoJoutaiKbn(String zaikoJoutaiKbn) {
		this.zaikoJoutaiKbn = zaikoJoutaiKbn;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return zaikoItemNm
	 */
	public String getZaikoItemNm() {
		return zaikoItemNm;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param zaikoItemNm を設定する
	 */
	public void setZaikoItemNm(String zaikoItemNm) {
		this.zaikoItemNm = zaikoItemNm;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return whNm
	 */
	public String getWhNm() {
		return whNm;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param whNm を設定する
	 */
	public void setWhNm(String whNm) {
		this.whNm = whNm;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return zaikoJoutaiNm
	 */
	public String getZaikoJoutaiNm() {
		return zaikoJoutaiNm;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param zaikoJoutaiNm を設定する
	 */
	public void setZaikoJoutaiNm(String zaikoJoutaiNm) {
		this.zaikoJoutaiNm = zaikoJoutaiNm;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return qty
	 */
	public String getQty() {
		return qty;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param qty を設定する
	 */
	public void setQty(String qty) {
		this.qty = qty;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return hikiQty
	 */
	public String getHikiQty() {
		return hikiQty;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param hikiQty を設定する
	 */
	public void setHikiQty(String hikiQty) {
		this.hikiQty = hikiQty;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return realQty
	 */
	public String getRealQty() {
		return realQty;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param realQty を設定する
	 */
	public void setRealQty(String realQty) {
		this.realQty = realQty;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return adjustKbn
	 */
	public String getAdjustKbn() {
		return adjustKbn;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param adjustKbn を設定する
	 */
	public void setAdjustKbn(String adjustKbn) {
		this.adjustKbn = adjustKbn;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return adjZaikoJoutai
	 */
	public String getAdjZaikoJoutai() {
		return adjZaikoJoutai;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param adjZaikoJoutai を設定する
	 */
	public void setAdjZaikoJoutai(String adjZaikoJoutai) {
		this.adjZaikoJoutai = adjZaikoJoutai;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return adjustQty
	 */
	public String getAdjustQty() {
		return adjustQty;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param commentを設定する
	 */
	public void setBiko(String biko) {
		this.biko = biko;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return comment
	 */
	public String getBiko() {
		return biko;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param adjustQty を設定する
	 */
	public void setAdjustQty(String adjustQty) {
		this.adjustQty = adjustQty;
	}	
	
	/**
	 * [概 要]:<br>
	 * 
	 * @return adjustList
	 */
	public Vector<Map<String, String>> getAdjustKbnList() {
		return adjustKbnList;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param adjustKbnList を設定する
	 */
	public void setAdjustKbnList(Vector<Map<String, String>> adjustKbnList) {
		this.adjustKbnList = adjustKbnList;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @return zaikoJoutaiList
	 */
	public Vector<Map<String, String>> getAdjZaikoJoutaiList() {
		return adjZaikoJoutaiList;
	}

	/**
	 * [概 要]:<br>
	 * 
	 * @param adjZaikoJoutaiList を設定する
	 */
	public void setAdjZaikoJoutaiList(Vector<Map<String, String>> adjZaikoJoutaiList) {
		this.adjZaikoJoutaiList = adjZaikoJoutaiList;
	}

}
