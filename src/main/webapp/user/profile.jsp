<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../head.jsp" />
<c:import url="navbar.jsp" />

<div class="row pd-10">
    <div class="col-6">
        Name: ${user.firstName} ${user.lastName} <br />
        Location: ${user.location} <br />
        League: ${user.league} <br />
    </div>
    <div class="col-6"></div>
</div>

<c:import url="../footer.jsp" />