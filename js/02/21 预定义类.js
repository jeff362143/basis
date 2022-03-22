let reg = /\..*hello/;
let match = ".123hello".match(reg);
console.log(match);
// .  可以用于匹配除回🚗和换行外的全部字符,至于。则使用\。进行匹配

reg = /\d+\D+/;
match = "123hello".match(reg);
console.log(match);
// \d用于匹配数字，\D用于匹配非数字

reg = /\S+\s+\S+/;
match = "hello world".match(reg);
console.log(match);
// \s匹配空格字符   \S匹配非空格字符

reg = /\w+\W+\w/;
match = "abc123  ****  cba321".match(reg);
console.log(match);
// \w用于匹配a-z|A-Z|0-9    \W匹配非


