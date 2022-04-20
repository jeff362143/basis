'''
单引号，双引号，三引号扩起来的内容就是字符串
截取字符串片段是很常见的用法,python提供了快捷截取的语法
包括list，也是可以使用这种语法进行list截取的
'''


# 一般不用三引号表示普通string类型变量，它可以用于保持字符串样式不变
str = '''hello
world'''
print(str)  # 本质就是'hello\nworld'

'''
字符串切片截取 (编程语言截取字符串一般都是从start截取到end-1)
'''
str = 'hello world 2022-0222'

# str[:]格式为截取整个字符串
print(str[:])

# 把5作为起始项截取到末尾
print(str[5:])

# 从开头截取到end-1
print(str[:5])

# 从start截取到end-1
print(str[0:5])

# 从start截取到end-1，每隔step步伐截取一个
print(str[0:5:2])
