// 默认参数值
function fun(arg = 'red') {
    console.log(arg);
}
fun();
fun("skyblue");
// JS中函数重栽这个概念，ES6也还是没有。
/** fun()表达式调用fun函数时为避免出现args为undefined情况，ES6可以设置函数
值为undefeated时，给它一个默认值
*/

// ES6中可以使用。。。语法来代替函数参数
function add(...args) {
    // console.log(args);
    // args是一个数组

    // 调用累加方法
    let result = args.length && args.reduce(function(pre, item) {
        // reduce用于数组值累加
        return pre + item;
    })
    console.log(result);
}

add();
add(1, 2);
add(1, 2, 3);
add(1, 2, 3, 4);
add(1, 2, 3, 4, 5);
add(1, 2, 3, 4, 5, 6);


let arr = [0, 1, 2, 3, 4 ,5 ,6, 7, 8, 9];

// console.log(arr.copyWithin(2, 5, 8));


// 点语法逆向使用在数组上
let num = [1,2];
newNum = num.splice(0, 0, 1);
console.log(newNum)

// 实现数组的copyWithin方法(截取数组的start到end-1项，从pos项开始依次替换)
Array.prototype.icktCopyWithin = function(pos, start, end) {
    // 获取粘贴的数组
    let subArr = this.slice(start, end);

    // 调用splice方法(splice方法是会影响数组本身的)
    this.splice(pos, end - start, ...subArr);

    // 使用apply
    // Array.prototype.splice.apply(this, [pos, end - start].concat(subArr));

    // 合并成为一条语句
    // Array.prototype.splice.apply(this, [pos, end - start].concat(this.slice(start, end)));
    // 返回this
    return this;
}

console.log(arr.icktCopyWithin(2, 5, 8));


function fun(...args) {console.log(...args)}
let num2 = [1, 2, 3];
fun(...num2);
