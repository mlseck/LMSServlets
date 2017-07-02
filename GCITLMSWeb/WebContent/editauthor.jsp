<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.entity.Book"%>
<%@page import="com.gcit.lms.entity.Publisher"%>
<%@page import="com.gcit.lms.entity.Author"%>
<%@page import="com.gcit.lms.entity.Genre"%>
<%@page import="com.gcit.lms.service.AdminBookService"%>
<%
	Integer authorId = Integer.parseInt(request.getParameter("authorId"));
	AdminBookService service = new AdminBookService();
	Author author = service.getAuthorByPK(authorId);
%>

<div class="modal-header">
	<button type="button" class="close" data-dismiss="modal"
		aria-label="Close">
		<span aria-hidden="true">&times;</span>
	</button>
	<h4 class="modal-title" id="myModalLabel">Edit Author Details</h4>
</div> 
<div class="box">
	<form action="editAuthor" method="post">
		<div class="row"> 
			<label>Author Name </label><input class="input-sm" type="text" name="authorName" value="<%=author.getAuthorName()%>">
			<input type="hidden" name="authorId" value=<%=author.getAuthorId()%>>
		</div></br> 
		<div class="modal-footer">
		<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
		<button type="submit" class="btn btn-primary">Edit Author</button>
	</div>
	</form>
</div>