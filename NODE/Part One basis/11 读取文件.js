const fs = require('fs');

let data = fs.readFileSync('./10 fs.txt');
console.log(data.toString());
// 异步读取文件，可以获取文件内容为Buffer流，再用toString()方法将其转换为字符串


// fs.readFile('', function(err, data){})