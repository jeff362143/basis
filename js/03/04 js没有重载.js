// 函数重载即函数名相同，参数个数或类型不同
// js中函数名相同即为同一函数，不存在重载概念

fun();
// 2
// 多个同名函数存在，调用顺序在后边的

function fun() {
    console.log(1)
}

function fun(a) {
    console.log(2)
}