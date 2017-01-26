(function(){
    'use strict';

    angular
        .module('movieflixapp')
        .controller('adminViewMovieController', adminViewMovieController);

    adminViewMovieController.$inject = ['adminService'];
    function adminViewMovieController(adminService){
        var viewVm = this;

        init();

        function init(){
            console.log("inside admin view movie Controller");
            adminService.viewMovies()
                .then(function(data){
                    console.dir(data);
                    viewVm.movie = data;
                })
                .catch(function (error) {
                    console.log(error);
                })
        }
    }
})();