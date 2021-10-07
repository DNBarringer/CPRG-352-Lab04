<%-- 
    Document   : editnote
    Created on : 5-Oct-2021, 4:01:41 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="POST" action="note">
            <label>Title:</label>
            <input type="text" name="titleField" value="${note.title}">
            <br>
            <label>Contents:</label>
            <textarea name="contentField" rows="6">${note.content}</textarea>
            <br>
            <input type="submit" value="Save">
        </form>
       
    </body>
</html>
