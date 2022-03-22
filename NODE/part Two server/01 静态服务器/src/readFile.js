let fs = require('fs');

fs.readFile('demo.js', function(err, data) {
    console.log(data.toString());
})