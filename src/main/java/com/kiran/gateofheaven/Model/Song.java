package com.kiran.gateofheaven.Model;

import java.sql.Date;

public class Song {

    private int SerialNumber;
    private String SongName;
    private String SongNameEnglish;
    private String SongData;
    private String SongArtist;
    private String SongCategory;
    private Date SongDate;

    public Song(int serialNumber, String songName, String songNameEnglish, String songData, String songArtist, String songCategory, Date songDate) {
        SerialNumber = serialNumber;
        SongName = songName;
        SongNameEnglish = songNameEnglish;
        SongData = songData;
        SongArtist = songArtist;
        SongCategory = songCategory;
        SongDate = songDate;
    }

    public Song(String songName, String songNameEnglish, String songData, String songArtist, String songCategory, Date songDate) {
        SongName = songName;
        SongNameEnglish = songNameEnglish;
        SongData = songData;
        SongArtist = songArtist;
        SongCategory = songCategory;
        SongDate = songDate;
    }

    public Song(){
    }

    public int getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        SerialNumber = serialNumber;
    }

    public String getSongName() {
        return SongName;
    }

    public void setSongName(String songName) {
        SongName = songName;
    }

    public String getSongNameEnglish() {
        return SongNameEnglish;
    }

    public void setSongNameEnglish(String songNameEnglish) {
        SongNameEnglish = songNameEnglish;
    }

    public String getSongData() {
        return SongData;
    }

    public void setSongData(String songData) {
        SongData = songData;
    }

    public String getSongArtist() {
        return SongArtist;
    }

    public void setSongArtist(String songArtist) {
        SongArtist = songArtist;
    }

    public String getSongCategory() {
        return SongCategory;
    }

    public void setSongCategory(String songCategory) {
        SongCategory = songCategory;
    }

    public Date getSongDate() {
        return SongDate;
    }

    public void setSongDate(Date songDate) {
        SongDate = songDate;
    }
}
