let obj = {
    desc: 'git add'
};
obj.desc = "git commit";
// 当不知道存在desc这个属性时，容易再次定义赋值。导致之前的desc属性被覆盖

let s1 = Symbol();
let s2 = Symbol('fox');
console.log(typeof s1, typeof s2);   // symbol  symbol

//  symbol是独一无二的
obj[s1] = "symbol";
obj[s2] = "symbol_fox";
// for in 遍历 obj
for (let i in obj) {
    console.log(i);
}
// console只打印出desc, 使用symbol做为值的属性无法被遍历打印

console.log(obj[s1], obj[s2]);//  symbol  symbol_fox
// 因为s1，s2并不是字符串，而是symbol类型。因此在之后定义中一般不会覆盖掉它




// 该方法可以遍历对象基本类型为symbol的属性
let keys = Object.getOwnPropertySymbols(obj);  //  [Symbol(), Symbol('fox')]
// 该方法能帮助我们获取对象中存在的Symbol属性的值并返回到一个数组中
// demo:
s1 = Symbol();
s2 = Symbol();  
obj = {[s1]: 1, [s2]: 2}
keys = Object.getOwnPropertySymbols(obj);   //   [Symbol(), Symbol()]
console.log(obj[keys[0]], obj[keys[1]]);    //  1, 2       必须使用数组变量,因为获取到的数组项尽管都是Symbol()，但每一个Symbol()的返回值都是不一样的。使用Symbol设置属性时,不要设置Symbol参数相同或者都为空，容易迷惑自己和他人