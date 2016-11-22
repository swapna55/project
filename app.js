var app=angular.module('myApp',['ngRoute']);

app.config(function($routeProvider) {
	  $routeProvider

	  .when('#/', {
	    templateUrl : 'index.html',
	    controller  : 'HomeCtrl'
	  })
	  
	  .when('/about',{
		  templateUrl : 'About.html',
		  controller  : 'AboutCtrl'
	  })
	  
});


app.controller('HomeCtrl',function($scope)
		{
	$scope.message="Home page";
		});
/*app.controller('AboutController', function($scope) {
	  $scope.message = 'Hello from AboutController';
	});*/