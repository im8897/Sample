<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic"
	prefix="logic"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Dolteng Auto Generated</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css"
	integrity="sha384-PmY9l28YgO4JwMKbTvgaS7XNZJ30MK9FAZjjzXtlqyZCqBY6X6bXIkM++IkyinN+"
	crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap-theme.min.css"
	integrity="sha384-jzngWsPS6op3fgRCDTESqrEJwRKck+CILhJVO5VvaAZCq8JYf8HsR/HPpBOOPZfR"
	crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"
	integrity="sha384-vhJnz1OVIdLktyixHY4Uk3OHEwdQqPppqYR8+5mjsauETgLOcEynD9oPHhhz18Nw"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">

		<div class="page-header">
			<h1>サンプルアプリケーション</h1>
			<p>このアプリケーションを完成させていって、Seasar2を勉強していってください。</p>
		</div>

		<div class="page-header">
			<h2 class="sub-header">変更が完了しました</h2>
			<p>変更されたユーザーの情報です</p>

		<div class="page-header">
			<h2 class="sub-header">詳細</h2>

		<table class="table table-striped">

			<tbody>
			<thead>
				<tr>
					<td>ID</td>
					<td><bean:write name="updateUser" property="userId" /><td>
				</tr>
				<tr>
					<td>お名前</td>
					<td><bean:write name="updateUser" property="name" /><td>
				</tr>
				<tr>
					<td>住所</td>
					<td><bean:write name="updateUser" property="address" /><td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><bean:write name="updateUser" property="birthDay" /><td>
				</tr>
			</thead>
			</tbody>
		</table>
			<s:form>
				<input type="hidden" name="selectedId" value =<bean:write name="updateUser" property="userId" /> >
				<input type="hidden" name="selectedName" value =<bean:write name="updateUser" property="name" /> >
				<input type="hidden" name="selectedAdd" value =<bean:write name="updateUser" property="address" /> >
				<input type="hidden" name="selectedBd" value =<bean:write name="updateUser" property="birthDay" /> >
				<input type="submit" name="index" value="変更" onClick= "location.href='detail/'"/>
			</s:form>
		</div>
				<form method= "post" action= "/Sample/">
				<input type="submit" name="index" value="ユーザー一覧に戻る"/>
				</form>
		</div>
	</div>
</body>
</html>