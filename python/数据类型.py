'''
python3数据类型
分为可变数据类型和不可变数据类型
'''

# 不可变指的是改变该变量的值会导致生成一块新内存地址
# 如number，string，tuple.tuple元祖重新赋值的话地址就发生了改变,子项又不可改变,故我把它归纳到不可变
num = 1
print(id(num))
num = 2
print(id(num))
# id即内存地址不一致了

# 可变指的是改变该变量的值(改变子项)，内存地址不会发生变化
numList = [1, 2, 3]
print(id(numList))
numList.append(4)
print(numList, id(numList), sep="   ")
# 改变子项的值内存地址不会发生变化，不可以重新赋值
numList = [10]
print(id(numList))

