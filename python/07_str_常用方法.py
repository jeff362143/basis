# 转义
str = "live in earth \\a"
print(str)          # live in earth \a
# 使用r符号可以避免转义。\a \n 这两个字符被避免转义了
str = r"live in earth \a \n"
print(str)

# 统计'earth'在字符串变量str中的出现次数
times = str.count('earth')
print(times)

# 查找字符串变量str中是否有earth字符串片段，有则返回start值，无则返回-1
print(str.find('earth'))

# replace替换方法(将替换结果返回,非直接作用)
str2 = str.replace('earth', 'magic')
print(str2)

# split分割字符串方法

# 字符串的index方法，与find方法一样。只是如果没有匹配到对应字符串片段，会返回异常。不建议使用

# 列表的join方法，列表连成字符串