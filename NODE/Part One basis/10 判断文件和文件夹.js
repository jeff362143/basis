const fs = require('fs');

fs.stat('./10 fs.txt', function(err, stat) {
    console.log(`这是一个${stat.isDirectory()? '文件夹': '文件' + "啊"}`);
    //  ${}括号中可以进行变量的运算

    // console.log('这是一个', (stat.isDirectory() ? '文件夹': '文件'));
})