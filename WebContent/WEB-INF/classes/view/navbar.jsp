<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
                Menu <i class="fa fa-bars"></i>
            </button>
            <a class="navbar-brand page-scroll" href="/Skywings">
                <i class="fa fa-plane"></i> <span style="font-weight:bold">SKYWINGS</span> Prototyp II
            </a>
        </div>

        <%
            if(request.getRemoteUser() != null) {
        %>
        <div class="collapse navbar-collapse navbar-right navbar-main-collapse">
            <ul class="nav navbar-nav">
                <li><a class="page-scroll" href="#">User: <%= request.getRemoteUser() %></a></li>
                <li><a class="page-scroll" href="logout.jsp">Sign Out</a></li>
            </ul>
        </div>
        <%
            }
        %>
    </div>
</nav>
