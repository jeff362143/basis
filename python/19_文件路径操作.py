import os

# os.path.join方法用于给出单个文件路径上的文件夹和文件名，就会返回一个文件路径的字符串
print(os.path.join('document', 'readme.md'))
# document/readme.md
# 如果是windows系统,则返回document\\readme.md(多一个斜杠用于转义)

# 获取当前路径
print(os.getcwd())

# 改变该文件的当前工作目录，但只是临时性的
# os.chdir('/Users/jeff/PycharmProjects/pythonProject/demo')

# makedirs()创建新文件夹
# os.makedirs('/Users/jeff/PycharmProjects/pythonProject/newDir')

# os.path.abspath()这是一个用于将相对路径转化为绝对路径的有效方法
print(os.path.abspath('../newDir'))
print(os.path.abspath('.'))        # .即代表当前文件夹

# os.path.relpath(start, end) 将返回从satrt到end的相对路径
print(os.path.relpath('.', '/Users/jeff/PycharmProjects/pythonProject/newDir'))

# 用于将文件路径拆分为 路径和文件名，以元祖格式返回
print(os.path.split('/Users/jeff/PycharmProjects/pythonProject/demo/index.py'))

# 返回文件字节大小(注意上面chdir方法，它会改变文件当前工作内容)
print(os.path.getsize('./index.py'))

# 查看文件夹内容(返回一个list)
print(os.listdir('../basis'))




