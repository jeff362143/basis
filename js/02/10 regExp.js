let reg = /hello world/;
console.log(typeof reg);
// object 
let flag = reg.test('hello world and bitCoin');
console.log(flag);   // true
// reg.test(str)用于判断字符串是否符合正则,返回boolean值

let telReg = /\d{3}-\d{6}/;
let telNum = "000-362143";
flag = telReg.test(telNum);
console.log(flag); 
//    /\d/用于匹配数字

reg = /\d{3,}/;
console.log("匹配结果:" + reg.test("12580"));
// regExp的test方法是用于匹配字符串的