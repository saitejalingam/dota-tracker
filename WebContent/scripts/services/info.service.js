(function(){
    'use strict';

    angular
        .module('Tracker')
        .service('infoService', infoServiceFn);

    infoServiceFn.$inject = ['$http', '$q'];
    function infoServiceFn($http, $q){

        var self = this;

        init();

        function init(){
            self.average = {
                win_percent: 0,
                kills: 0,
                deaths: 0,
                assists: 0,
                last_hits: 0,
                gpm: 0,
                xpm: 0
            };

            self.heroes = [];
            self.items = [];
        }

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
            var defer = $q.defer();
            $http({
                method: 'GET',
                url: 'http://localhost:8080/Tracker/api/heroes/getHeroes',
                cache: true
            }).success(function(data){
                self.heroes = data;
                defer.resolve(data);
            }).error(function(err){
                defer.reject(err);
            });

            return defer.promise;
        };

        self.getItems = function(){
            var defer = $q.defer();
            $http({
                method: 'GET',
                url: 'http://localhost:8080/Tracker/api/items/getItems',
                cache: true
            }).success(function(data){
                self.items = data;
                defer.resolve(data);
            }).error(function(err){
                defer.reject(err);
            });

            return defer.promise;
        };

        self.getMatchHistory = function(playerID){

            var matchPromise = $q.defer();
            $http({
                method: 'GET',
                url: 'http://localhost:8080/Tracker/api/player/'+playerID,
                cache: true
            })
                .success(function (data) {
                    console.dir(data);
                    self.average = self.getAverages(data);
                    matchPromise.resolve(data);
                })
                .error(function(err){
                    console.log(err);
                    matchPromise.reject(err);
                });

            return matchPromise.promise;
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

                average.win_percent = ((average.win_percent/len)*100).toFixed(2);
                average.kills /= len;
                average.deaths /= len;
                average.assists /= len;
                average.last_hits /= len;
                average.gpm /= len;
                average.xpm /= len;

            return average;
        };

        self.getHeroName = function(id){

            var i=0;
            while(self.heroes[i].id != id)
                i++;
            return self.heroes[i].name;
        };

        self.getItemName = function(id){

            var i=0;
            while(self.items[i].id != id)
                i++;
            return self.items[i].name;
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
    }

})();