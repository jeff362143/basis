let http = require('http');

// express()的本质就是调用http.createServer()
http.createServer(function(req, res) {
    // 状态码必须是符合规范的响应状态码
    // res.writeHead(200, { 'Content-Type': 'text/plain;charset=utf-8' });
    res.writeHead(200, {'Content-Type': 'text/plain;charset=utf-8'})
    res.end('hello!');
}).listen(3001);


