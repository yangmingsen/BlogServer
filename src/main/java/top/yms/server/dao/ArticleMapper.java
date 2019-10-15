package top.yms.server.dao;

import org.apache.ibatis.annotations.*;
import top.yms.server.entity.Article;
import top.yms.server.entity.SimpleArticle;

import java.util.List;

@Mapper
public interface ArticleMapper {

    //findOne
    @Select("SELECT id,author_id,article_category_id,tag_id,title,markdown_doc,content,created_time,update_time," +
            "browse_num,like_num,is_public,publish_states,is_del,keywords,abstract_content,allow_comment FROM article WHERE id=#{id}")
    public Article findOne(@Param("id") long id);

    //findAll
    @Select("SELECT id,author_id,article_category_id,tag_id,title,markdown_doc,content,created_time,update_time," +
            "browse_num,like_num,is_public,publish_states,is_del,keywords,abstract_content,allow_comment FROM article")
    public List<Article> findAll();


    @Update("UPDATE article SET browse_num=#{browse_num} WHERE id=#{id}")
    public int updateBrowseNum(@Param("browse_num") int browseNum, @Param("id") long id);

    @Update("UPDATE article SET like_num=like_num+1 WHERE id=#{id}")
    public int updateLikeNum(@Param("id") long id);

    /***
     * 根据一些文章分类id查询相应的文章
     *
     * @author yangminsen
     * @createTime 2019-07-03
     * @updateTime 2019-10-03
     * @param article_category_id
     * @return
     *
     * @version 1.1
     */
    @Select("SELECT id,author_id,article_category_id,title,update_time,browse_num,like_num,abstract_content  FROM article" +
            " WHERE article_category_id=#{article_category_id}")
    public List<SimpleArticle> findAllByCategoryId(@Param("article_category_id") int article_category_id);

    /**
     * 根据一些文章id查询相应的文章
     * @param ids (1561914320208921,1561914320208922,1561914320208924,...)
     * @return
     */
    @Select("SELECT id,author_id,article_category_id,tag_id,title,content,created_time,update_time,browse_num,like_num," +
            "is_public,publish_states,is_del,keywords,abstract_content,allow_comment FROM article WHERE id in (#{ids})")
    public List<Article> findAllByIds(@Param("ids") String ids);


    /**
     * 根据 tagId向数据库查询文章
     *
     * @author yangminsen
     * @createTime 2019-10-03
     * @updateTime 2019-10-03
     * @param tagId
     * @return
     */
    @Select("SELECT id,author_id,article_category_id,title,update_time,browse_num,like_num,abstract_content FROM article" +
            " WHERE id IN (SELECT article_id FROM t_l_a WHERE tag_id=#{tagId})")
    public List<SimpleArticle> findAllByTagId(@Param("tagId") long tagId);

    /**
     * 查询所有文章数据,简单版
     *
     *
     * @author yangminsen
     * @createTime 2019-07-03
     * @updateTime 2019-10-04
     *
     * @nowVersion1.1
     *
     * @lastVersion 1.0
     * @Select("SELECT id, author_id, article_category_id, title, update_time, browse_num, like_num, abstract_content FROM article")
     *     public List<SimpleArticle>findAllOfMain();
     * @return
     */
    @Select("SELECT id,author_id,article_category_id,title,update_time,browse_num,like_num,abstract_content FROM article" +
            " ORDER BY update_time DESC")
    public List<SimpleArticle>findAllOfSimple();

    @Select("SELECT id,author_id,article_category_id,tag_id,title,update_time,browse_num,like_num,abstract_content FROM article" +
            " ORDER BY update_time DESC")
    public List<SimpleArticle>findAllOfAdmin();

    //add
    @Insert("INSERT INTO article (id,author_id,article_category_id,tag_id,title,markdown_doc,content,created_time,update_time," +
            "browse_num,like_num,is_public,publish_states,is_del,keywords,abstract_content,allow_comment)" +
            "VALUES(#{id},#{author_id},#{article_category_id},#{tag_id},#{title},#{markdown_doc},#{content},#{created_time},#{update_time},#{browse_num},#{like_num},#{is_public}," +
            "#{publish_states},#{is_del},#{keywords},#{abstract_content},#{allow_comment})")
    public int add(@Param("id") long id,@Param("author_id") int author_id,@Param("article_category_id") int article_category_id,@Param("tag_id") String tag_id,
                   @Param("title") String title,@Param("markdown_doc") String markdown_doc,@Param("content") String content,@Param("created_time") String created_time,@Param("update_time") String update_time,
                   @Param("browse_num") int browse_num,@Param("like_num") int like_num,@Param("is_public") int is_public,@Param("publish_states") int publish_states,
                   @Param("is_del") int is_del,@Param("keywords") String keywords,@Param("abstract_content") String abstract_content,
                   @Param("allow_comment") int allow_comment);

    //update
    @Update("UPDATE article SET author_id=#{author_id},article_category_id=#{article_category_id},tag_id=#{tag_id},title=#{title},markdown_doc=#{markdown_doc},content=#{content}," +
            "created_time=#{created_time},update_time=#{update_time},browse_num=#{browse_num},like_num=#{like_num},is_public=#{is_public},is_del=#{is_del}," +
            "keywords=#{keywords},abstract_content=#{abstract_content},allow_comment=#{allow_comment} WHERE id=#{id}")
    public int update(@Param("author_id") int author_id,@Param("article_category_id") int article_category_id,@Param("tag_id") String tag_id,
                      @Param("title") String title,@Param("markdown_doc") String markdown_doc,@Param("content") String content,@Param("created_time") String created_time,@Param("update_time") String update_time,
                      @Param("browse_num") int browse_num,@Param("like_num") int like_num,@Param("is_public") int is_public,@Param("publish_states") int publish_states,
                      @Param("is_del") int is_del,@Param("keywords") String keywords,@Param("abstract_content") String abstract_content,
                      @Param("allow_comment") int allow_comment,@Param("id") long id);

    //delete
    @Update("UDATE aritcle SET is_del=1 WHERE id=#{id}")
    public int delete(@Param("id") long id);

}
