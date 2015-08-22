(function(){
    'use strict';

    angular
        .module('Tracker')
        .controller('StatController', StatController);

    StatController.$inject = ['infoService', '$routeParams'];
    function StatController(infoService, $routeParams) {
        var stat = this;

        init();

        function init(){
            stat.playerID = $routeParams.profileID;

            infoService.getHeroes().then(function(result){
                //console.log(result);
            });

            infoService.getItems().then(function(result){
                //console.log(result);
            });

            infoService.getMatchHistory(stat.playerID).then(function(result){
                stat.matchDetails = result;
            });

            stat.average = infoService.average;
        }

        stat.getHeroName = function(id){
            return infoService.getHeroName(id);
        };

        stat.getItemName = function(id){
            return infoService.getItemName(id);
        };
    }
})();