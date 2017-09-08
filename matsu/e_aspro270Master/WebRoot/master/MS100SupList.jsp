<%@ page language="java" contentType="text/html; charset=windows-31j" pageEncoding="windows-31j"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.framework.base.EscapeHTML"%>
<%@ include file="/taglibs.jsp" %>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="jp.co.tcc.ecs.e_asproUser.User.User"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.common.Constants"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.common.Properties"%>

<%@page import="jp.co.tcc.ecs.e_asproMaster.MS100SupList.SupListBean"%>
<%@page import="jp.co.tcc.ecsolution.framework.otherUtils.StringUtil"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.framework.base.EscapeBean"%>

<%
	SupListBean bean = (SupListBean) request.getAttribute("bean");
	EscapeBean.escapeBeanAllProperty(bean,new String[]{"strErrMsg"});
	String strErrMsg = StringUtil.nvl(bean.getStrErrMsg());
%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
		<title>
			�d����}�X�^
		</title>
		<script type="text/javascript">
			//�d����X�V���
			function siireLink(siireCd) {
				$$("_Form").action="<%=Constants.URL_BASE%>/e_asproMaster/MS101SupEntry?processKbn=2&shiiresakiCd=" + siireCd;
				$$("_processType").value="";
				$$("_Form").submit();
				btnDisabled();
			}
			
			//insert
			function insert(){
				$$("_Form").action="<%=Constants.URL_BASE%>/e_asproMaster/MS101SupEntry";
				$$("_processType").value="";
				$$("_Form").submit();
				btnDisabled();
			}
			//�\�����𑀍삷�遥����\��
			function changeSort(srcCd, descCd){
				$$("_processType").value = "<%=Constants.POWER_UPDATE %>";
				$$("_moto").value = srcCd;
				$$("_chg").value = descCd;
				$$("_Form").action="<%=Constants.URL_BASE%>/e_asproMaster/MS100SupList";
				$$("_Form").submit();
				btnDisabled();
			}

			// �����{�^������,�������s��
			function search() {
				$$("_processType").value ="<%=Constants.POWER_SEARCH %>";
				$$("_Form").action="<%=Constants.URL_BASE%>/e_asproMaster/MS100SupList";
				$$("_Form").submit();
				btnDisabled();
			}
		</script>
	</head>
	<body>
		<!-- MasStoreList -->
		<app:IconImgSrc baseId="MS100"/>
		<div class="pt">�d����}�X�^</div>
		<br>
		<b style="color:red"><%=strErrMsg%></b>
		<br>
		<form action="<%=Constants.URL_BASE%>/e_asproMaster/MS100SupList" id="_Form" method="post">
			<input type="hidden" name="searchKbn" value="2">
			<input type="hidden" name="userNo" id="_userNo" value="<%=bean.getUserNo() %>"/>
			<input type="hidden" name="processType" id="_processType" value="">
			<input type="hidden" name="coNo" id="_coNo" value="<%=bean.getCoNo() %>"/>
			<input type="hidden" name="strFromPageId" value="<%=bean.getStrFromPageId() %>">
			<input type="hidden" name="motoSiireCd" id="_moto" value="">
			<input type="hidden" name="chgSiireCd" id="_chg" value="">
			<input type="hidden" name="sortKbn" id="_sortKbn" value="">
			<input type="hidden" name="intPageNo" id="_intPageNo" value="<%=bean.getIntPageNo() %>">
			<input type="hidden" name="intPageSize" id="_intPageSize" value="<%=bean.getIntPageSize() %>">
			
			<table border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<table CLASS="sf" style="width:850">
							<col width="100"><col width="200">
							<col width="100"><col width="250">
							<col width="100"><col width="100">
							<tr>
								<th>�d����R�[�h</th>
								<td>
									<input type="text" name="searchSiireCd" size="10" class="code" maxlength="20" value="<%=bean.getSearchSiireCd()%>">
									<app:searchflg searchFlg="1"/>
								</td>
								<th>�d���於</th>
								<td>
									<input type="text" name="searchSiireNm" size="20" class="multi" maxlength="75" value="<%=bean.getSearchSiireNm()%>">
									<app:searchflg searchFlg="2"/>
								</td>
								<th>�L��/����</th>
								<td>
									<select name="searchDispFlg"> 
										<option value=""></option>      
										<option value="0"  <%if((bean.getSearchDispFlg() != null) && bean.getSearchDispFlg().equals("0")){ %> selected <%} %>>�L��</option>
										<option value="1"  <%if((bean.getSearchDispFlg() != null) && bean.getSearchDispFlg().equals("1")){ %> selected <%} %>>����</option>
									</select>
								</td>
							</tr>
						</table>
					</td>
					<td valign="bottom">
						<%-- ����--%>
						<input <app:PowerCheck fromId="<%=bean.getStrFromPageId() %>" baseId="MS100" value="<%=Constants.POWER_SEARCH %>"/> type="button" onClick="search();"value="����"/>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<hr align="left" width="100%">
					</td>
				</tr>
			</table>
		</form>
		<br>
		<!-- �������ʈꗗ -->
		<%if(bean != null && "2".equals(bean.getSearchKbn())){%>
			<%Vector list = bean.getList(); %>
			<%if (list != null && list.size() > 0){%>
			<table class="lt" width="850">
				<colgroup>
					<col width="30">
					<col width="140">
					<col width="200">
					<col width="300">
					<col width="100">
					<col width="80">
				</colgroup>

				<tr class="head">
					<th>No</th>
					<th>�d����R�[�h</th>
					<th>�d���於</th>
					<th>�d����Z��</th>
					<th>�d�b�ԍ�</th>
					<th>�L��/����</th>
				</tr>
						<%int cntNo = 0;
						  for(int i=0;i<list.size();i++){
							Map item = (Map) list.get(i);
							cntNo = cntNo + 1;%>
							<%--No --%>
							<tr>
							<td align="center">
								<%=StringUtil.nvl(item.get("ROW_NO"))%>
							</td>
							<%--�d����R�[�h --%>
							<td title="<%=StringUtil.nvl(item.get("SIIRE_CD")) %>">
								<a href="#" onclick="siireLink('<%=StringUtil.nvl(item.get("SIIRE_CD"))%>');">
									<%=StringUtil.nvl(item.get("SIIRE_CD"))%>
								</a>
							</td>
							<%--�d���於 --%>
							<td title="<%=StringUtil.nvl(item.get("SIIRE_NM1"))%>">
								<%=StringUtil.nvl(item.get("SIIRE_NM1"))%>
							</td>
							<%--�d����Z�� --%>
							<td title="<%=StringUtil.nvl(item.get("SIIRE_ADDR1")) +
										StringUtil.nvl(item.get("SIIRE_ADDR2")) +
										StringUtil.nvl(item.get("SIIRE_ADDR3"))%>">
									<%=StringUtil.nvl(item.get("SIIRE_ADDR1"))%>
									<%=StringUtil.nvl(item.get("SIIRE_ADDR2"))%>
									<%=StringUtil.nvl(item.get("SIIRE_ADDR3"))%>
							</td>
							<%--�d�b�ԍ� --%>
							<td title="<%=StringUtil.nvl(item.get("SIIRE_TEL"))%>">
								<%=StringUtil.nvl(item.get("SIIRE_TEL"))%>
							</td>

							<%--�L��/���� --%>
							<td>
								<%if("0".equals(StringUtil.nvl(item.get("DISP_FLG")))){%>
								�L��
								<%} %>
								<%if("1".equals(StringUtil.nvl(item.get("DISP_FLG")))){%>
								����
								<%} %>
							</td>
							</tr>
						<%} %>
				</table>
			<%}
			  if(list != null && list.size() == 0){%> 
				<font size="2">
					<%=Properties.getMsg("MSG.HA.001")%>
				</font>
			<%}
		} %>
		<app:pageinit/>
	</body>
</html>