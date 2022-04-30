# 终端进程会接收并执行linux发送的信号
# trap关键字捕获信号
# ctrl+c组合键会生成linux信号 SIGINT ,shell进程接收该信号会停止进程执行
# 使用trap命令可以捕获该信号,同时将该信号从shell进程执行转换到从本地执行

# 下列Testing代码会打印Loop1后等待10s依次打印Loop2，反复执行到打印Loop10。在等待sleep 10执行的过程中,使用ctrl+c组合键会使用进程跳过该次sleep 10,不影响后续打印以及下次sleep 10的执行(这就是将该信号从shell进程转换到本地执行?)
# Testing signal trapping
#
trap "echo ' Sorry! I have trapped Ctrl-C'" SIGINT
# trap "echo '使用trap捕获到了该脚本结束时'" exit        (1)
#
echo This is a test script
#
count=1
while (( $count < 5 ))
do
       echo "Loop #$count"
       sleep 3
       count=$[ $count + 1 ]
#       trap -- SIGINT    #(2)
done
    echo "This is the end of the test script"


#(1)
# 捕获脚本的结束
# trap "echo '该脚本执行结束了'" exit      这段命令可用于捕获脚本的退出


#(2)
# 修改或移除捕获 (在脚本不同位置进行不同的捕获,使用带有选项的trap即可)
# trap -- SIGINT      可以用于停止SIGINT信号的捕获


#(3)
# 以后台模式运行shell脚本
# ./16_signal.sh为普通模式执行shell脚本, ./16_signal.sh &为使用后台模式执行该shell脚本
# &符放到命令后时，它会将该shell脚本和bash shell分离开来，作为系统中的一个独立的后台进程运行

# 以后台模式运行脚本时,我们不需要等待脚本执行完毕就可以在当前终端使用各种linux普通命令。不过后台脚本的stdout和stderr
#也是显示在当前终端显示窗口的。与我们后续使用命令的stdout杂在一起会导致显示屏看起来有点乱。(使用下面的nohup命令完成真正后台运行)

# 后台进程是以当前终端窗口打开的,当前终端窗口关闭的话；后台模式运行的进程也会被关闭。



#(4)
# nohup可以做到真正后台运行脚本,即使启动该脚本进程的终端窗口关闭了,后台运行的进程也不会关闭(但是后台运行的进程无法使用ps命令查询到)
# 使用nohup运行的脚本结果不会显示在当前终端,而是生成一个nohup.out文本文件存储输出
# 可以使用>关键字来自定义生成的文本文件的名称    ./16_signal.sh > out.txt &


#(5)  ctrl+z可以停止进程
# jobs命令可以查看后台和暂停的进程，bg命令可以用于继续执行暂停的进程


#(6) 多任务操作系统中，内核负责将cpu时间分配给系统的每一个进程
# nice命令


# (7) LINUX提供了at命令和corn表在预定时间执行脚本
