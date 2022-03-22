fun("str", 1, {"desc": "none"});

function fun(Str, Num) {
    console.log(arguments['2']);
    console.log(typeof arguments);
    console.log(arguments["0"], arguments.length);
    // console.log(arguments.join());       非数组无法使用该数组方法
    // arguments是一个类数组对象，像数组但实质是对象

    console.log(arguments[2]);
    // 型参只有两个参数，实参的三个参数都可以获取到
}