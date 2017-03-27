package com.undabot.newsapp.model;

public class Article {

    public final String id;
    public final String title;
    public final String content;

    public Article(String id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return title;
    }

}