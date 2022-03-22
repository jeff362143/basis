let fs = require('fs');

// fs.appendFile('06 readme.txt', "06 readme", (err) => {
//     console.log(err);
// })

fs.rename('06 readme.txt', '06 readme_renamed.txt', (err) => {
    console.log(err);
})