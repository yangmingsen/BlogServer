app.controller("articleController",function ($scope,articleService) {

    $scope.save=function () {

        $scope.entity.content=edit.getHTML();
        $scope.entity.publishStates=1; //发布状态默认为为公开 1,
        $scope.entity.browseNum=0; //浏览数
        $scope.entity.likeNum=0; //点赞数
        $scope.entity.isDel=0;//删除默认为0

        var serviceObject;//服务层对象
        if($scope.entity.id != null)  {
            //修改
            //serviceObject=articleService.update($scope.entity);
            console.log("entity = "+$scope.entity);
        } else {
            //增加
            serviceObject=articleService.add( $scope.entity);
        }
        serviceObject.success(
            function (response) {
                if(response.success){
                    alert('保存成功');
                    alert("res = "+response.message);
                    // location.href="#";//跳转到商品列表页
                }else{
                    alert("failed res = "+response.message);
                }
        });
    }
});