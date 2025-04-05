package com.pinggy.assignment.Utility;

public class PostDto {

    private  String title;
    private String body;
    private String PinggyAuthHeader = AuthContext.getAuthHeader();

    public PostDto() {
    }

    public PostDto(String title, String body, String authContext) {
        this.title = title;
        this.body = body;
        PinggyAuthHeader = authContext;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getPinggyAuthHeader() {
        return PinggyAuthHeader;
    }

    public void setPinggyAuthHeader(String authContext) {
        PinggyAuthHeader = authContext;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", PinggyAuthHeader='" + PinggyAuthHeader + '\'' +
                '}';
    }
}
