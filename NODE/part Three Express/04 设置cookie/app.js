//  使用cookie需要引入cookie插件


const express = require("express");
let router = require('./router');
let body_parser = require('body-parser');

let app = express();
app.use('/', express.static('./'));
app.use(body_parser.urlencoded({ extended: false }));
app.use(router);

app.listen(3000);

