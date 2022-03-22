console.log(parseInt("123"));
console.log(parseInt("12ED"));
console.log(parseInt("12.12"));
// let variable = "12E12"
// parseInt(variable) 使用一个参数是将字符串转换为整数


console.log(parseFloat("12.12"));
// parseInt只能将字符串转换为整数数值，parseFloat是转换为浮点数



// parseInt
console.log(parseInt(11, 8));
// 第二个参数代表的是前一个参数的以何种进制表示，默认是10进制。
// 如上运算过程就是将8进制的11转换为10进制