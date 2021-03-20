<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="head.jsp" />

<c:import url="banner.jsp" />


<div class="row text-center">

    <div class="col-sm-2 col-md-3 col-lg-4"></div>
    <div class="col-sm-8 col-md-6 col-lg-4">
        <div class="card h-100">
            <div class="card-body">
                <form action="j_security_check" method="POST">
                    <div class="form-group">
                        <h5 class="card-title"><label for="j_username">username</label></h5>
                        <input type="text" class="form-control" id="j_username" name="j_username">
                        <h5 class="card-title"><label for="j_password">Password</label></h5>
                        <input type="password" class="form-control" id="j_password" name="j_password">
                    </div>
                    <div class="text-center">
                        <input type="submit" class="btn btn-primary" value="Login">
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="col-sm-2 col-md-3 col-lg-4"></div>
</div>


<c:import url="footer.jsp" />