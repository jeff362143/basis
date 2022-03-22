let num = 0;
demo: for (let i = 0; i < 5; i ++) {
    for (let j = 0; j < 5; j ++) {
        if (j == 1) {
            continue demo;
        }
        num++;
    }
}
console.log(num);

// break跳出整个j循环，而continue只是跳过整个j循环中的一小部分
// continue 也可以特殊使用用于跳出外层的循环
