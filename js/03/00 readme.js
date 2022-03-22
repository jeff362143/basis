/**
 * 01 replace
 * 需要对匹配到的内容进行较复杂的替换，replace不使用函数参数时一般是进行简单的局部替换。
 * 使用函数时常常用进行较复杂的替换
 * 
 * replace方法第一个参数为regExp对象时，第二个参数可以为一个函数
 * str.replace(/baidu.([a-z]*)/, function(match, $1) {})
 * 这个方法与regExp配合使用，reg内被扩起来的内容会第一个之后的参数匹配到
 * 详见  ./ 01 replace进阶
 * 
 * 返回值就是新的str值
 * 
 * let str = "hello362 world143";
    let str = "hello362 world143";
    let reg = /(\w{1,}\d{1,})/g;
    str = str.replace(reg, function(match, $1, $2) {
        console.log($1);
    return "hzf"
    });
    console.log(str);    
 * 
 * 03 arguments
 * arguments类数组对象，可以通过arguments[n]获取函数的每一个实参
 * 
 * 04 函数重载
 * 重载即函数名字一样，参数个数或者类型不一样
 * js中，没有函数重载这个概念
 * 
 * 05 函数即时调用
 * 常用的即时调用 (function(){})();
 * 另一种 let fun = function(){}()。  
 * 第二种方式只是相对常用方式少了一个括号，在表达式中它是合理的，但在第一种的非表达式中，它是不合法的，会报错
 * 
 * (function() {})()
 * let fun = function(){}()
 */