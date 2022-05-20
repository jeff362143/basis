# 单星号两种用法:1、函数定义时当形参，可接收多个参数 2、*数组名可以将数组转化为多个单项

# 1
def calc(*num):
    s = 0
    for i in num:
        s = i * i + s
    print(s)
# 函数定义时型参使用*号，可以接受n个实参
calc(1, 2, 3)

# 2
num = [1, 2, 3, 1]
calc(*num)


# 两个星号作型参用法, 可以接受字典形式参数
def fun(**param):
    print(param)
fun(a=1,b=2)        # {'a': 1, 'b': 2}