'use strict';
 
App.factory('OrderRecord', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class
    return $resource(
            'http://localhost:8080/fruitnvegAPI/orderrecords/:id', 
            {id: '@id'},
            {
                update: {
                      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
                }
                 
            }
    );
}]);

App.factory('UserGet', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class
    return $resource(
            'http://localhost:8080/user', 
           
    );
}]);