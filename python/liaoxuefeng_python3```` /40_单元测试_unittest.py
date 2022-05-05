'''
单元测试就是对一个模块、一个函数进行测试。
比如对函数abs()进行测试:
设计测试用例,然后对以下测试用例进行测试
1、正数
2、负数
3、0
4、非数值类型None、string、boolean等
这样的话该测试模块就是一个完整的单元测试(就设计测试用例进行测试啊)
'''

'''
为了编写单元测试，我们需要引入python自带的unittest模块
通过调用unittest.TestCase类提供的方法就可以断言输出是否是我们所期望的( 最常用的断言就是assertEqual() )
以 test 开头的方法就是测试方法，不以 test 开头的方法不被认为是测 试方法，测试的时候不会被执行

执行我们编写的unittest单元测试方法:
1、在文件尾端加上 if __name__ == '__main__': unittest.main()
2、命令行运行, python3 -m unittest 40_单元测试_unittest.py 
运行结果会在终端显示运行了多少测试，时间为多少
'''
import unittest
from dict import Dict

class TestDict(unittest.TestCase):
    def test_init(self):
        d=Dict(num=1, string='test')
        self.assertEqual(d.num, 1)
        self.assertEqual(d.string, 'test')
        self.assertTrue(isinstance(d, dict))

if __name__ == '__main__':
    unittest.main()



