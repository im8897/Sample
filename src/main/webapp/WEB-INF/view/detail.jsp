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
			<h2 class="sub-header">ユーザー情報</h2>
			<p>選択されたユーザーの情報です</p>

					<div class="page-header">
			<h2 class="sub-header">詳細</h2>

		<table class="table table-striped">
		<s:form>
			<tbody>
			<thead>
				<tr>
					<td>ID</td>
					<td><%= request.getAttribute( "selectedId" ) %></td>
					<td>
					</td>
				</tr>
				<tr>
					<td>お名前</td>
					<td><%= request.getAttribute( "selectedName" ) %></td>
					<td>
					</td>
				</tr>
				<tr>
					<td>住所</td>
					<td><%= request.getAttribute( "selectedAdd" ) %></td>
					<td>
					</td>
				</tr>
				<tr>
					<td>生年月日</td>
					<td><%= request.getAttribute( "selectedBd" ) %></td>
					<td>
					</td>
				</tr>
			</thead>
			</tbody>
			</s:form>
		</table>
			</div>
			<form method= "post" action= "/Sample/detail/">
				<input type="hidden" name="selectedId" value =<%= request.getAttribute( "selectedId" ) %> >
				<input type="hidden" name="selectedName" value =<%= request.getAttribute( "selectedName" ) %> >
				<input type="hidden" name="selectedAdd" value =<%= request.getAttribute( "selectedAdd" ) %> >
				<input type="hidden" name="selectedBd" value =<%= request.getAttribute( "selectedBd" ) %> >
				<input type="submit" name="index" value="変更" onClick= "location.href='detail/'"/>
				<input type="button" name="back" value="戻る" onClick= history.back() />
			</form>

		</div>
	</div>
</body>
</html>