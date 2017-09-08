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
 * [概 要]:仕入先マスタ（一覧）サービス<br>
 * [説 明]:仕入先マスタ（一覧）サービス<br>
 * [備 考]:<br>
 * 著作権: Copyright (c) 2011<br>
 * 
 * @author Toukei Computer Company
 * @author LiuXiaoyan
 * @version 1.0
 * @since 1.0
 */
public class SupEntryService {
	/**
	 * [概 要]:検索。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（一覧） bean
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
	 * [概 要]:追加。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 仕入先マスタ（一覧） bean
	 * @throws Exception
	 */
	public void insert(SupEntryBean bean) throws Exception {
		// DAO取得
		SupEntryDAO dao = new SupEntryDAO();
		dao.insert(bean);
	}

	/**
	 * [概 要]:更新。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 
	 * @throws Exception
	 */
	public void update(SupEntryBean bean) throws Exception {
		// DAO取得
		SupEntryDAO dao = new SupEntryDAO();
		dao.update(bean);
	}

	/**
	 * [概 要]:削除。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 
	 * @throws Exception
	 */
	public void delete(SupEntryBean bean) throws Exception {
		// DAO取得
		SupEntryDAO dao = new SupEntryDAO();
		dao.delete(bean);
	}

	/**
	 * [概 要]:排他チェック<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 
	 * @return boolean
	 * @throws Exception
	 */
	public boolean checkExcl(SupEntryBean bean) throws Exception {
		// 排他チェック
		SupEntryDAO dao = new SupEntryDAO();
		return dao.checkExcl(bean);
	}

	/**
	 * [概 要]:排他チェック<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 
	 * @return boolean
	 * @throws Exception
	 */
	public boolean checkExcl2(SupEntryBean bean) throws Exception {
		// 排他チェック
		SupEntryDAO dao = new SupEntryDAO();
		return dao.checkExcl2(bean);
	}
	
	/**
	 * [概 要]:入力項目チェック。<br>
	 * [説 明]:<br>
	 * [備 考]:
	 * 
	 * @param bean 
	 * @return エラーメッセージ
	 * @throws Exception
	 */
	public String validator(boolean exclFlg, SupEntryBean bean) throws Exception {
		StringBuilder sb = new StringBuilder();
		
		// 排他チェック
		if (exclFlg && !checkExcl(bean)  && !checkExcl2(bean) ) {
			return Properties.getMsg(Constants.EXCL_ERROR, true);
		}
		
		/*// 仕入先コード入力チェック
		String siireMsg = InputChecker.checkEisuji(bean.getSiireCd(), "仕入先コード", 1, "20");
		if (!StringUtil.isNull(siireMsg)) {
			sb.append(siireMsg);
		} else {
			// 新規時、すでに存在チェック
			if (!exclFlg && checkSiireCdExists(bean)) {
				sb.append(Properties.getMsg("ERROR.HA.036", new String[]{"仕入先コード"}, true));
			}
		}*/
		// 仕入先名入力チェック
		sb.append(InputChecker.checkMulti(bean.getShiiresakiNm(), "仕入先名", 1, "20", ""));
		// 仕入先名（カナ）入力チェック
		sb.append(InputChecker.checkHalf(bean.getShiiresakiNmKana(), "仕入先名（カナ）", 1, "25"));
		//仕入先短縮名
		sb.append(InputChecker.checkMulti(bean.getShiiresakiSnNm(), "仕入先短縮名", 1, "8", ""));
		// 代表者名
		sb.append(InputChecker.checkMulti(bean.getMainuserNm(), "代表者名", 0, "20", ""));
		// 担当者名
		sb.append(InputChecker.checkMulti(bean.getManagerNm(), "担当者名", 0, "20", ""));
		
		/*// 仕入先名1入力チェック
		sb.append(InputChecker.checkMulti(bean.getSiireNm1(), "仕入先名1", 1, "20", ""));
		// 仕入先名2入力チェック
		sb.append(InputChecker.checkMulti(bean.getSiireNm2(), "仕入先名2", 0, "20", ""));
		// 郵便番号必須入力チェック
		sb.append(InputChecker.checkNumber(bean.getSiireZip1(), "郵便番号１", 1, "3", null, 0));
		sb.append(InputChecker.checkNumber(bean.getSiireZip2(), "郵便番号２", 1, "4", null, 0));
		// 仕入先住所1入力チェック
		sb.append(InputChecker.checkMulti(bean.getSiireAddr1(), "仕入先住所１", 1, null, "50"));
		// 仕入先住所2入力チェック
		sb.append(InputChecker.checkMulti(bean.getSiireAddr2(), "仕入先住所２", 0, null, "50"));
		// 仕入先住所3入力チェック
		sb.append(InputChecker.checkMulti(bean.getSiireAddr3(), "仕入先住所３", 0, null, "50"));
		// 仕入先電話番号入力チェック
		sb.append(InputChecker.checkTel(bean.getSiireTel(), "電話番号", 1, "15"));
		// FAX入力チェック
		sb.append(InputChecker.checkTel(bean.getSiireFax(), "FAX", 0, "50"));
		// 仕入先担当者
		sb.append(InputChecker.checkMulti(bean.getSiireTantoNm(), "仕入先担当者", 0, "20", ""));
		// メールアドレスのチェック
		sb.append(InputChecker.checkMail(bean.getSiireTantoMail(), "メールアドレス", 0, "250"));*/
		
		return sb.toString();
	}

	/**
	 * [概 要]:新規登録時、仕入先コードがすでに存在しているかチェックする。<br>
	 * [説 明]:新規登録時、仕入先コードがすでに存在しているかチェックする。<br>
	 * [備 考]:
	 * @param bean
	 * @return チェック結果
	 */
	private boolean checkSiireCdExists(SupEntryBean bean) throws Exception {
		SupEntryDAO dao = new SupEntryDAO();
		return dao.checkSiireCdExists(bean);
	}
	
	/**
	 * [概 要]:形式をyyyyMMddからyyyy/MM/ddに変換。<br>
	 * [説 明]:形式をyyyyMMddからyyyy/MM/ddに変換。<br>
	 * [備 考]:
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
