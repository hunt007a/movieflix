(function(){
    'use strict';

    angular
        .module('movieflixapp')
        .service('signInService', signInService);

    signInService.$inject = ['$http', '$q', 'CONFIG'];
    function signInService($http, $q, CONFIG){
        var self = this;

        self.addUser = addUser;

        function addUser(user){
            console.log('User' + user);
            return $http.post(CONFIG.API_HOST + "/user",user)
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