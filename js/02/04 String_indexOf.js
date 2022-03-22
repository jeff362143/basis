/**
 * indexOf用于查找字符串中的指定字符串片段,返回start下标
 */

let str = 'gnx/btc2021_1020';
let index = str.indexOf('btc');
console.log(index);
// btc位于str的第四位

let index2 = str.lastIndexOf('btc');
console.log(index2);
// lastIndexOf为从字符串右边寻找参数字符，返回值为从左到右的位数

console.log("helloworld".indexOf('world'));