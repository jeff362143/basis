def calc(*num):
    s = 0
    for i in num:
        s = i * i + s
    print(s)
'''
函数形参使用*num，可以用于表示n个实惨
'''
calc(1, 2, 3)


'''
*num用于实惨，可将列表的子项转化为多个单独的参数  
'''
num = [1, 2, 3, 1]
calc(*num)

