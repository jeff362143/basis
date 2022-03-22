// 引入express搭建服务器   npm依赖存于外层web目录
let express = require('express');
let app = express();  

app.get('/', function(req, res) {
    res.end('hello express');
})

app.listen(3000);