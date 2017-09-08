<%@ page language="java" contentType="text/html; charset=windows-31j" pageEncoding="windows-31j"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.framework.base.EscapeHTML"%>
<%@ include file="/taglibs.jsp" %>
<%@page import="java.util.Vector"%>
<%@page import="java.util.HashMap"%>
<%@page import="jp.co.tcc.ecs.e_asproUser.User.User"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.framework.base.EscapeBean"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.framework.base.EscapeHTML"%>
<%@page import="jp.co.tcc.ecs.e_asproComm.common.Properties"%>
<%@page import="jp.co.tcc.ecsolution.framework.otherUtils.StringUtil"%>
<%@page import="jp.co.tcc.ecs.e_asproMaster.MS101SupEntry.SupEntryBean"%>

<%

	SupEntryBean bean = (SupEntryBean) request.getAttribute("bean");
	EscapeBean.escapeBeanAllProperty(bean,new String[]{"strErrMsg"});
	String strErrMsg = StringUtil.nvl(bean.getStrErrMsg());
%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=windows-31j">
		<title>
			�d����}�X�^
		</title>		
		<script type="text/javascript" src="<%=Constants.DOC_ROOT%>/js/autoKana.js?"></script>
		<script type="text/javascript">
			//�V�K�o�^
	 		function Insert(){
	 			if(confirm("<%=Properties.getMsg("MSG.HA.003")%>")) {
					$$("_Form").action="<%=Constants.URL_BASE%>/e_asproMaster/MS101SupEntry";
					$$("_processType").value="<%=Constants.PAGE_INSERT%>";
					$$("_Form").submit();
					btnDisabled();
	 			}
			}
			//�X�V����
	 		function Update(){
	 			if(confirm("<%=Properties.getMsg("MSG.HA.004")%>")) {
					$$("_Form").action="<%=Constants.URL_BASE%>/e_asproMaster/MS101SupEntry";
					$$("_processType").value="<%=Constants.PAGE_UPDATE%>";
					$$("_Form").submit();
					btnDisabled();
	 			}
			}
			//�폜����
			function do_Delete(){
				if(confirm("<%=Properties.getMsg("MSG.HA.005")%>")){
					$$("_Form").action="<%=Constants.URL_BASE%>/e_asproMaster/MS101SupEntry";
					$$("_processType").value="<%=Constants.PAGE_DELETE%>";
					$$("_Form").submit();
					btnDisabled();
				}
			}
			//�Z����������
			//�p�����[�^tdk_zip1�ɗX�֔ԍ��O3�����Z�b�g
			//�p�����[�^tdk_zip2�ɗX�֔ԍ���4�����Z�b�g
			//�p�����[�^idx�ɍsNo���Z�b�g
			function addrAutoInput(_index){
				var zip1 = "";
				var zip2 = "";
				zip1 = $$("siireZip1").value;
				zip2 = $$("siireZip2").value;
				var url = "<%=Constants.URL_BASE%>/e_asproLogin/CC900PostalCheck";
				var parms = "processType="+<%=Constants.PAGE_AJAX%>;
				parms = parms+"&tdk_zip1="+zip1;
				parms = parms+"&tdk_zip2="+zip2;
				parms = parms+"&idx="+_index;
				<app:AjaxSendRequest2Action params="parms" url="url" async="false"/>
			}

			// �Z������Ajax�̖߂�
			// �p�����[�^��_addr1,_addr2,_addr3�Ɂu�Z���P,�Z���Q,�Z���R�v�̌`�Ŗ߂��Ă���
			// �p�����[�^��_idx�ɍs�m�����߂��Ă���
			function setAddr(_addr1,_addr2,_addr3, _idx, _ken_cd){
				//$$("_dispAddr1hidden").innerText = _addr1;
				$$("siireAddr1").innerText = _addr1;
				$$("siireAddr2").innerText = _addr2;
				$$("siireAddr3").innerText = _addr3;
			}
			// �Z�����������݂����ꍇ�̖߂�
			// �Z�������E�B���h�E�̕\��
			function open_sub(_zip1, _zip2, _idx){
				var url = "<%=Constants.URL_BASE%>/e_asproLogin/CC900PostalCheck";
				url = url + "?processtype=1";
				url = url + "&tdk_zip1="+_zip1;
				url = url + "&tdk_zip2="+_zip2;
				url = url + "&idx="+_idx;
				_searchWin = window.open(url,"CC900","width=500,height=450,menubar=no,location=no,status=yes,resizable=yes,scrollbars=yes");
				_searchWin.focus();
			}
		</script>
	</head>
	<body>
		<app:IconImgSrc baseId="MS100"/>
		<div class=pt>�d����}�X�^<app:navigator request="<%=request%>"/></div>
		<form id="_Form" method="post" action="<%=Constants.URL_BASE%>/e_asproMaster/MS101SupEntry">
			<input type="hidden" name="processType" id="_processType"/>
			<input type="hidden" name="processKbn" id="_processKbn" value="<%=bean.getProcessKbn() %>"/>
			<input type="hidden" name="exclCnt" id="_exclCnt" value="<%=bean.getExclCnt()%>" />
			<b style="color: red" id="js_errMsg"><%=strErrMsg%></b>
			<br>
			<table class="ft" style="width: 430">
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100" class="must">�d����R�[�h</th>
					<td nowrap width="289">
						<%=bean.getShiiresakiCd() %>
						<input type="hidden" name="shiiresakiCd" value="<%=bean.getShiiresakiCd() %>"/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100" class="must">������</th>
					<td nowrap width="289">						
						<%=bean.getEffectiveDate() %>	
						<input type="hidden" name="effectiveDate" value="<%=bean.getEffectiveDate() %>"/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100" class="must">������</th>
					<td nowrap width="289">						
						<%=bean.getIneffectiveDate() %>		
						<input type="hidden" name="ineffectiveDate" value="<%=bean.getIneffectiveDate() %>"/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100" class="must">������R�[�h</th>
					<td nowrap width="289">						
						<%=bean.getChoaitoCd() %>	
						<input type="hidden" name="choaitoCd" value="<%=bean.getChoaitoCd() %>"/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100" class="must">�d���於</th>
					<td nowrap width="289">
						<app:text
								id="shiiresakiNm"
								name="shiiresakiNm"
								cssClass="multi"
								value="<%= bean.getShiiresakiNm() %>"
								size="19"
								maxlength="20"
								onkeypress="_chkInp()"
								/>
					</td>
				</tr>
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100">�d���於�i�J�i�j</th>
					<td nowrap width="289">
						<app:text
								id="shiiresakiNmKana"
								name="shiiresakiNmKana"
								cssClass="half"
								value="<%= bean.getShiiresakiNmKana() %>"
								size="19"
								maxlength="25"
								onkeypress="_chkInp()"
								/>
						<script type="text/javascript">
						//�J�i��������
						var auto_kana_1 = new AutoKana('shiiresakiNm', 'shiiresakiNmKana', {katakana:true, toggle:false, isHalf:true});
						</script>			
					</td>
				</tr>
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100" class="must">�d����Z�k��</th>
					<td nowrap width="289">
						<app:text
								id="shiiresakiSnNm"
								name="shiiresakiSnNm"
								cssClass="multi"
								value="<%= bean.getShiiresakiSnNm() %>"
								size="19"
								maxlength="8"
								onkeypress="_chkInp()"
								/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100">��\�Җ�</th>
					<td nowrap width="289">
						<app:text
								id="mainuserNm"
								name="mainuserNm"
								cssClass="multi"
								value="<%= bean.getMainuserNm() %>"
								size="19"
								maxlength="20"
								onkeypress="_chkInp()"
								/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100">�S���Җ�</th>
					<td nowrap width="289">
						<app:text
								id="managerNm"
								name="managerNm"
								cssClass="multi"
								value="<%= bean.getManagerNm() %>"
								size="19"
								maxlength="20"
								onkeypress="_chkInp()"
								/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100">������</th>
					<td nowrap width="289">
						<%= bean.getBushomei() %>
						<input type="hidden" name="telNo" value="<%=bean.getBushomei() %>"/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100" class="must">�d����Z��</th>
					<td nowrap width="289">
						<br>
						��<%= bean.getPostNo() %><br>
						<%= bean.getAdr() %>
						<input type="hidden" name="postNo" value="<%=bean.getPostNo() %>"/>	
						<input type="hidden" name="adr" value="<%=bean.getAdr() %>"/>
						<br>
						<br>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100">�d�b�ԍ�</th>
					<td nowrap width="289">
						<%= bean.getTelNo() %>
						<input type="hidden" name="telNo" value="<%=bean.getTelNo() %>"/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100">FAX</th>
					<td nowrap width="289">
						<%= bean.getFaxNo() %>
						<input type="hidden" name="faxNo" value="<%=bean.getFaxNo() %>"/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100">����J�n��</th>
					<td nowrap width="289">
						<%= bean.getTorihikistartDate() %>
						<input type="hidden" name="torihikistartDate" value="<%=bean.getTorihikistartDate() %>"/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100">����I����</th>
					<td nowrap width="289">
						<%= bean.getTorihikiendDate() %>
						<input type="hidden" name="torihikiendDate" value="<%=bean.getTorihikiendDate() %>"/>
					</td>
				</tr>
				
				<tr bgcolor="white">
					<th align="center" nowrap bgcolor="#cccccc" width="100">�L��/����</th>
					<td>
						<select name="dispFlg" SIZE="1">
							<option value="0"  <%if((bean.getDispFlg() != null) && bean.getDispFlg().equals("0")){ %> selected <%} %>>�L��</option>
							<option value="1"  <%if((bean.getDispFlg() != null) && bean.getDispFlg().equals("1")){ %> selected <%} %>>����</option>
						</select>
					</td>
				</tr>
				
			</table>
			<br>
			<table width="430" border="0" cellspacing="0" cellpadding="1">
				<tr bgcolor="#ffcccc">
					<%if("2".equals(bean.getProcessKbn())){ %>
						<td align="center" width="50%">
							<input type="button" onClick="Update();" value="�X�V����"
								<app:PowerCheck fromId="<%=bean.getStrFromPageId() %>" baseId="MS101" value="<%=Constants.POWER_UPDATE %>"/>
							/>
						</td>
					<%}%>
				</tr>
			</table>
		</form>
	<app:pageinit/>	
	</body>
</html>
