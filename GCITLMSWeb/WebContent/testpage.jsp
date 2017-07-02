<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.gcit.lms.service.AdminBookService"%>
<%@page import="com.gcit.lms.entity.Book"%>

<%@include file="header.html" %>
<script src="js/gcitlms.js"></script>

<%
AdminBookService adminBookService = new AdminBookService();
List<Book> books = adminBookService.getAllBooks(null, null);
%>
<select class ="input-sm" name="genreId">
					<%for(Book b: books){ %>
					<option value="<%=b.getBookId()%>"><%=b.getTitle() %></option>
					<%} %>
				</select>