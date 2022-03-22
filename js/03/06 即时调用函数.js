// 即时调用函数又名IIFE？

let fun = function a() {
    console.log(1);
}();
(function b() {
    console.log(2);
})();
// 即时函数使用的两种方式

// a();
// b();
// 两者调用上面的即时函数都会报错，因为即时函数作用域只在其内部