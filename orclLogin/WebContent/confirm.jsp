<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirm</title>
</head>

<body>
	<div>
		<h2>confirm</h2>
	</div>

	<div>
		<div>
			<h3>登録内容に誤りがなければ完了を押下してください。</h3>
			<s:form action ="CompleteAction">
				<table>
					<tr>
						<td>username:</td>
						<td><s:property value ="userName" /></td>
					</tr>
					<tr>
						<td>userid:</td>
						<td><s:property value ="userId" /></td>
					</tr>
					<tr>
						<td>password:</td>
						<td><s:property value ="password" /></td>
					</tr>
				</table>

				<s:submit value ="完了" />
			</s:form>
		</div>

		<div>
			<span>登録内容を変更する場合は</span>
			<a href ='<s:url action ="RegisterAction" />'>こちら</a>
		</div>
	</div>
</body>
</html>