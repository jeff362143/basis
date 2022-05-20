'''
doctest可以用来测试执行注释中的代码
官方代码中常常会在注释中用给出一个输入输出方便我们理解语法，它们的例子一般是可以用doctest进行测试的吧
'''


# 下面注释测试没生效。。。
def abs(num):
    return num if num > 0 else (-num)   # python各种写法真多..
    '''
    >>> abs(5)
    51 
    '''
    if __name__ == '__main__':
        import doctest
        doctest.testmod()