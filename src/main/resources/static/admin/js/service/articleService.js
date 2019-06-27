app.service('articleService',function ($http) {

    //增加
    this.add=function (entity) {
        return $http.post('../admin/article/add',entity);
    }

    //修改
    this.update=function(entity){
        return  $http.post('..',entity );
    }

    //读取列表数据绑定到表单中
    this.findAll=function(){
        return $http.get('..');
    }

    //查询实体
    this.findOne=function(id){
        return $http.get('../goods/findOne.do?id='+id);
    }

    //删除
    this.dele=function(ids){
        return $http.get('../goods/delete.do?ids='+ids);
    }

    this.test=function() {
        alert("go to test");
        return $http.get('./admin/article/test');
    }
});