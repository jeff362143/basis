# 堆是堆，栈是栈，堆栈就是栈

# 栈有后进先出的特性。

__metaclass__ = type

class mystack():
    def __init__(self,value):
        self.value = value
        self.behind = None
        self.before = None

    def __str__(self):
        return str(self.value)

def top(stack):    #顶部
        if isinstance(stack,mystack):
            if stack.behind is not None:
                return top(stack.behind)
            else:
                return stack
        else:
            print ('没有初始化')

def push(stack,elem):  #入栈
    in_elem = mystack(elem)
    if isinstance(stack,mystack):
        now_top = top(stack)
        in_elem.before = now_top
        in_elem.before.behind = in_elem
        print ('成功入栈')
    else:
        print ('没有初始化')

def pop(stack):     #出栈
    if isinstance(stack,mystack):
        now_top = top(stack)
        if now_top.before is not None:
            now_top.before.behind = None
            now_top.before = None
            return now_top
        else:
            return('栈空了')
    else:
        return('没有初始化')

demo1 = mystack(1)  #初始化,只能通过demo1访问

for i in range(10): #入栈
    push(demo1,i)

print '---------------'
print demo1

for p in range(11): #出栈
    print pop(demo1)

# 输出:
# 成功入栈
# 成功入栈
# 成功入栈
# 成功入栈
# 成功入栈
# 成功入栈
# 成功入栈
# 成功入栈
# 成功入栈
# 成功入栈
# ---------------
# 1
# 9
# 8
# 7
# 6
# 5
# 4
# 3
# 2
# 1
# 0
# 栈空了
# [Finished in 0.5s]
