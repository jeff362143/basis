'''
切片:可切list、tuple、string
'''

# 元祖切了也还是元祖,元祖本质就是不可变的list
numTuple = (1, 2, 3, 4)
numTuple = numTuple[:2]
print(numTuple)

'''
可迭代对象:可以通过迭代器访问全部属性的对象就是可迭代对象。
for in可以用于遍历可迭代对象(包括有下标的list和无下标的dict)
'''
