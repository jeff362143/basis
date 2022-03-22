let reg = /a{3}/;
let reg2 = /a{3,6}/;   // 大于等于3 小于等于6
let reg3 = /a{0,}/
let reg4 = /a{0,}/;
//   a*即{0,}   出现0次或n次
let reg5 = /a{1,}/;
//   a+即{1,}   出现1次或n次

let reg6 = /ab?c/;
// ?符号即代表它前面的b字符可以出现0次或者1次      
//  它的含义应该和 b{0,1}是一致的
let flag = reg6.test('abbbc');
console.log(flag);