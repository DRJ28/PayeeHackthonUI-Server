module.controller('addPayeeCtrl', function($scope, $route, $routeParams, $location) {
     
     $scope.countrycode = [
     						{id: 1, name: '+91'},
     						{id: 2, name: '+1'}];
     $scope.countryCodeValue = $scope.countrycode[0].name;
     $scope.setCountryCode = function(index){
     	debugger;
      	$scope.countryCodeValue = this.code.name;
      }

      $scope.submitForm = function(){
        alert('Payee added');
        $location.path('/home');
    }
 })
