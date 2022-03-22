# 文件名取名为math导致允许失败，不要使用关键字
import math

print(math.floor(1.1))
print(math.floor(-2.1))
print(math.ceil(1.1))