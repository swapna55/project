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
	  .when('/Login',{
		  templateUrl : 'Login.html',
		  controller  : 'UserController'
	  })
	  .when('/Register', {
		    templateUrl : 'Register.html',
		    controller  : 'UserController'
		  })
		.when('/myprofile', {
		    templateUrl : 'my_profile.html',
		    controller  : 'UserController'
		  })
		  /*.when('/searchFriend', {
		    templateUrl : 'c_friend/search_friend.html',
		    controller  : 'FriendController'
		  })

		  .when('/viewFriend', {
		    templateUrl : 'c_friend/view_friend.html',
		    controller  : 'FriendController'
		  })

		  
*/		  

	  .otherwise({redirectTo:'/'});
	  
	  
	  
	});
/*

app.controller('HomeCtrl',function($scope)
		{
	$scope.message="Home page";
		});
*/