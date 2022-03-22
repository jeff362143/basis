// node管理模块使用的是commonjs规范
let descObj = require('./01 index');
let http = require('http');
console.log(typeof http);
console.log(descObj);

// commonJs规范使用require导入 ./index , index文件使用module.exports导出