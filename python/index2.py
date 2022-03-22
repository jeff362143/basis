'''
isinstance()
'''
# 获取绝对值
def my_dbs(x):
    if not isinstance(x, (float, int)):
        raise TypeError('argument type must be float or int')
    elif x < 0:
        return -x
    else:
        return x

print(my_dbs(-10))
print(my_dbs(10))



'''
除法
python中10 / 3 会返回浮点数3。33333333333333
使用//可得到整数       10 // 3 == 3
'''
