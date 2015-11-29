module.controller('viewAccountsCtrl', function($scope, $route, $routeParams, $location) {
     
      $scope.accounts = [
      	{id: 1, name:"ABC", account: 7578500,  amount:32000 },
      	{id: 2, name:"BCD", account: 2589623,  amount:25000 },
      	{id: 3, name:"DBD", account: 9999999,  amount:26000},
      	{id: 4, name:"ASD", account: 7578500, amount:85000}
      ];
 })
