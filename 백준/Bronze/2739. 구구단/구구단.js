var fs = require('fs');
var input = fs.readFileSync('/dev/stdin').toString();
var N = parseInt(input[0]);

for (var i = 1; i < 10; i++){
    console.log(N+ " * " + i + " = " + N*i);
}