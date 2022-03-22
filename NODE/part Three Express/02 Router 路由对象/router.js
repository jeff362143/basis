let express = require('express');

let Router = express.Router;
let router = new Router();

router.get('/login', function(req, res) {
    res.writeHead(200, {'content-type': 'text/plain;charset=utf-8'})
    res.end('express Router 响应get请求');
})

module.exports = router;
// 将该js文件整个导出，以router变量名导出