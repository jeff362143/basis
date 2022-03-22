let arr = [0, 1, 2, 3, 4, 5];
let arr2 = arr.reverse();
console.log(arr2);
// reverse方法用于反转数组。

let numArr = [1, 2, 3];
let numArr2 = numArr.sort(function(a, b) {
    console.log('*')
    return a - b;
    // sort方法的参数为一个函数，用于自定义数值数组的生序还是降序
    // a为2，b为1   2-1大于0不调换顺序，sort返回数组为升序（返回值大于0则调换顺序
});
console.log(numArr2);
// sort用于数字排序
// 1, 3, 2    比较步骤为   a、1&3   b、3&2  c、2&1