# dir()方法可以获取一个类实例对象的全部属性和方法(包括它的类)
print(dir('str'))
# 类似__xxx__的属性和方法在PYTHON中都是有特殊用途的。
print('str'.__len__() == len('str'))    # 事实上，len方法本质就是去调用该传入字符对象的__len__方法
# 类的私有属性也可以通过__xxx去获取`

# 对象默认拥有的方法,hasattr方法可以判断一个对象是否有xxx属性,setattr用于获取对象属性
print(hasattr('str', '__len__'))        # True
print(getattr('str', '__len__'))
# 使用getattr方法获取一个不存在的属性会抛出错误，可以传入一个默认参数；如果属性不存在就返回默认值
print(getattr('str', 'xxx', 'no exit'))