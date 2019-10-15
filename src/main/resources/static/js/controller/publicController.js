app.controller('publicController',function ($scope) {
    $scope.enterEvent = function (e) {
        var keycode = window.event ? e.keyCode : e.which;
        if(keycode==13){

            let keywords = $scope.keywords;
            if (keywords == null || keywords.length==0) return ;

            window.location.href="./list.html#?keywords="+$scope.keywords;
        }
    };
});