'''
类实例的属性可以通过类定义时__init__方法中的self和创建好的类实例直接创建:
self.desc="xxx"       student.desc="xxx"

那么如何直接给类本身绑定一个属性呢？
在类定义时直接下方声明就可以绑定,绑定后该类实例也可以访问(实例找不到该属性，就继续查找类的属性)
类没有__init__方法也没事
'''
class Student(object):
    desc = 'class Student'  #   定义在类本身的属性
xiaoming = Student()
# print(xiaoming.__init__())    # 系统默认创建该方法，只是没有显式创建它就为空
print(xiaoming.desc)


'''
MethodType就是个煞笔(我不太了解它,使用它给类新增的方法无法指向实例，暂时不要使用它)
给类新增方法属性很简单,  Person.desc = desc(该函数的第一个参数能指向类实例)
'''
# 动态新增方法
class Person:
    def __init__(self):
        self.desc = "000"


man = Person()
woman = Person()


def say_hello():
    print("helloWorld")


def set_desc(self, desc):
    self.desc = desc;


# 类新增方法
Person.set_desc = set_desc
# 实例新增方法
man.say_hello = say_hello
man.say_hello()
print(dir(Person), dir(man), sep="\n")
Person.desc = "Person"
woman.desc = "woman000"
woman.set_desc('woman111')
man.desc = 'man000'
man.set_desc('man111')
print(man.desc, woman.desc, Person.desc)
