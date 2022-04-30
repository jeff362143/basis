'''
切片:可切list、tuple、string
'''
# 元祖切了也还是元祖,元祖本质就是不可变的list
numTuple = (1, 2, 3, 4)
print(numTuple[:2])
print(numTuple[2:])
'''
可迭代对象:可以通过for循环访问全部属性的对象就是可迭代对象。
for in可以用于遍历可迭代对象(包括有下标的list和无下标的dict)
python的for in本质就是通过不断调用迭代对象的next方法的(这句话有点矛盾啊，这样的话全部的可迭代对象就都是迭代器了)
'''

