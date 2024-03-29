"use strict";

//const http = require('https');
const http = require('http');

/*
const options = {
    key: fs.readFileSync('/home/karkinen/.node-red/nodecerts/node-key.pem'),
    cert: fs.readFileSync('/home/karkinen/.node-red/nodecerts/node-cert.pem')
};
*/

const fs = require('fs');
const path = require('path');

//http.createServer(options, (request, response) => {
http.createServer((request, response) => {

    console.log('request starting...');

    var filePath = './website' + request.url;
    if (filePath == './')
        filePath = './website/index.html';

    var extname = path.extname(filePath);
    var contentType = 'text/html';
    switch (extname) {
        case '.js':
            contentType = 'text/javascript';
            break;
        case '.css':
            contentType = 'text/css';
            break;
        case '.json':
            contentType = 'application/json';
            break;
        case '.png':
            contentType = 'image/png';
            break;      
        case '.jpg':
            contentType = 'image/jpg';
            break;
        case '.wav':
            contentType = 'audio/wav';
            break;
    }

    fs.readFile(filePath, function(error, content) {
        if (error) {
            if(error.code == 'ENOENT'){
                fs.readFile('./website/404.html', function(error, content) {
                    response.writeHead(200, { 'Content-Type': contentType });
                    response.end(content, 'utf-8');
                });
            }
            else {
                response.writeHead(500);
                response.end('Sorry, check with the site admin for error: '+error.code+' ..\n');
                response.end(); 
            }
        }
        else {
            response.writeHead(200, { 'Content-Type': contentType });
            response.end(content, 'utf-8');
        }
    });

}).listen(8125);
console.log('Https server running at port 8125');
