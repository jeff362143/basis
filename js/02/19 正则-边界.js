let str = 'hello1';
let reg = /^hello$/
let flag = reg.test(str);
console.log(flag);
// false     当存在边界符号时，代表的是匹配字符串的整体而言前后边界需要满足要求
// 类似1hello1这样的必然不能满足，不然的话/^hello$/和/hello/有什么区别？