# 队列是一种先入先出的数据结构。操作包括入队和出队，入队就是元素加到队尾，出队就是取出队头的元素

queue()
is_empty()
size()
enqueue()
dequeue()

class queue(self):
#创立容器
def __init__(self):
    self.__list[]

#入队
def enqueue(self, item):
    self.__list.append(item)

#出队
def dequeue(self):
    self.__list.pop(0)

#判断是否为空
def is_empty(self):
    return self._list==[]

#队列长度
def size(self):
    return len(self.__list)


