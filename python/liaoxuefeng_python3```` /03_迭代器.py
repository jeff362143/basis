# 可以通过for循环遍历的就是可迭代对象(dict、list)；for循环并不是指for in
# 可以使用isinstance()判断一个对象是否为可迭代对象(iterable)
# 生成器(Iterator)都是迭代对象,但list,dict等迭代对象并不是生成器

# 可以被 next()函数调用并不断返回下一个值的对象称为迭代器(生成器)
# 迭代器(iterator)对象表示的是一个数据流，我们通过next()方法不断计算得到它的下一个数据，
# 所以它是惰性的，只有在需要返回下一个数据时才会进行计算。


# 迭代对象和迭代器对象(str、{}都是常见的可迭代对象)
from collections.abc import Iterable, Iterator
print(isinstance([], Iterable))
print(isinstance({}, Iterable))
print(isinstance('', Iterable))
print(isinstance(10, Iterable))
# True True True False

# dict，list可以通过iter方法变成生成器，生成器就是迭代器
print(isinstance(iter([]), Iterator))
print(isinstance(iter(''), Iterator))
# True  True


