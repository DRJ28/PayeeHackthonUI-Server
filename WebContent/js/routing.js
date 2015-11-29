module.config(function($routeProvider, $locationProvider) {
  $routeProvider
   .when('/', {
    templateUrl: 'views/login.html',
    controller: 'LoginController'
  }).
   when('/signup', {
    templateUrl: 'views/signup.html',
    controller: 'SignupController'
  }).
   when('/home', {
    templateUrl: 'views/home.html',
    controller: 'HomeController'
  }).
   when('/addAcc', {
    templateUrl: 'views/addAccount.html',
    controller: 'addAccountCtrl'
  }).
   when('/addMoneyWallet', {
    templateUrl: 'views/addMoneyToWallet.html',
    controller: 'addMoneyToWalletCtrl'
  }).
   when('/transferPayee', {
    templateUrl: 'views/transferToPayee.html',
    controller: 'transferToPayeeCtrl'
  }).
   when('/addPayee', {
    templateUrl: 'views/addPayee.html',
    controller: 'addPayeeCtrl'
  }).
   when('/viewTrasact', {
    templateUrl: 'views/viewTransaction.html',
    controller: 'viewTransactionCtrl'
  }).
   when('/viewPayee', {
    templateUrl: 'views/viewPayeeList.html',
    controller: 'viewPayeeCtrl'
  }).
   when('/viewAccounts', {
    templateUrl: 'views/viewBankAccount.html',
    controller: 'viewAccountsCtrl'
  })
});