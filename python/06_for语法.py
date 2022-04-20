'''
for循环利用的是range函数，根据函数参数个数决定作用
'''

for i in range(3):
    print('for循环_demo1', i)
# 打印三次, i初始值为0，大于等于3结束循环

for i in range(1, 3):
    print('for循环_demo2', i)
# 打印二次，i初始值为1，大于等于3跳出循环

for i in range(5, 0, -2):
    print('for循环_demo3', i)
# 打印三次，i值分别为5，3，1      第三个参数代表的是步数，默认情况为1



