<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 5/22/2018
  Time: 6:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/views/shared/header.jsp"/>
<!-- Page Content -->
<div class="container">
    <div class="row">
        <div class="col-sm-12 col-lg-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h1 class="panel-title"><span class="glyphicon glyphicon-bullhorn"></span> Dashboard</h1>
                </div>
                <div class="panel-body">
                    <h4>Urađeno:</h4>
                    <p>Kontroler, model i Viewmodel za kontakte.</p>
                    <p>Gson library za upis-ispis podataka o kontaktima u Json fajl. (mini DB)</p>
                </div>
            </div>
        </div>
        <div class="col-sm-12 col-lg-9">
            <div class="alax-loading-spinner">
                <span class="gloader"></span>
            </div>
            <div id="mainAjaxDiv">
                <h1>Java kurs</h1>
                <div class="container-fluid">
                    <button ajax-poziv='da' ajax-url='/kontakti' ajax-rezultat='mainAjaxDiv' class="btn btn-default">Kontakti</button>
                </div>
            </div>
        </div>
    </div>
    <!-- /.row -->
</div><!-- /.container -->
<jsp:include page="/WEB-INF/views/shared/footer.jsp"/>
