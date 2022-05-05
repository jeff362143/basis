from types import MethodType


class Person:
    def __init__(self):
        self.desc = "000"

man = Person()
woman = Person()
def set_desc(self, desc):
    self.desc = desc;
Person.set_desc = set_desc
print(dir(Person), dir(man), sep="\n")
Person.desc = "Person"
woman.desc = "woman000"
woman.set_desc('woman111')
man.desc = 'man000'
man.set_desc('man111')
print(man.desc, woman.desc, Person.desc)