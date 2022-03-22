/**
 * url模块用于解析url为一个对象，方便使用
 * 
 * readFile回调函数第一个参数为err，方便处理错误
 * 那么使用异步readFileSync如何处理错误？
 * 
 * path模块用于处理位于某一路径的文件 （home/js/index.js这种类型的字符串)
 * 
 * ajax请求（XMLHttpRequest）
 * 
 */


// 原生ajax
function ajax() {
    let xhr = null;
    if (window.XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        throw new Error('您的浏览器过于古董，不支持网络请求')
    }
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            console.log(xhr.responText);
        }
    }
    xhr.open('GET', '/login');
    xhr.send();
}
// xhr.send('{"username": "jeff"}');
// jquery的ajax
$.ajax({})



