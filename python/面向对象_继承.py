'''
类就是对具有相同方法和属性的对象的总称
面向对象三大特性：继承封装多态
在python语言中，封装表现的不明显，没有private，protected这些关键字来封装类
多态在python中也是很弱的形态。同一个接口在不同实例下执行不同的操作。如：猫和鱼继承动物类的eat接口会有不同的eat，work行为。
'''

class RichMan:
    # self指向创建的对象实例,__init__方法用于初始化对象
    def __init__(self, money):
        # self.__money将money属性设为私有属性
        self.__money = money
    # 每一个对象方法第一个参数都是指向创建的对象实例
    def showMoney(self):
        print('我有{}'.format(self.__money))

# 子类继承父类
class RichChild(RichMan):
    # pass
    def showMoney(self):
        print('我家里有{}'.format(self.__money))    # RichChild实例并没有money这个私有属性

f = RichChild(5000000)
#  f.showMoney()  报错,因为父类的私有属性无法被继承


# 严格来讲,python的私有属性也是不完全隐蔽的。   me.RichMan__money可以访问私有属性money
me = RichMan(1000000)
print(me._RichMan__money)
