let reg = /[abc]/;
// []：  字符串匹配到中括号中任意一个字符则匹配成功
let flag = reg.test("a362143");
console.log(flag);   // true


let reg2 = /web3.0[abc]coin/;
let str = "web3.0acoin,hello,world,web3.0bcoin";
flag = reg2.test(str);
console.log(flag);
// [abc]： 字符串匹配到abc三个字符中其中一个就匹配成功

// 组合类
let reg3 = /[a-zA-Z]/;
// [a-Z]可以匹配全部字母，但是也会匹配到一些其他字符
flag = reg3.test('s');
console.log(flag);


// 负向类
// ^只能使用在[]中，[]代表或，因此使用^后变成且
reg4 = /[^A-Z]/;
//  [^A^B...^Z]
// 含义为既不能为A也不能为B，而不是理解为Z满足^A则为真
// 中括号为或的意思，但是加上了^就变成了且的意思。离散数学中的逻辑数学？
flag = reg4.test("zZ");
//  匹配到非大写字母则为true，大写Z不影响结果
console.log(flag);

reg5 = /[^abc]/;
//  在中括号使用^都是连续的，[^abc]: [^a^b^c]含义为匹配到abc外字符就为true
flag = reg5.test('b');
console.log(flag);
