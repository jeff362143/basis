# python内建reduce和map函数

# map函数接收两个参数，一个是函数，一个是Iterable，map将函数依次作用于可迭代对象的每一个列，返回一个新的Iterable
from functools import reduce


def f(x):
    return x * x
r = map(f, [1, 2, 3])   # r是一个map对象
print(list(r))
# 由于结果 r 是一个 Iterator，Iterator 是惰性序列，因此通过 list()函数让它把整个序列都 计算出来并返回一个 list(书中原文)

# 利用map把全部数字转换为字符串格式
nums = map(str, [1, 2, 3])
print(list(nums))


# reduce方法
# reduce 把一个函数作用在一个序列[x1, x2, x3, ...] 上，这个函数必须接收两个参数，reduce 把结果继续和序列的下一个元 素做累积计算，
# reduce(f, [x1, x2, x3]) = f(f(x1, x2), x3)
from functools import reduce
def add(x, y):
    return x + y
print(reduce(add, [1, 2, 3]))