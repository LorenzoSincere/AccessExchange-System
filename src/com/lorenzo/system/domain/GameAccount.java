package com.lorenzo.system.domain;

import java.util.Objects;

/**
 * 游戏账号实体类
 * @author lorenzo
 * @date 2022/03/04 11:30
 **/
public class GameAccount {

    private String accName;
    private String accId;
    private String accLevel;
    private double accPrice;

    public GameAccount(String accName, String accId, String accLevel, double accPrice) {
        this.accName = accName;
        this.accId = accId;
        this.accLevel = accLevel;
        this.accPrice = accPrice;
    }

    public GameAccount() {
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        this.accId = accId;
    }

    public String getAccLevel() {
        return accLevel;
    }

    public void setAccLevel(String accLevel) {
        this.accLevel = accLevel;
    }

    public double getAccPrice() {
        return accPrice;
    }

    public void setAccPrice(double accPrice) {
        this.accPrice = accPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameAccount that = (GameAccount) o;
        return Double.compare(that.accPrice, accPrice) == 0 && Objects.equals(accName, that.accName) && Objects.equals(accId, that.accId) && Objects.equals(accLevel, that.accLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accName, accId, accLevel, accPrice);
    }

    @Override
    public String toString() {
        return "GameAccount{" +
                "accName='" + accName + '\'' +
                ", accId='" + accId + '\'' +
                ", accLevel='" + accLevel + '\'' +
                ", accPrice=" + accPrice +
                '}';
    }
}
