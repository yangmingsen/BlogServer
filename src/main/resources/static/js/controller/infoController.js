app.controller('infoController',function ($scope,$filter,$location,$sce,infoService) {
    $scope.searchMap={'id':''};//搜索对象

    $scope.loadInfo=function() {

        let searchId = $location.search()['id'];
        if (searchId == null) {//如果恶意跳转该界面 直接转入list.html
            window.location.href="./list.html";
        }

        $scope.searchMap.id=searchId;
        $scope.search();

    };

    $scope.search=function () {
        $scope.searchMap.id=parseInt($scope.searchMap.id);

        infoService.search($scope.searchMap).success(
            function (response) {
                $scope.resultMap=response;
                $scope.handleSomeProblem();
            });

    };

    /**
     * 用户点赞
     * @type {number}
     */
    $scope.isClick=0;//开关默认开启
    $scope.updateLikeNum=function() {
        if ($scope.isClick == 0) {
            infoService.updateLikeNum($scope.searchMap);
            $scope.isClick=1;//开关关闭
            $scope.resultMap.article.likeNum=$scope.resultMap.article.likeNum+1;//加1
        }
    };


    /***
     *评论实体
     * @type {{articleId: string, createdTime: string, id: number, content: string, username: string}}
     */
    $scope.comment={'id':-1,'articleId':'','createdTime':'','username':'','content':''};
    /***
     * 添加评论方法
     */
    $scope.addComment=function() {

        /**
         * 防止空用户名和内容
         */
        var username = $scope.comment.username;
        if (username == null || username.length<1) {
            alert("您需要输入用户名哎!");
            return ;
        }

        var content = $scope.comment.content;
        if (content == null || content.length<1) {
            alert("您需要输入评论内容哎!");
            return ;
        }

        $scope.comment.articleId=parseInt($scope.resultMap.article.id);

        //创建时间
        $scope.dt1 = new Date();
        let dd = $filter("date")($scope.dt1, "yyyy-MM-dd HH:mm:ss");

        $scope.comment.createdTime=dd;

        infoService.addComment($scope.comment).success(
            function (response) {
                if(response.success) {
                    $scope.resultMap.comments.push(angular.copy($scope.comment));
                    $scope.randomImage();
                    $scope.clearComment();
                } else {
                    alert("添加失败")
                }
            }
        );
    };

    /***
     * 清空评论内容
     */
    $scope.clearComment=function() {
        $scope.comment.username='';
        $scope.comment.content='';
    };

    /***
     * 随机匿名头像
     */
    $scope.randomImage=function() {
        for (let i = 0; i < $scope.resultMap.comments.length; i++) {
            $scope.resultMap.comments[i].imageIdx=Math.ceil(Math.random()*9)+1;
        }
    };


    $scope.handleSomeProblem=function() {

        //处理文章时间格式
        $scope.resultMap.article.updateTime = $scope.resultMap.article.updateTime.substr(0,10);

        //找到当前文章分类
        var category = $scope.resultMap.categorys;
        for(var i=0; i<category.length; i++) {
            if(category[i].id == $scope.resultMap.article.articleCategoryId) {
                $scope.resultMap.categoryName=category[i].categoryName;
                break;
            }
        }

        //为了找出该文章的标签名字;
        var tagNames = new Array();
        var splitTagId = $scope.resultMap.article.tagId.split(',');
        for(var i=0; i<splitTagId.length; i++) {
            for(var j =0; j<$scope.resultMap.tags.length; j++) {
                var tt = $scope.resultMap.tags[j].id;
                if(splitTagId[i] == tt ) {
                    tagNames.push($scope.resultMap.tags[j]);
                    break;
                }
            }
        }
        $scope.resultMap.tagNames=angular.copy(tagNames);

        //让angularJS运行插入HTML代码
        $scope.resultMap.article.content = $sce.trustAsHtml($scope.resultMap.article.content);

        $scope.randomImage();

    };

});