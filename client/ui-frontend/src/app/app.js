(function(){
    'use strict';


    angular
        .module('movieflixapp',['ngRoute','ngMessages'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider', '$locationProvider']
    function moduleConfig($routeProvider, $locationProvider){

        $routeProvider
            .when('/movie',{
                templateUrl:'app/views/movie.tmpl.html',
                controller:'MovieController',
                controllerAs:'movieVm'
            })
            .when('/movie/:id',{
                templateUrl:'app/views/movie-detail.tmpl.html',
                controller:'MovieDetailController',
                controllerAs:'movieDetailVm'
            })
            .when('/movielist',{
                templateUrl:'app/views/movielist.tmpl.html',
                controller:'MovieController',
                controllerAs:'movieVm'
            })
            .when('/movielist/:id',{
                templateUrl:'app/views/movie-detail.tmpl.html',
                controller:'MovieDetailController',
                controllerAs:'movieDetailVm'
            })
            .when('/sign-in',{
                templateUrl:'app/views/sign-in.tmpl.html',
                controller:'SignInController',
                controllerAs:'signInVm'
            })
            .when('/login',{
                templateUrl:'app/views/login.tmpl.html',
                controller:'loginController',
                controllerAs:'loginVm'
            })
            .when('/admin',{
                templateUrl:'app/views/admin.tmpl.html',
                controller:'AdminController',
                controllerAs:'adminVm'
            })
            .when('/adminpage',{
                templateUrl:'app/views/adminview.tmpl.html',
            })
            .when('/adminviewmovie',{
                templateUrl:'app/views/adminviewmovie.tmpl.html',
                controller:'adminViewMovieController',
                controllerAs:'viewVm'
            })
            .when('/adminupdatemovie/:id',{
                templateUrl:'app/views/adminupdatemovie.tmpl.html',
                controller:'adminViewMovieDetailController',
                controllerAs:'viewDetailVm'
            })
            .when('/admindeletemovie/:id',{
                templateUrl:'app/views/admindeletemovie.tmpl.html',
                controller:'adminViewMovieDetailController',
                controllerAs:'viewDetailVm'
            })
            .otherwise({
                redirectTo:'/movie'
            })

        $locationProvider.hashPrefix('');
    }
})();