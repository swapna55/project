var app = angular.module('myApp',['ngRoute','ngCookies','ngFileUpload']);
app.config(function($routeProvider){
	$routeProvider
	
	.when('/', {
		templateUrl : 'c_home/home.html',
		controller  : 'HomeController'
	})
	
	.when('/manageUser' ,{
		templateUrl : 'c_admin/manage_users.html',
		controller  : 'AdminController'
	})

	.when('/event' ,{
		templateUrl : 'c_event/event.html',
		controller  : 'EventController'
	})

	.when('/about' ,{
		templateUrl : 'c_about/about.html',
		controller  : 'AboutController'
	})
	
	.when('/login' ,{
		templateUrl : 'c_user/login.html',
		controller  : 'UserController'
	})

	.when('/register', {
		templateUrl : 'c_user/register.html',
		controller  : 'UserController'
	})
	
	.when('/create_blog', {
		templateUrl : 'c_blog/create_blog.html',
		controller  : 'BlogController'
	})
	
	.when('/list_blog', {
		templateUrl : 'c_blog/list_blog.html',
		controller  : 'BlogController'
	})

	.when('/view_blog', {
		templateUrl : 'c_blog/view_blog.html',
		controller  : 'BlogController'
	})

.when('/add_friend', {
		templateUrl : 'c_friend/add_friend.html',
		controller  : 'FriendController'
	})


.when('/search_friend', {
		templateUrl : 'c_friend/search_friend.html',
		controller  : 'FriendController'
	})

.when('/view_friend', {
		templateUrl : 'c_friend/view_friend.html',
		controller  : 'FriendController'
	})

.when('/view_blog', {
		templateUrl : 'c_blog/view_blog.html',
		controller  : 'BlogController'
	})

/*.when('/view_blog', {
		templateUrl : 'c_blog/view_blog.html',
		controller  : 'BlogController'
	})

.when('/view_blog', {
		templateUrl : 'c_blog/view_blog.html',
		controller  : 'BlogController'
	})

.when('/view_blog', {
		templateUrl : 'c_blog/view_blog.html',
		controller  : 'UserController'
	})

.when('/view_blog', {
		templateUrl : 'c_blog/view_blog.html',
		controller  : 'UserController'
	})

.when('/view_blog', {
		templateUrl : 'c_blog/view_blog.html',
		controller  : 'UserController'
	})


*/.otherwise({
	redirectTo: '/'
});
	
});

	


app.run(function($rootScope,$location,$cookiesStore,$http){
	$rootScope.$on('locationChangeStart',function(event,next,current){
	console.log('locationChangeStart')
	//redirect to loinpage  if not loggedin & trying to access a restrictedpage
	var restrictedPage=$.inarray($location.path(),['//', '/home.html,'/','/search_job,'/view_blog','/login,'/register,'/list_blog']) === -1;
	
	console.log("restrictedPage:" +restrictedPage)
	var loggedIn = $rootScope.currentUser.id;
	console.log("loggedIn:" +loggedIn)
		
	
		if(restrictedPage & !loggedIn )
		{
			console.log('navigating to loginpage')
			
		    $location.path('/login');
		}
});
	//keep user logged in after refresh
	$rootScope.currentUser = $cookieStore.get(currentUser) || {};
	if(rootScope.currentUser){
		$http.defaults.headers.common['Authorization'] = 'Basic' +rootScope.currentUser;
		}
});