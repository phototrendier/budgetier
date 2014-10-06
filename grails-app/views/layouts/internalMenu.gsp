<%--
  Created by IntelliJ IDEA.
  User: vbledar
  Date: 10/6/14
  Time: 22:41
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<g:applyLayout name="main">

    <g:if test="${pageProperty(name: "page.internalMenu")}">
        <g:pageProperty name="page.internalMenu"/>
        <div class="spacer10"></div>
    </g:if>

    <g:layoutBody/>
</g:applyLayout>