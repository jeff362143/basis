import random

#  随机返回 1，10 之间的整数
print(random.randint(1, 10))

'''
randrange()随机返回包括1，不包括11的整数
randrange(1,11)  等价于 randint(1,10)
'''
print(random.randrange(1,11))


# random.random()随机返回0-1之间的n位小数。此为单向闭合区间[0,1)
print(random.random()*10)

# 生成[a,b]的随机浮点数
print(random.uniform(1,10))

# choice()随机取出列表参数中的一个元素
print(random.choice([1,3]))


