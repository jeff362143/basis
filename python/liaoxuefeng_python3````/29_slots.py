from types import MethodType


class Student(object):
    pass

# 给类实例新增方法(不可以像属性成员一样直接赋值，需要使用MethodType方法)
# def set_score(self, score):
#     self.score = score
#
# student.set_score = MethodType(set_score, student)
# student.set_score(90)
# print(student.score)

# 给类新增方法(实质是作用在类上，下方的self是指向类而不是实例😅😅😅,而该方法写在类中self指向类实例)
def set_score(self, score):
    self.score = score
Student.set_score = MethodType(set_score, Student)
student = Student()
student2 = Student()
student.score = 99.5
student.set_score(90)
print(student.score)
