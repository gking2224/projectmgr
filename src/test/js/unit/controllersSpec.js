'use strict';

/* jasmine specs for controllers go here */
describe('Project Manager controllers', function() {
  var mockService = {};
  
  beforeEach(function() {
    module('simpleCtrlrs');
  });

  describe('SimpleCtrlTest', function() {
    var $httpBackend, $controller;
    
    beforeEach(inject(function(_$controller_, _$httpBackend_){
      // The injector unwraps the underscores (_) from around the parameter names when matching
      $controller = _$controller_;
      $httpBackend = _$httpBackend_;
    }));

    it('does something', function() {
      var $scope, ctrl;
      $scope = {}
      ctrl = $controller('SimpleCtrl', {$http: $httpBackend, $scope: $scope});
      $scope.dummyFunction();
      expect($scope.executedDummyTest).toEqual('yes');
    });
    
  });
});
