# 结构化命令

# 11111
#  if command
#  then
#    commands
#  fi
#  其他编程语言的if后接一个boolean值,shell可后接基本linux命令,若该命令调用成功(即状态吗为0)，则执行command和commands

# 22222
#  if command
#  then
#    commands
#  elif command
#  then
#    commands
#  fi

# 333333
#  if command
#  then
#    commands
#  elif command
#  then
#    commands
#  else
#    commands
#  fi

# test命令用于在if中进行字符串、数值比较(数值比较需要用参数...煞笔)、文件比较
# 比较数值。该文件后面有双括号比较表达式。直接下滑，这个可以别看了😅😅😅😅😅😅😅😅😅😅😅😅😅😅😅😅😅😅
if test 1 -eq 1
then
  echo 'true'
fi
# 可以使用[]方框来表示test命令,使用时需要有空格间隔。
if [ 1 -eq 1 ]
then
  echo '[]'
fi

# 比较字符串
str1='hello'
str2='world'
if [ $str1 != $str2 ]
then
  echo 'str true'
else
  echo 'str false'
fi

# 比较文件(检测文件是否存在、是否是文件夹、是否存在并非空)
# 需要各类比较参数,-d 用于判断是否存在且是一个目录
#directory=/Users/j223hr331/Desktop/git add/linux命令行与shell脚本编程大全(该路径存在空格shell报错
directory=/Users/j223hr331/Desktop
if [ -d $directory ]
then
  echo "$directory it is a directory"
fi

# 复合逻辑,即shell的if elif中也可以使用&& ||
# if [  ] && [  ]




#
# (())提供了更好的数值比较
# (())双括号命令允许在比较过程使用更高级的数学表达式
# 可以使用自增,逻辑和、逻辑或，逻辑取反等
if (( 2 > 1 && 3 > 1))
then
  echo '(())表达式'
fi

# [[]] 提供了更好字符串比较，可以进行模式匹配(正则表达式)
if [[ 'rich' == r* ]]
then
  echo 'reg'
fi

# case语法
user='root'
case $user in
root | jeff)
  echo 'admin';;
local)
  echo 'local';;
esac
