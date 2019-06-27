package top.yms.server.dao;

import org.apache.ibatis.annotations.*;
import top.yms.server.entity.Article;

import java.util.List;

@Mapper
public interface ArticleMapper {

    //findOne
    @Select("SELECT id,author_id,article_category_id,tag_id,title,content,created_time,update_time,browse_num,like_num,is_public,publish_states,is_del,keywords FROM article WHERE id=#{id}")
    public Article findOne(@Param("id") long id);

    //findAll
    @Select("SELECT id,author_id,article_category_id,tag_id,title,content,created_time,update_time,browse_num,like_num,is_public,publish_states,is_del,keywords FROM article")
    public List<Article> findAll();

    //add
    @Insert("INSERT INTO article (id,author_id,article_category_id,tag_id,title,content,created_time,update_time,browse_num,like_num,is_public,publish_states,is_del,keywords)" +
            "VALUES(#{id},#{author_id},#{article_category_id},#{tag_id},#{title},#{content},#{created_time},#{update_time},#{browse_num},#{like_num},#{is_public}," +
            "#{publish_states},#{is_del},#{keywords})")
    public int add(@Param("id") long id,@Param("author_id") int author_id,@Param("article_category_id") int article_category_id,@Param("tag_id") String tag_id,
                   @Param("title") String title,@Param("content") String content,@Param("created_time") String created_time,@Param("update_time") String update_time,
                   @Param("browse_num") int browse_num,@Param("like_num") int like_num,@Param("is_public") int is_public,@Param("publish_states") int publish_states,
                   @Param("is_del") int is_del,@Param("keywords") String keywords);

    //update
    @Update("UPDATE article SET author_id=#{author_id},article_category_id=#{article_category_id},tag_id=#{tag_id},title=#{title},content=#{content}," +
            "created_time=#{created_time},update_time=#{update_time},browse_num=#{browse_num},like_num=#{like_num},is_public=#{is_public} WHERE id=#{id}")
    public int update(@Param("author_id") int author_id,@Param("article_category_id") int article_category_id,@Param("tag_id") String tag_id,
                      @Param("title") String title,@Param("content") String content,@Param("created_time") String created_time,@Param("update_time") String update_time,
                      @Param("browse_num") int browse_num,@Param("like_num") int like_num,@Param("is_public") int is_public,@Param("publish_states") int publish_states,
                      @Param("is_del") int is_del,@Param("keywords") String keywords,
                      @Param("id") long id);

    //delete
    @Update("UDATE aritcle SET is_del=1 WHERE id=#{id}")
    public int delete(@Param("id") long id);

}
