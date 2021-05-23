<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="head.jsp" />

<c:import url="banner.jsp" />

<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">

        <form>
            <div class="form-group">
                <label for="league">League Name</label>
                <input type="text" class="form-control" id="league" name="league">
            </div>

            <div class="form-group">
                <label for="userName">Username</label>
                <input type="text" class="form-control" id="userName" name="userName">
            </div>

            <div class="form-group">
                <label for="firstName">Username</label>
                <input type="text" class="form-control" id="firstName" name="firstName">
            </div>

            <div class="form-group">
                <label for="lastName">Username</label>
                <input type="text" class="form-control" id="lastName" name="lastName">
            </div>

            <div class="form-group">
                <label for="location">Username</label>
                <input type="text" class="form-control" id="location" name="location">
            </div>

                <p>Are you a league admin?</p>
                <div class="form-check">
                    <input class="form-check-input" type="radio" name="exampleRadios" id="yesAdmin" value="yesAdmin">
                    <label class="form-check-label" for="yesAdmin">Yes</label>
                </div>

                <div class="form-check">
                    <input class="form-check-input" type="radio" name="exampleRadios" id="notAdmin" value="notAdmin" checked>
                    <label class="form-check-label" for="notAdmin">No</label>
                </div>



        </form>

    </div>
    <div class="col-sm-2"></div>
</div>

<c:import url="footer.jsp" />