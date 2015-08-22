(function(){
    'use strict';

    angular
        .module('Tracker')
        .controller('StatController', StatController);

    StatController.$inject = ['infoService', '$routeParams'];
    function StatController(infoService, $routeParams) {
        var stat = this;
        stat.playerID = $routeParams.profileID;
        stat.matchDetails = infoService.getMatchHistory(stat.playerID);
        stat.average = infoService.average;

        infoService.getItems().then(function(data){
            stat.items = data;
        }, function(err){
            console.log(err);
        });

        infoService.getHeroes().then(function(data){
            stat.heroes = data;
        }, function(err){
            console.log(err);
        });

        stat.getHeroName = function(id){
           		var i=0;
            	while(stat.heroes[i].id != id)
                    i++;
				return stat.heroes[i].name;
        };

        stat.getItemName = function(id){
           		var i=0;
            	while(stat.items[i].id != id)
                    i++;
				return stat.items[i].name;
        };
    }
})();