// 代理(Proxy)和特性(defineProperty)都可以实现双向绑定
// Vue2基于defineProperty,Vue3基于Proxy实现数据双向绑定


// new Proxy实例会生成一个代理对象,操作代理对象时会受到Proxy设置的限制；但是可以直接操作new Proxy准备代理的data对象，因此选择将data对象定义在函数中
let data = function() {
    let data = {
        name: 'jeff',
        desc: 'yellow lamp'
    };
    return new Proxy(data, {
        // 取值器
        get(obj, key){
            if (key === "desc") {
                console.log("secret");
                return
            }
            // 获取数据
            return obj[key];
        },
        // 赋值器
        set(obj, key, value) {
            if (key === "desc") {
                console.log("aband");
                return
            }
            // 修改数据
            obj[key] = value;
        }
    })    
}();

// 尝试修改以及读取   被代理的对象的属性值
console.log(data.desc);
data.desc = "true";






// 对象特性的设置(Object构造函数的静态方法defineProperty)
let lamp = {

}
// defineProperty设置lamp新增一个color属性,并设置它的值,是否可修改，可迭代(访问)
Object.defineProperty(lamp, 'color', {
    // 设置value
    value: 'blue',
    // 枚举项
    enumerable: true,
    // 修改项
    writable: false,
    // 配置项
    configurable: false
})

// 需要将枚举项设置为true
console.log(lamp);
