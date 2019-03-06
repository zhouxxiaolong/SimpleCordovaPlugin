var exec = require('cordova/exec');

exports.startNewActivity = function (arg0, success, error) {
    exec(success, error, 'SimplePlugin', 'startNewActivity', [arg0]);
};
