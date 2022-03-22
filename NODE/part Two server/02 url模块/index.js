let url = require('url');

let urlStr = "https://www.google.com#home";
let url_obj = url.parse(urlStr);
console.log(url_obj);