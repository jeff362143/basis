'''
占位符的话,py有三种方法可以使用
'''
PI = 3.1415926
num = 10

# 1
print(f"PI的值{PI:.3}")

# 2
print("PI的值{:.3}".format(PI))

# 3
print("PI的值%.2f" %(PI))
print("引用整型%d" %(num))
