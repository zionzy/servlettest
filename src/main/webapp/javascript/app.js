(function(){
	var myApp = angular.module('myAppModule', []);
	
	myApp.controller('myController', ['$scope', function($scope){
		
		$scope.changeParagraph = function(test) {
			
			//document.getElementById("demo").innerHTML = "Paragraph changed.";
			
			$scope.spice = test;
		};
	}]);
})();

