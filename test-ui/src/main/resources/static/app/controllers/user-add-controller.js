/**
 * 
 */
'use strict';

angular.module('test').controller('UserAddController',  function ($scope, $state, UserService) {

	$scope.user = {
			name : '',
			telephone_number : '',
			email : '',
			gender : ''
	};
	
	$scope.addUser = function(){
		UserService.addUser($scope.user).then(function(response){
			$scope.redirect();
		})
	};
	
	$scope.redirect = function(){
		$state.go('listUser', {});
	}

});