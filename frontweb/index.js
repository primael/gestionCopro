var express = require('express');
var path = require('path');
var http = require('http');
//var logger = require('express-logger');
var bodyParser = require('body-parser');

var app = express();

app.set('port', process.env.PORT || 80);
app.use(express.static(path.join(__dirname, 'public')));
//app.use(logger({path: "gestcopro_front.log"}));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.use(
	function (req, res, next) {
        res.setHeader('Access-Control-Allow-Origin', "http://127.0.0.1");

        res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');
        res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');
        next();
    }
);

http.createServer(app).listen(app.get('port'), function(){
	console.log("Express server listening on port " + app.get('port'));
});