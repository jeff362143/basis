# 双星号设置形参，实参传入字典时可以采用 字典项=值 形式(去掉**后的字符串就是字典变量名)
# 字典构造函数也可以使用该语法格式
def test(**kw):
    print(kw)
test(a=1,b=2)

# 字典类构造函数的使用
dictory = dict(a=1,b=2)
print(dictory['a'])

# 编写一个Dict类，行为与dict类一致
class Test(dict):
    def __init__(self, **kw):
        # 这样的话不就是在使用dict类???
        super(Test, self).__init__(**kw)

# super(Test, self)可以调用Test的父类

