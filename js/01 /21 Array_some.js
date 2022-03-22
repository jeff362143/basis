// // function Array_some is used to  遍历数组

let arr = ["1", "2", "3"];
let i = 0;
let flag = arr.some(function(item) {
    // 回调函数调用次数为数组项数,item为数组项值
    console.log(`数组第${++i}项是${item}`);
});
console.log(flag);
// some方法的返回值会转换为boolean类型


// /**
//  * 值得注意的是：
//  * 
//  * 在该种多次调用用于遍历的函数，出现返回值一般意味着整个函数返回了（即中断了）
//  * 因为源码大概为：
//  * function Array_some(fun) {
//  *     for (i < arr.length) {
//  *          reutn fun();    
//  *      }
//  * }    好吧，我不会。。。。
//  *  
//  */


// function a() {
//     (function() {
//         console.log("b")
//         return;
//     })();
//     console.log("a");
// }

// a();
// b  a  内部函数return并不会影响其外面的函数

