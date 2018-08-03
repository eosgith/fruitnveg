'use strict';
 
App.factory('HomeService', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class
    return $resource(
            'http://localhost:8080/fruitnvegAPI/produceItems/lastAdded', 
    );
}]);


