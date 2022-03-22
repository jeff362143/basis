'''
匹配电话号码
[a-z][1-9]都能实现范围匹配
'''

import re

iphone = re.compile(r'1[3-9]\d{9}')
iphoneList = iphone.findall('13123456789')
print(iphoneList)



'''
用.*匹配全部字符
.可以匹配除了换行之外到所有字符
*可以匹配0-n次
'''

reg_demo = re.compile(r'.*')
strList = reg_demo.findall('ddd.')
print(strList)
# 匹配结果为['ddd', '']          不知道为什么会匹配到一个空字符串
