<%@page import="bean.NhanVien"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/inc/header.jsp" %>
<%@include file="/templates/inc/left_bar.jsp" %>

<!-- Page Content -->
<% NhanVien nhanVien=(NhanVien)request.getAttribute("nhanVien"); %>

<div id="page-wrapper">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">
					Chỉnh sửa <small>Thông tin nhân viên</small>
				</h1>
			</div>
			<!-- /.col-lg-12 -->
			<div class="col-lg-7" style="padding-bottom: 120px">
				<form action="${pageContext.request.contextPath}/admin/updateNhanVien"
					method="POST">
					<div class="form-group">
						<label>Mã nhân viên: </label> <input class="form-control"
							type="text" name="ma-nhan-vien" value=<%=nhanVien.getId()%> />
					</div>
					<div class="form-group">
						<label>Ảnh: </label> <input class="form-control" type="text"
							name="anh" value=<%=nhanVien.getIdAnh()%>/>
					</div>
					<div class="form-group">
						<label>Quán: </label> <input class="form-control" type="text"
							name="quan" value=<%=nhanVien.getIdQuan()%> readonly="read-ony"/>
					</div>
					<div class="form-group">
						<label>Tên: </label> <input class="form-control" type="text"
							name="ten" value=<%=nhanVien.getTen()%>/>
					</div>
					<div class="form-group">
						<label>Ghi chú </label> <area class="form-control" 
							name="ghichu" value=<%=nhanVien.getIdAnh()%>/>
					</div>
					
					<button type="submit" class="btn btn-default">Save</button>
					<button type="submit" class="btn btn-default">Cancel</button>
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