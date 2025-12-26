int square(int x){
    int digit, sq=0;
    while(x!=0){
        digit = x%10;
        sq += digit*digit;
        x =x/10;
    }
    return sq;
}

bool isHappy(int n) {
    int slow=n, fast=n;
    do{
        slow = square(slow);
        fast = square(square(fast));
    }while(slow!=fast);

    return slow==1;
}
