var N = require('fs').readFileSync('/dev/stdin').toString();

var star = "";

for (var i = 0; i < N; i++) {
    star += "*"
    console.log(star);
}