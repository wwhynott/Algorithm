function solution(price, money, count) {
    pay_price = 0
    for (i = 1; i <= count; i++) {
        pay_price += price * i
    }
    if (money >= pay_price) return 0;
    return pay_price - money;
}