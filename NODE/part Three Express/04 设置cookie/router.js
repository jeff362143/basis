let express = require('express');

let Router = express.Router;
let router = new Router();

router.post('/login', function(req, res) {
    let username = req.body.username;
    res.cookie('username', username, {
        maxAge: 1000 * 60 * 60
    });

    res.writeHead(200, {'content-type': 'text/plain;charset=utf-8'});
    res.end('登陆成功');
})

router.get("/getCookie", function(req, res) {
    console.log(req.cookie);
})

module.exports = router;