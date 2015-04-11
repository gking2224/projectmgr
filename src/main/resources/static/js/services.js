'use strict';


var simpleServicesModule = angular.module('simpleServicesModule', []);

simpleServicesModule.factory('SimpleService',function() {
  var getValue = function() {
    return "realValue";
  }
  return {getValue: getValue};
});

var services = angular.module('services', ['ngResource']);

services.factory('ProjectService', ['$http', function($http) {
  var myfunc = function() {
    return $http.get('/orgunit/list');
  }
  return {
    refreshOrgUnits : myfunc
  }
}]);

services.factory('BudgetService', ['$http', function($http) {
  var getBudgets = function(id) {
    return $http.get("/api/budget/byproject/"+id);
  }
  var create = function(budget) {
    return $http.post("/api/budget/create/"+budget.projectId+"/"+budget.name);
  }
  var getForecast = function(budgetId) {
    return $http.get("/api/budget/forecast/"+budgetId)
  }
  var createResource = function(resource) {
    return $http.post("/api/budget/createresource/"+resource.budgetId+"/"+
        resource.roleSubTypeId+"/"+resource.fte);
  }
//  var removeResource = function(resourceId) {
//    return $http.delete("/api/budget/resource/"+resource.resourceId);
//  }
  return {
    getBudgets : getBudgets,
    create : create,
    getForecast : getForecast,
    createResource : createResource
  }
}]);

services.factory('StaticDataService', ['$http', function($http) {
  var getRoleTypes = function() {
    return $http.get("/api/staticdata/roletypes");
  }
  var getRoleSubTypes = function(roleTypeId) {
    return $http.get("/api/staticdata/rolesubtypes/"+roleTypeId);
  }
  return {
    getRoleTypes : getRoleTypes,
    getRoleSubTypes : getRoleSubTypes
  }
}]);

services.factory('ProjectApi', function($resource) {
  return $resource("/api/project/:id");
});

services.factory('ProjectSearchApi', function($resource) {
  return $resource("/api/project/search/:q");
});

services.factory('ResourceApi', function($resource) {
  return $resource("/api/budget/resource/:resourceId");
});