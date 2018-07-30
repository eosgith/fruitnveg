'use strict';

var App = angular.module('myApp', ['ngResource', 'ngRoute']);

App.config(['$routeProvider', function ($routeProvider) {
        $routeProvider

                .when('/produceItemVA', {
                        templateUrl: 'produceItemViewAdd.html',
                        controller: "ProduceItemController as prodItemtCtrl"
                })
                .when('/produceItemView', {
                        templateUrl: 'produceItemView.html',
                        controller: "ProduceItemController as prodItemtCtrl"
                })
                .when('/produceTypeVA', {
                        templateUrl: 'produceTypeViewAdd.html',
                        controller: "ProduceTypeController as prodTypeCtrl"
                })
                .when('/orderVA', {
                        templateUrl: 'orderView.html',
                        controller: "OrderRecordController as orderRecCtrl"
                })
                .when('/orderItemAdd', {
                        templateUrl: 'orderItemAdd.html',
                        controller: "OrderRecordController as orderRec2Ctrl"
                })
                .when('/login', {
                        templateUrl: 'login.html',
                        controller: "LoginController as loginCtrl"
                })
                .when('/logout', {
                        templateUrl: 'login.html',
                        controller: "LogoutController as logoutCtrl"
                })
                .otherwise({
                         redirectTo: '/home',
                        templateUrl: 'home.html',
                        controller: "HomeController as homeCtrl"
                });


    }]);




App.config(['$locationProvider', function ($locationProvider) {
        $locationProvider.hashPrefix('');
    }]);

// Ref: Below: Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2434-2436). Apress. Kindle Edition. 

App.config(['$httpProvider', function($httpProvider) {
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    }]);

//App.factory('AuthInterceptor',  ['$rootScope', function ($rootScope) {
//        return {
//            // Send the Authorization header with each request
//            'request': function (config) {
//               config.headers = config.headers || {};
//  ////            var encodedString = btoa("jill:password");
//  //                var encodedString = btoa("user:password");
//  ////            var encodedString = btoa("${login.name}:${login.password}");
//  //
// var encodedString = btoa($rootScope.credentials.username+ ":" +$rootScope.credentials.password);
//                console.log('in factory authi', encodedString);
//                config.headers.Authorization = 'Basic ' + encodedString;
//                return config;
//            }
//       };
//   }]);
//
//App.config(['$httpProvider', function($httpProvider) {
//  $httpProvider.interceptors.push('AuthInterceptor');
//}]);
