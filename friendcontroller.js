'use strict';
app.controller('FriendController',['UserService','$scope','FriendService','location','$rootScope'])
console.log("FriendController....") 
var self = this;
self.friend = {id:'',userid:'',friendid:'',status:''};
self.friends = [];
self.user = {
		id:'',
		name:'',
		password:'',
		mobile:'',
		address:'',
		email:'',
		isOnline:'',
		errorMessage:''
};
self.users = [];

self.sendFriendRequest = sendFriendRequest,
{

funciton sendFriendRequest(friendid)
{
console.log("->sendFriendRequest :"+friendid)
FriendService.sendFriendRequest(friendid)
.then(
		function(d){

			self.friend = d;
			alert("Friend request sent")
			
		},
		function(errResponse){
           console.error('Error while sending friend request');
		}

		);

}
}

	
self.getMyFriends = function()
{
console.log("getting my friends")
FriendService.getMyFriends()
.then(
		function(d){

			self.friend = d;
			console.log("got my friends")
			
		},
		function(errResponse){
           console.error('Error while fetching friend request');
		}

		);





};
self.updateFriend = function(friend,id)
{
console.log("getting my friends")
FriendService.updateFriend(friend,id)
.then(
		self.fetchfriends,
	
		function(errResponse){
           console.error('Error while fetching friend request');
		}

		);


};
self.deleteFriend = function(id)
{
console.log("getting my friends")
FriendService.deleteFriend(id)
.then(
		self.fetchallfriends,
	
		function(errResponse){
           console.error('Error while deleting friend request');
		}

		);


};

self.fetchAllUsers = function()
{

UserService.fetchAllUsers()
.then(
		function(d){

			self.friend = d;
			
			
		},
		function(errResponse){
           console.error('Error while fetching friend request');
		

		});





};
self.fetchAllUsers();
self.getMyFriends(); 



