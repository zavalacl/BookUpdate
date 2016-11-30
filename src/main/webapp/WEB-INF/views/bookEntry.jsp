<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book Entries</title>
</head>
<body>
<h1>Your added book entry is as follows:</h1>

<table border="1">
	<tr>
		<th>Author</th>
		<th>Book Title</th>
		<th>Publisher/Imprint</th>
		<th>Sales</th>
		<th>Year Published</th>
		<th>Genre</th>
		<th>Status</th>
		<th>Borrower</th>	
	</tr>

	<tr>
		<td>${nb.getAuthor() }</td>
		<td>${nb.getTitle() }</td>
		<td>${nb.getPublisher() }: ${nb.getImprint() }</td>
		<td>${nb.getSales() }</td>
		<td>${nb.getYearPublished() }</td>
		<td>${nb.getGenre() }</td>
		<td>${nb.getStatus() }</td>
		<td>${nb.getBorrower()}</td>
	</tr>

</table>
<p>See all books here:<a href="list">Book List</a></p>
<p>Or submit another book here:<a href="resources/form.html">Add another book</a></p>
</body>
</html>