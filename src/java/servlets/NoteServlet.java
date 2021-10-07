/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author david
 */
public class NoteServlet  extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(path,false)));
        
        
        String title = req.getParameter("titleField");
        String contents = req.getParameter("contentField");    
        
        out.write(title);
        out.write("\n");
        out.write(contents);
        
        out.close();
        
        contents = contents.replace( "\n","<br>");
        Note note = new Note(title,contents);
        req.setAttribute("note",note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        //create a Note object using the text file
        String title = br.readLine();
        String line;
        String contents = "";
        
        while ((line = br.readLine()) != null) {
            contents = contents.concat(line + "<br>");
        }

        
        //close readers
        br.close();
        
        //redirects to editnote.jsp if edit is clicked
        if (req.getQueryString() != (null)) {
            contents = contents.replace("<br>", "\n");
            
            Note note = new Note(title,contents);
            req.setAttribute("note",note);
            
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(req,resp);
            return;
        }
        
        Note note = new Note(title,contents);
        req.setAttribute("note",note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(req,resp);
    }
    
}
