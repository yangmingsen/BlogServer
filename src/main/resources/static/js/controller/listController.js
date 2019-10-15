app.controller('listController',function ($scope,$sce,$location,listService) {
    //初始化2中方式；
    //1.如果url中没有参数表示获取所有数据
    //2.如果url中有参数则表示选择性获取

    $scope.searchMap={'tagId':'','categoryId':'','keywords':''};

    $scope.loadInfo=function () {
        $scope.findAll();

    };

    //listening 用户回车键 搜索
    $scope.enterEvent = function (e) {
        var keycode = window.event ? e.keyCode : e.which;
        if(keycode==13){
            $scope.checkKeyword();
        }
    };

    //check keyword is null or length==0
    $scope.checkKeyword = function() {
        let keywords = $scope.keywords;
        if (keywords == null || keywords.length==0)  {
            //load all
            $scope.loadAll();
            return ;
        }
        $scope.searchMap.keywords = keywords;

        $scope.findAllByKeywords();
    };

    //监听用户鼠标点击监听
    $scope.userClickSearch = function() {
        //$scope.checkKeyword();
        let keywords = $scope.keywords;
        if (keywords == null || keywords.length==0)  {
            //load all
            return ;
        }
        $scope.findAllByKeywords();

    };

    //
    $scope.loadAll = function() {
        $scope.resultMap.articles=[];
        for (let i = 0; i < $scope.localCache.articles.length; i++) {
            let article = angular.copy($scope.localCache.articles[i]);
            $scope.resultMap.articles.push(article);
        }
        $scope.addCategoryName();
    };


    /**
     * 更新tag
     * @param tagId
     */
    $scope.updateByTag=function(tagId) {
        $scope.searchMap.tagId=parseInt(tagId);
        $scope.findAllBytagId();
    };

    /***
     * 更新category
     * @param categoryId
     */
    $scope.updateByCategory=function(categoryId) {
        $scope.searchMap.categoryId=parseInt(categoryId);
        $scope.findAllByCategoryId();
    };


    $scope.addCategoryName = function() {
        //给每个article增加分类名
        for (let i = 0; i <$scope.resultMap.articles.length ; i++) {
            for (let j = 0; j < $scope.resultMap.categorys.length; j++) {
                if($scope.resultMap.categorys[j].id == $scope.resultMap.articles[i].articleCategoryId) {
                    $scope.resultMap.articles[i].categoryName=$scope.resultMap.categorys[j].categoryName;
                    break;
                }
            }
        }

        //设置trustAsHtml
        for (let i = 0; i < $scope.resultMap.articles.length; i++) {
            $scope.resultMap.articles[i].title = $sce.trustAsHtml($scope.resultMap.articles[i].title);
            $scope.resultMap.articles[i].abstractContent = $sce.trustAsHtml($scope.resultMap.articles[i].abstractContent);
        }

    };

    //找到所有
    $scope.findAll=function () {
        //获取所有数据
        listService.findAll().success(
            function (response) {
                $scope.resultMap=response;
                $scope.localCache = angular.copy(response);

                /***
                 * 1.当其他界面跳入该界面时,先检查传入参数,如果符合下面3个参数,那么
                 * 调用相应的方法后,直接返回.
                 *
                 * 2.如果跳入该界面无参数,说明是直接点击list.html.那么默认查找所有文章
                 */
                var tagId =$location.search()['tagId'];
                var categoryId =$location.search()['categoryId'];
                var keywords =$location.search()['keywords'];

                if(tagId != null) {//根据tagId进行查找
                    $scope.searchMap.tagId=parseInt(tagId);
                    $scope.findAllBytagId();
                    return ;
                } else if (categoryId != null) {//根据categoryId进行查找
                    $scope.searchMap.categoryId=parseInt(categoryId);
                    $scope.findAllByCategoryId();
                    return ;
                } else if(keywords != null && keywords.length>0) {//根据标题或者内容进行查找
                    console.log("keywords="+keywords);
                    $scope.searchMap.keywords=keywords;
                    $scope.findAllByKeywords();
                }

                $scope.addCategoryName();

            });
    };

    //根据用户输入的关键字查询文章
    $scope.findAllByKeywords=function() {
        $scope.resultMap.articles=[];

        let keywords = $scope.searchMap.keywords;
        console.log("localCacheArticlesLength = "+$scope.localCache.articles.length);
        for (let i = 0; i < $scope.localCache.articles.length; i++) {

            let article = angular.copy($scope.localCache.articles[i]);
            let flag = 0;

            if (article.title.indexOf(keywords) >-1) {

                article.title=article.title.replace(new RegExp(keywords,'g'),
                    "<span style='color: red'>"+keywords+"</span>");

                flag = 1;
            }

            if (article.abstractContent.indexOf(keywords) > -1) {

                article.abstractContent=article.abstractContent.replace(new RegExp(keywords,'g'),
                    "<span style='color: red'>"+keywords+"</span>");
                flag = 1;
            }

            if (flag == 1) {
                $scope.resultMap.articles.push(article);
            }
        }

        $scope.addCategoryName();
    };

    //根据tag查找
    $scope.findAllBytagId=function () {
        $scope.resultMap.articles=[];

        listService.findAllByTagId($scope.searchMap).success(
            function (response) {
                for (let i = 0; i < response.articles.length; i++) {
                    $scope.resultMap.articles.push(response.articles[i]);
                }
                $scope.addCategoryName();
            }
        );
    };

    //根据category查找
    $scope.findAllByCategoryId=function () {
        $scope.resultMap.articles=[];

        listService.findAllByCateGoryId($scope.searchMap).success(
            function (response) {
                for (let i = 0; i < response.articles.length; i++) {
                    $scope.resultMap.articles.push(response.articles[i]);
                }
                $scope.addCategoryName();
            }
        );

    };


    /**
     * 弃用
     */
    $scope.update1=function() {
        var tagId =$location.search()['tagId'];
        var categoryId =$location.search()['categoryId'];
        var name =$location.search()['name'];

        if(tagId != null) {//根据tagId进行查找
            $scope.searchMap.tagId=parseInt(tagId);
            console.log("tagId = "+$scope.searchMap.tagId);
            $scope.findAllBytagId();
        } else if (categoryId != null) {//根据categoryId进行查找
            $scope.searchMap.categoryId=parseInt(categoryId);
            $scope.findAllByCategoryId();
        } else if(name != null) {//根据标题或者内容进行查找
            console.log("name");
            $scope.searchMap.name=name;
            //$scope.findAll();
        }

    };


});