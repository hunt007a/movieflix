(function() {
    'use strict';

    angular.module('movieflixapp')
        .filter('capitalize', capitalize);

    function capitalize(){
        return function(input){
            return String(input).charAt(0).toUpperCase() + String(input).substr(1);
        }
    }
})();