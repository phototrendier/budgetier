<%--
  Created by IntelliJ IDEA.
  User: vbledar
  Date: 10/6/14
  Time: 22:22
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="internalMenu"/>
  <title>
      <g:message code="page.title.transaction.category"/>
  </title>
</head>
<body>

    <content tag="internalMenu">
        <div class="row">
            <div class="col-sm-12">
                <div class="btn-group">
                    <g:link controller="customization" action="createTransactionCategory" class="btn btn-default">
                        <span class="glyphicon glyphicon-plus-sign"></span> <g:message code="button.label.add" default="Add"/>
                    </g:link>
                </div>
            </div>
        </div>
    </content>

    <div id="transactionCategoriesForm">
        <g:if test="${transactionCategories}">

        </g:if>
        <g:else>
            <div class="row">
                <div class="col-sm-12">
                    <p class="alert alert-info">
                        <g:message code="user.message.list.empty" default="No entries have been added."/>
                    </p>
                </div>
            </div>
        </g:else>
    </div>

</body>
</html>