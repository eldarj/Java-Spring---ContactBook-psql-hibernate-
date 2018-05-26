<%@ page import="ba.fit.java.spring.mvc.viewmodels.kontakti.KontaktVM" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 5/26/2018
  Time: 12:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%
    KontaktVM model = (KontaktVM) request.getAttribute("model");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Novi kontakt</h2>
<div class="col-sm-12">
    <form:form method="POST" ajax-poziv="da" ajax-rezultat="mainAjaxDiv" action="/kontakti/snimi" modelAttribute="model" >
        <form:input type="hidden" path="id"/>
        <div class="form-group">
            <label>Ime: </label>
            <form:input type="text" path="ime" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Prezime: </label>
            <form:input type="text" path="prezime" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Email: </label>
            <form:input type="text" path="email" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Adresa: </label>
            <form:input type="text" path="adresa" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Telefon: </label>
            <form:input type="text" path="telefon" class="form-control"/>
        </div>
        <div class="form-group">
            <label>Website: </label>
            <form:input type="text" path="website" class="form-control"/>
        </div>
        <input class="btn btn-primary" type="submit" value="Snimi" />
    </form:form>
</div>