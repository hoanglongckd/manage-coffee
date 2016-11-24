<%@page import="bean.TypeMenu"%>
<%@page import="bean.Table"%>
<%@page import="java.util.ArrayList"%>
<%@  page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/inc/_header.jsp" %>
<%@include file="/templates/inc/_top.jsp" %>
<%@include file="/templates/inc/_menu.jsp" %>
<%@include file="/templates/inc/left_bar.jsp"%>
<title> Danh sách Thực đơn</title>

<!-- Page Content -->

<div id="page-wrapper">

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-12">

				<h1 class="page-header">
					MANAGER TypeMenu <small>List</small>
				</h1>	
			</div>

			<%
				ArrayList<TypeMenu> alItem = (ArrayList<TypeMenu>) request.getAttribute("alItem");
			%>
			<form action="">
			<table class="table table-striped table-bordered table-hover"
				id="dataTables-example">
				<thead>
					<tr align="center">

						<th>ID Type Menu</th>
						<th>Name Type Menu</th>
						<th>Delete</th>
						<th>Edit</th>

						

					</tr>
				</thead>
				<tbody>
					<%
						for (TypeMenu item : alItem) {
					%>
					<tr class="odd gradeX" align="center">
						<td><%=item.getIdType()%></td>
						<td><%=item.getNameType()%></td>
						
						<td class="center"><i class="fa fa-trash-o  fa-fw"></i><a
							href="<%=request.getContextPath()%>/admin/delTypeMenu?tMid=<%=item.getIdType()%>"> Delete</a></td>
						<td class="center"><i class="fa fa-pencil fa-fw"></i> <a
							href="<%=request.getContextPath()%>/admin/editTypeMenu?tMid=<%=item.getIdType()%>"> Edit</a></td>
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

<jsp:include page="/templates/inc/_footer-start.jsp" />
<jsp:include page="/templates/inc/_footer-end.jsp" />
