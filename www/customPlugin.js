	var exec = require('cordova/exec');

	exports.call = function(arg0) {
		exec(null, null, "customPlugin", "call", [arg0]);
	};

	exports.sendSMS = function(arg0) {
    	exec(null, null, "customPlugin", "sendSMS", [arg0]);
    };
