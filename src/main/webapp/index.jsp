<%-- Document : index Created on : Jun 11, 2018, 5:41:46 PM Author : bastianjoe --%>
<%@include file="views/inc/header.jsp" %>
<c:if test="${not empty sessionScope.Role}">
    <META http-equiv="refresh" content="0;URL=views/${sessionScope.Role}">
</c:if>
<link href="Assets/css/login.css" rel="stylesheet" type="text/css" />
<div class="container">
    <div class="col-md-4 col-md-offset-4">
        <div class="gb-spinner spinner-centered panel-sign-in-loader hidden"></div>
        <div class="panel panel-default panel-sign-in">
            <div class="panel-body">
                <form method="post" action="${contextPath}/Auth" id="login">
                    <div class="form-group">
                        <label for="user">Username</label>
                        <input type="text" class="form-control" id="user" name="userName" required="" placeholder="Username">
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password</label>
                        <input type="password" required="" class="form-control" name="password" id="pwd" placeholder="Password">
                    </div>
                    <button type="submit" data-spinner="" class="btn btn-primary btn-block">Login</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="Assets/js/login.js" type="text/javascript"></script>
<footer class="footer text-center">&copy; 2016 Tata Consultancy Services</footer>