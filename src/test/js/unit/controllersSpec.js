'use strict';

/* jasmine specs for controllers go here */
describe('Project Manager controllers', function() {
  describe('SimpleCtrlTest', function() {
    var $httpBackend, $controller, $scope;
    var MockSimpleService;

    beforeEach(function() {
      module('simpleCtrlModule');
      MockSimpleService = {
          getValue: function() {return "mockValue";}
      };
      module(function($provide) {
        $provide.value('SimpleService', MockSimpleService);
      });
    });
    
    beforeEach(inject(function(_$controller_, _$httpBackend_, $rootScope){
      // The injector unwraps the underscores (_) from around the parameter names when matching
      $controller = _$controller_;
      $httpBackend = _$httpBackend_;
      $scope = $rootScope.$new();
    }));
    
    

    it('does something', function() {
      var ctrl;
      ctrl = $controller('SimpleCtrl', {$http: $httpBackend, $scope: $scope});
      $scope.dummyFunction();
      expect($scope.executedDummyTest).toEqual('yes');
      expect($scope.value).toEqual("mockValue");
    });
    
  });
});
