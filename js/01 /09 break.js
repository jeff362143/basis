let num = 0;
demo: for (let i = 0; i < 5; i ++) {
    for (let j = 0; j < 5; j ++) {
        num++;
        if (j == 1) {
            break demo;
        }
    }
}
console.log(num);

// break特殊使用， 控制外层循环

// switch和break区别在多层循环中容易体现