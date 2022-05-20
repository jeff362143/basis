# https://www.cnblogs.com/Jeff362143/p/15949852.html
'''
crud:
list使用append(附加),insert,pop(取出)
set使用add和remove
'''

# list
numList = [1, 2, 3, 4]
numList.append(5)
# 1, 2, 3, 4, 5
numList.insert(0, 0)
# 0 1 2 3 4 5
numList.pop()
# 0 1 2 3 4
numList.pop(0)
# 1 2 3 4
print(numList)

# tuple 元祖
numTuple = (0, 1, 2)
# 元祖不允许子项的指向地址发生改变，即子项为基本类型时值不可变
# 像打印列表一样打印

# set使用{}定义，而不是[]
# 可以将数组转化为set
numList = [1, 1, 2, 3, 4]
numSet = set(numList)
print(numSet)
# 也可以将set转化为数组
numList = list(numSet)
print(numList)

# 定义set
numSet = {1, 1, 2, 2, 3, 4}
print(numSet)
numSet.add(5)
print(numSet)
numSet.remove(1)
print(numSet)

# dictory 字典
dict = {
    'name': 'f',
    'desc': 'looking'
}
# 读取字典的key项值可以直接读取也可以使用get方法
print(dict.get('name'), dict['name'], sep="         ")
# 遍历，新增和删除字典项
dict['id'] = '001'
# 遍历字典key和value两项子项时需要使用items()方法。只遍历一项可以不使用该方法，直接使用字典变量即可
for key, value in dict.items():
    print(f'{key}:{value}')
dict.pop('name')
print("******分隔符******")

for key, value in dict.items():
    print('{}:{}'.format(key, value))


