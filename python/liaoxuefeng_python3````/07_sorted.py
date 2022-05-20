# sorted函数对list进行排序
print(sorted([3, -2, 4, -1]))

# sorted函数也是一个高阶函数,接收一个key函数来完成自定义的排序
print(sorted([3, -2, 4, -1], key=abs))   # [-1, -2, 3, 4]


# demo
# 字母排序
# 大写Z的ascii码是比小写a来得小的，因此直接sorted进行排序的话z会在a前面
print(list(sorted(['aa', 'ZZ', 'zzz'])))
# 可以考虑将全部字符全转换为小写或者大写
# sorted是一个高阶函数，可以传入一个key函数(key函数将作用于每一个list参数上，且根据key的返回值进行排序)
print(list(sorted(['aa', 'ZZ', 'zzz'], key=str.lower)))
# 结果取反
print(list(sorted(['aa', 'ZZ', 'zzz'], key=str.lower, reverse=True)))

