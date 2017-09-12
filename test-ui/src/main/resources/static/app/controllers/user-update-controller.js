/**
 * 
 */

'use strict';

angular.module('test').controller('UserUpdateController',  function ($scope, $state, userFounded, userId, UserService) {
	
	$scope.user = userFounded.data;
	$scope.userId = userId;

	$scope.updateUser = function(){
		UserService.updateUser($scope.userId, $scope.user);
		//$state.go('listUser', {}, {reload: true});
		$state.transitionTo("listUser",{
			id: $scope.userId
	    },{
	        reload: true,
	        notify: true
	    });
	};
});