let json = {
    desc: 'obj',
    time: '2021-12-04'
};
for (let k in json) {
    console.log(json[k]);
}
// delete对象属性   
delete json.desc;
console.log("******");
for (let k in json) {
    // k为json对象的属性名
    console.log(json[k]);
}
