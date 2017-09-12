/**
 * 
 */

'use strict';

angular.module('test').controller('UserUpdateController',  function ($scope, $state, $location, userFounded, userId, UserService) {
	
	$scope.user = userFounded.data;
	$scope.userId = userId;

	$scope.updateUser = function(){
		UserService.updateUser($scope.userId, $scope.user).then(function(response){
			$scope.redirect();
		});
	};
	
	$scope.redirect = function(){
		$state.go('listUser', {});
	}
});