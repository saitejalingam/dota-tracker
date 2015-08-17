(function(){
    'use strict';

    angular
        .module('Tracker')
        .service('dataService', dataServiceFn);

    dataServiceFn.$inject = ['$http'];
    function dataServiceFn($http) {

    }
})();