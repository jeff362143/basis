var arr = [];
for (var i = 0 ; i <= 9 ; i ++) {
    (function (a) {
        arr[a] = function () {
            return a;
        };
    })(i);
}
// 即时调用后，i那时是1永远就是1，不会随着i之后变化而变化
console.log(arr[0]());
console.log(arr[5]());
// 立即执行函数和闭包的结合    与         for循环和闭包     结合的区别
// 这是将外层变化的i做为实参传入，而不是在闭包内部调用变化的i