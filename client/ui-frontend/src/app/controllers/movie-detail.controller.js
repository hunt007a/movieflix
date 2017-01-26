(function(){
    'use strict';

    angular
        .module('movieflixapp')
        .controller('MovieDetailController', MovieDetailController);

    MovieDetailController.$inject = ['movieService','$routeParams'];
    function MovieDetailController(movieService, $routeParams){
        var movieDetailVm = this;

        init();

        function init(){
            console.log("Show parameters");
            console.log($routeParams);

            movieService.getMovieById($routeParams.id)
                .then(function(data){
                    movieDetailVm.movie = data;
                    console.log(movieDetailVm.movie);
                })
                .catch(function (error) {
                    console.log(error);
                })
        }

    }
})();