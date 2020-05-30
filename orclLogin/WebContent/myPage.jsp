<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mypage</title>
</head>

<body>
	<div>
		<h2>mypage</h2>
	</div>

	<div>
		<div>
			<table>
				<tr>
					<td>username:</td>
					<td><s:property value ="session.userName" /></td>
				</tr>
				<tr>
					<td>userid:</td>
					<td><s:property value ="session.userId" /></td>
				</tr>
				<tr>
					<td>password:</td>
					<td><s:property value ="session.password" /></td>
				</tr>
			</table>
		</div>

		<div>
			<span>ログアウトは</span>
			<a href ='<s:url action ="HomeAction" />'>こちら</a>
		</div>
	</div>
</body>
</html>