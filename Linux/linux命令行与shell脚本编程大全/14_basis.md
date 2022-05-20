> 向shell脚本传递数据的最基本方法是使用命令行参数
- \$1就是传递的第一个参数，$2就是第二个参数，以此类推
- 传递的参数是以空格作为分隔符的
- \$0变量值是该shell脚本的文件名
- $#变量可以获取传递给该sh文件的参数个数\
- 一次性打印传递的参数($*和#@)
```shell
echo $*
for var in $*
do
  echo $var
done
```

> 直接echo可以进行换行

> ?如何获取字符串的长度
- if [ -n "$1" ]可以判断字符串为空，非空则执行

> shift命令可以用于删除参数，会将传入的参数依次左移
- 这是遍历命令行参数的另一个好方法，尤其是在你不知道到底有多少参数时。你可以只操作 第一个参数，移动参数，然后继续操作第一个参数。

> getopt命令以及getopts命令
- getopt命令格式: getopt optstring parameters

> read获取用户输入
- read -p "what is your name" name(b-shell可用，mac下的z-shell不支持-p选项)
- -s选项可设置输入不可见(输入密码时常用)
- read命令也可以用于读取文本文件