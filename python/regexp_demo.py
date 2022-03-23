'''
匹配电话号码
[a-z][1-9]都能实现范围匹配
'''

import re

iphone = re.compile(r'1[3-9]\d{9}')
iphoneList = iphone.findall('dwdw13123456789')
print(iphoneList)



'''
用.*可以匹配全部字符
.可以匹配除了换行之外到所有字符
*可以匹配0-n次
'''

# findall方法返回一个匹配列表
# reg_demo = re.compile(r'\d*')   \d*含义也为可匹配空字符,例如匹配ddd11时从头开始匹配,d前面默认为三个空格
reg_demo = re.compile(r'\d{1,}')
strList = reg_demo.findall('ddd11ddd222')
print(strList)
# 匹配结果为['ddd', '']          不知道为什么会匹配到一个空字符串
