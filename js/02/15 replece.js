let str = "helloworld,hello123bit,hello362143bitcon";
let str1 = str.replace('hello', "hi");
console.log(str1);
let reg = /hello/g;
str1 = str.replace(reg, 'hi');
// 字符串的replace方法第一个参数可以用reg对象用于匹配相应的字符串
console.log(str1);

