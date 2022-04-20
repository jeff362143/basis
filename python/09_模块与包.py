'''
导入系统定义的模块，如import random，导入和使用前面是不需要加包名的
但是如果是我们自定义的包，导入和使用都是需要在前面加上包名的

模块就是一个.py文件，包就是一个文件夹
'''
# 引入demo包下的demo_module模块并运行它的demo方法
import demo.demo_module

demo.demo_module.demo()


import sys       # sys是包名,调用内部方法 sys.method
# from sys import * 这种导入法在使用时可以不使用前缀的包名
while True:
    response = input('please enter a word:')
    if (response == 'z'):
        # sys.exit()用于停止并退出程序执行
        sys.exit()
        None
        # exit() 
    break