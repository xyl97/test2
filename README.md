# test2
账号：admin
密码：123


密码没加密

swagger接口地址:http://localhost:8078/doc.html

拦截器没写过期时间

实体类Teacher和项目没有关系


shell脚本

在给定文件中搜索指定内容，并将搜索结果(含内容出现的行号)保存到新的文件中，同时结果输出到控制台

#!/bin/bash

#path=/home/test.txt
read -p "输入搜索内容：" data
read -p "输入文件路径"  path

#搜索写入
function seach(){

#read -p "输入搜索内容" data

grep -o -n $data $path >> file.txt

}

#控制台输出
function prit(){

grep -o -n $data $path

}
seach

prit







