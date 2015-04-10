'use strict';

/* Controllers */

var simpleCtrlrs = angular.module('simpleCtrlrs', []);
simpleCtrlrs.controller(
    'SimpleCtrl', ['$http', '$scope', function($http, $scope) {
      $scope.dummyFunction = function() {
        $scope.executedDummyTest = "yes";
      }
    }]);

var projMgrCtrlrs = angular.module('projMgrCtrlrs', ['services']);
projMgrCtrlrs.controller(
    'ProjectCtrl',
    ['$http', '$scope', 'ProjectService', 'ProjectApi', 'ProjectSearchApi',
    function(
        $http, $scope, service, Project, ProjectSearch) {
      $scope.showProjectList = true;
      $scope.showForm = false;
      $scope.search = function() {
        ProjectSearch.query({q: $scope.searchString}, function(data) {
          $scope.projects = data;
        });
      }
      $scope.addAnother = function() {
        service.refreshOrgUnits().success(function(data) {
          $scope.orgunits = data;
        });
        $scope.showProjectList = false;
        $scope.showForm = true;
      }
      $scope.update = function(project) {
        Project.save(project);
        $scope.showProjectList = true;
        $scope.showForm = false;
      }
      $scope.reset = function() {
        $scope.showProjectList = true;
        $scope.showForm = false;
      }
    }]);


projMgrCtrlrs.controller(
    'BudgetCtrl',
    ['$http', '$scope', '$routeParams', 'BudgetService', 'ProjectApi',
     'ResourceApi', 'StaticDataService',
    function($http, $scope, $routeParams, BudgetService, ProjectApi,
        ResourceApi, StaticDataService) {
      $scope.projectId = $routeParams.projectId
      BudgetService.getBudgets($scope.projectId).success(function(data) {
        $scope.budgets = data;
        $scope.showBudgetList = true;
        $scope.showForm = false;
        $scope.project = ProjectApi.get({id:$scope.projectId})
      });

      $scope.addAnother = function() {
        $scope.budget = {projectId : $scope.projectId};
        $scope.showBudgetList = false;
        $scope.showForm = true;
      }
      $scope.update = function(budget) {
        BudgetService.create(budget);
        $scope.showBudgetList = true;
        $scope.showForm = false;
      }
      $scope.reset = function() {
        $scope.showBudgetList = true;
        $scope.showForm = false;
      }
      $scope.editForecast = function(budgetId) {
        $scope.budgetId = budgetId;
        BudgetService.getForecast(budgetId).success(function(data) {
          $scope.forecast = data;
          $scope.showBudgetList = false;
          $scope.showForm = false;
          $scope.editForecasts = true;
        });
      }
      $scope.addResource = function() {
        StaticDataService.getRoleTypes().success(function(data) {
          $scope.roleTypes = data;
          $scope.showAddResource = true;
        });
      }
      $scope.updateRoleSubTypes = function() {
        StaticDataService.getRoleSubTypes($scope.resource.roleTypeId).success(function(data) {
          $scope.roleSubTypes = data;
        });
      }
      $scope.createResource = function() {
        $scope.resource.budgetId = $scope.budgetId;
        BudgetService.createResource($scope.resource).success(function(data) {
          $scope.forecast.push(data);
          $scope.showAddResource = false;
        });
      }
      $scope.removeResource = function(fc) {
        ResourceApi.remove({resourceId:fc.resourceId});
      }
      $scope.saveResource = function(fc) {
        ResourceApi.save(fc);
      }
    }]);
