'use strict';

App.controller('OrderRecordController', ['$scope', 'OrderRecord', 'PassResource', function ($scope, OrderRecord, PassResource) {
//App.controller('OrderRecordController', ['$scope', 'OrderRecord',  function ($scope, OrderRecord) {
        var self = this;
        
        self.orderRecord = new OrderRecord();

        self.orderRecords = [];

        self.produceItem = PassResource.getValue();
        
        //self.orderRecord.produceItem = self.produceItem;
       
        
       
        self.init = function () {
            
            self.orderRecord.username = "user";
            self.orderRecord.produceItem = self.produceItem;
            self.orderRecord.totalOrderCost = self.orderRecord.produceItem.itemPrice;
            
            console.log('Init: Saving New OrderRecord', self.orderRecord);
        };
        
        self.init();
        
        self.fetchAllOrderRecords = function () {
            self.orderRecords = OrderRecord.query();
        };
        
      self.findAuthorisedUser = function () {
            self.user = OrderRecord.UserGet();
            if (response.data.name) {
                self.orderRecord.status = "true";
                $rootScope.authenticated = true;

            } else {
                self.orderRecord.status = "false";
                $rootScope.authenticated = false;
            }
        };

//        self.findAuthorisedUser();
        
        self.fetchOrderRecordByID = function (identity) {
            var orderRecord = OrderRecord.get({id: identity}, function (response) {
                console.log('Fetch orderRecord with id 1 ', response);
                console.log('Fetch orderRecord with id 2 ', response.id);
                self.orderRecords = [];

                // add response produce item to arrary for display of just 1 item
                self.orderRecords.push(response);
                self.orderRecord = response
                console.log('Fetch orderRecord with id 3 ', self.orderRecords);
                
            })

        };

        self.fetchOrderRecordBySellerName = function (identity) {
            var orderRecords = OrderRecord.get({sellerName: "Jack Black"}, function (response) {
                console.log('Fetch orderRecord with seller name 1 ');
               
//                self.orderRecords = [];

                // add response produce item to arrary for display of just 1 item
//                self.orderRecords.push(response);
                console.log('Fetch orderRecord with seller name 3 ', self.orderRecords);
            })

        };

        self.createOrderRecord = function () {
            self.orderRecord.$save(function (response) {
                //console.log('Created orderRecord with id 1 ', response);
                // console.log('Created orderRecord with id 1 ', response.id);
                //self.orderRecords = [];
                //self.orderRecords.push(response);
                //                   console.log('Created orderRecord with id 3 ', self.orderRecords);
                self.orderRecord = self.fetchOrderRecordByID(response.id);
            //    self.fetchOrderRecordBySellerName(response.id);
            });
        };

        self.updateOrderRecord = function () {
            self.orderRecord.$update(function () {
                self.fetchAllOrderRecords();
            });
        };

        self.deleteOrderRecord = function (identity) {
            var orderRecord = OrderRecord.get({id: identity}, function () {
                orderRecord.$delete(function () {
                    console.log('Deleting orderRecord with id ', identity);
                    self.fetchAllOrderRecords();
                });
            });
        };

//        self.fetchAllOrderRecords();

        self.submit = function () {
            if (self.orderRecord.id == null) {
//                self.orderRecord.produceItem = angular.copy(self.produceItem);
                console.log('Saving New OrderRecord', self.orderRecord);
                console.log('Saving New OrderRecord : produceItem', self.produceItem);
                self.orderRecord.itemprice = 1;
                self.orderRecord.totalcost = 1;
                console.log('Saving New OrderRecord: log itemprice', self.orderRecord.itemprice);
                self.createOrderRecord();
            } else {
                console.log('Upddating orderRecord with id ', self.orderRecord.id);
                self.updateOrderRecord();
                console.log('OrderRecord updated with id ', self.orderRecord.id);
            }
            self.reset();
        };

        self.edit = function (id) {
            console.log('id to be edited', id);
            for (var i = 0; i < self.orderRecords.length; i++) {
                if (self.orderRecords[i].id === id) {
                    self.orderRecord = angular.copy(self.orderRecords[i]);
                    console.log('Edit orderRecord with id ', self.orderRecord.produceType.prodType);
                    break;
                }
            }
        };

        self.remove = function (id) {
            console.log('id to be deleted', id);
            if (self.orderRecord.id === id) {//If it is the one shown on screen, reset screen
                self.reset();
            }
            self.deleteOrderRecord(id);
        };


        self.reset = function () {
            self.orderRecord = new OrderRecord();
            $scope.myForm.$setPristine(); //reset Form
        };

    }]);