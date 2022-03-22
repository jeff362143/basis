let fs = require('fs');

fs.rmdir("07 mkdir", err => {
    console.log(err);
})