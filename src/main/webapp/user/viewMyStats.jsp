<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../head.jsp" />
<c:import url="navbar.jsp" />



<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8 justify-content-center">
        <table class="table table-hover">
            <thead>
            <tr class="table-info"><th colspan="8">Your Overall Stats</th></tr>
            <tr>
                <th>Total Games Played</th>
                <th>Total Buy-in Paid</th>
                <th>Times Rebought Back In</th>
                <th>Total Rebuy Paid</th>
                <th>Grand Total Paid</th>
                <th>Grand Total Money Won</th>
                <th>Average Position Finished</th>
                <th>Tournaments Won</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${careerStats.get("totalGamesPlayed")}</td>
                <td>${careerStats.get("totalBuyInPaid")}</td>
                <td>${careerStats.get("timesRebought")}</td>
                <td>${careerStats.get("totalRebuyPaid")}</td>
                <td>${careerStats.get("grandTotalPaid")}</td>
                <td>${careerStats.get("grandTotalWon")}</td>
                <td>${careerStats.get("averagePlacement")}</td>
                <td>${careerStats.get("tournamentsWon")}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="col-md-2"></div>
</div>


<div class="row">
    <div class="col-md-2"></div>
    <div class="col-md-8 justify-content-center">
        <table class="table table-hover">
            <thead>
                <tr class="table-info"><th colspan="4">Individual Game Results</th></tr>
                <tr>
                    <th>Date</th>
                    <th>Rebuy?</th>
                    <th>Position Finished</th>
                    <th>Money Won</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${games}" var="game">
                    <tr>
                        <td>${game.datePlayed}</td>
                        <td>
                            <c:choose>
                                <c:when test="${game.rebuyPaid == 0}">No</c:when>
                                <c:otherwise>Yes</c:otherwise>
                            </c:choose>
                        </td>
                        <td>${game.positionFinished}</td>
                        <td>${game.moneyWon}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-md-2"></div>
</div>


<c:import url="../footer.jsp" />