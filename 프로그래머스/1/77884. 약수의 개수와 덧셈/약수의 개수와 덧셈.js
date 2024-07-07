function solution(left, right) {
    answer = 0;
    num = left;
    while (num <= right) {
        count = 0;
        i = 1;
        while (i <= num) {
            if (num % i == 0) {
                count += 1;
            }
            i += 1;   
        }
        if (count % 2 == 0) { 
            answer += num;
        }
        else {
            answer -= num;
        }
        num += 1;
    }
    return answer;
}