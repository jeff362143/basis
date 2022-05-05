'''
和 map()类似，filter()也接收一个函数和一个序列。和 map()不同的时， filter()把传入的函数依次作用于每个元素，
然后根据返回值是 True 还 是 False 决定保留还是丢弃该元素。
'''

def is_odd(num):
    return num % 2 == 0

# 会map方法一样，会返回一个惰性的可迭代对象(需要使用list方法把内容计算出来)
r = filter(is_odd, [1, 2, 3, 4])
print(list(r))

