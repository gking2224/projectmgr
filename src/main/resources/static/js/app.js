'use strict';

/* App */
var projMgrApp = angular.module(
    'projMgrApp', ['ngRoute', 'projMgrCtrlrs']);


projMgrApp.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/project', {
        templateUrl: 'partials/project.html',
        controller: 'ProjectCtrl'
      }).
      when('/budget/:projectId', {
        templateUrl: 'partials/budget.html',
        controller: 'BudgetCtrl'
      }).
      otherwise({
        redirectTo: '/project'
      });
  }]);