// set和map
// set
Let set = new Set([1, 2, '2', 2])
Console.log(set);   // [1, 2, '2']
// 添加数据 
  set.add('python中的set对象添加对象也是使用add')
// 删除数据
  set.delete(2)		//  python中的set对象删除数据使用的是remove
// 判断是否存在：使用has()

// 遍历set中的数据
For(let item in set) {console.log(item)}
Set.forEach(item => console.log(item))



// map(key值不允许重复)
Let map = new Map()
map.set(null, 1)
map.set([], 1)
Console.log(map);     //. {null:1, []:1}

//遍历map中的数据，方法和遍历set一样、
(尽管Set和Map实例都不是数组对象,但它们都可以使用forEach方法)
