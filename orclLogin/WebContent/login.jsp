<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
</head>

<body>
	<div>
		<h2>login</h2>
	</div>

	<div>
		<s:if test ="errorMessage !=''">
			<s:property value ="errorMessage" />
		</s:if>

		<s:form action ="LoginAction">
			<table>
				<tr>
					<td>ユーザーID</td>
					<td><s:textfield name ="userId" placeholder="1から8文字の半角英数字" /></td>
				</tr>
				<tr>
					<td>パスワード</td>
					<td><s:password name ="password" placeholder="1から8文字の半角英数字" /></td>
				</tr>
			</table>
			<s:submit value ="ログイン" />
		</s:form>

		<s:form action ="RegisterAction">
			<s:submit value ="ユーザー登録" />
		</s:form>
	</div>
</body>
</html>