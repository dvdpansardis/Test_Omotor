'use strict';

angular.module('test', ['ui.router'])
	.config(['$stateProvider', function ($stateProvider) {
		
		$stateProvider
	    	.state('home', {
	    		url : '/home',
				templateUrl : 'app/view/app-template.html',
				controller : 'AppController'
	    	})
	    	.state('listUser', {
	    		url : '/user',
				templateUrl : 'app/view/user-list-template.html',
				controller : 'UserListController',
				resolve: {
					allUsers : function(UserService) {
						return UserService.getAllUsers();
					}
				}
	    	})
	    	.state('addUser', {
	    		url : '/user/add',
				templateUrl : 'app/view/user-add-template.html',
				controller : 'UserAddController'
	    	})
	    	.state('updateUser', {
	    		url : '/user/:id',
				templateUrl : 'app/view/user-update-template.html',
				controller : 'UserUpdateController',
				resolve: {
					userFounded: function (UserService, $stateParams) {
						return UserService.getUser($stateParams.id);
					},
					userId: function ($stateParams) {
						return $stateParams.id;
					}
				}
	    	});
	
}]);
