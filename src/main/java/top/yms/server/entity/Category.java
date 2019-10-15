package top.yms.server.entity;

public class Category {
    private int id;
    private String categoryName;
    private String createdTime;

    public Category(int id, String categoryName, String createdTime) {
        this.id = id;
        this.categoryName = categoryName;
        this.createdTime = createdTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}

