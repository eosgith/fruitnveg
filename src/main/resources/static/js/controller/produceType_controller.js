'use strict';

App.controller('ProduceTypeController', ['$scope', 'ProduceType', function ($scope, ProduceType) {
        var self = this;
        self.produceType = new ProduceType();

        self.produceTypes = [];

        self.fetchAllProduceTypes = function () {
            self.produceTypes = ProduceType.query();
        };

        self.fetchProduceTypeByID = function (identity) {
            var produceType = ProduceType.get({id: identity}, function (response) {
                console.log('Fetch produceType with id 1 ', response);
                console.log('Fetch produceType with id 2 ', response.id);
                self.produceTypes = [];

                // add response produce item to arrary for display of just 1 item
                self.produceTypes.push(response);
                console.log('Fetch produceType with id 3 ', self.produceTypes);
            })

        };



        self.createProduceType = function () {
            self.produceType.$save(function (response) {
                //console.log('Created produceType with id 1 ', response);
                // console.log('Created produceType with id 1 ', response.id);
                //self.produceTypes = [];
                //self.produceTypes.push(response);
                //                   console.log('Created produceType with id 3 ', self.produceTypes);
                
                self.fetchProduceTypeByID(response.id);
            //    self.fetchProduceTypeBySellerName(response.id);
            });
        };

        self.updateProduceType = function () {
            self.produceType.$update(function () {
                self.fetchAllProduceTypes();
            });
        };

        self.deleteProduceType = function (identity) {
            var produceType = ProduceType.get({id: identity}, function () {
                produceType.$delete(function () {
                    console.log('Deleting produceType with id ', identity);
                    self.fetchAllProduceTypes();
                });
            });
        };

        self.fetchAllProduceTypes();

        self.submit = function () {
            if (self.produceType.id == null) {
                console.log('Saving New ProduceType', self.produceType);
                self.createProduceType();
            } else {
                console.log('Upddating produceType with id ', self.produceType.id);
                self.updateProduceType();
                console.log('ProduceType updated with id ', self.produceType.id);
            }
            self.reset();
        };

        self.edit = function (id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.produceTypes.length; i++) {
                if (self.produceTypes[i].id === id) {
                    self.produceType = angular.copy(self.produceTypes[i]);
                    break;
                }
            }
        };

        self.remove = function (id) {
            console.log('id to be deleted', id);
            if (self.produceType.id === id) {//If it is the one shown on screen, reset screen
                self.reset();
            }
            self.deleteProduceType(id);
        };


        self.reset = function () {
            self.produceType = new ProduceType();
            $scope.myForm.$setPristine(); //reset Form
        };

    }]);