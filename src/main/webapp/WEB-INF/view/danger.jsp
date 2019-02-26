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
			<h2 class="sub-header">削除確認</h2>
			<p>本当に削除しますか？</p>

					<div class="page-header">
			<h2 class="sub-header">削除対象ユーザ一</h2>
		</div>
		<table id="tb" class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>お名前</th>
				</tr>
			</thead>
			<tbody>
					<tr>
					<s:form>
						<td><%= request.getAttribute( "selectedId" ) %></td>
						<td><%= request.getAttribute( "selectedName" ) %></td>
					</s:form>
					</tr>
			</tbody>
		</table>
			<form method= "post" action= "/Sample/danger/">
				<input type="hidden" name="selectedId" value =<%= request.getAttribute( "selectedId" ) %> />
				<input type="hidden" name="selectedName" value =<%= request.getAttribute( "selectedName" ) %> />
				<input type="submit" name="delete" value="OK" onClick= "location.href='danger/'"/>
				<input type="button" name="back" value="戻る" onClick= history.back() />
			</form>
		</div>
	</div>
</body>
</html>