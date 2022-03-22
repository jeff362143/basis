/**
 * splice方法利用参数含义可以对数组进行删除增加等操作
 * splice也是影响真实数组对象的
 * 
 * 第一个参数代表起始项
 * 第二个参数代表删除后续几个参数
 * 第三个参数+都是新增的数组参数项
 */

let arr = [0 ,'str', undefined, null, {desc: 'obj'}, [0, 1, 2]];
arr.splice(0, 1);
console.log(arr);
// 删除作用
// 参数：从start项开始删除n项

arr.splice(0, 0, 0, 1, 2);
console.log(arr);
// 插入数组项作用
// 参数：前两个参数为删除作用，第二个参数需要为0，即删除0项
// 后面参数为想要新增的数组项

arr.splice(0, 3, 0);
console.log(arr);
//  替换
//  删除掉前面三项，再新增。即起替换作用
