package top.yms.server.dao;

import org.apache.ibatis.annotations.*;
import top.yms.server.entity.TagLinkArticle;

import java.util.List;

@Mapper
public interface TagLinkArticleMapper {

    @Select("SELECT id,tag_id,article_id FROM t_l_a WHERE id=#{id}")
    public TagLinkArticle findOne(@Param("id") int id);

    @Select("SELECT id,tag_id,article_id FROM t_l_a")
    public List<TagLinkArticle> findAll();

    @Insert("INSERT INTO t_l_a (tag_id,article_id)VALUES(#{tag_id},#{article_id})")
    public int add(@Param("tag_id") long tag_id, @Param("article_id") long article_id);


}
