let http = require('http');
let fs = require('fs');
let url = require('url');
// url模块用于解析url

// 定义mt对象
let mt = {
    'html': 'text/html',
    'css': 'text/css',
    'js': 'text/javascript',
    'txt': 'text/plain',
    'png': 'image/png',
    'jpg': 'image/jpg'
}

let server = http.createServer(function(req, res) {
    console.log(req.url);
    let url_obj = url.parse(req.url);
    console.log(url_obj);
    // url的parse方法可以用于解析url路径
    // 将url字符串转换为对象，拥有port，query，protocol，hash,path的字符串对象
    let extName = url_obj.pathname.slice(1).split(".").pop();
    // pop方法删除数组项是直接作用在本体上，返回值为被删除的项
    let pathName = url_obj.pathname.slice(1);
    // 为什么将/src/demo.js转换为src/demo.js格式
    // readFile的第一个参数要么使用相对路径，要么使用绝对路径且绝对路径不能加上/
    // 建议使用readFile方法第一个参数不使用斜杠， 直接使用 'src/demo.js'格式


    fs.readFile(pathName, function(err, data) {
        if (err) {
            res.writeHead(404,{"content-type": "text/plain;charset=utf-8"});
            res.end(`您获取的${extName}文件不存在`);
            // 使用res.end即代表该次服务器响应结束
        }

        res.writeHead(200, {"content-type": `${mt[extName]};charset=utf-8`});
        // console.log(data.toString());
        // 发送给浏览器的data数据是Buffer格式的，浏览器会自动进行转换   
        // 我们也可以使用toString()方法将它转换为字符串格式
        res.end(data);
    })
})

server.listen(3000);

