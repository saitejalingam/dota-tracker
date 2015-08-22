/**
 * Created by Daedalus on 8/22/2015.
 */

(function(){

    describe('Information Service:', function(){

        var httpBackend,
            infoService;

        beforeEach(module('Tracker'));

        beforeEach(inject(function($injector, $httpBackend){
            infoService = $injector.get('infoService');
            httpBackend = $httpBackend;
        }));

        describe('should get list of players ', function(){
            it('| Success', function(){

                httpBackend.expectGET('http://localhost:8080/Tracker/api/player/getPlayers').respond(200, [{},{}]);
                infoService.getPlayers().then(function(result){
                    expect(result.length).toEqual(2);
                })
            });

            it('| Error', function(){

                httpBackend.expectGET('http://localhost:8080/Tracker/api/player/getPlayers').respond(500, {});
                infoService.getPlayers().then(function(result){
                    expect(result.length).toEqual({});
                })
            });
        });

        describe('should get list of heroes ', function(){
            it('| Success', function(){

                httpBackend.expectGET('http://localhost:8080/Tracker/api/heroes/getHeroes').respond(200, [{},{},{}]);
                infoService.getHeroes().then(function(result){
                    expect(result.length).toEqual(3);
                })
            });

            it('| Error', function(){

                httpBackend.expectGET('http://localhost:8080/Tracker/api/heroes/getHeroes').respond(500, {});
                infoService.getHeroes().then(function(result){
                    expect(result.length).toEqual({});
                })
            });
        });

        describe('should get list of items ', function(){
            it('| Success', function(){

                httpBackend.expectGET('http://localhost:8080/Tracker/api/items/getItems').respond(200, [{},{},{}]);
                infoService.getItems().then(function(result){
                    expect(result.length).toEqual(3);
                })
            });

            it('| Error', function(){

                httpBackend.expectGET('http://localhost:8080/Tracker/api/items/getItems').respond(500, {});
                infoService.getItems().then(function(result){
                    expect(result.length).toEqual({});
                })
            });
        });

        describe('should get match history of player ', function(){
            it('| Success', function(){

                httpBackend.expectGET('http://localhost:8080/Tracker/api/player/{playerID}').respond(200, [{},{},{},{},{}]);
                infoService.getMatchHistory(87915734).then(function(result){
                    expect(result.length).toEqual(5);
                })
            });

            it('| Error', function(){

                httpBackend.expectGET('http://localhost:8080/Tracker/api/player/{playerID}').respond(500, {});
                infoService.getMatchHistory(87915734).then(function(result){
                    expect(result).toEqual({});
                })
            });
        });

        it('should calculate average stats', function(){

            var matchDetails = [
                {
                    player_slot: 32,
                    radiant_win: true,
                    kills: 10,
                    deaths: 5,
                    assists: 5,
                    last_hits: 50,
                    gpm: 500,
                    xpm: 500
                },
                {
                    player_slot: 128,
                    radiant_win: false,
                    kills: 10,
                    deaths: 5,
                    assists: 5,
                    last_hits: 50,
                    gpm: 500,
                    xpm: 500
                }
            ];

            var result = infoService.getAverages(matchDetails);
            expect(result.win_percent).toEqual('100.00');
            expect(result.kills).toEqual(10);
            expect(result.deaths).toEqual(5);
            expect(result.assists).toEqual(5);
            expect(result.last_hits).toEqual(50);
            expect(result.gpm).toEqual(500);
            expect(result.xpm).toEqual(500);
        });

    });
})();