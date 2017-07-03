package com.example.android.bigapp.model;

/**
 * Created by Chetan on 7/1/2017.
 */

public class ToDo {
    int userId;
    int id;
    String title;
    Boolean completed;
    //note that the the feilds you define in the model should be exactly same as
    //the ones in JSON

    public ToDo(int userId, int id, String title, Boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
