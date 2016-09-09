/**
 * Created by cuter74 on 2016. 9. 9..
 */

var exec = require('cordova/exec');

function Adbrix(){}

Adbrix.prototype.endSession = function(callback) {
    exec(callback,function(err){console.log("adbrix error!");},"Adbrix","end",[]);
};

Adbrix.prototype.menuName = function (menuName,callback) {
    exec(callback,function(err){console.log("adbrix error!");},"Adbrix","menuName",[menuName]);
}
var adbrix = new Adbrix();
module.exports = adbrix;