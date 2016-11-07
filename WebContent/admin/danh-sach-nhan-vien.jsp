<%@page import="bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/header.jsp" %>
<%@include file="/templates/inc/left_bar.jsp" %>


<div id="wrapper">
	<!-- Page Content -->
	<%
	ArrayList<NhanVien> listNhanVien = null;
	if(request.getAttribute("listNhanVien")!=null){
		listNhanVien = (ArrayList<NhanVien>)request.getAttribute("listNhanVien");
	}
	else System.out.print("List nhan vien null");
	%>
	<div id="page-wrapper">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">
						Danh sách <small>Nhân viên</small>
					</h1>
				</div>
				<!-- /.col-lg-12 -->
				<table class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr align="center">
							<th> Id</th>
							<th> Ảnh</th>
							<th> Tên quán</th>
							<th> Tên nhân viên</th>
							<th> Ghi chú</th>
							<th> Edit</th>
							<th> Delete</th>
						</tr>
					</thead>
					<tbody>
					
						<% for (NhanVien a : listNhanVien){
							%>
								<tr >
									<td><%=a.getId()%></td>
									<td> Ảnh</td>
									
									<td> Tên Quán</td>
									
									<td><%=a.getTen()%></td>
									<td><%=a.getGhiChu() %></td>									
									<td><i class="fa fa-pencil"></i> <a href="<%=request.getContextPath()%>/admin/updateNhanVien?idNhanVien=<%=a.getId()%>"> Update</a> </td>
									<td><i class="fa fa-trash-o fa-fw"></i> <a href="<%=request.getContextPath()%>/admin/deleteNhanVien?idNhanVien=<%=a.getId()%>"> Delete</a></td>
								</tr>
						 <%}%>
					</tbody>
				</table>
			</div>
			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->

</div>

</body>

</html>
