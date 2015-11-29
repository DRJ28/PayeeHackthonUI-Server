module.controller('transferToPayeeCtrl', function($scope, $route, $routeParams, $location) {
     
      $scope.accounts =  [
      						{id: 1,name: 'Dhananjay- 9921255509'}, 
      						{id: 2,name: 'Dheeraj-9896857458'}];

      $scope.payeeName = $scope.accounts[0].name;
      $scope.setPayeeName = function(index){
      	$scope.payeeName = this.item.name;
      }
      $scope.submitForm = function(){
      	this.user.payeeName = this.payeeName;
      	console.log(this.user);
            alert('Amount transfered');
            $location.path('/home');
      }
 })
