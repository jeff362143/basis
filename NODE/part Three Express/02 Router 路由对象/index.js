let express = require('express');

let app = express();

let router = require('./router');

app.use(router);
//  将使用express Router便写的get请求接口引入到该服务器上

app.listen(3000);