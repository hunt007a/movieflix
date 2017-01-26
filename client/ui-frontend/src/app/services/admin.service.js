(function(){
    'use strict';

    angular
        .module('movieflixapp')
        .service('adminService', adminService);

    adminService.$inject = ['$http', '$q', 'CONFIG'];
    function adminService($http, $q, CONFIG){
        var self = this;

        self.addMovie = addMovie;
        self.viewMovies = viewMovies;
        self.getMovieById = getMovieById;
        self.updateMovies = updateMovies;
        self.deleteMovies = deleteMovies;

        function viewMovies() {
            var deferred = $q.defer();
            var config = {
                url: CONFIG.API_HOST + "/movie",
                method: 'GET'
            }
            console.log("In new method");
            $http(config)
                .then(function (response) {
                    deferred.resolve(response.data);
                })
                .catch(function (err) {
                    deferred.reject(err);
                })
            return deferred.promise;
        }

        function getMovieById(id) {
            var deferred = $q.defer();
            var config = {
                url: CONFIG.API_HOST + '/movie/' + id,
                method: 'GET'
            }
            console.log("In new method Id");
            $http(config)
                .then(function (response) {
                    deferred.resolve(response.data);
                })
                .catch(function (err) {
                    deferred.reject(err);
                })
            return deferred.promise;
        }

        function updateMovies(id,movie){
            console.log('Updating Movies');
            return $http.put(CONFIG.API_HOST + "/movie/admin/"+id,movie)
        }

        function deleteMovies(id){
            console.log('Deleting Movies');
            return $http.delete(CONFIG.API_HOST + "/movie/admin/"+id)
        }

        function addMovie(movie){
            return $http.post(CONFIG.API_HOST + "/movie/admin",movie)
                .then(successFn, errorFn);
        }

        function successFn(response) {
            return response.data;
        }

        function errorFn(response) {
            return $q.reject(error.status);
        }
    }

})();