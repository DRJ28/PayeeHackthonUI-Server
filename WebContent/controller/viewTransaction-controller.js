module.controller('viewTransactionCtrl', function($scope, $route, $routeParams, $location, $http, $rootScope) {
     
      /*$scope.transaction = [
      	{id: 1, account: 7578500, credit:100, debit:0, tranasctionId: 01111, date:'20/12/2015'},
      	{id: 2, account: 2589623, credit:0, debit:110, tranasctionId: 01258, date:'01/05/2015'},
      	{id: 3, account: 9999999, credit:100, debit:0, tranasctionId: 01181, date:'20/06/2015'},
      	{id: 4, account: 7578500, credit:0, debit:3256, tranasctionId: 01111, date:'20/07/2015'}
      ];*/
      
      $http.post('http://localhost:8081/PayeeHackathon/rest/service/user/getTransaction', $rootScope.userId).then(function(response){
    	 console.log(response);
    	 $scope.transaction = response.data;
         debugger;
      });
 })
