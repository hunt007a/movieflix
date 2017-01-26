(function(){
    'use strict';

    angular
        .module('movieflixapp')
        .controller('loginController', loginController);

    loginController.$inject = ['$location'];
    function loginController($location){
        var loginVm = this;

        loginVm.formSubmit = formSubmit;
        init();

        function init(){
            console.log("Inside login Controller");
        }

        function formSubmit(){
            console.log('Form submitted');
        }
    }
})();