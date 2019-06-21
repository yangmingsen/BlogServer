app.controller('userController',function ($scope,$location,userService) {
    $scope.getUser=function () {
        userService.getUser().success(
            function (response) {
                console.log("respose = "+response);
                $scope.user=response;
            }
        );
    }
});