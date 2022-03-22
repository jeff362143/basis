'''
单引号，双引号，三引号扩起来的内容就是字符串
'''

# 一般不用它表示普通string类型变量，它可以用于保持字符串样式不变
str = '''hello
world'''
print(str)

'''
字符串切片
'''
str = 'hello world 2022-0222'

# str[:]格式为切掉整个字符串
print(str[:])

# 把5作为起始项截取到末尾
print(str[5:])

# 从开头截取到end-1(5-1)
print(str[:5])

# 从start截取到end-1
print(str[0:5])

# 从start截取到end-1，每隔step步伐截取一个
print(str[0:5:2])

