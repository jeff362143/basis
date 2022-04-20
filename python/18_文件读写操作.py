'''
https://www.cnblogs.com/Jeff362143/p/15958549.html

文件读写
1、调用open函数，返回一个file对象
2、调用file对象的read或者write方法
3、调用对象的close方法，关闭该文件(重新调用open打开文件时，系统会自动关闭之前打开的文件)
'''
# 读取文件内容:
file = open('./input.py')
print(file.read())      # 返回字符串，与文件内容一致(空格换行都存在)\
# file调用一次read方法后想再使用readLines方法需要重新关闭再打开,否则会读取到空值
file = open('./input.py')
print(file.readlines())     # 返回list，段落换行以\n转义符表示，空行也用\n表示


# 写入内容到文件(分为写模式和添加模式)
# 写模式(第二个参数为w):
file = open('./newFile.txt', 'w')
file.write('newFile文件下已经存在其他内容。写模式下写入的文件内容,该模式会覆盖文件内容')
file.close()       # 随手关闭是个好习惯，尽管下方open再次调用时系统会自动关闭之前的打开的文件

# 添加模式(第二个参数为a):
file = open('./newFile.txt', 'a')
file.write('\n添加模式不会覆盖原文件内容，只会在尾部添加内容')
file.close()

