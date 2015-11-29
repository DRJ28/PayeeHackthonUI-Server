module.controller('addAccountCtrl', function($scope, $route, $routeParams,$http, $location, $rootScope) {
     
    $scope.items = [{id: 1,name: 'India'}, {id: 2,name: 'UK'}];       
    $scope.bankslist =  [
    						{ id: 1, name: 'BankName1'}, 
    						{ id: 2, name: 'BankName2'}, 
    						{ id: 3, name: 'BankName3'}];
    $scope.countryName = "India";
    $scope.setCountryName = function(index){
    	$scope.countryName = this.item.name;
    }
    
    $scope.bankName = "BankName1";
    $scope.setBankName = function(index){
    	$scope.bankName = this.item.name;
    }

    $scope.submitForm = function(){
   	 console.log($scope.user);
   	 $scope.user.countryName = $scope.countryName;
   	 $scope.user.bankName = $scope.bankName;
   	 $scope.user.userId = $rootScope.userId;
   	console.log($scope.user);
	 $http.post('http://localhost:8081/PayeeHackathon/rest/service/user/addBankAccount', $scope.user).then(function(response){
    	 console.log(response);
         debugger;
 		if (response.data.valid) {
 			//navigate to home page
                
                $location.path("home");
 		}else{
 			//show wrong user and password name
 			$scope.wrongUserPassword = true
 		}
 	})
 
        alert('bank account added successfully');
        $location.path('/home');
    }
 })

