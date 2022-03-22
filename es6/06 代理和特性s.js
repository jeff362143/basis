let data = function() {
    let data = {
        name: 'jeff',
        title: 'qa'
    };
    return new Proxy(data, {
        get(data, key){
            if (key === 'title') {
                console.log('不可直接获取信息');
                return
            }
        },
        set(data, key, value){
            if (key === 'name') {
                console.log('名字不可修改');
                return
            }
            data[key] = value;
        }
    })
}();

// 使用了代理的对象，获取数据和修改数据是调用get和set方法
console.log(data.title);
data.name = 'zf';
