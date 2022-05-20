> sed和grep的区别?
-sed更多的是起编辑处理文本作用,而grep更多的只是过滤获取文本作用

# macos中称为awk,linux os中称为 gakw
# sed是一个流编辑器(读取文件内容是按行读取的),语法格式为 sed option script file (script中一般还包括操作的路径和sed关键字)

# (1) 默认情况下，sed会将指定的命令应用到stdin输入流上,因此我们可以直接将数据通过管道输入sed编辑器处理。
echo 'helloWorld' | sed 's/World/Jeff/'     # s/str1/str2/ 实现替换
ls | sed -n '1p'  # 使用p命令时,如果不加上-n选项，默认还会打印全部文本内容
cat readme.txt
sed 's/脚本/sed/g' readme.txt    # sed 只是将修改后的文本内容发送到stdout,并不会修改原文件readme.txt的内容。
# s可以进行字符串替换(只会匹配每行第一个),再匹配g可进行全局匹配。

# 想要连续使用多个sed命令,将sed的option设置为-e就可以了
sed -e '1p; s/脚本/shell/' readme.txt

# 从文件中读取sed命令(文件中写入script命令即可)
sed -n -f script.sed readme.txt       # sed的script命令只要放置于文本文件即可,无名称要求

#sed删除行
sed '2d' readme.txt

# sed编辑器向数据流插入数据(mac shell用法有点不同，，，用不了)



# (2) awk程序能提供一个类编程环境来修改和重新组织文件中的数据。也可以称awk编辑器
# 使用awk时，可以 定义变量、结构化编程处理逻辑(if,while)
# 格式:  awk option program file

#awk主要特性就是处理文本文件数据的能力,它会自动给每一行的数据元素分配一个变量对应(数据元素的划分默认是以空格作为分隔符)
# $0 代表整行文本, $n 代表第n个元素。
ps | awk '{print$1}'  # 打印每行的第一个数据元素字段
# sed，awk都可以接收通过 管道传递的来自终端输出的数据

# 通过设置option为   -F分隔符   改变分隔符的值
ps | awk -F00 '{print$1}'

# awk的program中使用多条命令,使用;分割即可

# awk允许在终端多次输入,它会以单引号作为结束符
# 模拟终端输入
# a) awk '{     回🚗
# b) print$0}   回🚗
# c) '          回🚗
#这样的话一个awk程序就写好了,因为awk程序是需要一个输入的,这样终端就会停留等待你输入数据到stdin中。得到数据后调用awk程序
#打印$0然后再次进入等待你输入数据到stdin。退出程序,推荐使用ctrl+D的组合键，它会发送一个EOF字符给awk程序意味结束。

# 跟sed编辑器一样，awk编辑器的程序可以写在文本中供调用(设置option为 -f)
ps | awk -f program.awk

# 设置变量(打印变量直接使用变量名即可)
ps | awk '{text="helloWorld"; print $1 text}'

# awk允许在处理数据前后运行脚本,比如创建标题等，写结束语等(使用BEGIN,END关键字，必须大写)
ps | awk 'BEGIN {print "显示shell相关进程的pid*********"} {print $1} END{print "显示结束*********"}'

