var N = require('fs').readFileSync('/dev/stdin');

var LongInt = ""

var realN = N/4

for (var i = 0; i < realN; i++) {
    LongInt += "long "
}

console.log(LongInt+"int")
