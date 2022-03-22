/**
 * slice有三种方式进行数组的截取，根据情况自行搭配
 */

let arr = [0, 1, 2, 3, 'str', undefined, null];
let slicedArr = arr.slice(0, 4);
console.log(slicedArr);
// slice参数：
// 从start截取到end，不包括end项

let arr2 = arr.slice(0, -1);
console.log(arr2);
// slice参数第二项可以为负数
// 不包括end项，即-1不会包括最后一项

let arr3 = arr.slice(1,);
console.log(arr3);
// slice(1,)这种写法也是被允许的




