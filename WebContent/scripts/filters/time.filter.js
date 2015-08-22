/**
 * Created by Daedalus on 8/22/2015.
 */

(function(){

    angular
        .module('Tracker')
        .filter('time', timeFilter);

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