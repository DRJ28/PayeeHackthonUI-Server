module.controller('SignupController', function($scope, $route, $routeParams, $location, $rootScope) {
     
     $("#dobSignUp").datepicker();
     $scope.countrycode = [
     						{id: 1, name: '+91'},
     						{id: 2, name: '+1'}];
     $scope.countryCodeValue = $scope.countrycode[0].name;
     $scope.setCountryCode = function(index){
     	debugger;
      	$scope.countryCodeValue = this.code.name;
      }
     $scope.submitForm = function(){
     	this.user.countrycode = this.countryCodeValue;
        console.log(this.user);
        alert(this.user.fname + ', your account is created');
        $rootScope.myName = this.user.fname;
        $location.path('/');
     }
 })
