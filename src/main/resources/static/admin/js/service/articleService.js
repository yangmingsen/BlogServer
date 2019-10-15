app.service('articleService',function ($http) {

    //增加
    this.add=function (entity) {
        return $http.post('../admin/article/add',entity);
    };

    //修改
    this.update=function(entity){
        return  $http.post('../admin/article/update',entity );
    };

    //删除
    this.dele=function(ids){
        return $http.get('..ids='+ids);
    };

    this.findAll=function () {
        return $http.get("../admin/article/findAll");
    };

    this.findOne=function (searchMap) {
        return $http.post("../admin/article/findOne",searchMap);
    };

});