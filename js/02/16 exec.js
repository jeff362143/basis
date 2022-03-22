let text = 'cat, bat, sat, fat';
let pattern = /\w{1}at/g;
// 使用exec的时候必须设置为全局匹配，不然的话调用exec无法向前搜索
let matches = pattern.exec(text);
console.log(matches);
// 返回一个对象，同match返回的对象一致
// 返回对象匹配的是cat中的at

matches = pattern.exec(text);
console.log(matches);
// exec具有标记性，返回对象匹配的是bat字符串🀄️的at


// exec一次只能返回一个结果，但是exec具有记忆性，能自动根据上次exec结果继续往后进行搜索