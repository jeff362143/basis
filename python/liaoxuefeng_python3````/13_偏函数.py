# python函数的默认参数呢？

# functools.partial的作用就是，把一个函数的某些参数给固定住(也就是设置默认值)，返回一个新的函数，调用这个新函数会更简单
def person(name, age, salary):
    print(name, age, salary)
person('jeff', '23', '2000')

import functools
man = functools.partial(person, 'jeff')     # 调用man函数时'jeff'这个字符串默认当作person函数的第一个参数
man('24', '5000')   # person('jeff', '24', '5000')



# 练习
# 二进制转换为十进制可以使用int方法并指定进制: int(100, base=2)
# 使用偏函数默认传入base=2
int2 = functools.partial(int, 100)
print(int2())

# 有问题。。。   function.partial用法？？

