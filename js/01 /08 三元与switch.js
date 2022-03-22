let variable = "java sdk";
if(variable == "wasm" ? true : false) {
    console.log('Java And JavaScript');
} else {
    console.log("CppAndAssebly")
}
console.log('hello world');

switch(variable) {
    case "java sdk": 
        console.log("android and linux");
        break;
    case "wasm": 
        console.log("v8 and compiler");
        break;
    default: 
        console.log('life')
}