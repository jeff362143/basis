'''
成员属性的创建和新增：
类实例属性的创建：
1、类定义时创建    self.desc="xxx"
2、类实例创建后添加  student.desc="xxx"

那么如何直接给类本身绑定一个属性呢？
1、定义类时直接写
2、类定义好后直接   类名.属性
'''
class Student(object):
    desc = 'class Student'  #定义在类本身的属性
xiaoming = Student()
print(xiaoming.desc)


'''
方法属性的创建和新增：
MethodType可以新增类和实例属性，但它就是个煞笔(我不太了解它,使用它给类新增的方法无法指向实例，暂时不要使用它)
直接类名.方法 = 函数就可以给类新增属性方法了
'''
class Person:
    def __init__(self):
        self.desc = "000"

man = Person()
woman = Person()

def say_hello():
    print("helloWorld")

def set_desc(self, desc):
    self.desc = desc
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
