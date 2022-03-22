let num = [0, 1, 2, 3, 4, 5];

num.sort(function(a, b) {
    return a - b;
    // 注意： 在sort方法的函数参数中，参数a变量值是1，为数组第二位的值，b值为0
    // 大于0则不会调换顺序   
});
console.log(num);

num = num.reverse();
console.log(num);
num.sort(function(a, b) {
    console.log("1");
    // sort内部调换几次应该是根据情况而定的，明面上调用次数为数组个数减一
    return a - b;
})
console.log(num);

/**
 * 以目前水平，sort只用于数组排序，尽量不要使用在其他地方。
 */