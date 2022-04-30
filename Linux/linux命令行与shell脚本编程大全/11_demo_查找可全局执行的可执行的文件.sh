、# chmod 777即可将文件设置为可执行文件
# 可执行文件就可以在终端执行，只是非sh文件执行也没用
# 将可执行文件移到$PATH所在的目录下即可全局执行

# 查找shell环境中有执行权限的文件
IFS=:
  for folder in $PATH
  do
    echo "$folder 下有执行权限的文件:"
    for file in $folder/*
    do
      if [ -x $file ]
      then
        echo "         $file"
      fi
    done
  done
