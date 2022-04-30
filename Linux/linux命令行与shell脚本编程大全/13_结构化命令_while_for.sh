# 更多的结构化指令(for...,while)

# for in遍历(可以遍历用于分隔字符串，文本文件内容，同一目录下文件)
# 遍历字符串的分隔符是基于特殊的环境变量IFS，叫作内部字段分隔符(internal field separator)。默认以空格、换行、制表作为分隔符。
# 我们可以手动设置分隔符:设置分隔符为换行: IFS=$'\n'，设置换行符为冒号: IFS:
str="1 2 3 a b c"
for var in $str
#for var in 1 2 3 a b c
do
  echo $var
done

# for in从文件中读取数据
for state in $(cat readme.txt)
do
  echo $state
done

# for in遍历目录(需要使用通配符)
for file in /Users/*
do
  echo $file
done


# shell中的for循环(数值在if、while中进行比较也是使用双括号)
for (( i=1;i<=3;i++))
do
  echo "***"
done

# while；  能使用[[]]和(())进行字符串和数值比较
i=5
while (( $i != 0 ))
do
  i=$[$i-1]   # 变量减一
  echo 'while'
done

# until 就是跟while反着来。 条件为false时until才会执行。
