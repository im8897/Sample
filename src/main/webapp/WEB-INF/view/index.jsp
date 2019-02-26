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
			<h2 class="sub-header">新規登録</h2>
		</div>
		<s:form>
			<input type="text" name="name" />
			<input type="submit" name="register" value="登録"
				class="btn btn-primary" />
		</s:form>
<!-- matsuzaki.add 課題1-->
		<html:errors/>


		<div class="page-header">
			<h2 class="sub-header">ユーザ一覧</h2>
		</div>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>お名前</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<logic:iterate id="user" name="userList">
					<tr>
						<td><bean:write name="user" property="userId" /></td>
						<td><bean:write name="user" property="name" /></td>
						<td>
							<s:form>
							<input type="hidden" name="selectedId" value =<bean:write name="user" property="userId" />>
							<input type="hidden" name="selectedName" value =<bean:write name="user" property="name" />>
							<input type="hidden" name="selectedAdd" value =<bean:write name="user" property="address" />>
							<input type="hidden" name="selectedBd" value =<bean:write name="user" property="birthDay" />>
							<input type="submit" name="detail" value="詳細" class="btn btn-info">
							<input type="submit" name="danger" value="削除" class="btn btn-danger">
							</s:form>
						</td>
					</tr>

				</logic:iterate>
			</tbody>
		</table>
	</div>
</body>
</html>