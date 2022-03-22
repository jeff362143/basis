// 基于arguments.length进行重载模拟

/**
 * if (argument.length == 2) {
 * } else if (arguments.legnth == 3) {
 * }
 */

function fun() {
    switch(arguments.length){
        case 1:
            console.log(1);
            break;
        case 2:
            console.log(2);
            break;
        default:
            throw new Error("参数有误");
    }
}