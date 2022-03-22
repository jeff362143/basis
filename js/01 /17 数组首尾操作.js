/**
 * 数组首尾增删都是影响实际地址数组对象的
 */

let arr = [0, 'str', undefined];
let newArr = arr.push({desc: 'obj'});
console.log(arr, newArr);
// 尾部加一数组项

newArr = arr.pop();
// 删除数组最后一项
console.log(arr, newArr);

newArr = arr.unshift(null);
console.log(arr, newArr);
// 首部加一数组项

newArr = arr.shift();
console.log(arr, newArr);
// 删除数组第一项