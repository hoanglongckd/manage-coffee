<%@page import="bean.User"%>
<%@page import="bean.Anh"%>
<%@page import="bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/header.jsp" %>
<%@include file="/templates/inc/left_bar.jsp" %>

<!-- Page Content -->
<% NhanVien nhanVien=(NhanVien)request.getAttribute("nhanVien");
	Anh anh = (Anh) request.getAttribute("anh");
	User user = null;
	if(request.getAttribute("user")!=null)
		user = (User) request.getAttribute("user");
%>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Thông tin nhân viên
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="${pageContext.request.contextPath}/admin/updateNhanVien"
					method="POST">
					<div class="form-group">
						<label>Ảnh: </label><br/> 
						<img src="<%=anh.getDuongDan() %>" alt="No Image" width="150" />
					</div>
					<div class="form-group">
						<label>Quán: </label> <input class="form-control" type="text"
							name="quan" value="Moc Coffee" readonly="read-ony"/>
					</div>
					<div class="form-group">
						<label>Tên: </label> <input class="form-control" type="text"
							name="ten" value="<%=nhanVien.getTen()%>"/>
					</div>
					<%
					if(user!=null){
					%>
					<div class="form-group">
						<label>Tên tài khoản: </label> <input class="form-control" type="text"
							name="username" value="<%=user.getUsername() %>" />
					</div>
					<div class="form-group">
						<label> Mật khẩu: </label> <input class="form-control" type="password"
							name="password" value="<%=user.getPassword() %>" />
					</div>
					<div>
					<input class="form-control" type="hidden"
							name="idUser" value="<%=user.getId_user()%>"/>
					</div>
					<%
					}
					else{
					%>
					<div class="form-group">
						<label>Tên tài khoản: </label> <input class="form-control" type="text"
							name="username" value="" placeholder=" Nhập Username"/>
					</div>
					<div class="form-group">
						<label>Mật khẩu: </label> <input class="form-control" type="password"
							name="password" value="" placeholder=" Nhập Password"/>
					</div>
					<%} %>
					<div class="form-group">
						<label>Ghi chú </label> <textarea  rows="5" cols="20" class="form-control" 
							name="ghichu" ><%=nhanVien.getGhiChu() %></textarea>
					</div>
					<button type="submit" class="btn btn-default">Update</button>
					<button type="reset" class="btn btn-default">Reset</button>
				</form>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container-fluid -->
</div>
<!-- /#page-wrapper -->

</body>

</html>