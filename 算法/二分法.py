'''
二分法 时间复杂度为   log2（x）
在有序排序列表，最多log2（x）可找出目标项

如果采用一个一个数的话，这种行为运行时间为 O(N)
如果采用二分法的，运行时间为log2(N)

[0 , 1, 2]辅助记忆
当目标值比中间值大时，需要设置 low = mid + 1，从而（low + high）/2获取到下标2
当目标值比中间值小时，需要 high = mid - 1，从而（low + high）/2获取到下标0
'''

def binary_search(list, item):
    low = 0
    high = len(list) - 1
    while low <= high:
        mid = int((high + low) / 2)
        guess = list[mid]
        if guess == item:
            return guess
        elif guess > item:
            high = mid - 1
        else:
            low = mid + 1
    return None

my_list = [1, 2, 3, 4]
guess =  binary_search(my_list, 4)
print(guess)
