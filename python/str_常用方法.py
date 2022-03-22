str = "live in earth \\a"
print(str)          # live in earth \a

# 使用r符号可以避免转义。\a \n 这两个字符被避免转义了
str = r"live in earth \a \n"
print(str)

# 统计'earth'在字符串变量str中的出现次数
time = str.count('earth')
print(time)

# 查找字符串变量str中是否有earth字符串片段，有则返回start，无则返回-1
print(str.find('earth'))

# replace替换方法

# split分割字符串方法

# 字符串的index方法，与find方法一样。只是没有对应字符串片段，会返回异常。不建议使用

# 列表的join方法，列表连成字符串