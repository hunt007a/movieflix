(function() {
    'use strict';

    angular
        .module('movieflixapp')
        .constant('CONFIG', {
            'API_HOST': 'http://localhost:8080/backendapp/api'
        });

})();