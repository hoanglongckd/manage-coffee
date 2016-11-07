<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



   
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button">
                                        <i class="fa fa-search"></i>
                                    </button>
                                </span>
                            </div>
                            <!-- /input-group -->
                        </li>
                       
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/personnel.jsp"><i class="fa fa-users fa-fw"></i> Personnel<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/personnel.jsp">List Personnel</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addPer.jsp">Add Personnel</a>
                                </li>
                                
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a  href="<%=request.getContextPath()%>/admin/menu.jsp"><i class="fa fa-cube fa-fw"></i>Menu<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/menu.jsp">List Menu</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addMenu.jsp">Add Menu</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/importProduct.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> Import Product<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/importProduct.jsp">List import product</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addImportProduct.jsp">Add import product</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/order.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> Order <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/order.jsp">List order</a>
                                </li>
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/addOrder.jsp">Add order</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=request.getContextPath()%>/admin/countProfit.jsp"><i class="fa fa-bar-chart-o fa-fw"></i> Count profit <span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=request.getContextPath()%>/admin/countProfit.jsp">List Count profit</a>
                                </li>
                               
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
       
    <!-- /#wrapper -->

   
</body>

</html>
