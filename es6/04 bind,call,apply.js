let obj = {
    num: 100,
    getNum: function() {console.log(this.num)}
};
let fun = obj.getNum;
fun();      // undefined
// 尽管fun是使用let定义的,意味着它不是window的属性,但fun函数中的this仍会指向window(js代码最外层都是window作用域),因此该处window.num === undefined


// bind用法(bind方法会返回一个函数,第一个参数用于指明该函数的作用域,无论该函数在哪里执行,它的作用域已经在声明该函数时通过函数参数指定了).    Bind方法第一参数后面可以再传入n个参数作为调用bind函数的参数,它与call很相似,最大的区别就是call传入参数必须使用数组一次性传完
Let fn = getNum.bind(obj);
fn(); 	// 100
Obj.num = 200;
fn();   // 200, fn函数作用域是obj

// call方法使用与bind一致,只是getNum.call(obj)表达式是将getNum放在obj作用域下执行一次，而不是bind方法返回一个函数。且传入参数时需要一次性使用数组传入。

// apply方法(apply用法与call基本一致,只是传入函数参数时允许多次传入)