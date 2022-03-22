let index = require('./01 index');
console.log(index);
let num = require('num');
console.log(num);

// let http = require('http');
// http.createServer(function(req, res) {
//     req.writeHead(200, {"Content-type": 'text/plain;charset=utf-8'})
// }).listen(3000);

let fs = require('fs');
// fs.appendFile('00 test.txt', "this is a useless file that created by node runtime", function(err) {console.log(err)});
// // fs.unlink("./00 test.txt", (err) => {console.log(err)});
// fs.rename('00 test.txt', "00 test1.txt", (err) => { console.log(err) });

fs.mkdir('00 文件夹', err => { console.log(err) });
// fs.rmdir('00 文件夹', err => { console.log(err) });
const content = fs.readdirSync('00 文件夹');
console.log(content);

fs.stat('00 文件夹', function(err, stat) {
    console.log(stat.isDirectory());
})

let bufferContent = fs.readFileSync('00 test1.txt');
console.log(bufferContent.toString());