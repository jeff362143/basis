// 箭头函数
let arrow = () => {
    console.log("arrow function");
};
arrow();

// 省略(),只写单个参数
let arrow2 = msg => {
    console.log(msg);
};
arrow2('hello world');

// 数组的map方法,map返回值是一个新数组:传入参数为函数,新数组子项为原数组子项作为函数参数调用函数后得到的值
let num = [1, 2, 3];
let newNum = num.map( (item) => { return item * item });
console.log(newNum);
// 省略版的写法,可省略return
// newNum = num.map(item => item * item);


// 箭头函数无法使用arguments
let fun = (...args) => {
    console.log(arguments);
    // 获取到的arguments对象并不是函数参数，好像获取了一个和node有关的arguments对象
    console.log(args);
}
fun(1, 2, 3);
// 正常函数获取arguments对象
function fun2(...args) {
    console.log(arguments);
    console.log(args);
}
fun2(1, 2, 3);



// 定义构造函数 
let Player = function Player(x, y) {
    this.x = x;
    this.y = y;
    // 设置它的x属性和y属性
};
Player.prototype.getPosition = function() {
    return {
        x: this.x,
        y: this.y
    }
}

let player = new Player(10, 20);
console.log(player);    //  console结果  Player {x;10 y:20}
console.log(player.getPosition());

// 箭头函数的this指向
// 普通函数的this会指向它的直接调用者,但箭头函数指向它的父级作用域(一般都是window)



// this指向
let demo = function() {
    // 'use strict';
    // 严格模式下，this会指向undefined。'use strict'只能在某一个作用域下第一行才能生效

    console.log(this);
    // node中this指向global对象，浏览器运行时指向window
}
demo();

