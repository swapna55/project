'use strict';
console.log("hello..")
app
		.controller(
				'UserController',
				[
						'$scope',
						'UserService',
						'$location',
						'$rootScope',
						
						'$http',
						function($scope, UserService, $location, $rootScope,
								$http) {
							console.log("UserController...")
							var self = this;
							self.userdetails = {
								userid : '',
								username : '',
								password : '',
								contact : '',
								address : '',
								email : '',
								isOnline : '',
								role : '',
								errorCode : '',
								errorMessage : ''
							};
							self.users = [];

							self.fetchAllUsers = function() {
								console.log("fetchAllUsers...")
								UserService
										.fetchAllUsers()
										.then(
												function(d) {
													self.users = d;
												},
												function(errResponse) {
													console
															.error('Error while fetching Users');
												});
							};
							
							//self.fatchAllUsers();

							self.createUser = function(userdetails) {
								console.log("createUser...")
								UserService
										.createUser(userdetails)
										.then(
												self.fetchAllUsers,
												function(errResponse) {
													console
															.error('Error while creating user');
												});
							};
							
							self.myProfile = function() {
								console.log("myProfile...")
								UserService
										.myProfile()
										.then(
												function(d) {
													self.userdetails = d;
													$location.path("/myProfile")
												},
												function(errResponse) {
													console
															.error('Error while fetch profile.');
												});
							};

							self.updateUser = function(userdetails, userid) {
								console.log("updateUser...")
								UserService
										.updateUser(userdetails, userid)
										.then(
												self.fetchAllUsers,
												function(errResponse) {
													console
															.error('Error while updating User.');
												});
							};

							self.authenticate = function(userdetails) {
								console.log("authenticate...")
								UserService
										.authenticate(userdetails)
										.then(

												function(d) {

													self.userdetails = d;
													console
															.log("userdetails.errorCode: "
																	+ self.userdetails.errorCode)
													if (self.userdetails.errorCode == "404")

													{
														alert(self.userdetails.errorMessage)

														self.userdetails.userid = "";
														self.userdetails.password = "";

													} else {
														console
																.log("Valid credentials. Navigating to home page")
														$rootScope.currentUser = self.userdetails
														$http.defaults.headers.common['Authorization'] = 'Basic '
																+ $rootScope.currentUser;
													/*	$cookieStore
																.put(
																		'currentUser',
																		$rootScope.currentUser); */
														
														$location.path('/');

													}

												},
												function(errResponse) {

													console
															.error('Error while authenticate Users');
												});
							};

							self.logout = function() {
								console.log("logout")
								$rootScope.currentUser = {};
								$cookieStore.remove('currentUser');
								UserService.logout()
								$location.path('/');

							}

							self.deleteUser = function(userid) {
								console.log("UserController...")
								UserService
										.deleteUser(userid)
										.then(
												self.fetchAllUsers,
												function(errResponse) {
													console
															.error('Error while deleting User.');
												});
							};

							// self.fetchAllUsers();

							self.login = function() {
								{
									console.log('login validation????????',
											self.userdetails);
									self.authenticate(self.userdetails);
								}

							};

							self.submit = function() {
								{
									console.log('Saving New User', self.userdetails);
									self.createUser(self.userdetails);
									$location.path('/Login');
								}
								self.reset();
								
							};

							self.reset = function() {
								self.userdetails = {
									userid : '',
									username : '',
									password : '',
									mobile : '',
									address : '',
									email : '',
									isOnline : '',
									errorCode : '',
									errorMessage : ''
								};
								$scope.myForm.$setPristine(); // reset Form
							};

						} ]);