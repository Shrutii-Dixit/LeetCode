bool isPalindrome(int x) {
    int b;
    long long a=x,c=0;
    if(x<0){
        return false;
    }
    while(x!=0){
        b=x%10;
        c=(c*10)+b;
        x=x/10;
    }
    if(c==a){
        return true;
    }
    else{
        return false;
    }
}
