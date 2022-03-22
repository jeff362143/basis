let str = "hello123bit,hello362143btc";
let reg = /hello\d+/g;
console.log(str.match(reg));
//  [ 'hello123', 'hello362143' ]

// match全局匹配的应用：可用于从一大串字符串中找出符合一定规律的数据
