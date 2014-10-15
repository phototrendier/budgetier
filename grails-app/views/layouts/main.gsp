<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title><g:layoutTitle default="Grails"/></title>

		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">

        <r:require modules="bootstrap"/>

		<g:layoutHead/>
		<g:javascript library="application"/>		
		<r:layoutResources />
	</head>
	<body>

        <g:render template="/standard/header"/>
        <g:render template="/standard/navigationMenu"/>

        <g:render template="/standard/messageHandler"/>

        <div class="container-fluid container-full-width">
            <div class="row">
                <div class="col-sm-12">
                    <g:layoutBody/>
                </div>
            </div>
        </div>



		<div class="footer" role="contentinfo"></div>
		<div id="spinner" class="spinner" style="display:none;"><g:message code="spinner.alt" default="Loading&hellip;"/></div>
		<r:layoutResources />
	</body>
</html>
