var vehicleApp = angular.module('vehicleApp', [ 'ngRoute',
		'vehicleControllers', 'vehicleServices' ]);

vehicleApp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/vehicles', {
		templateUrl : 'partials/vehicle-list.html',
		controller : 'VehicleListController'
	}).when('/vehicles/add', {
		templateUrl : 'partials/vehicle-add.html',
		controller : 'VehicleAddController'
	}).when('/vehicles/edit/:vehiclesId', {
		templateUrl : 'partials/vehicle-edit.html',
		controller : 'VehicleEditController'
	}).otherwise({
		redirectTo : '/vehicles'
	});
} ]);