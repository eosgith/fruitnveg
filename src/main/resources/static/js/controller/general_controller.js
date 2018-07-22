'strict'

//App.controller('chooseProdTypeCtrl', function ($scope) {

App.controller('chooseProdTypeCtrl', ['$scope', 'ProduceType', function ($scope, ProduceType)  {

//    $scope.chProduceTypes=[
//        {name : "France - Mainland", desc: "some description" },
//        {name : "Gibraltar", desc: "some description"},
//        {name : "Malta", desc: "some description"}
//    ];
    
    $scope.chProduceTypes=[];
    $scope.chProduceTypes=ProduceType.query();

//    $scope.selectedCountry = $scope.chooseCountries[0].countryId;
}]);


//        {countryId : 1, name : "France - Mainland", desc: "some description" },
//        {countryId : 2, name : "Gibraltar", desc: "some description"},
//        {countryId : 3, name : "Malta", desc: "some description"}

