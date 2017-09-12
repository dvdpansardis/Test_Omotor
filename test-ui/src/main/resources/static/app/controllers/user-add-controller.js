/**
 * 
 */
'use strict';

angular.module('test').controller('UserAddController',  function ($scope, $state, UserService) {

	$scope.user = {
			name : "",
			telephone_number : "",
			email : "me@example.com",
			gender : ["female", "male"]
	};
	
	$scope.addUser = function(){
		UserService.addUser($scope.user);
		//$state.go('listUser', {}, {reload: true});  
		$state.transitionTo("listUser",{
			id: $scope.user.id
	    },{
	        reload: true,
	        notify: true
	    });
	};

});