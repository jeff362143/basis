'''
列表排序算法，以下简单描述用于辅助记忆
冒泡：比较相邻的元素，如果第一个比第二个大，就调换顺序，并往下继续进行比较，可找出列表最大值。重复过程，即可实现顺序列表

选择：设计一个寻找列表最小值的方法，利用该方法将最小值append进一个新列表并在旧列表中删去该最小值，反复执行该方法

堆排序：利用大根堆原理设置的方法，寻到列表最大值并放在列表尾端，反复执行即可得到顺序列表
'''

'''
冒泡排序
'''
def bubble_sort(numberlist):
    length = len(numberlist)
    for i in range(length):
        for j in range(1, length - i):
            if numberlist[j - 1] > numberlist[j]:
                numberlist[j], numberlist[j - 1] = numberlist[j - 1], numberlist[j]
    return numberlist

'''
这是我自己写的冒泡排序，最后一个元素没有比较对象进行比较了，我选择删去最后一次排序       
'''
def bubble_sort2(numList):
    length = len(numList)
    for i in range(length - 1):
        for j in range(1, length - i):
            if numList[j - 1] > numList[j]:
                numList[j - 1], numList[j] = numList[j], numList[j - 1]
    return numList
print(bubble_sort2([1, 3, 4, 4, 5, 5, 6, 2]))




# 选择排序
def findSmallest(arr):  # 用于查找出数组中最小的元素，返回最小元素的索引。
    smallest = arr[0]
    smallest_index = 0
    for i in range(1, len(arr)):
        if smallest > arr[i]:
            smallest = arr[i]
            smallest_index = i
    return smallest_index

def selectSort(arr):
    newArr = []
    while arr:
        smallest = findSmallest(arr)
        newArr.append(arr.pop(smallest))
    return newArr

# 插入排序
def insert_sort(data):
    for k in range(1, len(data)):
        cur = data[k]
        j = k
        while j > 0 and data[j - 1] > cur:
            data[j] = data[j - 1]
            j -= 1
        data[j] = cur
    return data

# 希尔排序
def shell_sort(numberlist):
    length = len(numberlist)
    gap = length // 2
    while gap > 0:
        for i in range(gap, length):
            temp = numberlist[i]
            j = i
            while j >= gap and numberlist[j - gap] > temp:
                numberlist[j] = numberlist[j - gap]
                j -= gap
            numberlist[j] = temp
        gap = gap // 2
    return numberlist


# 堆排序
'''
堆是一种完全二叉树，即从上到下，从左到右生成的二叉树。
堆有大根堆和小根堆
大根堆即每个节点的值都大于或者等于孩子节点的值
小根堆即每个节点小雨等于。。。

堆排序算法即用数组模拟大根堆或者小根堆的算法
1：堆算法将列表数据排成一个堆
2：堆排序算法排成有序列表
'''
def heap_sort(numberlist):
    length = len(numberlist)
    def sift_down(start, end):
        root = start
        while True:
            child = 2 * root + 1
            if child > end:
                break
            if child + 1 <= end and numberlist[child] < numberlist[child + 1]:
                child += 1
            if numberlist[root] < numberlist[child]:
                numberlist[root], numberlist[child] = numberlist[child], numberlist[root]
                root = child
            else:
                break
# 创建最大堆
    for start in range((length - 2) // 2, -1, -1):
        sift_down(start, length - 1)

# 堆排序
    for end in range(length - 1, 0, -1):
        # 将最大的根与最后一位进行调换
        numberlist[0], numberlist[end] = numberlist[end], numberlist[0]
        sift_down(0, end - 1)

    return numberlist

print(heap_sort([2, 3, 5, 4, 6, 4, 2, 3, 4, 5, 7, 1]))

# 计数排序
def counting_sort(numberlist, maxnumber):  # maxnumber为数组中的最大值
    length = len(numberlist)  # 待排序数组长度
    b = [0 for i in range(length)] # 设置输出序列，初始化为0
    c = [0 for i in range(maxnumber+ 1)]  # 设置技术序列，初始化为0
    for j in numberlist:
        c[j] = c[j] + 1
    for i in range(1, len(c)):
        c[i] = c[i] + c[i - 1]
    for j in numberlist:
        b[c[j] - 1] = j
        c[j] = c[j] - 1
    return b

