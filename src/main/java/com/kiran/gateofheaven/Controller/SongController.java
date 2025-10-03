package com.kiran.gateofheaven.Controller;

import com.kiran.gateofheaven.Model.Song;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SongController {
    DBConnection connection;
    SQLQueries sqlQueries;

    public SongController() throws ClassNotFoundException {
        connection = new DBConnection();
        sqlQueries = new SQLQueries();
    }

    public Song getSongById(int id){
        Song song = new Song();

        try {
            ResultSet rs = connection.resultSet(sqlQueries.selectById, id);
            while(rs.next()){
                song.setSerialNumber(rs.getInt("serialNumber"));
                song.setSongName(rs.getString("songName"));
                song.setSongNameEnglish(rs.getString("songNameEnglish"));
                song.setSongData(rs.getString("songData"));
                song.setSongArtist(rs.getString("songArtist"));
                song.setSongCategory(rs.getString("songCategory"));
                song.setSongDate(Date.valueOf(rs.getString("songDate")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return song;
    }

    public List<Song> getAllSongs(){

        List<Song> songs = new ArrayList<>();

        try {
            ResultSet rs = connection.stmt().executeQuery(sqlQueries.selectAll);
            sets(songs, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }

    public List<Song> getSongByCategory(String category){
        List<Song> songs = new ArrayList<Song>();

        try {
            ResultSet rs = connection.resultSet(sqlQueries.selectByCategory, category);
            sets(songs, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }

    public List<Song> getSongByArtist(String artist){
        List<Song> songs = new ArrayList<Song>();

        try {
            ResultSet rs = connection.resultSet(sqlQueries.selectByArtist, artist);
            sets(songs, rs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return songs;
    }


    private void sets(List<Song> songs, ResultSet rs) throws SQLException {
        while(rs.next()){
            Song song = new Song();
            song.setSerialNumber(rs.getInt("serialNumber"));
            song.setSongName(rs.getString("songName"));
            song.setSongNameEnglish(rs.getString("songNameEnglish"));
            song.setSongData(rs.getString("songData"));
            song.setSongArtist(rs.getString("songArtist"));
            song.setSongCategory(rs.getString("songCategory"));
            songs.add(song);
        }
    }

}

