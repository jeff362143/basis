# 调试最常用手段就是在打印变量的值查看

# 1、通过assert来辅助查看变量值(了解一下)
# num=input()
# num=int(num)
# assert num != 0, 'num is zero'
# num!=0时不会发生什么，num=0时抛出AssertionError:num is zero

# 2、使用ide自带的调试工具
# 设置一个断点，慢慢debug

# 3、logging模块调试错误
import logging
logging.basicConfig(level=logging.INFO)
num=input()
num=int(num)
logging.info('n = %d' %num)
print(10 / num)
