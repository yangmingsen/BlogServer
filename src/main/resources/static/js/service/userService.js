app.service('userService',function ($http) {
   this.getUser = function () {
       return $http.get('/user/getuser');
   }
});