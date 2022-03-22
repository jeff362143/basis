/**
 *  我不懂怎么用
 */


// 引入querystirng模块
var qs = require('querystring');

// 定义query字符串
var likeQuery = 'key:value$key1:value1$key2:value2';

// 处理
var result = qs.parse(likeQuery, '$', ':');

console.log(result);

