/**
 * Created by cuter74 on 2016. 9. 9..
 */

var exec = require('cordova/exec');

function Adbrix(){
    var menuName = function (menuName,callback) {
        exec(callback,function(err){console.log("adbrix error!");},"AdBrixPlugin","menuName",[menuName]);
    }
}

Adbrix.prototype.endSession = function(callback) {
    exec(callback,function(err){console.log("adbrix error!");},"AdBrixPlugin","end",[]);
};

var adbrix = new Adbrix();
module.exports = adbrix;