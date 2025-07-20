package com.InterPrep;

public class BalanceAfterPurchase {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int lastDigit = purchaseAmount % 10;
        int firstDigit = purchaseAmount / 10;
        if(lastDigit >= 5) {
            firstDigit += 1;
        }
        return purchaseAmount - firstDigit * 10;
    }
}
