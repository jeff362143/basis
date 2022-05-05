'''
MethodType就是个煞笔(有些过时的用法,类新增的方法无法指向实例)
给类新增方法很简单,   Person.desc = desc(该函数的第一个参数能指向类实例)
'''


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
