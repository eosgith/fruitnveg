'strict'

//App.controller('HomeController',['$scope', 'ProduceItem', function ($rootScope, $scope, $http, $location, $route, ProduceItem) {
App.controller('HomeController', ['$scope', 'ProduceItem', 'PassResource',function ($scope, ProduceItem, PassResource) {
//    if ($rootScope.authenticated) {
//        $location.path("/"); 
//        $scope.loginerror = false;
//    } else {
//        $location.path("/login");
//        $scope.loginerror = true; 
//        
//       
        var self = this;
        self.produceItem = new ProduceItem();
        //= new ProduceItem();

        self.errorInd = false;

        self.fetchLastAddedItem = function () {
            console.log('Fetch last added item');
            self.produceItem = ProduceItem.get({id: "lastAdded"}, function (response) {


                console.log('Fetch last added produce item ', self.produceItem);
                console.log('Fetch last added item:  ', response);

//                self.produceItems = [];

                // add response produce item to arrary for display of just 1 item
//                self.produceItems.push(response);
//                console.log('Fetch produceItem with seller name 3 ', self.produceItems);
            }
                    
            ,function(){
                console.log('No produce item returned');
                self.errorInd = true;}
            )
           
        };

        self.fetchLastAddedItem();

        self.order = function () {
            PassResource.setValue(self.produceItem);
            console.log('Edit produceItem with id ', self.produceItem);
            console.log('Edit produceItem wfrom PassResource', PassResource.getValue());
//                    break;
//                }
//            }
        };


    }]);

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