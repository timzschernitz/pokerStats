<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row bg-light">
    <div class="col-2"></div>
    <div class="col-8">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Poker Stats</a>
            <button class="navbar-toggler" type="button"
                    data-toggle="collapse"
                    data-target="#navbarToggler"
                    aria-controls="navbarToggler"
                    aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarToggler">
                <ul class="navbar-nav mr-auto mt-2 mt-lg-0">

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="playerInfoDropdown" role="button" data-toggle="dropdown" aria-expanded="false">
                            My Profile
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="playerInfoDropdown">
                            <li><a class="dropdown-item" href="#">My Stats</a></li>
                            <li><a class="dropdown-item" href="profileView">View My Profile</a></li>
                            <li><a class="dropdown-item" href="#">Edit My Profile</a></li>
                        </ul>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="leagueDropdownMenu" role="button" data-toggle="dropdown" aria-expanded="false">
                            League Info
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="leagueDropdownMenu">
                            <li><a class="dropdown-item" href="#">Player List</a></li>
                            <li><a class="dropdown-item" href="#">View Past Games</a></li>
                            <li><a class="dropdown-item" href="#">Leaderboard</a></li>
                        </ul>
                    </li>

                    <!-- admin only option need to filter display by role -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="adminDropDownMenu" role="button" data-toggle="dropdown" aria-expanded="false">
                            Admin Options
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="adminDropDownMenu">
                            <li><a class="dropdown-item" href="#">Enter Game Stats</a></li>
                            <li><a class="dropdown-item" href="#">Score Corrections</a></li>
                            <li><a class="dropdown-item" href="#">Player Maintenance</a></li>
                        </ul>
                    </li>

                </ul>
            </div>
        </nav>
    </div>
    <div class="col-2"></div>
</div>