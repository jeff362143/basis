let str = "helloworld,hello123bit,hello362143bitcon";
let reg = /hello\d+/g;
let index = str.search(reg);
let match = str.match(reg);
// 它能做到的事match方法也能做到，  match.index = index
console.log(index);
console.log(match);
// 返回匹配字符串对应的下标
// 字符串的search方法可以使用reg对象作为参数，但是无法全局匹配


