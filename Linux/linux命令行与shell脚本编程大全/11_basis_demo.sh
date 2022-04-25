#!/bin/bash
# 查找shell环境中有权限执行的文件
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



