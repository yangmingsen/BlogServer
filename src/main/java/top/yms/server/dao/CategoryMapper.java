package top.yms.server.dao;

import org.apache.ibatis.annotations.*;
import top.yms.server.entity.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    @Select("SELECT id,category_name,created_time FROM category WHERE id=#{id}")
    public Category findOne(@Param("id") long id);

    @Select("SELECT id,category_name,created_time FROM category WHERE category_name=#{category_name}")
    public Category findByCategoryName(@Param("category_name") String category_name);

    @Select("SELECT id,category_name,created_time FROM category")
    public List<Category> findAll();

    @Insert("INSERT INTO category (id,category_name,created_time)VALUES(#{id},#{category_name},#{created_time})")
    public int add(@Param("id") long id, @Param("category_name") String category_name, @Param("created_time") String created_time);


    public int delete();

    @Update("UPDATE category set category_name=#{category_name},created_time=#{created_time} WHERE id=#{id}")
    public int update(@Param("category_name") String category_name, @Param("created_time") String created_time, @Param("id") long id);

}
