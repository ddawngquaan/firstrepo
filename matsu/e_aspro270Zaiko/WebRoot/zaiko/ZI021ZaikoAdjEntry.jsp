<%@ page language="java" contentType="text/html; charset=windows-31j" pageEncoding="windows-31j"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.framework.base.EscapeHTML"%>
<%@ include file="/taglibs.jsp" %>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="jp.co.tcc.ecs.e_asproUser.User.User"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.common.Constants"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.common.Properties"%>

<%@page import="jp.co.tcc.ecs.e_asproZaiko.ZI021ZaikoAdjEntry.ZaikoAdjEntryBean"%>
<%@page import="jp.co.tcc.ecsolution.framework.otherUtils.StringUtil"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.framework.base.EscapeBean"%>
<%
	ZaikoAdjEntryBean bean = (ZaikoAdjEntryBean) request.getAttribute("bean");
	EscapeBean.escapeBeanAllProperty(bean,new String[]{"strErrMsg"});
	String strErrMsg = StringUtil.nvl(bean.getStrErrMsg());
%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
		<title>
			在庫調整入力
		</title>
		<script type="text/javascript">
			$(document).ready(function(){
				adjustKbnChange($("#adjustKbn").val());
			});
		
			//調整
			 function adjust(){
				if (confirm('<%=Properties.getMsg("MSG.HA.003")%>')) {
					$$("_processType").value = "<%=Constants.PAGE_INSERT%>";
					$$("_Form").action="<%=Constants.URL_BASE%><%= ZaikoAdjEntryBean.RETRUN_URL2 %>";
					$$("_Form").submit();
					btnDisabled();
				}
			}
			
			// 振替先　在庫状態表示
			function adjustKbnChange(val) {
				//調整区分=30（在庫振替）の場合Enable表示にする。以外の場合Disable表示にする
				if (val == 30) {
					$("#adjZaikoJoutai").removeAttr("disabled");
	 			} else {
					$("#adjZaikoJoutai").val("").attr("disabled","disabled");
				}
			}
		</script>
	</head>
	<body>
		<!-- MasStoreList -->
		<app:IconImgSrc baseId="ZI020"/>
		<div class="pt">在庫調整入力<app:navigator request="<%= request%>"/></div>
		<br>
		<b style="color:red"><%=strErrMsg%></b>
		<br>
		<form action="<%=Constants.URL_BASE%>/e_asproZaiko/ZI020ZaikoAdjList" id="_Form" method="post">
			<input type="hidden" name="processType" id="_processType" value="1">
			<input type="hidden" name="strFromPageId" value="<%=bean.getStrFromPageId() %>">
			<input type="hidden" name="exclCnt" value="<%=bean.getExclCnt()%>">
			<input type="hidden" name="zaikoItemNo" value="<%=bean.getZaikoItemNo()%>">
			<input type="hidden" name="whCd" value="<%=bean.getWhCd()%>">
			<input type="hidden" name="zaikoJoutaiKbn" value="<%=bean.getZaikoJoutaiKbn()%>">
			<input type="hidden" name="zaikoItemNm" value="<%=bean.getZaikoItemNm()%>">
			<input type="hidden" name="whNm" value="<%=bean.getWhNm()%>">
			<input type="hidden" name="zaikoJoutaiNm" value="<%=bean.getZaikoJoutaiNm()%>">
			<input type="hidden" name="qty" value="<%=bean.getQty()%>">
			<input type="hidden" name="hikiQty" value="<%=bean.getHikiQty()%>">
			<input type="hidden" name="realQty" value="<%=bean.getRealQty()%>">
			
			<font size="2" color="#ff9900">■</font><font size="2">在庫詳細情報</font><br>
			<table class="sf" style="width:840px">
				<col width="120"/>
				<col width="300"/>
				<col width="120"/>
				<col width="300"/>
				<tr>
					<th>商品コード</th>
					<td title="<%=bean.getZaikoItemNo()%>"><%=bean.getZaikoItemNo()%></td>
					<th>倉庫名</th>
					<td title="<%=bean.getWhNm()%>"><%=bean.getWhNm()%></td>
				</tr>
				<tr>
					<th>商品名</th>
					<td colspan="3" title="<%=bean.getZaikoItemNm()%>"><%=bean.getZaikoItemNm()%></td>
				</tr>
				<tr>
					<th>在庫状態</th>
					<td><%=bean.getZaikoJoutaiNm()%></td>
					<th>現在庫</th>
					<td><app:NumberFormat numberValue='<%=bean.getQty()%>'></app:NumberFormat></td>
				</tr>
					<th>引当数</th>
					<td><app:NumberFormat numberValue='<%=bean.getHikiQty()%>'></app:NumberFormat></td>
					<th>有効在庫</th>
					<td><app:NumberFormat numberValue='<%=bean.getRealQty()%>'></app:NumberFormat></td>
				</tr>
			</table>
			<br/>
			<table class="sf" style="width:840px">
				<col width="120px"/>
				<col width="720px"/>
				<tr>
					<th>コメント</th>
					<td>
						<textarea style="width:400px;" rows="4" id="biko" name="biko"><%=bean.getBiko()%></textarea>
					</td>
				</tr>
			</table>
			<br/>
			<font size="2" color="#ff9900">■</font><font size="2">調整</font><br>
			<table class="sf" style="width:420px">
				<col width="120"/>
				<col width="300"/>
				<tr>
					<th class="must">調整区分</th>
					<td>
						<app:select name="adjustKbn" id="adjustKbn"
							list = "<%=bean.getAdjustKbnList() %>"
							value="<%=bean.getAdjustKbn() %>"
							listKey ="KEY"
							listValue = "VALUE"
							onChange="adjustKbnChange(this.value)"/>
					</td>
				</tr>
			</table>
			<br/>
			<table class="sf" style="width:420px">
				<col width="120"/>
				<col width="300"/>
				<tr>
					<th>現在庫</th>
					<td><app:NumberFormat numberValue='<%=bean.getRealQty()%>'></app:NumberFormat></td>
				</tr>
				<tr>
					<th class="must">調整数</th>
					<td>
						<input type="text" name="adjustQty" id="adjustQty" value="<%=bean.getAdjustQty() %>" 
								maxlength="8" size="12" class="num" style="ime-mode:disabled;" />
					</td>
				</tr>
				<tr>
					<th class="must">振替先　在庫状態</th>
					<td>
						<app:select name="adjZaikoJoutai" id="adjZaikoJoutai"
							list = "<%=bean.getAdjZaikoJoutaiList() %>"
							value="<%=bean.getAdjZaikoJoutai() %>"
							listKey ="KEY"
							listValue = "VALUE"/>
					</td>
				</tr>
			</table>
			<br/>
			<table class="nb" style="width:840px">
				<tr style="background-color:#ffcccc;">
					<td align="center">
						<input type="button" onClick="adjust();" value="登録する"
							<app:PowerCheck fromId="<%=bean.getStrFromPageId() %>" baseId="ZI021" value="<%=Constants.POWER_INSERT%>"/>
						/>
					</td>
				</tr>
			</table>
		</form>
		<app:pageinit/>
	</body>
</html>