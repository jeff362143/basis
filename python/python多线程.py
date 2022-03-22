'''
https://www.cnblogs.com/Jeff362143/p/15958958.html

python的多线程依靠threading和_thread模块实现，但_thread被淘汰。只使用threading
多线程是为了同时间段运行多段代码，即并发。利用时间等待片段去干其他事。

并行一般为多处理器处理多个事件，python多进制可以实现并行。
'''

import threading
import time

# 定义一个函数
def fun(args):
    print(f'我是线程{args}')
    time.sleep(2)
    print(f'线程{args}结束\n')


'''
Thread方法参数:
函数参数可以是一个表达式。为什么设置线程时使用target=fun格式呢?也许因为线程原函数作用域存在一个target变量需要赋值发挥作用
赋值给args的必须是一个元祖,但元祖只有一个项时，需要添加逗号避免被识别为数字

执行线程操作时，不会等待t1执行完毕，而是t1传递到一个线程执行马上回到主线程
'''
t1 = threading.Thread(target=fun, args=(1,))
t2 = threading.Thread(target=fun, args=(2,))
start_time = time.time()
t1.start()
t2.start()
end_time = time.time()
print(f'\n启动两个线程花费{end_time - start_time}')


'''
输出情况:两个线程谁更快结束是一个随机事件。尽管线程1先启动，但这点时间可以忽略不计
'''


