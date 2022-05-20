'''
高级语言通常都内置了一套 try...except...finally...的错误处理 机制，Python 也不例外。
所有的错误类型类都是从BaseException类派生的(command+鼠标点击可查看ZeroDivisionError源码)
'''
# 常见用法
try:
    num = 10 / 0
    print('try代码块的尾端')
except ZeroDivisionError as e:
    print('捕获到错误', e)
finally:
    print('finally')
print('end')

'''
1、expect关键字后面可以不接错误类，只要捕获到任意error就执行子语句
2、可以连续使用expect捕获不同类型的错误
3、expect可以后接else:(没有到捕获error时执行)
'''