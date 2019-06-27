app.controller("articleController",function ($scope,articleService) {

    $scope.save=function () {

        $scope.entity.content=edit.getHTML();
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