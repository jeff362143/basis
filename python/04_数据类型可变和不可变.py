'''
python3数据类型
分为可变数据类型和不可变数据类型(可变指的是子项改变不影响该变量的内存地址)
'''

# 如number，string，tuple.    
num = 1
print(id(num))
num = 2
print(id(num))
# id即内存地址

# 可变指的是改变该变量的值(改变子项)，内存地址不会发生变化
numList = [1, 2, 3]
print(id(numList))
numList.append(4)
print(numList, id(numList), sep="   ")
# 改变子项的值内存地址不会发生变化
numList = [10]
print(id(numList))

