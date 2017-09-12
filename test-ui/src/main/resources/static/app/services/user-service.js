/**
 * 
 */

'use strict';

angular.module("test").factory("UserService", function ($http, config) {

	this.getAllUsers = function () {
		return $http.get(config.baseUrl + "/user").then(function (response){
			return response.data;
		});
	};

	this.getUser = function (id) {
		return $http.get(config.baseUrl + "/user/" + id);
	};
	
	this.deleteUser = function(id){
		$http.delete(config.baseUrl + "/user/" + id)
	}

	this.addUser = function (user) {
		return $http.post(config.baseUrl + "/user", user);
	};
	
	this.updateUser = function (id, user) {
		return $http.put(config.baseUrl + "/user/" + id, user);
	};

	return this;

});