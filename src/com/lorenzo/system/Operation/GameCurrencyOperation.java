package com.lorenzo.system.Operation;

import com.lorenzo.system.domain.GameCurrency;
import com.lorenzo.system.utils.GameUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * 游戏金币操作类：提供增删改查
 * @author lorenzo
 * @date 2022/03/04 19:42
 **/
public class GameCurrencyOperation implements BasicOperation {

    /**
     *  添加金币信息
     *
     * @param sc
     * @param list
     */
    @Override
    public void addInfo(Scanner sc, ArrayList list) {
        // 1. 键盘录入要添加的信息数据
        System.out.println("请输入游戏名称：");
        String gameName = sc.nextLine();
        System.out.println("请输入所在大区：");
        String gameArea = sc.nextLine();
        System.out.println("请输入商家名称：");
        String gameBusiness = sc.nextLine();
        System.out.println("请输入上架数量：");
        String count = sc.nextLine();
        System.out.println("请输入起售金额：");
        String startingAmount = sc.nextLine();

        // 2. 创建游戏金币类对象【存储数据的】
        GameCurrency gc = new GameCurrency(); // gc的成员变量都是默认值

        // 3. 将键盘录入的数据封装到gc对象中去 【键盘录入只有5个数据，而GameCurrency有7个，还差 编号id和上架时间gameRegisterDate】
        gc.setGameName(gameName);
        gc.setGameArea(gameArea);
        gc.setGameBusiness(gameBusiness);
        gc.setCount(Integer.parseInt(count));
        gc.setStartingAmount(Double.parseDouble(startingAmount));

        String gameRegisterDate = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒").format(new Date());
        gc.setGameRegisterDate(gameRegisterDate);
        // 通过工具类提供的类变量类维护游戏金币的编号
        gc.setId(++GameUtils.gameCid);

        // 5. 将封装好数据的游戏金币对象gc添加到集合中去
        list.add(gc);

        // 6. 给出游戏金币添加成功的提示信息
        System.out.println("【成功】数据已被保存！");
    }

    @Override
    public void deleteInfo(Scanner sc, ArrayList list) {
        if(list!=null && list.size()>0) {
            // 1.集合中有数据，键盘录入用户输入的编号
            System.out.println("请输入要删除的金币信息编号：");
            String id = sc.nextLine();

            // 假设系统不存在指定id的数据
            boolean flag = false;

            // 3. 判断(看系统中是否存在该编号的金币信息数据)
            for (int i = 0; i < list.size(); i++) {
                // 4. 获得单个游戏金币对象
                GameCurrency gc = (GameCurrency) list.get(i); // 明确知道list存入的是GameCurrency类型的对象
                // 5. 判断
                if (gc.getId() == Integer.parseInt(id)) {
                    // 6. 修改变量的值
                    flag = true;
                    break;
                }
            }

            // 7. 判断
            if (flag) { // 系统有指定id的数据
                // 8. 遍历
                for (int i = 0; i < list.size(); i++) {
                    // 9. 获得单个游戏金币对象
                    GameCurrency gc = (GameCurrency) list.get(i); // 明确知道list存入的是GameCurrency类型的对象
                    // 10. 判断
                    if (gc.getId() == Integer.parseInt(id)) {
                        // 11. 打印
                        System.out.println("【查询结果】");
                        // 12. 打印表头！
                        System.out.println("编号\t游戏名称\t\t所在大区\t\t商家\t\t上架时间\t\t\t\t\t\t\t\t上架数量\t\t起售金额");
                        System.out.println(gc.getId() + "\t\t" + gc.getGameName() + "\t\t" + gc.getGameArea() + "\t\t" + gc.getGameBusiness() + "\t\t" + gc.getGameRegisterDate() + "\t\t\t" + gc.getCount() + "\t\t" + gc.getStartingAmount());
                        // 13. 删除确认
                        System.out.println("【删除确认】你确定要删除编号为" + id + "的记录么？(y/n)");
                        String line = sc.nextLine();
                        // 14.判断
                        if ("y".equals(line)) {
                            // 14. 删除
                            list.remove(gc);
                            // 15. 给出提示信息
                            System.out.println("【成功】数据已被删除！");
                            // 16. 结束循环
                            break;
                        }
                    }
                }
            } else {
                System.out.println("系统中暂无编号为" + id + "的游戏金币信息数据，请重写输入！");
            }
        }else{
            System.out.println("系统暂无金币信息数据！请先添加！");
        }
    }

    @Override
    public void updateInfo(Scanner sc, ArrayList list) {
        if(list!=null && list.size()>0) {
            // 1.集合中有数据，键盘录入用户输入的编号
            System.out.println("请输入要修改的金币信息编号：");
            String id = sc.nextLine();

            // 假设系统不存在指定id的数据
            boolean flag = false;

            // 3. 判断(看系统中是否存在该编号的金币信息数据)
            for (int i = 0; i < list.size(); i++) {
                // 4. 获得单个游戏金币对象！
                GameCurrency gc = (GameCurrency) list.get(i); // 明确知道list存入的是GameCurrency类型的对象
                // 5. 判断
                if (gc.getId() == Integer.parseInt(id)) {
                    // 6. 修改变量的值
                    flag = true;
                    break;
                }
            }

            // 7. 判断
            if (flag) { // 系统有指定id的数据
                // 8. 遍历
                for (int i = 0; i < list.size(); i++) {
                    // 9. 获得单个游戏金币对象
                    GameCurrency gc = (GameCurrency) list.get(i); // 明确知道list存入的是GameCurrency类型的对象
                    // 10. 判断
                    if (gc.getId() == Integer.parseInt(id)) {
                        // 11. 打印
                        System.out.println("【查询结果】");
                        // 12. 打印表头！
                        System.out.println("编号\t游戏名称\t\t所在大区\t\t商家\t\t上架时间\t\t\t\t\t\t\t\t上架数量\t\t起售金额");
                        System.out.println(gc.getId() + "\t\t" + gc.getGameName() + "\t\t" + gc.getGameArea() + "\t\t" + gc.getGameBusiness() + "\t\t" + gc.getGameRegisterDate() + "\t\t\t" + gc.getCount() + "\t\t" + gc.getStartingAmount());
                        // 13. 录入要修改在字段数据
                        System.out.println("请输入新游戏名称[保留原值输入0]");
                        String newGameName = sc.nextLine();
                        System.out.println("请输入新游大区[保留原值输入0]");
                        String newGameArea = sc.nextLine();
                        System.out.println("请输入新游戏商家名称[保留原值输入0]");
                        String newGameBusiness = sc.nextLine();
                        System.out.println("请输入新上架数量[保留原值输入0]");
                        String newCount = sc.nextLine();
                        System.out.println("请输入新起售金额[保留原值输入0]");
                        String newStartingAmount = sc.nextLine();

                        // 14. 判断
                        if(!newGameName.equals("0")){
                            gc.setGameName(newGameName);
                        }

                        if(!newGameArea.equals("0")){
                            gc.setGameArea(newGameArea);
                        }

                        if(!newGameBusiness.equals("0")){
                            gc.setGameBusiness(newGameBusiness);
                        }

                        if(!newCount.equals("0")){
                            gc.setCount(Integer.parseInt(newCount));
                        }

                        if(!newStartingAmount.equals("0")){
                            gc.setStartingAmount(Double.parseDouble(newStartingAmount));
                        }

                        // 15. 给出提示
                        System.out.println("【成功】数据已被修改！");

                        // 16. 结束循环
                        break;

                    }
                }
            } else {
                System.out.println("系统中暂无编号为" + id + "的游戏金币信息数据，请重写输入！");
            }
        }else{
            System.out.println("系统暂无金币信息数据！请先添加！");
        }
    }

    @Override
    public void findAll(ArrayList list) {
        // 1. 判断
        if(list !=null && list.size()>0){
            System.out.println("【所有游戏金币信息数据如下：】");
            // 3. 打印表头
            System.out.println("编号\t游戏名称\t\t所在大区\t\t商家\t\t上架时间\t\t\t\t\t\t\t\t上架数量\t\t起售金额");
            // 4. 遍历集合
            for (int i = 0; i < list.size(); i++) {
                // 5. 获得单个游戏金币对象
                GameCurrency gc = (GameCurrency) list.get(i); // 明确知道list存入的是GameCurrency类型的对象
                // 6. 打印
                System.out.println(gc.getId()+"\t\t"+gc.getGameName()+"\t\t"+gc.getGameArea()+"\t\t"+gc.getGameBusiness()+"\t\t"+gc.getGameRegisterDate()+"\t\t\t"+gc.getCount()+"\t\t"+gc.getStartingAmount());
            }
        }else{
            // 2.集合无数据！
            System.out.println("系统中暂无游戏金币信息数据，请先添加！");
        }

    }
}
