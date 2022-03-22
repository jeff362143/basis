let url = "http://www.baidu.com你妹";
url = url.replace(/(www.)([a-zA-Z]+)(.com)(你妹)/, function(match, $1, $2, $3, nimei) {
    console.log(match);
    console.log($1);
    console.log($2);
    console.log($3);
    console.log(nimei);
    return $1 + "google" + $3
// 使用了回调函数，需要我们自行设置返回值

    /***
     * 在使用replace的时候，使用括号将它们包裹起来（华为一个一个分组）
     * 这样的话，在replace的回调函数中，可以通过第 2+ 个参数获取它们
     * 如果不使用括号进行分组，回调函数参数就不确定获取的是什么东西了
     * 
     * 
     * 在书写正则表达式时，可以直接使用中文
     * 
     * replace方法替换字符串中的字符，不会影响到使用该方法的字符串本体，只是以返回值返回修改后的字符串
     * 
     * 
     */
})

console.log(url);

