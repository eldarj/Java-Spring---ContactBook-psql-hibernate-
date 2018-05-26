<%@ page import="ba.fit.java.spring.mvc.models.Contact" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ba.fit.java.spring.mvc.viewmodels.kontakti.KontaktIndexVM" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 5/23/2018
  Time: 12:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%
    KontaktIndexVM model = (KontaktIndexVM) request.getAttribute("model");
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2>Kontakti</h2>
<div class="col-sm-12">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">#</th>
            <th scope="col">Ime</th>
            <th scope="col">Prezime</th>
            <th scope="col">Email</th>
            <th scope="col">Adresa</th>
            <th scope="col">Telefon</th>
            <th scope="col">Website</th>
        </tr>
        </thead>
        <tbody>
        <% for (KontaktIndexVM.Row x : model.rows){%>
            <tr>
                <td scope="row"><strong><%=x.id%></strong></td>
                <td><%=x.ime%></td>
                <td><%=x.prezime%></td>
                <td><%=x.email%></td>
                <td><%=x.adresa%></td>
                <td><%=x.telefon%></td>
                <td><%=x.website%></td>
            </tr>
        <% } %>
        </tbody>
    </table>
</div>
<div class="col-sm-12">
    <button ajax-poziv='da' ajax-url='/kontakti/novi' ajax-rezultat='mainAjaxDiv' class="btn btn-default">Dodaj</button><br>
</div>
