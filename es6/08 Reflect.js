// reflect用于设置特性
let data = {
    desc: 'null'
}
 
Object.defineProperty(obj, 'desc', {
    value: 'undefined',
    enumerable: false
})
Reflect.defineProperty(obj, 'desc', {
    writable: false
})

// Object和Reflect设置特性的区别
/**
存在Object，为什么还要有reflect呢？
1、把散落的工具函数集中到一个统一的对象上，保持对象的简洁性。
2、Object.defineProperty设置特性会返回一个对象,如果出现异常还需要使用try catch捕获。而Reflect.defineProperty返回的是布尔值。
*/

// defineProperty和Proxy很大的一个区别是：defineProperty是直接作用于设置的对象上的,Proxy是生成一个新的代理对象