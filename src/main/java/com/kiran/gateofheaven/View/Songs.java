package com.kiran.gateofheaven.View;

import com.kiran.gateofheaven.Controller.SongController;
import com.kiran.gateofheaven.Model.Song;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/Songs")
public class Songs extends HttpServlet{
    SongController songController;
    public Songs(){
        try {
            songController = new SongController();
        } catch (ClassNotFoundException e) {
            System.out.println("Songs constructor error");
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String idStr = req.getParameter("id");
        String catStr = req.getParameter("category");
        String artStr = req.getParameter("artist");

        // All Songs
        if(idStr == null && catStr == null && artStr == null){
            List<Song> allSongsList = new ArrayList<Song>();
            allSongsList.addAll(songController.getAllSongs());
            req.setAttribute("allSongsList", allSongsList);
            req.getRequestDispatcher("songs.jsp").forward(req, resp);
        }
        // Single Song by Id
        else if(idStr != null && catStr == null && artStr == null){
            Song song = songController.getSongById(Integer.parseInt(idStr));
            System.out.println(song.getSongNameEnglish());
            req.setAttribute("song", song);
            req.getRequestDispatcher("song.jsp").forward(req, resp);
        }
        // Songs by artist
        else  if(idStr == null && catStr == null && artStr != null){
            List<Song> allSongsList = new ArrayList<Song>();
            allSongsList.addAll(songController.getSongByArtist(artStr));
            req.setAttribute("allSongsList", allSongsList);
            req.getRequestDispatcher("songs.jsp").forward(req, resp);
        }
        else  if(idStr == null && artStr == null && catStr != null){
            List<Song> allSongsList = new ArrayList<Song>();
            allSongsList.addAll(songController.getSongByCategory(catStr));
            System.out.println("category");
            System.out.println(allSongsList);
            req.setAttribute("allSongsList", allSongsList);
            req.getRequestDispatcher("songs.jsp").forward(req, resp);
        }
    }

}
