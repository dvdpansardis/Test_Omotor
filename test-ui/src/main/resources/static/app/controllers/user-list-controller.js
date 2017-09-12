/**
 * 
 */

'use strict';

angular.module('test').controller('UserListController',  function ($scope, $state, $window, allUsers, UserService) {
	
	$scope.users = allUsers;
	
	$scope.deleteUser = function(id) {
		if($window.confirm('are you sure?')) {
			UserService.deleteUser(id);
			$scope.users = $scope.users.filter(function(u) {return u.id !== id;});
		}
	};
	
	$scope.updateUser = function(userId) {
		$state.go('updateUser', { id : userId })
	};

});

