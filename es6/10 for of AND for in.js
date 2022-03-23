// for in在其他语言中也很常见,是ES5的语法
let num = [10 ,20]
for (let item in num) {
    console.log(item, num[item])
}

let obj = {
    num: 0
}
for (let item in obj) {
    console.log(item, obj[item])
}
// for in无法遍历map和set

console.log('********')

// for of是ES5语法
for (let item of num) {
    console.log(item)
}

// 无法遍历对象
// for (let item of obj) {
//     console.log(item, obj[item])
// }