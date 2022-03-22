function outer(m) {
    function inner(n) {
        return m + n;   
    }
    return inner;
}
let inn = outer(10);
// inner定义在outer中，因此outer不会随意销毁
console.log(inn(5));

// 在遇到该情况时，记忆也许比理解更可靠