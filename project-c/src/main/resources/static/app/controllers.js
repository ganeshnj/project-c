var vehicleControllers = angular.module('vehicleControllers', []);

vehicleControllers.controller('VehicleListController', 
		[ '$scope', 'VehiclesFactory', 'VehicleFactory', '$location', 
		  function($scope, VehiclesFactory, VehicleFactory, $location) {
			
			$scope.msg = 'hello';
			
			$scope.editVehicle = function (vehicleId) {
	            $location.path('/vehicles/edit/' + vehicleId);
	        };

	        $scope.deleteVehicle = function (vehicleId) {
	        	VehicleFactory.delete({ id: vehicleId })
	        	.$promise.then(
	        			function(value){
	        				$scope.vehicles = VehiclesFactory.query().$promise.then(function(value){
	        		        	$scope.total = value.length;
	        		        	$scope.vehicles = value;
	        		        	
	        		        	var car=0, bike=0, cycle=0;
	        		        	angular.forEach($scope.vehicles, function(vehicle) {
	        		        		if (vehicle.type == 'CAR')
	        							car++;
	        						else if (vehicle.type == 'BIKE')
	        							bike++;
	        						else if (vehicle.type == 'BICYCLE')
	        							cycle++;
	        		            });
	        		        	$scope.totalCar = car;
	        		        	$scope.totalBike = bike;
	        		        	$scope.totalCycle = cycle;
	        		        	
	        		        }); 
	        			}
	        	);
	        	
	        };
	        
	        $scope.vehicles = VehiclesFactory.query().$promise.then(function(value){
	        	$scope.total = value.length;
	        	$scope.vehicles = value;
	        	
	        	var car=0, bike=0, cycle=0;
	        	angular.forEach($scope.vehicles, function(vehicle) {
	        		if (vehicle.type == 'CAR')
						car++;
					else if (vehicle.type == 'BIKE')
						bike++;
					else if (vehicle.type == 'BICYCLE')
						cycle++;
	            });
	        	$scope.totalCar = car;
	        	$scope.totalBike = bike;
	        	$scope.totalCycle = cycle;
	        });
	        
	        
		} ]);

vehicleControllers.controller('VehicleAddController', 
		[ '$scope', 'VehiclesFactory', '$location',
		function($scope, VehiclesFactory, $location) {
			$scope.createNewVehicle = function() {
				VehiclesFactory.create($scope.vehicle).$promise.then(function(value){
					  $location.path('/vehicles');
		        });
			}
		} ]);

vehicleControllers.controller('VehicleDetailController', 
		['$scope', '$routeParams', 'VehicleFactory', '$location',
		 function ($scope, $routeParams, VehicleFactory, $location) {
   
    	
    	  // callback for
			// ng-click
			// 'cancel':
    	  $scope.cancel = function () {
    	      $location.path('/vehicle-list');
    	  };
    	
    	      $scope.vehicle = VehicleFactory.show({id: $routeParams.vehiclesId});
    	  }]);

vehicleControllers.controller('VehicleEditController', 
		['$scope', '$routeParams', 'VehicleFactory', '$location',
		 function ($scope, $routeParams, VehicleFactory, $location) {
	
	      // callback for ng-click 'updateUser':
	  $scope.updateVehicle = function () {
		  VehicleFactory.update($scope.vehicle).$promise.then(function(value){
			  $location.path('/vehicles');
	        }); ;
		 
	  };
	
	  // callback for ng-click 'cancel':
	  $scope.cancel = function () {
	      $location.path('/vehicle-list');
	      };
	
	      $scope.vehicle = VehicleFactory.show({id: $routeParams.vehiclesId});
	  }]);