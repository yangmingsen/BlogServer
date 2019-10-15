package top.yms.server.entity;

import java.io.Serializable;

public class Comment implements Serializable {
    private long id;
    private long articleId;
    private String username;
    private String content;
    private String createdTime;

    public Comment(long id, long articleId, String username, String content, String createdTime) {
        this.id = id;
        this.articleId = articleId;
        this.username = username;
        this.content = content;
        this.createdTime = createdTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
