// 将div#demo.box转化成<div id=’demo’ class=’box’></div>
// 利用函数思维：功能将字符串转为标签形式

let str = "div#app.center";
str = str.replace(/([a-zA-z]+)(#[a-zA-Z0-9]+)(.[a-zA-Z0-9]+)/, function(match, $1, $2, $3) {
    // console.log(match);
    // console.log($1);
    // console.log($2);
    // console.log($3);

    return `<${$1} id="${$2.slice(1)}" class="${$3.slice(1)}" /${$1}>`;
    // 单引号中调用变量的方法格式是： ${variable.toString()}，而不是${variable}.toString()
})
console.log(str);

