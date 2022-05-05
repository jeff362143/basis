# __slots__
# slots会限制类实例的属性设置，不会限制类本身的属性设置
class Person:
    __slots__ = ('name', 'desc')
man = Person()
man.name = 'man name'
# man.desc = "desc"   # 类实例不允许使用__slots__设定之外的属性(包括方法和成员属性)
print(dir(Person), dir(man), sep="\n")
print(man.name, Person.name, sep="\n")