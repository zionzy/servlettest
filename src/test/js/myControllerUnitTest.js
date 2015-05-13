describe('myController', function() {
	beforeEach(module('myAppModule'));
	
	var $controller;

	beforeEach(inject(function(_$controller_){
		$controller = _$controller_;
	}));

	describe('$scope.changeParagraph', function() {
		it('test $scope.spice has correct value', function() {
			var $scope = {};
			var myController = $controller('myController', { $scope: $scope});
			$scope.changeParagraph('hello there');
			expect($scope.spice).toEqual('hello there');
		});
	});
});