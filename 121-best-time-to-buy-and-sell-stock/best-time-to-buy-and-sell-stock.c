int maxProfit(int* prices, int pricesSize) {
    int profit=0, min=prices[0];
    for(int i=1; i<pricesSize; i++){
        if(min > prices[i]){
            min = prices[i];
        }
        else if(profit < prices[i]-min){
            profit = prices[i]-min;
        }
    }
    return profit;
}