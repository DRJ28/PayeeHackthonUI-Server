module.controller('addMoneyToWalletCtrl', function($scope, $route, $routeParams, $location) {
     
    $scope.accounts =  [{id: 2,name: '125869'},
    					{id: 3,name: '147852'}];
 	$scope.accountName = 'select account';
 	$scope.setValue = function(index){
 		//this.item
 		$scope.accountName = this.item.name;
 	}

 	$scope.submitForm = function(){
 		if ($scope.accountName == 'select account') {
 			alert('Please select account');
 		}else{
 			alert(this.user.accNum + ' added to wallet');
        	$location.path('/home');
 		}
        
    }

 })
