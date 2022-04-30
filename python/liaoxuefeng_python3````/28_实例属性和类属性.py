'''
类实例的属性可以通过类定义时的self和类实例直接创建:
self.desc="xxx"       student.desc="xxx"
那么如何直接给类本身绑定一个属性呢？
在类定义时直接下方声明就可以绑定,绑定后该类实例也可以访问(实例找不到该属性，就继续查找类的属性)
'''

class Student(object):
    desc = 'class Student'
#   Student类没有定义时没有创建__init__方法都没问题
xiaoming = Student()
# print(xiaoming.__init__())    # 系统默认创建该方法，只是没有显式创建它就为空
print(xiaoming.desc)
