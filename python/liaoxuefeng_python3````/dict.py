# 双星号设置形参，实参传入字典时可以采用 = 形式(去掉**的字符串变量就是指向传入的字典)
# def test(**kw):
#     print(kw)
# test(a=1,b=2)
#
# # 字典类构造函数的使用
# dictory = dict(a=1,b=2)
# print(dictory['a'])


# 编写一个Dict类，行为与dict类一致(该类将进行单元测试)
class Dict(dict):
    def __init__(self, **kw):
        # 这样的话不就是在使用dict类???
        super(Dict, self).__init__(**kw)
    def __getattr__(self, item):
        try:
            return self[item]
        except:
            raise AttributeError(r"Dict object has no attribute '%s'" %item)
    def __setattr__(self, key, value):
        self[key] = value