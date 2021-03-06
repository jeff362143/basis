# 和常用编程语言差别不大;  特殊的字符串不好记忆,其他语言使用反斜杠的特殊字符更任意记忆。

# 正则表达式即预定义的模式模板。linux工具(awk、sed)配合正则可以更好进行文本过滤。
echo 'hello' | sed -n '/hello/p'
# 这就是一个最基本的sed和正则联动

# 正则表达式中,空格就是一个基本字符（直接放在正则的两个正斜杠中就可以）
echo 'hello  ' | sed -n '/ /p'

# .可以用于匹配除换行符外的任意符号
echo 'at the clock we will go back home' | sed -n '/.at/p'
# 匹配失败。     .预定符没匹配到任何字符

# 字符组，即[ab]

# 区间，[a-z] [0-9]  横杠不要省略。

# 特殊的字符组,即预定符。
[[:alpha:]] [[:alnum:]] [[:blank:]] [[:digit:]] [[:lower:]] [[:print:]] [[:punct:]] [[:space:]] [[:upper:]]
#匹配任意字母字符，不管是大写还是小写
#匹配任意字母数字字符0~9、A~Z或a~z
#匹配空格或制表符
#匹配0~9之间的数字
#匹配小写字母字符a~z
#匹配任意可打印字符
#匹配标点符号
#匹配任意空白字符:空格、制表符、NL、FF、VT和CR
#匹配任意大写字母字符A~Z