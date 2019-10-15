app.service('listService',function ($http) {
    this.findAll=function () {
        return $http.get('./article/list/findAll');
    };

    this.findAllByTagId=function (searchMap) {
        return $http.post('./article/list/findAllByTagId',searchMap);
    };

    this.findAllByCateGoryId=function (searchMap) {
        return $http.post('./article/list/findAllByCategoryId',searchMap);
    };

});