// 数组允许是不同类型的值
let arr = [1, "str", undefined, null, {desc: 'obj'}];
console.log(typeof arr);
// object   typeof只能很浅层的表示数据结构。无法分辨new Array()和new Date()
let arr2 = arr;
arr2[1] = "changge";
console.log(arr, arr2);
// 因为typeof arr 等于object，因此在赋值arr2 = arr时，传递的是arr地址而不是数值

