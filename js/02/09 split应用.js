// 将hello wolrd and btcCoin转换为每个单词首字母大写

let str = "hello world and btc";
let strArr = str.split(" ");
console.log(strArr);
// 以空格字符为分隔符将字符串转换为数组
for(let i = 0; i < strArr.length; i ++) {
    strArr[i] = strArr[i].charAt(0).toUpperCase() + strArr[i].slice(1);
}
console.log(strArr);

// slice既可以用于数组截取作用，也可以用于字符串截取作用
// 同时的话，substr和substring也可以用于字符串截取作用