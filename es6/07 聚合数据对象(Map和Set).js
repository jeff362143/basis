// set和map
// set
let set = new Set([10, 20, '2', 3])
console.log(set);   // [1, 2, '2']
// 添加数据 
  set.add('python中的set对象添加对象也是使用add')
// 删除数据
  set.delete(3)		//  python中的set对象删除数据使用的是remove
// 判断是否存在：使用has()

// 遍历set中的数据(存在)
console.log(set)
set.forEach(item => console.log(item))
console.log('***')
for (let item of set) {
  console.log(item)
}


// map(key值不允许重复)
let map = new Map()
map.set(null, 1)
map.set([], 1)
console.log(map);     //. {null:1, []:1}

//遍历map中的数据，方法和遍历set一样、
// (尽管Set和Map实例都不是数组对象,但它们都可以使用forEach方法)
