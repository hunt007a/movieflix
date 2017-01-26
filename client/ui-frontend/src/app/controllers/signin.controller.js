(function(){
    'use strict';

    angular
        .module('movieflixapp')
        .controller('SignInController', SignInController);

    SignInController.$inject = ['signInService', '$location'];
    function SignInController(signInService,$location){
        var signInVm = this;

        signInVm.createUser = createUser;
        init();

        function init(){
            console.log("Inside SignIn Controller");
        }

        function createUser(){
            console.dir(signInVm.user);
            signInService.addUser(signInVm.user)
                .then(function(data) {
                    $location.path('/movie');
                }, function(error) {
                    console.log(error);
                })
        }
    }
})();