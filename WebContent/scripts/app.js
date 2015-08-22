(function(){

    angular
        .module('Tracker', ['ngRoute'])
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];
    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/:profileID', {
                templateUrl: 'templates/stats_tmpl.html',
                controller: 'StatController',
                controllerAs: 'stat'
            });
    }
})();