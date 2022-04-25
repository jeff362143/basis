echo $1

# 运行该脚本时传入参数    ./test.sh 100
# 传递的参数是以空格作为分隔符的

echo $0
# $0变量值是该脚本的文件名

echo $#
# 可以获取传递给该sh文件的参数个数

# 一次性打印传递的参数
echo $*
for var in $*
do
  echo $var
done
