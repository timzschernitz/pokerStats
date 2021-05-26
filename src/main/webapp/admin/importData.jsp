<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../head.jsp" />
<c:import url="../user/navbar.jsp" />

<div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
        <c:if test = "${gameDataAdded != null}">
            <c:choose>
                <c:when test = "${gameDataAdded == true}">
                    <div class="alert alert-success" role="alert">
                        Tournament records added successfully!
                    </div>
                </c:when>
                <c:when test = "${gameDataAdded == false}">
                    <div class="alert alert-danger" role="alert">
                        No tournament records were added. Please try again.
                    </div>
                </c:when>
                <c:otherwise></c:otherwise>
            </c:choose>
            <c:remove var="gameDataAdded" />
        </c:if>

        <form action="../admin/importDataAction" method="POST">

            <div class="form-group">
                <label for="league">League Name</label>
                <input type="text" class="form-control" id="league" name="league" required value="${user.league}">
            </div>

            <div class="form-group">
                <label for="tournamentName">Tournament Name</label>
                <input type="text" class="form-control" id="tournamentName" name="tournamentName" required>
            </div>

            <div class="form-group">
                <label for="date">Date</label>
                <input type="date" class="form-control" id="date" name="date" required>
            </div>

            <br /><br />
            <input type="submit" name="submit" value="Import Data" class="btn btn-primary" />

        </form>
    </div>
    <div class="col-md-4"></div>
</div>


<c:import url="../footer.jsp" />