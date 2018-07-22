'use strict';

var App = angular.module('myApp', ['ngResource', 'ngRoute']);

App.config(['$routeProvider', function ($routeProvider) {
        $routeProvider
//       .when('/', {template: 'This is the default Route'})         
//                .when('/test', {template: 'This is route test'})
//                .when('/index', {templateUrl: 'index.html'})
                .when('/produceItemVA', {templateUrl: 'produceItemViewAdd.html',controller : "ProduceItemController as prodItemtCtrl",})
                .when('/produceTypeVA', {templateUrl: 'produceTypeViewAdd.html',controller : "ProduceTypeController as prodTypeCtrl",})
                .when('/login', {templateUrl: 'login.html'})
                .otherwise({redirectTo: '/'});
    }]);

App.config(['$locationProvider', function($locationProvider) {
    $locationProvider.hashPrefix('');
}]);

App.factory('AuthInterceptor', [function() {  
    return {
    // Send the Authorization header with each request
        'request': function(config) {
            config.headers = config.headers || {};
//            var encodedString = btoa("jill:password");
            var encodedString = btoa("${login.name}:${login.password}");
            config.headers.Authorization = 'Basic '+encodedString;
           return config;
        }
    };
}]);

App.config(['$httpProvider', function($httpProvider) {
  $httpProvider.interceptors.push('AuthInterceptor');
}]);