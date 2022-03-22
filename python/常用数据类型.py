# https://www.cnblogs.com/Jeff362143/p/15949852.html


'''
list
'''
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

'''
tuple 元祖
'''
numTuple = (0, 1, 2)
# 元祖不允许子项的指向地址发生改变，即子项为基本类型时值不可变
# 像打印列表一样打印
print(numTuple[1])

'''
set
set使用{}定义，而不是[]
'''
# 可以将数组转化为set
numList = [1, 1, 2, 3, 4]
numSet = set(numList)
print(numSet)
# 也可以将set转化为数组
numList = list(numSet)
print(numList)

# 直接定义set
numSet = {1, 1, 2, 2, 3, 4}
print(numSet)

'''
新增和删除set中的值
list使用append,insert,pop crud
set使用add和remove
'''
numSet.add(5)
print(numSet)
numSet.remove(1)
print(numSet)

'''
dictory 字典
'''
dict = {
    'name': 'f',
    'desc': 'looking'
}
# 读取字典的key项值可以直接读取也可以使用get方法
print(dict.get('name'), dict['name'], sep="         ")
# 遍历，新增和删除字典项
dict['id'] = '001'
print(dict)
for key, value in dict.items():
    print(f'{key}:{value}')
dict.pop('name')
print("******分隔符******")
for key, value in dict.items():
    print('{}:{}'.format(key, value))


