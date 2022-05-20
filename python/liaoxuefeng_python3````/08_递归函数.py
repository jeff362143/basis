def add(num):
    if (num == 1):
        return num
    else:
        return num + add(num - 1)

print(add(100))