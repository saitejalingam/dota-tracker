/**
 * Created by Daedalus on 8/22/2015.
 */
(function(){

    describe('Nav Controller: ', function(){

        var service, navVm,
            mockData=[{},{}];

        beforeEach(module('Tracker'));

        beforeEach(inject(function($controller, infoService, $q, $rootScope){
            service = infoService;
            var defer = $q.defer();
            defer.resolve(mockData);

            spyOn(service, 'getPlayers').and.returnValue(defer.promise);
            spyOn(service, 'getMatchHistory').and.returnValue(defer.promise);
            
            navVm = $controller('NavController', {'infoService': service});
            $rootScope.$apply();
        }));

        it('should be defined', function(){
            expect(navVm).toBeDefined();
        });

        it('should get player list', function(){
            expect(navVm.playerList.length).toEqual(2);
        });

        it('should add new player', function(){
            var len = navVm.playerList.length;
            navVm.newPlayer = {player_id: 2, name: "Test"};
            navVm.addPlayer();
            expect(navVm.playerList.length).toEqual(len + 1);
        });

        it('should remove player', function(){
            var len = navVm.playerList.length;
            navVm.removePlayer(0);
            expect(navVm.playerList.length).toEqual(len - 1);
        });

    });
})();