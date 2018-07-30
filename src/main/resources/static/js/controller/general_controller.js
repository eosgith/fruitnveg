'strict'

App.controller('HomeController', function ($rootScope, $scope, $http, $location, $route) {
//    if ($rootScope.authenticated) {
//        $location.path("/"); 
//        $scope.loginerror = false;
//    } else {
//        $location.path("/login");
//        $scope.loginerror = true; 
//} 
});

App.controller('LoginController', function ($rootScope, $scope, $http, $location, $route) {

    $rootScope.credentials = {};

    $scope.resetForm = function () {

        $rootScope.credentials = null;
    }

    var authenticate = function (credentials, callback) {

        var headers = $rootScope.credentials ? {
            authorization: "Basic " + btoa($rootScope.credentials.username + ":" + $rootScope.credentials.password)
        } : {};
        
        console.log('in authenticate method', credentials);
        $http.get('/user', {
             
            headers: headers})
                .then(function (response) {
                    console.log('in authenticate method', response);
                    if (response.data.name) {
                        $rootScope.authenticated = true;

                    } else {
                        $rootScope.authenticated = false;
                    }
                    callback && callback();
                }, function () {
                    $rootScope.authenticated = false;

                    callback && callback();
                });
    }

    authenticate();

    $scope.loginUser = function () {
        
        authenticate($rootScope.credentials, function () {
            if ($rootScope.authenticated) {
                $location.path("/");
                $scope.loginerror = false;
                console.log('in login method authenticated:  ', $rootScope.authenticated, $scope.loginerror);
            } else {
                $location.path("/login");
                $scope.loginerror = true;
            }
        });
    };
});

App.controller('LogoutController', function ($rootScope, $scope, $http, $location, $route) {
    $http.post('/logout', {}).finally(function () {
        $rootScope.authenticated = false;
        $location.path("/");
        console.log('in logOUT method authenticated:  ', $rootScope.authenticated, $scope.loginerror);
    });
});

// Ref: Soni, Ravi Kant. Full Stack AngularJS for Java Developers: Build a Full-Featured Web Application from Scratch Using AngularJS with Spring RESTful (Kindle Locations 2481-2508). Apress. Kindle Edition. 