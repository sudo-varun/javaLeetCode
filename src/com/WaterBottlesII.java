package com;

public class WaterBottlesII {
    /*
            You are given two integers numBottles and numExchange.

        numBottles represents the number of full water bottles that you initially have. In one operation, you can perform one of the following operations:

            Drink any number of full water bottles turning them into empty bottles.
            Exchange numExchange empty bottles with one full water bottle. Then, increase numExchange by one.

        Note that you cannot exchange multiple batches of empty bottles for the same value of numExchange. For example, if numBottles == 3 and numExchange == 1, you cannot exchange 3 empty water bottles for 3 full bottles.

        Return the maximum number of water bottles you can drink.

        Can i use greedy approach here? If enough bottles to exchange are available exchange it otherwise drink all the bottles

     */
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = 0;
        int bottlesDrunk = 0;
        do {
            if(emptyBottles >= numExchange) {
                System.out.println("Exchanging bottles " + emptyBottles + " for num exchange " + numExchange);
                emptyBottles = emptyBottles - numExchange;
                numExchange++;
                numBottles++;
                continue;
            }
            System.out.println("Drinking " + numBottles);
            bottlesDrunk += numBottles;
            emptyBottles += numBottles;
            numBottles = 0;
            System.out.println("Empty bottles: " + emptyBottles + " and num exchange: " + numExchange);
        } while (numBottles > 0 || emptyBottles >= numExchange);
        return bottlesDrunk;
    }
    public static void main(String[] args) {
        WaterBottlesII waterBottles = new WaterBottlesII();
        System.out.println(waterBottles.maxBottlesDrunk(10, 3));
    }
}
