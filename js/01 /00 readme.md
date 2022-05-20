/**
 * 此文件为该文件夹下web前端知识点的缩减版，方便记忆
 * 
 * 01   进制：0x、0，计算方式都是从最右边开始计算
 * 0xa0(16*0*0 + 16*1*a)也就是10进制的160
 * 0xa1   16的0次方*1 + 16的1次方*10
 * 
 * 02   转义字符使用要在字符串中，使用反斜杠进行转义。正斜杠是离方向键近的那一个
 * 
 * 03   使用未定义变量会显示变量not defined。使用定义但没有赋值的变量会显示结果为undifined。
 * undefined也是数据类型中的一种（没有赋值的变量值为undefined）
 * number boolean undefined string null symbol
 * object
 * 
 * 04 typeof用来检测数据类型，symbol也是基本数据类型的一种
 * 
 * 05 parseInt和parseFloat
 * parseInt默认向下取整变成整数的
 * 
 * 06 Math的random方法返回（0，1】的小数
 * Math的ceil，floor，round方法用于将小数转换为整数
 * Math的ceil方法与parseInt方法作用一样，默认都是会向下转化为整数
 * 
 * 07 switch用法示例
 * switch(variable) {
 *     case "time":
 *          console.log('time..');
 *          break;
 *     default:
 *          console.log('none');
 * }
 * 
 * 08 完整表达式后面加分号
 * let fun = function() {}; 
 * 匿名函数的值赋给fun变量，是一个完整的表达式
 * 
 * 09 函数声明提升在所有正经语言中都适用
 * 
 * 10 闭包：嵌套函数🀄内部函数使用外部函数的作用域
 * 
 * 11 数组的reverse方法反转数组
 * sort方法的最大作用就是用来排序数字数组
 * let arr = [0, 2, 1];
 * let mewArr = arr.sort(function(a, b) {
 *      return a - b;
 *      // 2 - 0大于0不调换顺序,后面的 1 - 2小于0调换顺序。
 *      // return a-b就是进行升序排列
 * })
 * 
 * arr.sort(function(a, b) { return a - b}) 就是将arr数组进行升序排序
 * 
 * 12 闭包：
 * 嵌套函数中内部函数调用外部函数的作用域。
 * 内部函数就是外部函数实例作用域下的一个函数,它的作用域就是外部函数实例
 * 
 * 13 数组的数据类型是引用类型object
 * arr1 = arr2;数组赋值时是传递地址，修改arr1的项值会影响arr2的项值
 * 
 * 14 数组的push，pop，shift，unshift方法   这几个方法都是真实伤害
 * push和shift这两个增加数组项的方法返回值是数组长度
 * pop和unshift这两个删减数组项的方法返回值是被删除的数组项
 * 
 * 15 数组的concat方法返回值为新数组
 * concat也适用于底层是数组的字符串用于连接
 * 
 * 16 数组的slice方法用于截取并返回数组,slice方法同样适用于string数据类型的变量
 * 
 * 17 splice方法常用于数组的删除，新增，替换数组项
 * splice(var1, var2, var3)
 * 第一个参数为start，是number类型，代表起始位置
 * 第二个参数为长度，number类型，代表删除数组项个数
 * 第三个以及后第n个代表新增的数组项
 * 
 * 值得注意的是，slice不会影响原数组，splice却是在原数组上进行修改
 * 
 * 18 数组的some方法用于遍历数组
 * flag = arr.some(function(item) {
 *     数组有几项就调用几次，item为数组项值
 *     some方法的返回值是一个boolean类型的值(是true还是false我就不知道了)
 * })
 */


// 17      函数参数点语法存在两种用法
let num = [1, 2, 3];
let num2 = [4, 5];
num.splice(1, 1, ...num2);
// ES6函数拓展：   函数参数点语法逆用，将数组转换为多个函数项
console.log(num);