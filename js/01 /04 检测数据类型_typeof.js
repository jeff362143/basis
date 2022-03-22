// typeof

console.log(typeof 362143);
// number

console.log(typeof "string");
// string

console.log(typeof true);
// boolean

console.log(typeof undefined);
// undefiend

console.log(typeof {})
// object

console.log(typeof null);
//  object  但null本质不算object

let symbol = Symbol();
console.log(typeof symbol);
// symbol也是基本数据类型🀄️的一种，可被typeof识别

