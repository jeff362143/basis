let http = require('http');
let fs = require('fs');
let url = require('url');

// 定义MT对象
var MT = {
	'html': 'text/html',
	'css': 'text/css',
	'txt': 'text/plain',
	'js': 'text/javascript',
	'png': 'image/png',
	'jpg': 'image/jpg',
	'jpeg': 'image/jpeg'
}

http.createServer(function(req, res) {
    let url_obj = url.parse(req.url);
    let pathName = url_obj.pathname.slice(1);
    let extName = pathName.split(".").pop();
    // pop方法是作用于本体的，但是pathName.split("")并不会影响到pathName的值，因此pathName不变
    console.log(pathName, extName);
    let method = req.method.toUpperCase();

    //  处理login请求
    if (pathName == 'login' && method == "GET") {
        console.log("login request");
        res.writeHead(201, {'content-type': 'text/plain;charset=utf-8'});
        res.end('返回行需要content-type说明内容的格式')
        return
        // return会停止该次回调函数的继续执行
    }

    fs.readFile(pathName, function(err, data) {
        if (err) {
            res.writeHead(404, {'content-type': 'text/plain;charset=utf-8'});
            res.end('文件不存在');
            return
        }
        res.writeHead(201, {'content-type': `${MT[extName]};charset=utf-8`});
        res.end(data);
    })
    
}).listen(3000);






