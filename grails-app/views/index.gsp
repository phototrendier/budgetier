<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>
            <g:message code="page.title.homepage" default="Budget Manager"/>
		</title>
	</head>
	<body>

		<div id="page-body" role="main" style="min-height: 1500px;">
            <label>
                ${session["logged_in_user"]?.firstName} ${session["logged_in_user"]?.lastName}
            </label>
		</div>
	</body>
</html>
