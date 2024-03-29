package top.yms.server.controller.blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yms.server.config.RestfulResult;
import top.yms.server.entity.Article;
import top.yms.server.service.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private PublicService publicService;

    @Autowired
    private CommentService commentService;


    @RequestMapping("/findOne")
    @RestfulResult
    public Map<String,Object> findOne(@RequestBody Map searchMap) {
        if (searchMap == null) return null;

        Map<String, Object> map = publicService.getTagAndCategoryInfo();
        long articleId = (long) searchMap.get("id");

        //根据文章id查找这篇文章
        map.put("article",articleService.findOne(articleId));
        map.put("comments",commentService.findAllByArticleId(articleId));

        return map;

    }


    private int cnt = 1;

    @RequestMapping("/updateLikeNum")
    //@RestfulResult
    @Transactional
    public void updateLikeNum(@RequestBody Map searchMap) {
        long articleId = (long) searchMap.get("id");
        articleService.updateLikeNum(articleId);
        System.out.println("==========cnt==="+cnt);
        if (cnt % 3 ==0 ) {
            int x = 1/0;
        }
        cnt++;
    }

}
