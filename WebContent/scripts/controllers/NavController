(function(){
    'use strict';

    angular
        .module('Tracker')
        .controller('NavController', NavController);

    NavController.$inject = ['infoService'];
    function NavController(infoService, $http){
        var navList = this;
        navList.button = "Add";

        infoService.getPlayers().then(function(data){
            navList.playerList = data;
            navList.active = navList.playerList[0].player_id;

            for(var i= 0, len=navList.playerList.length; i<len; i++){
                infoService.getMatchHistory(navList.playerList[i].player_id);
            }
        }, function(){
            navList.playerList = null;
            navList.active = null;
        });

        navList.addPlayer = function(){
            if(navList.newPlayer.player_id != null) {
                navList.playerList.push(navList.newPlayer);
                infoService.addPlayer(navList.newPlayer);
            }
            navList.newPlayer = null;
        };

        navList.removePlayer = function(idx){
            navList.playerList.splice(idx, 1)
            infoService.addPlayer(navList.newPlayer);
        };

        navList.selectPlayer = function(n){
            navList.active = n;
            infoService.getMatchHistory(n);
        };

        navList.isSelected = function(n){
            return navList.active === n;
        }
    }
})();
