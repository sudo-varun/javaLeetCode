package com.InterPrep;

public class ApplyDiscount {

    public String discountPrices(String sentence, int discount) {
        StringBuilder ans = new StringBuilder();
        int pointer = 0;
        char[] chars = sentence.toCharArray();
        while(pointer < chars.length) {
            if(chars[pointer] != '$' || pointer + 1 == chars.length) {
                ans.append(chars[pointer]);
                pointer++;
                continue;
            }
            int left = pointer + 1, right = pointer + 1;

            while(right < chars.length && sentence.substring(left, right + 1).matches("[0-9]+")) {
                right++;
            }
            if(right < chars.length  && chars[right] == '$') {
                ans.append(sentence, left, right + 1);
                pointer = right + 2;
                continue;
            }
            long price;
            try {
                price = Long.parseLong(sentence.substring(left, right));
            } catch (NumberFormatException e) {
                ans.append('$');
                pointer++;
                continue;
            }
            double discountedPrice = price * (1 - (double) discount /100);
            ans.append('$');
            String formatted = String.format("%.2f", discountedPrice);
            ans.append(formatted);
            pointer = right;
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        ApplyDiscount applyDiscount = new ApplyDiscount();
        System.out.println(applyDiscount.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100));
    }
}
