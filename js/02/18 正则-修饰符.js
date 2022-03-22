// g表示全局匹配
// i表示对大小写不敏感
// ig可以同时书写

let reg = /helloWorld/i;
let flag = reg.test("HELLOwORLD");
console.log(flag);