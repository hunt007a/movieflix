(function(){
    'use strict';

    angular
        .module('movieflixapp')
        .service('movieService', movieService);

    movieService.$inject = ['$http', '$q', 'CONFIG'];
    function movieService($http, $q, CONFIG){
        var self = this;

        self.getAllMovies = getAllMovies;
        self.getMovieById = getMovieById;

        function getAllMovies(){
            return $http.get(CONFIG.API_HOST + "/movie")
                .then(successFn, errorFn);
        }

        function getMovieById(id){
            return $http.get(CONFIG.API_HOST + '/movie/' + id)
                .then(successFn, errorFn);
        }
        function successFn(response) {
            console.log(response);
            return response.data;
        }

        function errorFn(response) {
            return $q.reject(error.status);
        }
    }

})();