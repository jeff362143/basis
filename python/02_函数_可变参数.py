# 单星号两种用法:1、函数定义时当形参 2、函数调用时引入数组
def calc(*num):
    s = 0
    for i in num:
        s = i * i + s
    print(s)
# 函数定义时型参使用*号，可以接受n个实参
calc(1, 2, 3)

# *num用于实惨，可将列表的子项转化为多个单独的参数
num = [1, 2, 3, 1]
calc(*num)


# 两个星号用法,接受字典形式参数
def fun(**param):
    print(param)
fun(a=1,b=2)        # {'a': 1, 'b': 2}