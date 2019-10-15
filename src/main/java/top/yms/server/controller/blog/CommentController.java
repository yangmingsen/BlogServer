package top.yms.server.controller.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yms.server.entity.Comment;
import top.yms.server.entity.Result;
import top.yms.server.service.CommentService;
import top.yms.server.utils.DateHelper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    /***
     * 描述:
     * 根据articleId进行查找评论
     *
     * @createTime 2019-10-06
     * @updateTime 2019-10-06
     *
     * @version 1.0
     * @param searchMap
     * @return
     */
    @RequestMapping("/findAllByArticleId")
    public List<Comment> findAllByArticleId(@RequestBody Map searchMap) {
        if (searchMap == null) return null;

        return commentService.findAllByArticleId((long)searchMap.get("articleId"));

    }

    /***
     *Description:
     * 添加一个评论
     *
     * @createTime 2019-10-06
     * @updateTime 2019-10-06
     *
     * @version 1.0
     * @param comment
     * @return
     */
    @RequestMapping("/add")
    public Result add(@RequestBody Comment comment) {

        Result res=null;

        if (comment !=null) {
            commentService.add(comment);

            res = new Result(true,"添加评论成功");
        } else {
            res = new Result(false,"评论内容为空");
        }

        return res;
    }

}
