# 调试最常用手段就是在打印变量的值查看

# 1、通过assert断言来辅助查看变量值(了解一下)
# num = input()
# num = int(num)
# assert num != 0, 'num不允许为0'
# 断言num不为0，断言失败的话即num=0时抛出      AssertionError:num不允许为0

# 2、使用ide自带的调试工具
# 设置一个断点，慢慢debug

# 3、logging模块调试错误
import logging
logging.basicConfig(level=logging.INFO)
num=input()
num=int(num)
logging.info('loggin信息: n = %d' %num)
print(10 / num)
'''
logging.info可以输出信息到控制台以及文本
这就是 logging 的好处，它允许你指定记录信息的级别，有 debug，info， warning，error 等几个级别
'''