/**
 * NODE可以使用req.on事件处理post请求体的数据
 * 在express中需要使用body插件来处理
 */

let express = require('express');
let body_parser = require('body-parser');

let app = express();
app.use(body_parser.urlencoded({ extended: false }));
app.use('/', express.static('./'));

app.post('/login', function(req, res) {
    console.log(req.body.username);
    res.writeHead(200, {'content-type': 'text/plain;charset=utf-8'});
    res.end('浏览器访问一个接口，接口没有响应回数据的话，浏览器会一直在转圈圈');
})
app.listen(3000);