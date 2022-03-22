/**
 * 01 每个节点对象有
 * nodeType  nodeName nodeValue属性
 * 
 * 02 
 * 元素与元素之间容易存在空白文本节点，空白节点也是文本节点的一部分
 * node.childNodes会返回类数组对象，获取到该节点的全部子节点
 * 
 * 03 
 * 判断node.childNodes[i].nodeValue是否为空白
 * 
 * 04
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
 * 元素替换
 * ul.replaceWith(dl)
 * 
 * 07 复制元素节点
 * div.cloneNode()只会复制nodeType，nodeName，不会复制nodeValue
 * 
 * document.createElement('button')创建元素
 * 
 * ul.append(li)  ul元素对象里插入一个li元素对象到它的最后面
 * 
 * document.body.insertBefore(btn, div);
 * 父元素使用insertBefore方法将btn插入到div前面
 */