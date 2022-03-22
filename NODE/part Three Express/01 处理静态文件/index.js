let express = require('express');

let app = express();

app.get('/', function(req, res) {
    res.end('hello')
})
// express编写的服务器可以轻易设置get和post的响应
// 但现在还无法获取静态资源

app.use('/', express.static('./'));
// './'下的文件被静态化，可以直接访问
// 举个例子， 设置express.static('./web/js')，这样的话/等同于访问./web/js目录，
// 静态化的文件可以直接访问，不需要像原生node设置文件MT响应行并读取文件内容返回

app.listen(3000);