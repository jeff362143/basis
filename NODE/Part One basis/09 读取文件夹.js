let fs = require('fs');

fs.readdir('dir', function() {
    console.log(arguments)
})
// 读取文件夹下内容，存在哪些文件和文件夹


let arr = fs.readdirSync('dir');
console.log(arr);
//  异步读取文件夹dir的内容，它会将结果作为返回值返回。
// 且该次操作在console中，异步读取速度快于上面的同步读取