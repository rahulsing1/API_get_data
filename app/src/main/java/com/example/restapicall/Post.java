package com.example.restapicall;

public class Post {

    private String userid,id,title,body;

    public Post(String userid, String title, String body) {
        this.userid = userid;
        this.title = title;
        this.body = body;
    }


    public String getUserid() {
        return userid;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
