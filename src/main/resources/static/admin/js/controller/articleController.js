app.controller("articleController",function ($scope,$location,articleService) {

    $scope.save=function () {
        $scope.entity.content=edit.getPreviewedHTML();
        $scope.entity.markdownDoc=edit.getMarkdown();

        var serviceObject;//服务层对象

        if($scope.entity.id != null)  {
            //$scope.entity.updateTime=new Date().Format("yyyy-MM-dd hh:mm:ss").toString()+""; //设置更新时间
            //修改
            serviceObject=articleService.update($scope.entity);
        } else {
            $scope.entity.publishStates=1; //发布状态默认为为公开 1,
            $scope.entity.browseNum=0; //浏览数
            $scope.entity.likeNum=0; //点赞数
            $scope.entity.isDel=0;//删除默认为0
            //增加
            serviceObject=articleService.add( $scope.entity);
        }
        serviceObject.success(
            function (response) {
                if(response.success){
                    alert('保存成功');
                }else{
                    alert("failed res = "+response.message);
                }
            });
    };

    $scope.findAll = function () {
        articleService.findAll().success(
            function (response) {
                $scope.articleList=response;
            }
        );
    };

    $scope.searchMap={'id':''};//搜索对象
    $scope.loadArticle=function () {
        $scope.searchMap.id=$location.search()['id'];
        articleService.findOne($scope.searchMap).success(
            function (response) {
                $scope.entity=response;
            }
        );
    };

});