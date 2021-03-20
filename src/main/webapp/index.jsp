<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="head.jsp" />

<c:import url="banner.jsp" />

<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-4">
        <div class="card h-100">
            <div class="card-body">
                <h5 class="card-title">I have an existing account</h5>
                <p class="card-text">If you already have a poker stats account, click the button below to login.</p>
                <div class="text-center">
                    <a href="user/home.jsp" class="btn btn-primary">Login</a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-4">
        <div class="card h-100">
            <div class="card-body">
                <h5 class="card-title">I need to create a new account</h5>
                <p class="card-text">If this is your first time here, you'll need to sign up for a new account and join your league.</p>
                <div class="text-center">
                    <a href="register.jsp" class="btn btn-primary">Register</a>
                </div>
            </div>
        </div>
    </div>
    <div class="col-sm-2"></div>
</div>

<c:import url="footer.jsp" />