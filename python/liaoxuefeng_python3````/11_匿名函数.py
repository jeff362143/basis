# python中使用关键字lambda表达匿名函数，冒号前面的x表示函数参数
l = list(map(lambda x: x * x, [1, 2, 3]))
print(l)
# lambda x: x*x 代表的就是 def f(x): return x*x
