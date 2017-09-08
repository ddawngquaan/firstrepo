package jp.co.tcc.ecs.e_asproMaster.MS100SupList;

import java.util.Map;
import java.util.Vector;

import jp.co.tcc.ecs.e_asproComm.common.BaseBean;

/**
 * [概 要]:仕入先マスタ（一覧）bean<br>
 * [説 明]:仕入先マスタ（一覧）bean<br>
 * [備 考]:<br>
 * 著作権: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupListBean extends BaseBean {

	/** 遷移先のJSP */
	public static final String RETRUN_URL = "master/MS100SupList.jsp";
	/** 遷移先のACTION */
	public static final String RETRUN_URL2 = "/e_asproMaster/MS100SupList";
	/** パージID */
	public static final String PAGE_ID = "MS100";
	// 起動
	private String processType = "";
	// 排他カウンタ
	private String exclCnt = "";
	// ユーザCo_no
	private String coNo = "";
	// ユーザCo_no
	private String userNo = "";
	// エラーメッセージ
	private String strErrMsg = "";
	// 検索
	private String searchKbn = "1";
	// 検索仕入先CD
	private String searchSiireCd = "";
	// 検索仕入先名
	private String searchSiireNm = "";
	// 表示フラグ
	private String searchDispFlg ="";
	// 検索結果
	private Vector<Map<String, String>> list = null;
	// ソートNo更新用
	private String motoSiireCd = "";
	private String chgSiireCd = "";
	private String sortKbn = "";

	/**
	 * [概 要]:返回用参数Map。<br>
	 * [説 明]:入力された検索条件をＭａｐに設定しＥｎｔｒｙ画面から戻る用。<br>
	 * [備 考]:
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
	 * [概 要]:processTypeを取得する<br>
	 * 
	 * @return processType
	 */
	public String getProcessType() {
		return processType;
	}

	/**
	 * [概 要]:processTypeを設定する<br>
	 * 
	 * @param processType
	 */
	public void setProcessType(String processType) {
		this.processType = processType;
	}

	/**
	 * [概 要]:exclCntを取得する<br>
	 * 
	 * @return exclCnt
	 */
	public String getExclCnt() {
		return exclCnt;
	}

	/**
	 * [概 要]:exclCntを設定する<br>
	 * 
	 * @param exclCnt
	 */
	public void setExclCnt(String exclCnt) {
		this.exclCnt = exclCnt;
	}

	/**
	 * [概 要]:coNoを取得する<br>
	 * 
	 * @return coNo
	 */
	public String getCoNo() {
		return coNo;
	}

	/**
	 * [概 要]:coNoを設定する<br>
	 * 
	 * @param coNo
	 */
	public void setCoNo(String coNo) {
		this.coNo = coNo;
	}

	/**
	 * [概 要]:userNoを取得する<br>
	 * 
	 * @return userNo
	 */
	public String getUserNo() {
		return userNo;
	}

	/**
	 * [概 要]:userNoを設定する<br>
	 * 
	 * @param userNo
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
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
	 * [概 要]:searchKbnを取得する<br>
	 * 
	 * @return searchKbn
	 */
	public String getSearchKbn() {
		return searchKbn;
	}

	/**
	 * [概 要]:searchKbnを設定する<br>
	 * 
	 * @param searchKbn
	 */
	public void setSearchKbn(String searchKbn) {
		this.searchKbn = searchKbn;
	}

	/**
	 * [概 要]:siireCdを取得する<br>
	 * 
	 * @return siireCd
	 */
	public String getSearchSiireCd() {
		return searchSiireCd;
	}

	/**
	 * [概 要]:siireCdを設定する<br>
	 * 
	 * @param siireCd
	 */
	public void setSearchSiireCd(String searchSiireCd) {
		this.searchSiireCd = searchSiireCd;
	}

	/**
	 * [概 要]:siireNmを取得する<br>
	 * 
	 * @return siireNm
	 */
	public String getSearchSiireNm() {
		return searchSiireNm;
	}

	/**
	 * [概 要]:siireNmを設定する<br>
	 * 
	 * @param siireNm
	 */
	public void setSearchSiireNm(String searchSiireNm) {
		this.searchSiireNm = searchSiireNm;
	}

	/**
	 * [概 要]:dispFlgを取得する<br>
	 * 
	 * @return dispFlg
	 */
	public String getSearchDispFlg() {
		return searchDispFlg;
	}

	/**
	 * [概 要]:dispFlgを設定する<br>
	 * 
	 * @param dispFlg
	 */
	public void setSearchDispFlg(String searchDispFlg) {
		this.searchDispFlg = searchDispFlg;
	}

	/**
	 * [概 要]:listを取得する<br>
	 * 
	 * @return list
	 */
	public Vector<Map<String, String>> getList() {
		return list;
	}

	/**
	 * [概 要]:listを設定する<br>
	 * 
	 * @param list
	 */
	public void setList(Vector<Map<String, String>> list) {
		this.list = list;
	}

	/**
	 * [概 要]:motoSiireCdを取得する<br>
	 * 
	 * @return motoSiireCd
	 */
	public String getMotoSiireCd() {
		return motoSiireCd;
	}

	/**
	 * [概 要]:motoSiireCdを設定する<br>
	 * 
	 * @param motoSiireCd
	 */
	public void setMotoSiireCd(String motoSiireCd) {
		this.motoSiireCd = motoSiireCd;
	}

	/**
	 * [概 要]:chgSiireCdを取得する<br>
	 * 
	 * @return chgSiireCd
	 */
	public String getChgSiireCd() {
		return chgSiireCd;
	}

	/**
	 * [概 要]:chgSiireCdを設定する<br>
	 * 
	 * @param chgSiireCd
	 */
	public void setChgSiireCd(String chgSiireCd) {
		this.chgSiireCd = chgSiireCd;
	}

	/**
	 * [概 要]:sortKbnを取得する<br>
	 * 
	 * @return sortKbn
	 */
	public String getSortKbn() {
		return sortKbn;
	}

	/**
	 * [概 要]:sortKbnを設定する<br>
	 * 
	 * @param sortKbn
	 */
	public void setSortKbn(String sortKbn) {
		this.sortKbn = sortKbn;
	}

}
