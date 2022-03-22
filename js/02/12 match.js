let matchObj = "helloworldAndbitCoin".match('hello');
console.log(matchObj);
// match方法会返回一个对象
// 该对象的0属性为匹配成功的字符串值，index属性为匹配到的字符串的起始下标值

console.log(matchObj["0"]);


let str = "helloworld,hellobit,hellobitCoin";
let reg = /hello/;
let arr = str.match(reg);
console.log(arr);
/**
 * 字符串match方法以regExp为参数得到的是一个对象
 * 该对象：
 * {
 *      0: 正则匹配到的字符串片段
 *      index：正则匹配到的字符串片段的起始位置
 *      input：使用该方法的字符串
 * }
 */

