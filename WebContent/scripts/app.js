(function(){

    angular
        .module('Tracker', ['ngRoute'])
        .config(moduleConfig)
        .filter('time', timeFilter);

    moduleConfig.$inject = ['$routeProvider'];
    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/:profileID', {
                templateUrl: 'templates/stats_tmpl.html',
                controller: 'StatController',
                controllerAs: 'stat'
            });
    }

    function timeFilter(){
        return function(time){
            var x = time/60;
            var str ="";
            var arr = ["00","00"];

            if(x > 60){
                var y = x/60;
                y = Math.floor(y);
                y = y.toString();
                str = y+":";
                x = x - 60*y;
            }
            x= x.toFixed(2);

            x = x.toString();
            var arr = x.split(".");
            str = str+arr[0]+":"+arr[1];
            return str;
        }
    }


})();