'use strict';

angular.module('myApp.report', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/report', {
    templateUrl: 'views/report.html',
    controller: 'ReportCtrl'
  });
}])

.controller('ReportCtrl', ['$scope',function($scope) {
	
}]);