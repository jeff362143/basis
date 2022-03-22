// 解构赋值只是浅拷贝，只能拷贝值，不能拷贝地址
// 解构赋值只是赋值，在原对象基本属性修改后需要再次赋值

let obj = {
	num: 100,
	color: 'skyblue',
	getColor: function() {
		console.log(this);
		return this.color;
	}
}

// 解构对象
let { num, color, getColor } = obj;
obj.color = 'red';
console.log(color);
console.log(getColor()); 	// 打印window对象，而不是obj

// 注： 解构赋值是浅拷贝，无法用于对象

obj = {
	color: 'red',
	num: 1,
	obj: 'none',
	fun() {
		
	},
	name: 'jeff'
};

// 以...keys代表剩余全部参数
let { fun, name, ...keys } = obj;
console.log(name, keys)
let obj2 = keys
// 逆解构赋值
console.log(obj2);


