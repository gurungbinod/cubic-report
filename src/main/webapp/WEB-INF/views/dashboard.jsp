<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard | Cubic Report</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
<link rel="stylesheet" href="<c:url value='/static/css/style.css' />"
	type="text/css" />
<!-- build:js lib/js/main.min.js -->
<script type="text/javascript" src="<c:url value='/static/js/app.js' />"></script>
</head>
<body>

	<header>
		<div class="container">
			<nav id="navigation">
				<ul>
					<li><a href="#">Dashboard</a></li>
					<li><a href="#">Reports</a></li>
					<li><a href="#">Manage</a></li>
					<li class="pull-right"><a href="#">Hi <span
							class="username">Binod</span>!
					</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<section id="content">
		<div clas="container">
			<div class="row">
				<div class="col-sm-12">
					<table class="table">
						<thead>
							<tr>
								<th>S.N.</th>
								<th>V.C</th>
								<th>Marketing</th>
								<th>Vendor</th>
								<th>Client</th>
								<th>Technology</th>
								<th>Candidate</th>
								<th>Rounds</th>
								<th>Status</th>
								<th>Interview Type</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${interviewRoundList}" var="irs">
								<tr>
									<td><c:out value="++${count}" /></td>
									<td><c:out value="${irs.interview.vc.name}" /></td>
									<td><c:out value="${irs.interview.marketing.name}" /></td>
									<td><c:out value="${irs.interview.vendor.name}" /></td>
									<td><c:out value="${irs.interview.client.name}" /></td>
									<td><c:out value="${irs.interview.technology.name}" /></td>
									<td><c:out value="${irs.interview.candidate.firstName}" /></td>
									<td><c:out value="${irs.round.name}" /></td>
									<td><c:out value="${irs.interviewStatus}" /></td>
									<td><c:out value="${irs.interviewType.type}" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
