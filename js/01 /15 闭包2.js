function outer() {
    let num = 0;
    function inner() {
        console.log(num++);
    }
    return inner;
}
let inner2 = outer();
let inner3 = outer();
// 两次函数实例化占据的内存空间是不同的，但是inner2 3又都是唯一的

inner2();  
inner3();
inner3();
// 第二次调用inner3
// inner3就是一个实例化后的outer函数作用域下的函数，多次调用会影响实例outer的作用域

/**
 * 
 * output
 * 0
 * 0
 * 1
 * inner2和inner3都是一个独立的outer函数实例
 * 
 * inner函数本质就是一个实例化后outer函数作用域内的函数，同一个inner函数调用自然是使用一个作用域
 */