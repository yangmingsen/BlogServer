app.controller('indexController',function ($scope,indexService) {

    $scope.findAll=function () {
        indexService.findAll().success(
            function (response) {
                $scope.storageIndex = response;
                $scope.list = angular.copy($scope.storageIndex);
                $scope.addCategoryName();
            }
        );

    };

    $scope.findAllByCategory=function (category) {
        $scope.list.articles=[];
        if(category == 0) {
            $scope.list.articles=angular.copy($scope.storageIndex.articles);
        } else {
            for(var i=0; i<$scope.storageIndex.articles.length; i++) {
                if($scope.storageIndex.articles[i].articleCategoryId == category) {
                    $scope.list.articles.push($scope.storageIndex.articles[i]);
                }
            }
        }

        $scope.addCategoryName();

    };


    $scope.addCategoryName = function() {
        //给每个article增加分类名
        for (let i = 0; i <$scope.list.articles.length ; i++) {
            for (let j = 0; j < $scope.list.categorys.length; j++) {
                if($scope.list.categorys[j].id == $scope.list.articles[i].articleCategoryId) {
                    $scope.list.articles[i].categoryName=$scope.list.categorys[j].categoryName;
                    break;
                }
            }
        }
    };


});