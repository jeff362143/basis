let str = "hellobwolrdbethCoin";
let reg = /b/;
let strArr = str.split(reg);
// reg对象可以在字符串方法中可以充当字符串参数
console.log(strArr);

str = "hellobbbworldbbbcoin";
reg = /b+/;
//      /b+/可以用于匹配多个b字符串
strArr = str.split(reg);
console.log(strArr);

// split在字符串中就是默认全局匹配的，但使用正则可以使匹配内容更灵活