package com.example.minhthanh.lfcnews;

/**
 * Created by Minh Thanh on 13/3/2017.
 */

public class News {
    String id;
    String title;
    String thumb;
    String link;

    @Override
    public String toString() {
        return "News{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", thumb='" + thumb + '\'' +
                ", link='" + link + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public News(String id, String title, String thumb, String link) {

        this.id = id;
        this.title = title;
        this.thumb = thumb;
        this.link = link;
    }

    public News() {

    }
}
