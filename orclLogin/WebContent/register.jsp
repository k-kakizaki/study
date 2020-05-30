<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register</title>
</head>

<body>
	<div>
		<h2>register</h2>
	</div>

	<div>
		<s:if test ="errorIdMessage !=''">
			<s:property value ="errorIdMessage" />
		</s:if>

		<div>
            <s:property value="errorMessage"/>
            <s:actionmessage/><s:fielderror/>
    	</div>

		<s:form action ="ConfirmAction" validate ="true">
			<table>
				<tr>
					<td>ユーザー名</td>
					<td><s:textfield name ="userName" placeholder="1から8文字の半角英数字"/></td>
				</tr>
				<tr>
					<td>ユーザーID</td>
					<td><s:textfield name ="userId" placeholder="1から8文字の半角英数字" /></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><s:password name ="password" placeholder="1から8文字の半角英数字"/></td>
				</tr>
			</table>
			<s:submit value ="ユーザー登録確認" />
		</s:form>

		<div>
			<span>ホームは</span>
			<a href ='<s:url action ="HomeAction" />'>こちら</a>
		</div>
	</div>
</body>
</html>