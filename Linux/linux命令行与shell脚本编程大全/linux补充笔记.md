### linux介绍
linux核心是内核，控制着计算机系统所有的硬件和软件。它主要负责以下四个功能：
- 内存空间管理
内存空间会远小于外存，可能存在启动程序大小大于内存情况，因此需要虚拟内存，即将外存一块空间作为“交换空间”，该空间不停与内存空间进行交换。
内存单元被划分为块，这些块叫做页面，内核会维护一个内存页面表，决定哪些页面存在于内存，交换空间还是外存上。
- 软件程序管理
内核管理运行在linux系统上的程序。
- 硬件设备管理
任何linux系统需要与之通信的设备，都需要在内核代码中加入驱动代码。linux将硬件当做特殊的文件，称为设备文件。
- 文件系统管理。

> 拥有内核后我们还需要一套工具来执行一些标准功能，GNU工具包由三部分组成：1、处理文件 2、处理文本 3、管理进制。

---

### linux命令
>man命令:
- 查看命令手册时是以分页来进行显示的。
>cp命令
- 复制文件到当前文件夹并重命名避免重复,cp linux.txt ./linux2.txt

> ls命令
- Ls -F可以轻易分辨文件和文件夹(文件夹会在尾部加上/)
- Ls -a可以显示隐藏文件
- Ls -R为递归选项，它会显示当前目录的子文件夹下的内容
- Ls -l为长选项，会显示文件是否为目录，文件读写权限，文件上次修改时间，文件大小等
- Ls支持定义过滤器(ls l*,如果lxx是一个文件夹，会显示文件夹下内容)

> rm命令
- rm -i在进行文件删除时会提示你是否确定要删除该文件
- rmdir命令可以进行文件夹的删除(文件夹内部含有文件就无法删除)，我一般用rm -rf命令(可以删除文件夹下文件再进行文件夹的删除)

> mkdir命令
- mkdir想创建文件夹及其子目录，需要使用-p参数	mkdir -p /home/dictory/

> file命令
- file命令可以查看文件类型(可以区分文件夹、文本(显示编码格式）、图片、shell脚本等)

> cp命令
- cp命令仅用于复制文件，如果要复制文件夹需要使用cp -R加上R参数，它会递归复制文件夹底下文件并创建新文件夹

> ln文件链接命令
- ln命令可用于为文件添加硬链接和软链接：
-  ln -s fail.txt ln_fail.txt可为文件创建硬链接，硬链接本质和链接文件是同一个文件，直接ln可设置软链接。

> less
- less命令是more命令的升级版，可用于翻页查看文件

> tail命令和head命令
  tail命令可用于查看文件结尾部分，head用于查看文件开头部分
- tail -n 3 fail.txt表示为从第三行开始查看文件内容
- tail -n -3 fail.txt表示从倒数第三行开始查看文件内容
- tail -f可以实现实时监控文件内容
- head -n 10 fail.txt表示从开头查看到文件第十行
- head不支持参数为负数，这也不符合逻辑，且不支持-f实时刷新文件内容

> ps和top命令
- ps命令只会显示当前控制台下属性当前用户的进程
- ps -A或ps -e可以显示全部进场，ps -l可显示进程详细信息
- top命令可实时显示进程信息

> kill命令
- kill命令可以用于杀死进程(需要知道进程号)
- killall http*可杀死全部以http开头的进程(通过进程名杀进程)

> df -h命令可查看linux系统上设备相关的存储信息
查询到的/dev/文件夹指的是就是应用程序界面(万物皆文件)

> sort命令
- sort命令可以根据行开头字符对行文本进行排序 

> 压缩命令
- 压缩文件和归档文件是一个意思吧
- gzip工具是linux系统的GNU项目带的压缩工具，zip工具是window上的PKZIP工具的unix实现，尽管gzip已经能很好实现压缩功能了，但是unix系统上使用最广泛的归档工具是tar工具。
```shell
gzip命令无法压缩文件夹
gzip fail.txt可将文件压缩为gz格式
gzcat fail.txt可查看压缩文件内容
gunzip可解压文件
```
```shell
tar压缩命令功能比较丰富(参数c是压缩，x是解压缩，v是处理文件时展示相关内容，f是输出结果到文件)
tar -cvf test.rar demo/ 会将当前路径的demo文件夹内容压缩到test.rar归档文件中，且相关压缩文件会显示在终端中(压缩文件最起码需要cf参数)
tar -tf test.tar命令会显示压缩文件中的内容，但不解压
tar -xvf test.tar解压压缩文件
```
> tar和gz
- 书中
----

> &命令
- 命令末端加入&可将该命令加入后台
```shell
(sleep 2;echo 1:sleep 2)&
输出结果为：
j223hr390@90 Desktop % (sleep 2 ; echo 1 ; sleep 2)&
[1] 49165
j223hr390@90 Desktop % 1

[1]  + done       ( sleep 2; echo 1; sleep 2; )
命令置于后台开始时会有打印，结束也会有打印，且与输出内容也会显示到当前终端
```

> linux内部命令和外部命令
- ps就是一个外部命令，不存在于shell中(which ps显示在/bin/ps中)
外部命令执行的时候会创建一个子进程
type xxx可显示它是一个内部命令或者外部命令(外部命令会显示其位置)

> history命令可显示最近在终端使用的命令

### 第八章 管理文件系统
> 不会

### 第十章 使用编辑器
>vim软件包和vi
- vi指令也是调用vim编辑器，但是可能是tiny版本的vim编辑器，仅提供少量功能。某些linux发行版仅安装了vi编辑器 (sudo apt-get install vim是ubuntu发行版安装完整vim编辑器的命令)
> vim编辑器使用
- 拥有普通模式和插入模式(i)，普通模式需要记住各种指令(dd删除光标所在行，a在光标后面添加数据；y$复制光标到行尾的字符串，再使用p可以进行复制字符串)；插入模式点击i按键就可以进行编辑了

### 第十四章
