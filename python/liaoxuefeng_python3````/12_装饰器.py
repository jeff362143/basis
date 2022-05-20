# 函数对象可以赋值给变量使用，函数对象拥有一个__name__属性，能够得到函数的名字
def now():
    print('这是now函数的打印')
f = now
# print(f.__name__)

'''
在函数调用前打印一行说明，但又不希望修改now()函数的定义，这动态态增加功能的方式，称之为“装饰器”(Decorator)
装饰器本质就是一个返回高阶函数的函数,它会返回一个新函数(该新函数存在传入函数的功能以及我们想要新增的方法)
装饰器：decorator
'''
def log(fun):
    def wrapper(*args, **kw):
        print(f'{fun.__name__}函数启动了')
        return fun(*args, **kw)
    return wrapper
# new_fun = log(now)
# new_fun()

# python的@语法可以将decorator置于函数定义处,这样的话，test变量指向的就是已经经过装饰器包装的新函数了
@log
def test():
    print('这是test函数的输出')
test()