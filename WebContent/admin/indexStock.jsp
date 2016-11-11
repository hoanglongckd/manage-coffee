<%@page import="bean.Stock"%>
<%@page import="bean.Unit"%>
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
					Kho <small>List</small>
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
				ArrayList<Stock> alItem = (ArrayList<Stock>) request.getAttribute("alItem");
			%>
			<form action="">
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr align="center">

						<th>ID Kho</th>
						<th>Tên Nguyen Liệu</th>
						<th>Tổng số Lượng Còn</th>
						<th>Delete</th>
						<th>Edit</th>

						

					</tr>
				</thead>
				<tbody>
					<%
						for (Stock item : alItem) {
					%>
					<tr class="odd gradeX" align="center">
						<td><%=item.getId_stock()%></td>
						<td><%=item.getName_material()%></td>
						<td><%=item.getTotalNumber()%></td>
						<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
							href="<%=request.getContextPath()%>/admin/delStock?id=<%=item.getId_stock()%>"> Delete</a></td>
						<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
							href="<%=request.getContextPath()%>/admin/editStock?id=<%=item.getId_stock()%>"> Edit</a></td>
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
