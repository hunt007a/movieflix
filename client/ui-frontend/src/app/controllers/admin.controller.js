(function(){
    'use strict';

    angular
        .module('movieflixapp')
        .controller('AdminController', AdminController);

    AdminController.$inject = ['adminService', '$location'];
    function AdminController(adminService, $location){
        var adminVm = this;

        adminVm.createMovie = createMovie;
        init();

        function init(){
            console.log("inside admin Controller");
        }

        function createMovie(){
            console.dir(adminVm.movie);
            adminService.addMovie(adminVm.movie)
                .then(function(data) {
                    console.log("Movie successfully added");
                    $location.path('/adminviewmovie')
                }, function(error) {
                    console.log(error);
                })
        }

    }
})();