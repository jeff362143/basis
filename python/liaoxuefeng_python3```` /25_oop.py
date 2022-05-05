'''
私有属性:变量名前面使用两个下划线 __ 即可定义私有属性
但python不够严谨,私有属性__name可以通过实例的_Student__name属性访问到。
变量名前后都有两个下划线代表的是特殊变量，是可以访问的
'''

# 最基本的类，继承object类
class Student(object):
    def __init__(self, name):
        self.__name = name

    def introduction(self):
        print(self.name)


#  继承
class Pupil(Student):
    pass


xiaohuang = Student('xiaohuang')
xiaohuang.introduction()

# 子类继承父类相关的初始化方法和其他方法
xiaoming = Pupil('xiaoming')
xiaoming.introduction()

# isinstance用于判断数据类型(类实例也是一种数据类型)
# 父类实例不能兼容子类
print(isinstance(xiaohuang, Pupil))
# 子类实例可以兼容父类(小学生一定是学生，学生不一定是小学生；有助记忆)
print(isinstance(xiaoming, Student))

# isinstance判断不灵活(需要知道相关类进行判断),type方法打印它的类
print(type(xiaoming))   # pupil，Pupil类是继承Student类的，但是type()只能识别到他最近的类
print(type('hehe'))
def fun():{}
print(type(fun))


