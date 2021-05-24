<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="head.jsp" />

<c:import url="banner.jsp" />

<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">

        <form action="registerUser" method="POST">

            <div class="form-group">
                <label for="userName">Username</label>
                <input type="text" class="form-control" id="userName" name="userName" required>
            </div>

            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="password" name="password" required>
                <label for="passwordReentry">Re-enter Password</label>
                <input type="password" class="form-control" id="passwordReentry" name="passwordReentry">
            </div>


            <div class="form-group">
                <label for="league">League Name</label>
                <input type="text" class="form-control" id="league" name="league" required>
            </div>

            <div class="form-group">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" required>
            </div>

            <div class="form-group">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required>
            </div>

            <div class="form-group">
                <label for="location">Location</label>
                <input type="text" class="form-control" id="location" name="location" required>
            </div>

                <p>Are you a league admin?</p>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="admin" id="yesAdmin" value="yes">
                    <label class="form-check-label" for="yesAdmin">Yes</label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="admin" id="notAdmin" value="no" checked required>
                    <label class="form-check-label" for="notAdmin">No</label>
                </div>

            <br /><br />
            <input type="submit" name="submit" value="Register" class="btn btn-primary" />

        </form>

    </div>
    <div class="col-sm-2"></div>
</div>

<c:import url="footer.jsp" />