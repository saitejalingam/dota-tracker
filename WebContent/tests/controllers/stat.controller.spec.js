/**
 * Created by Daedalus on 8/22/2015.
 */
(function(){

    describe('StatController: ', function(){

        var service, statVm,
            mockList = [{},{},{}];

        beforeEach(module('Tracker'));

        beforeEach(inject(function($controller, infoService, $routeParams, $q, $rootScope){
            service = infoService;
            var defer = $q.defer();
            defer.resolve(mockList);
            spyOn(service, 'getMatchHistory').and.returnValue(defer.promise);
            spyOn(service, 'getHeroes').and.returnValue(defer.promise);
            spyOn(service, 'getItems').and.returnValue(defer.promise);

            spyOn(service, 'getHeroName').and.returnValue("some_hero_name");
            spyOn(service, 'getItemName').and.returnValue("some_item_name");

            statVm = $controller('StatController', {'infoService': service});
            $rootScope.$apply();
        }));

        it('should be defined', function(){
           expect(statVm).toBeDefined();
        });

        it('should get match history', function(){
            expect(statVm.matchDetails.length).toEqual(3);
        });

        describe('should get name of ', function(){
            it('hero', function(){
                var hero = statVm.getHeroName();
                expect(typeof hero).toEqual(typeof "");
            });

            it('item', function(){
                var item = statVm.getItemName();
                expect(typeof item).toEqual(typeof "");
            });
        });

    });
})();