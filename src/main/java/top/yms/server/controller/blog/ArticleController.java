package top.yms.server.controller.blog;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.yms.server.service.ArticleService;
import top.yms.server.service.PublicService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private PublicService publicService;


    /***
     * <h2>描述：</h2>
     * <p>根据tagId进行查找文章</p>
     * <p></p>
     * <h3>注意：</h3>
     * <p>1.传入的tagId一定要先在前台通过parseInt(tagId)进行转化,不然后台会出现无法转型异常,直接挂机.</p>
     *
     * @createTime 2019-10-03
     * @updateTime 2019-10-03
     *
     * @version 1.0
     * @param searchMap {"tagId":1561910658528091} //tagId:15位
     * @return
     */
    @RequestMapping("/list/findAllByTagId")
    public Map<String,Object> findAllByTagId(@RequestBody Map searchMap) {

        long tagId = (long)searchMap.get("tagId");
//        Map<String, Object> map = publicService.getTagAndCategoryInfo();
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("articles",articleService.findAllByTagId(tagId));

        return map;
    }

    /***
     * <h2>描述：</h2>
     * <p>根据categoryId进行查找文章</p>
     * <p></p>
     * <h3>注意：</h3>
     * <p>1.传入的categoryId一定要先在前台通过parseInt(categoryId)进行转化,不然后台会出现无法转型异常,直接挂机.</p>
     *
     * @createTime 2019-10-03
     * @updateTime 2019-10-04
     *
     * @version 1.0
     * @param searchMap
     * @return
     */
    @RequestMapping("/list/findAllByCategoryId")
    public Map<String,Object> findAllByCategoryId(@RequestBody Map searchMap) {
        int categoryId = (int)searchMap.get("categoryId");
        //Map<String, Object> map = publicService.getTagAndCategoryInfo();
        Map<String,Object> map = new ConcurrentHashMap<>();
        map.put("articles",articleService.findAllByCategoryId(categoryId));

        return map;
    }

    /***
     *
     * <h2>描述：</h2>
     * <p>查找所有文章</p>
     * <p></p>
     * <h3>注意：</h3>
     * <p></p>
     *
     * @createTime 2019-10-04
     * @updateTime 2019-10-04
     *
     * @version 1.0
     * @return
     */
    @RequestMapping("/list/findAll")
    public Map<String,Object> findAll() {
        Map<String, Object> map = publicService.getTagAndCategoryInfo();
        map.put("articles",articleService.findAll());

        return map;
    }


}
