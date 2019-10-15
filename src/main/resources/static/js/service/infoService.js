app.service('infoService',function ($http) {
    this.search=function (searchMap) {
        return $http.post('./info/findOne',searchMap);
    };

    this.addComment=function (entity)  {
        return $http.post('./comment/add',entity);
    };

    this.updateLikeNum=function (searchMap) {
        return $http.post('./info/updateLikeNum',searchMap);
    }

});