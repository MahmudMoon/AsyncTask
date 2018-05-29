package com.example.bou.asynctask;

public class MovieObject {
    String movie;
    int year;
    double rating;
    String duration;
    String director;
    String tagline;
    String actor;
    String image_;
    String story;

    public MovieObject(String movie, int year, double rating, String duration, String director, String tagline, String actor, String image_, String story) {
        this.movie = movie;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
        this.director = director;
        this.tagline = tagline;
        this.actor = actor;
        this.image_ = image_;
        this.story = story;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getImage_() {
        return image_;
    }

    public void setImage_(String image_) {
        this.image_ = image_;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
