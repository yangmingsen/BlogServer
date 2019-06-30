package top.yms.server.entity;

public class Tag {

    private long id;
    private String tagName;
    private String createdTime;

    public Tag(long id, String tagName, String createdTime) {
        this.id = id;
        this.tagName = tagName;
        this.createdTime = createdTime;
    }

    public Tag(String tagName, String createdTime) {
        this.tagName = tagName;
        this.createdTime = createdTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
