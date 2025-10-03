package com.kiran.gateofheaven.View;

import com.kiran.gateofheaven.Controller.BibleController;
import com.kiran.gateofheaven.Model.Bible;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/ChapterView")
public class ChapterView extends HttpServlet{

    private BibleController bController;

    @Override
    public void init() throws ServletException {
        super.init();
        bController = new BibleController(); // initialize controller once
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Bible> verses = bController.chapterView(request.getParameter("book"), Integer.parseInt(request.getParameter("chapter")));
        String bookName = verses.get(0).getBookName();
        request.setAttribute("bookName", bookName);
        request.setAttribute("chapterNumber", Integer.parseInt(request.getParameter("chapter")));
        request.setAttribute("versesList", verses);
        request.getRequestDispatcher("/chapter.jsp").forward(request, response);

    }
}
