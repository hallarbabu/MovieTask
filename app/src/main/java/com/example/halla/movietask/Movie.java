package com.example.halla.movietask;


public class Movie {

   private String id,name,vote_count,vote_average,release_date,overview;

    public Movie(String id, String name, String vote_count, String vote_average, String release_date, String overview) {
        this.id = id;
        this.name = name;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.release_date = release_date;
        this.overview = overview;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getVote_count() {
        return vote_count;
    }

    public String getVote_average() {
        return vote_average;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getOverview() {
        return overview;
    }
}
