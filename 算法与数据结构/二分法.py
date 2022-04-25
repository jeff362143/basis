'''
二分法即有序队列中折中查找，时间复杂度为   log2(N)
时间复杂度可以用大O表示，大O是用于表示上界的。即:
长度为N的有序数组中，寻找一个数字
如果从头采用一个一个数的话，最多经过N次就可以找出该数组，O（N）
如果采用二分法的，最长寻找时间为log2(N)；O(log2(N))

[0 , 1, 2]辅助记忆二分法步骤:
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
