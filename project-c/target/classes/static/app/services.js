var vehicleService = angular.module('vehicleServices', ['ngResource']);


vehicleService.factory('VehiclesFactory', function ($resource) {
    return $resource('/vehicles', {}, {
        query: { method: 'GET', isArray: true },
        create: { method: 'POST' }
    })
});

vehicleService.factory('VehicleFactory', function ($resource) {
    return $resource('/vehicles/:id', {}, {
        show: { method: 'GET', params: {id: '@id'} },
        update: { method: 'PUT', params: {id: '@id'} },
        delete: { method: 'DELETE', params: {id: '@id'} }
    })
});
