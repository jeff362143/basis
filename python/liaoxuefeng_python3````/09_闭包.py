# 闭包：内部函数调用外部函数的变量

num = [1, 2, 3]
f1,f2,f3 = num
print(f1, f2, f3)


def count():
    fs = []
    for i in range(1, 4):
        def f():
            return i * i    # i是变量，调用时才赋值
        fs.append(f)
    return fs


f1, f2, f3 = count()
print(f1(), f2(), f3())