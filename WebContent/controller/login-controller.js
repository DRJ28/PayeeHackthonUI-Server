module.controller('LoginController', function($scope,$http, $route, $routeParams, $location, $rootScope) {
     
     $rootScope.myName = "";
     $rootScope.userId = "";
     $scope.wrongUserPassword = false;
     $scope.submitLogin = function(){
    	 console.log($scope.user);
    	 $http.post('http://localhost:8081/PayeeHackathon/rest/service/user/getUser', $scope.user).then(function(response){
        	 console.log(response);
             debugger;
     		if (response.data.valid) {
     			//navigate to home page
                    $rootScope.myName = response.data.firstName;
                    $rootScope.userId = response.data.userId;
                    $location.path("home");
     		}else{
     			//show wrong user and password name
     			$scope.wrongUserPassword = true
     		}
     	})
     }
        
 })
