'use strict';

angular.module('myApp.dashboard', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/dashboard', {
    templateUrl: '/app/static/views/dashboard.html',
    controller: 'DashboardCtrl'
  })
  .when('/',{
	  templateUrl: '/app/static/views/dashboard.html',
	  controller: 'DashboardCtrl'
  })
  ;
}])

.controller('DashboardCtrl', ['$scope',function($scope) {
	
}]);