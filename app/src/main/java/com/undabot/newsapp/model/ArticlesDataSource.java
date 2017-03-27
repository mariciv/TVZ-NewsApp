package com.undabot.newsapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArticlesDataSource {

    public static final List<Article> ARTICLES = new ArrayList<>();
    public static final Map<String, Article> ARTICLE_MAP = new HashMap<>();

    private static void addArticle(Article item) {
        ARTICLES.add(item);
        ARTICLE_MAP.put(item.id, item);
    }

    private static Article createArticle(int position) {
        return new Article(String.valueOf(position), "Article " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Article: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore content information here.");
        }
        return builder.toString();
    }

    public static List<Article> getArticles() {
        return ARTICLES;
    }
}