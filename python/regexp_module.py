import re

# re.compile(str)方法会返回一个正则对象
# phoneNumRegexp = re.compile('\\d\\d\\d-\\d\\d\\d-\\d\\d\\d\\d')
'''
我们想表达的正则是\d\d\d-\d\d\d-\d\d\d\d，\d是正则规定的预定义符号。
为避免被识别为字符集规定的转义字符，需要使用\\来表示
更推荐使用r字符来避免被转义
'''
phoneNumRegexp = re.compile(r'\d\d\d-\d\d\d-\d\d\d\d')
# 使用search()匹配出正则表达式的模式，并返回一个match对象
mo = phoneNumRegexp.search('my iphone number is 110-120-1234')
# match对象的group方法获取电话号码
print(type(mo), mo.group())  # <class 're.Match'> 110-120-1234


# 利用括号分组
phoneNumRegexp = re.compile(r'(\d\d\d)-(\d\d\d)-(\d\d\d\d)')
# match对象
mo = phoneNumRegexp.search('my iphone number is 110-120-1234')
# mo.groud(1)匹配的是括号内匹配到的第一个内容，依次后推
print(mo.group(1))
print(mo.group(2))
print(mo.group(3))
# mo.group()和mo.group(0)返回的是匹配的全部内容
print(mo.group(), mo.group(0), sep="         ")


'''
字符| 被称为管道,  或字符
'''
songReg = re.compile(r'孤勇者|处处吻')

mo1 = songReg.search('一吻便颠倒众生《处处吻》   谁说站在光里的才算英雄《孤勇者》')

print(mo1.group())


'''
字符？实现可选匹配
'''
reg = re.compile(r'spider(wo)?man')
mo2 = reg.search('spiderman')
print(mo2.group())

'''
*表示匹配0-n次
+表示匹配1-n次
{3}
{3,5}
{,3}
'''


songReg = re.compile(r'孤勇者|处处吻')
mo1 = songReg.findall('一吻便颠倒众生《处处吻》   谁说站在光里的才算英雄《孤勇者》')
# regexp对象的findAll方法，用于找出所有匹配文本，返回一个字符串列表
print(mo1)


reg = re.compile(r'[^ab]')
# [ab]匹配到a或者b为True，[^ab]匹配到非a或非b则为True
strlLst = reg.findall('hello')
print(strlLst)