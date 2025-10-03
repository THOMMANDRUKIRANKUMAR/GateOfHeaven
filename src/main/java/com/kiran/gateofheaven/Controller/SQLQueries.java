package com.kiran.gateofheaven.Controller;

public class SQLQueries {

    public final String DBURL = "jdbc:postgresql://localhost:5050/kiran";
    public final String USERNAME = "postgres";   // superuser
    public final String PASSWORD = "root";       // only if you set this

    public final String selectAll = "select * from songs";
    public final String selectById = "select * from songs where \"serialNumber\" = ?";
    public final String selectByArtist = "select * from songs where \"songArtist\" = ?";
    public final String selectByCategory = "select * from songs where \"songCategory\" = ?";
    public final String check = "SELECT COUNT(*) FROM songs WHERE \"songName\" = ? OR \"songNameEnglish\" = ?";
    public final String insert =
            "INSERT INTO songs (\"songName\", \"songNameEnglish\", \"songData\", \"songArtist\", \"songCategory\", \"songDate\") " +
                    "VALUES (?, ?, ?, ?, ?, ?)";



    String chapterVerses = "SELECT book_name_telugu, verse_number, verse " +
            "FROM telugu_bible " +
            "WHERE \"book_name_english\" = ? " +
            "AND \"chapter_number\" = ? " +
            "ORDER BY \"verse_number\"";

}
