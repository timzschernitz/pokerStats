<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../head.jsp" />
<c:import url="navbar.jsp" />

<div class="row">
    <div class="col-sm-2"></div>
    <div class="col-sm-8">

        <form action="editProfileAction" method="POST">

            <%-- Removed username updating for now due to issues encountered. Need to revisit in the future --%>
<%--            <div class="form-group">--%>
<%--                <label for="userName">Username</label>--%>
<%--                <input type="text" class="form-control" id="userName" name="userName" required value="${user.userName}">--%>
<%--            </div>--%>

                <%-- Same thing with password updating. --%>
<%--            <div class="form-group">--%>
<%--                <label for="password">Password</label>--%>
<%--                <input type="password" class="form-control" id="password" name="password">--%>
<%--                <label for="passwordReentry">Re-enter Password</label>--%>
<%--                <input type="password" class="form-control" id="passwordReentry" name="passwordReentry">--%>
<%--            </div>--%>

            <div class="form-group">
                <label for="league">League Name</label>
                <input type="text" class="form-control" id="league" name="league" required value="${user.league}">
            </div>

            <div class="form-group">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" id="firstName" name="firstName" required value="${user.firstName}">
            </div>

            <div class="form-group">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" required value="${user.lastName}">
            </div>

            <div class="form-group">
                <label for="location">Location</label>
                <input type="text" class="form-control" id="location" name="location" required value="${user.location}">
            </div>

            <br /><br />
            <input type="submit" name="submit" value="Save Changes" class="btn btn-primary" />

        </form>

    </div>
    <div class="col-sm-2"></div>
</div>

<c:import url="../footer.jsp" />