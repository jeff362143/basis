# sys.exit()用于停止并退出程序执行

# import sys
# from sys import *
# from sys import * 这种导入法在使用时可以不使用前缀的包名

while True:
    response = input('please enter a word:')
    if (response == 'z'):
        None
    break
    # sys.exit()
    # exit()
    # exit()调用后程序就完毕退出了


'''
None是一个常量值，可代表空对象。和True，False一样需要大写
'''
# 每个函数都需要返回值，print()函数返回值就是None
returnValue = print('')
print(None == returnValue)

# end
# print函数在打印完内容后默认后面跟随一个换行符，可以通过end关键字设置默认跟随内容
print('hello', end='')
print('world')

# 字典
a = {
    'name': 'a',
    'age': 1
}
# 遍历字典的key和value两项时需要使用items()方法。只遍历一项可以不使用该方法，直接指明字典变量即可
for b,c in a.items():
    print(b)
    print(c)


# print方法打印多个变量时      默认abc变量的分隔符为一个空格字符，sep关键字可以设置分隔符
print('a', 'b', 'c', sep='xxx')

# for in遍历数组(i为数组项值,js中数组使用for in遍历有且只能遍历数组的下标)
for i in num:
    print(i)
