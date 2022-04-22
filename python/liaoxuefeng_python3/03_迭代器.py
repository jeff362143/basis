# 可以使用isinstance()判断一个对象是否是迭代对象(iterable)
# 生成器(Iterator)都是迭代对象,但list,dict并不是生成器
# 可以被 next()函数调用并不断返回下一个值的对象称为迭代器(生成器)

from collections.abc import Iterable,Iterator
print(isinstance([] ,Iterable))
print(isinstance({} ,Iterable))
print(isinstance('', Iterable))
print(isinstance(10 ,Iterable))
# True True True False

# dict，list可以通过iter方法变成生成器
print(isinstance(iter([]), Iterator))
print(isinstance(iter(''), Iterator))
# True True