'use strict';
 
App.factory('ProduceItem', ['$resource', function ($resource) {
    //$resource() function returns an object of resource class
    return $resource(
            'http://localhost:8080/fruitnvegAPI/produceItems/:id', 
            {id: '@id'},
            {
                update: {
                      method: 'PUT' // To send the HTTP Put request when calling this custom update method.
                }
                 
            }
    );
}]);




App.factory('PassResource', function() {

    // private
    var value = 0;

    // public
    return {
      
      getValue: function() {
        return value;
      },
      
      setValue: function(val) {
        value = val;
      }
      
    };
  })