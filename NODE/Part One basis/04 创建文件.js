// let fs = require('fs');
// // 引入文件模块

// fs.appendFile('04 readme.txt', "waht is the wheather today?", function(err) {
//     console.log(err);
// })


// 创建文件，引入fs模块
let fs = require('fs');
fs.appendFileSync('04 新建.txt', "hello wolrd", function(err) {console.log(err)});