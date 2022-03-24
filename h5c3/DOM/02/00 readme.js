/**
 * 01 
 * 每个节点对象有nodeType  nodeName nodeValue属性。元素节点的nodeValue是空或者undefined,属性节点是值,文本节点是文本内容
 * 
 * 02 
 * 元素与元素之间容易存在空白文本节点，空白节点也是文本节点的一部分
 * node.childNodes会返回类数组对象，获取到该节点的全部子节点
 * 
 * 03 处理空白节点
 * 利用正则判断node.childNodes[i].nodeValue是否为空白
 * 
 * 节点操作需要记忆性东西比较多:
 * 04 子节点和子元素节点的使用
 * children
 * childNodes
 * firstChild   lastChild
 * firstElementChild    lastElementChild
 * previousSibling  nextSibling
 * previousELementSibling   nextElementSibling
 * 
 * 05 
 * 删除子节点
 * ul.removeChild(ul.firstChild);
 * 
 * 06 子元素替换
 * ul.replaceChild(div, li)
 * 元素与元素进行替换
 * ul.replaceWith(dl)
 * 
 * 07 复制元素节点
 * div.cloneNode()只会复制nodeType，nodeName，不会复制nodeValue
 * 
 * document.createElement('button')创建元素
 * 
 * ul.append(li)  ul元素对象里插入一个li元素对象到它的最后面
 * 
 * document.body.insertBefore(btn, div);
 * 父元素使用insertBefore方法将btn插入到div前面
 */