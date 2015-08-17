(function(){
    'use strict';

    angular
        .module('Tracker')
        .service('infoService', infoServiceFn);

    infoServiceFn.$inject = ['$http', '$q'];
    function infoServiceFn($http, $q){

        var self = this;
        self.average = {
            win_percent: 0,
            kills: 0,
            deaths: 0,
            assists: 0,
            last_hits: 0,
            gpm: 0,
            xpm: 0
        };

        self.getPlayers = function(){
            var playerPromise = $q.defer();

            $http({
                method: 'GET',
                url: 'http://localhost:8080/Tracker/api/player/getPlayers',
                cache: false
            }).success(function(data){
                playerPromise.resolve(data);
                console.log(data);
            }).error(function(err){
                playerPromise.reject(err);
            });

            return playerPromise.promise;
        };

        self.getHeroes = function(){
            var heroPromise = $q.defer();

            $http({
                method: 'GET',
                url: 'http://localhost:8080/Tracker/api/heroes/getHeroes',
                cache: true
            }).success(function(data){
                heroPromise.resolve(data);
                console.dir(data);
            }).error(function(){
                heroPromise.reject(data);
            });

            return heroPromise.promise;
        };

        self.getItems = function(){
            var itemPromise = $q.defer();

            $http({
                method: 'GET',
                url: 'http://localhost:8080/Tracker/api/items/getItems',
                cache: true
            }).success(function(data){
                itemPromise.resolve(data);
                console.dir(data);
            }).error(function(err){
                itemPromise.reject(err);
            });

            return itemPromise.promise;
        };

        self.getMatchHistory = function(playerID){
            $http({
                method: 'GET',
                url: 'http://localhost:8080/Tracker/api/player/'+playerID,
                cache: true
            })
                .success(function (data) {
                    console.dir(data);
                    self.matchHistory = data;
                    self.average = self.getAverages(data);
                })
                .error(function(err){
                    console.log(err);
                });
        };

        self.addPlayer = function(player){

            $http({
                method: 'POST',
                url: 'http://localhost:8080/Tracker/api/player/add',
                data: player
            }).success(function(data){
                console.log(data);
            }).error(function(err){
                console.log(err);
            });

        };

        self.removePlayer = function(player){

            $http({
                method: 'POST',
                url: 'http://localhost:8080/Tracker/api/player/remove',
                data: player
            }).success(function(data){
                console.log(data);
            }).error(function(err){
                console.log(err);
            });
        };
        
        self.getAverages = function(matchDetails) {

            var average = {
                win_percent: 0,
                kills: 0,
                deaths: 0,
                assists: 0,
                last_hits: 0,
                gpm: 0,
                xpm: 0
            };

            for(var i= 0, len = matchDetails.length; i < len; i++){
                if((matchDetails[i].player_slot < 127 && matchDetails[i].radiant_win == true) || (matchDetails[i].player_slot > 64 && matchDetails[i].radiant_win == false))
                   average.win_percent += 1;
                   average.kills += matchDetails[i].kills;
                   average.deaths += matchDetails[i].deaths;
                   average.assists += matchDetails[i].assists;
                   average.last_hits += matchDetails[i].last_hits;
                   average.gpm += matchDetails[i].gpm;
                   average.xpm += matchDetails[i].xpm;
                }

                average.win_percent = ((average.win_percent/25)*100).toFixed(2);
                average.kills /= 25;
                average.deaths /= 25;
                average.assists /= 25;
                average.last_hits /= 25;
                average.gpm /= 25;
                average.xpm /= 25;

            return average;
        }
    }

})();