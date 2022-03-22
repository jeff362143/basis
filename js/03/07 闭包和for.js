var arr = [];
// 引用数据类型
console.log(typeof arr);
// 数组中可以保存任何数据类型，保存10个函数
// 通过遍历存放
for (var i = 0 ; i <= 9; i ++) {
    arr[i] = function () {
        return i;
    };
}
// arr[i] = function() { return i }
// arr[i]中的i被立即执行了，函数中的i不会被马上执行

console.log(arr);
console.log(i);
// 读取数组中任何一项
console.log(arr[0]);
console.log(arr[0]());
console.log(arr[1]());

//  这几个闭包函数是同在for作用域下的，它们使用的是同一个作用域的变量