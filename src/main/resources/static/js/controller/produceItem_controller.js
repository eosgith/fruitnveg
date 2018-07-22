'use strict';

App.controller('ProduceItemController', ['$scope', 'ProduceItem', function ($scope, ProduceItem) {
        var self = this;
        self.produceItem = new ProduceItem();

        self.produceItems = [];

        self.fetchAllProduceItems = function () {
            self.produceItems = ProduceItem.query();
        };

        self.fetchProduceItemByID = function (identity) {
            var produceItem = ProduceItem.get({id: identity}, function (response) {
                console.log('Fetch produceItem with id 1 ', response);
                console.log('Fetch produceItem with id 2 ', response.id);
                self.produceItems = [];

                // add response produce item to arrary for display of just 1 item
                self.produceItems.push(response);
                console.log('Fetch produceItem with id 3 ', self.produceItems);
                
            })

        };

        self.fetchProduceItemBySellerName = function (identity) {
            var produceItems = ProduceItem.get({sellerName: "Jack Black"}, function (response) {
                console.log('Fetch produceItem with seller name 1 ');
               
//                self.produceItems = [];

                // add response produce item to arrary for display of just 1 item
//                self.produceItems.push(response);
                console.log('Fetch produceItem with seller name 3 ', self.produceItems);
            })

        };

        self.createProduceItem = function () {
            self.produceItem.$save(function (response) {
                //console.log('Created produceItem with id 1 ', response);
                // console.log('Created produceItem with id 1 ', response.id);
                //self.produceItems = [];
                //self.produceItems.push(response);
                //                   console.log('Created produceItem with id 3 ', self.produceItems);
                self.fetchProduceItemByID(response.id);
            //    self.fetchProduceItemBySellerName(response.id);
            });
        };

        self.updateProduceItem = function () {
            self.produceItem.$update(function () {
                self.fetchAllProduceItems();
            });
        };

        self.deleteProduceItem = function (identity) {
            var produceItem = ProduceItem.get({id: identity}, function () {
                produceItem.$delete(function () {
                    console.log('Deleting produceItem with id ', identity);
                    self.fetchAllProduceItems();
                });
            });
        };

        self.fetchAllProduceItems();

        self.submit = function () {
            if (self.produceItem.id == null) {
                console.log('Saving New ProduceItem', self.produceItem);
                self.createProduceItem();
            } else {
                console.log('Upddating produceItem with id ', self.produceItem.id);
                self.updateProduceItem();
                console.log('ProduceItem updated with id ', self.produceItem.id);
            }
            self.reset();
        };

        self.edit = function (id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.produceItems.length; i++) {
                if (self.produceItems[i].id === id) {
                    self.produceItem = angular.copy(self.produceItems[i]);
                    console.log('Edit produceItem with id ', self.produceItem.produceType.prodType);
                    break;
                }
            }
        };

        self.remove = function (id) {
            console.log('id to be deleted', id);
            if (self.produceItem.id === id) {//If it is the one shown on screen, reset screen
                self.reset();
            }
            self.deleteProduceItem(id);
        };


        self.reset = function () {
            self.produceItem = new ProduceItem();
            $scope.myForm.$setPristine(); //reset Form
        };

    }]);