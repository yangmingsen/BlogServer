app.service('indexService',function ($http) {

    this.findAll=function () {
        return $http.get('./index/main');
    };

});