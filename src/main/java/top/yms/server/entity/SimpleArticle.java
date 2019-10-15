package top.yms.server.entity;

/**
 * <h2>为什么会有这个类？</h2>
 * <p><strong>1.</strong>因为AdminAtricleController 的 <span>public Result add(@RequestBody Article article) </span>方法当请求来临，在</p>
 * <p>匹配Article构造时，如果Article的构造器超过一个就会报错。</p>
 * <p><strong>2.</strong>而我在博客首页需要一次性查找所有的博客，但是有些数据又不需要(如content,markdownDoc)这些数据又大,读取肯定降低效率</p>
 * <p></p>
 * <h2>所以</h2>
 * <p>想了下,为了兼顾上述,又要是修改代码最少,采用继承Article类,当<span>public List<SimpleArticle>findAllOfMain();</span></p>
 * <p>返回的是一个List<SimpleArticle> 这样在服务层转一下便可以实现</p>
 *
 * @author yangmingsen
 * @version 1.0
 * @lastModifyDate 2019-07-21:24:00
 */
public class SimpleArticle extends Article{

    public SimpleArticle(long id, int authorId, int articleCategoryId, String tagId, String title,
                         String markdownDoc, String content, String createTime, String updateTime,
                         int browseNum, int likeNum, int isPublic, int publishStates, int isDel,
                         String keywords, String abstractContent, int allowComment) {
        super(id, authorId, articleCategoryId, tagId, title, markdownDoc, content, createTime, updateTime,
                browseNum, likeNum, isPublic, publishStates, isDel, keywords, abstractContent,allowComment);
    }

    public SimpleArticle(long id, int authorId, int articleCategoryId, String title, String updateTime, int browseNum, int likeNum, String abstractContent) {
        super(0, authorId, articleCategoryId, null, title, null, null, null, updateTime,
                browseNum, likeNum, 0, 0, 0, null, abstractContent,1);
    }

    public SimpleArticle(long id, int authorId, int articleCategoryId,String tagId, String title, String updateTime, int browseNum, int likeNum, String abstractContent) {
        super(0, authorId, articleCategoryId, tagId, title, null, null, null, updateTime,
                browseNum, likeNum, 0, 0, 0, null, abstractContent,1);
    }

}
