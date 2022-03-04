package com.lorenzo.system.domain;

/**
 *  游戏交易父类！====>>>提供共性内容！
 * @author lorenzo
 * @date 2022/03/04 11:38
 **/
public class GameDeal {
    // 编号
    private int id;
    // 游戏名称
    private String gameName;
    // 游戏大区
    private String gameArea;
    // 商家名称
    private String gameBusiness;
    // 上架日期
    private String gameRegisterDate;

    public GameDeal(int id, String gameName, String gameArea, String gameBusiness, String gameRegisterDate) {
        this.id = id;
        this.gameName = gameName;
        this.gameArea = gameArea;
        this.gameBusiness = gameBusiness;
        this.gameRegisterDate = gameRegisterDate;
    }

    public GameDeal() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameArea() {
        return gameArea;
    }

    public void setGameArea(String gameArea) {
        this.gameArea = gameArea;
    }

    public String getGameBusiness() {
        return gameBusiness;
    }

    public void setGameBusiness(String gameBusiness) {
        this.gameBusiness = gameBusiness;
    }

    public String getGameRegisterDate() {
        return gameRegisterDate;
    }

    public void setGameRegisterDate(String gameRegisterDate) {
        this.gameRegisterDate = gameRegisterDate;
    }

    @Override
    public String toString() {
        return "GameDeal{" +
                "id=" + id +
                ", gameName='" + gameName + '\'' +
                ", gameArea='" + gameArea + '\'' +
                ", gameBusiness='" + gameBusiness + '\'' +
                ", gameRegisterDate='" + gameRegisterDate + '\'' +
                '}';
    }
}
