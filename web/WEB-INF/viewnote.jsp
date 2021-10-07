<%-- 
    Document   : viewnote
    Created on : 5-Oct-2021, 4:01:25 PM
    Author     : david
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        <p><strong>Title: </strong>${note.title}</p>
        <p>
            <strong>Contents:</strong>
            <br>
            ${note.content}
        </p>
        <nav>
            <a href="note?edit">Edit</a>
        </nav>
    </body>
</html>
