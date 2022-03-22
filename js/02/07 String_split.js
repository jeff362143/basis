let str = 'gnx/btc2021_1020';
let arr = str.split('');
console.log(arr);
// split方法可以将字符串以参数为间隔符拆分为数组
// 每个字符间都会有空字符""



// 当split参数为regExp时
arr = str.split(/02/);
console.log(arr);
// 结果arr转换为了有三个项的数组，即分割了str两次。
// 说明了split方法默认为全局匹配的，不需要设置regExp的修饰符为全局g