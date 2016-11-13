'use strict';
app.factory('friendservice',['$http' ,'$sq','$rootScope',function($http,$sq,$rootScope){}])
{console.log("friendservice")
var BASE_URL = 'http;//localhost:8081/CollaborationPlatform'
	return {
	getMyFriends:function(){
                   return 	$http.get(BASE_URL+'/myFriends')
                            .then(
		                     function(response){
		                         return respose.data;
                             },
                  function(errResponse){
                       console('error while fetching friends');
                      return $q.reject(errResponse);
                        }

                     );
                },


sendFriendRequest:function(friendid){
    return 	$http.get(BASE_URL+'/addFriend/'+friendid)
             .then(
              function(response){
                  return respose.data;
              },
   function(errResponse){
        console('error while creating friends');
       return $q.reject(errResponse);
         }

      );
 },
 updateFriendRequest:function(friend,id){
	    return 	$http.get(BASE_URL+'/Friend/'+friend,id)
	             .then(
	              function(response){
	                  return respose.data;
	              },
	   function(errResponse){
	        console('error while updating friends');
	       return $q.reject(errResponse);
	         }

	      );
	 },
	 deleteFriendRequest:function(id){
		    return 	$http.get(BASE_URL+'/Friend/'+id)
		             .then(
		              function(response){
		                  return respose.data;
		              },
		   function(errResponse){
		        console('error while deleting friends');
		       return $q.reject(errResponse);
		         }

		      );
		 },





}

}