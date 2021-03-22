<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Library System</title>
</head>

<body>
        <h1>This is my Library System Page</h1>
        <h2> Add Entry </h2>
	    <form action="addBooks">
            <label for="bName">Book Name:</label>
            <input type="text" id="bName" name="bookName"> <br>
            <label for="bID">Book ID:</label>
            <input type="text" id="bID" name="bookID"> <br>
            <label for="aName">Author Name:</label>
            <input type="text" id="aName" name="authorName"> <br>
            <input type="submit"> <br>
        </form>


        <h2> Delete Entry  </h2>
        <h3> Using Book ID </h3>
        <form action="deleteBooks">
            <label for="bID"> Book ID: </label>
            <input type="text" id="bID" name="bookID"> <br>
            <input type="submit"> <br>
        </form>


        <h2> Fetch Entry </h2>
        <form action="getBookByName">
                    <label for="bName">Get Book By Name:</label>
                    <input type="text" id="bName" name="bookName"> <br>
                    <input type="submit"> <br>
        </form>
        <form action="getBookByID">
                    <label for="bID">Get Book By ID:</label>
                    <input type="text" id="bID" name="bookID"> <br>
                    <input type="submit"> <br>
        </form>
        <form action="getBookByAuthor">
                    <label for="aName">Get Book By Author Name:</label>
                    <input type="text" id="aName" name="authorName"> <br>
                    <input type="submit"> <br>
        </form>

        <h2> Print All </h2>
        <form action="getBooks">
                    <button type="submit">Print All</button>
        </form>

</body>
</html>

