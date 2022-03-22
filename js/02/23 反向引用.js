console.log("123abcabc".match(/(abc)\1/g));
console.log("abcabc12".match(/(abc)\1/g));

console.log("abcxyzxyz12xyzabc".match(/([a-z]{2})\1/g));

// 待更新