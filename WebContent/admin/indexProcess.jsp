<%@page import="bean.Process"%>
<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/header.jsp"%>
<%@include file="/templates/inc/left_bar.jsp"%>




<!-- Page Content -->

<div id="page-wrapper">

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">

				<h1 class="page-header">
					Danh Sách Quá Trình Chế Biến <small>Danh Sách</small>
				</h1>

				<div class="search">
					<ul class="nav" id="side-menu">
						<li class="sidebar-search">
							<div class="input-group custom-search-form">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="input-group-btn">
									<button class="btn btn-default" type="button">
										<i class="fa fa-search"></i>
									</button>
								</span>
							</div> <!-- /input-group -->
						</li>
						<li>
					</ul>
				</div>

			</div>

			<%
				ArrayList<Process> alItem = (ArrayList<Process>) request.getAttribute("alItem");
			%>
			<form action="">
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr align="center">


							<th>ID Chế biến</th>
							<th>Tên Nguyên liệu</th>
							<th>Tên Thực Đơn</th>
							<th>Số Lượng</th>




						</tr>
					</thead>
					<tbody>
						<%
							for (Process item : alItem) {
						%>
						<tr class="odd gradeX" align="center">
							<td><%=item.getId()%></td>
							<td><%=item.getName_material()%></td>
							<td><%=item.getName_menu()%></td>
							<td><%=item.getQuantity()%></td>
							<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
								href="<%=request.getContextPath()%>/admin/delProcess?id=<%=item.getId()%>">
									Delete</a></td>
							<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
								href="<%=request.getContextPath()%>/admin/editProcess?id=<%=item.getId()%>">
									Edit</a></td>
						</tr>
						<%
							}
						%>
					</tbody>
				</table>
			</form>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->





</body>

</html>
