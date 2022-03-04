package com.lorenzo.system.domain;

/**
 * 游戏金币类
 * @author lorenzo
 * @date 2022/03/04 11:35
 **/
public class GameCurrency extends GameDeal{
    // 上架数量
    private int count;
    // 起售金额
    private double startingAmount;

    public GameCurrency(int count, double startingAmount) {
        this.count = count;
        this.startingAmount = startingAmount;
    }

    public GameCurrency() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getStartingAmount() {
        return startingAmount;
    }

    public void setStartingAmount(double startingAmount) {
        this.startingAmount = startingAmount;
    }

    @Override
    public String toString() {
        return "GameCurrency{" +
                "count=" + count +
                ", startingAmount=" + startingAmount +
                '}';
    }

}
