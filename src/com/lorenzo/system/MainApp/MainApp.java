package com.lorenzo.system.MainApp;


import com.lorenzo.system.domain.GameCurrency;
import com.lorenzo.system.Operation.GameCurrencyOperation;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author lorenzo
 * @date 2022/03/04 17:45
 **/
public class MainApp {
    /**
     * 入口方法【一级菜单】
     *
     * @param args
     */
    public static void main(String[] args) {

        // 6. 定义一个ArrayList集合作为实参，存储所有的游戏金币信息数据
        ArrayList<GameCurrency> gcs = new ArrayList<>(); // 集合对象gcs是有值的(不为null)，只不过刚开始定义的时候里面没有数据

        Scanner sc = new Scanner(System.in);

        // 4. 加入死循环，能够让用户进行多次操作
        while (true) {
            // 1. 一些输出语句构成的提示
            System.out.println("***************************欢迎进入游戏交易系统***************************");
            System.out.println("1. 游戏金币信息管理\t\t2. 游戏账号信息管理\t\t3. 退出系统");
            System.out.println("************************************************************************");

            // 2. 键盘录入数据，得到用户的选择！
            // Scanner sc = new Scanner(System.in);// 对象只需要创建1次即可改动它的位置
            System.out.println("请输入您的选择：[1 or 2]");
            String line = sc.nextLine();

            // 3. 对用户的选择进行判断(使用switch语句)
            switch (line) {
                case "1":
                    // 5. 调用一个方法(为定义方法的形参变量赋值！)，完成游戏金币信息管理！
                    gameCurrencyManager(sc, gcs); // 这个方法内部，需要执行4个功能(增删改查：键盘录入Scanner，数据存储ArrayList)
                    // gcs集合里面存储的是GameCurrency，而定义方法的形参变量的类型是Object
                    break;
                case "2":
                    // 稍后去调用方法，完成 游戏账号信息管理 功能！
                    System.out.println("游戏账号信息管理");
                    break;
                case "3":
                    System.out.println("谢谢使用！");
                    System.exit(0); // 正常退出JVM
                default:
                    System.out.println("您的选择有误，请重写输入！");
                    break;
            }
        }


    }

    /**
     * 游戏金币信息管理(二级菜单)
     *
     * @param sc  形参变量(键盘录入)  ====>>> 稍后谁调用这个方法，那么就需要为这个形参变量赋值！
     * @param gcs 形参变量(存储所有金币信息的数据)
     */
    private static void gameCurrencyManager(Scanner sc, ArrayList<GameCurrency> gcs) {

        // 创建游戏金币操作类的对象【调方法的！】
        GameCurrencyOperation gco = new GameCurrencyOperation();

        // 4. 加入死循环，能够让用户对游戏金币信息进行多次操作！
        while(true) {
            // 1. 一些输出语句给出提示
            System.out.println("============================游戏金币信息管理=====================================================================");
            System.out.println("1. 添加游戏金币\t\t 2. 修改指定游戏金币信息\t\t 3.查询所有游戏金币信息\t\t 4.删除指定游戏金币信息\t\t 5. 返回");
            System.out.println("================================================================================================================");

            // 2. 键盘录入，获得用户选择的功能
            System.out.println("请输入您要选择的功能：【1-5数字】");
            String line = sc.nextLine();

            // 3. 对用户选择的功能进行判断
            switch (line) {
                case "1":
                    // System.out.println("添加");
                    // 调用一个方法，完成游金币信息数据的添加！【1.数据哪里来？(键盘录入) 2.添加到哪里去？(集合中)】
                    // 5. 创建游戏金币操作类的对象！【对象只需要创建1次即可，将其位置挪到死循环的外部】
                    gco.addInfo(sc,gcs);
                    break;
                case "2":
                    // 调用一个方法，完成游戏金币信息数据的修改！【1.数据哪里来？(集合) 2.修改条件? (键盘录入)】
                    gco.updateInfo(sc,gcs);
                    break;
                case "3":
                    // 调用一个方法，完成游戏金币信息数据的查看！【1.数据哪里来？(集合中)】
                    gco.findAll(gcs);
                    break;
                case "4":
                    // 调用一个方法，完成游金币信息数据的删除！【1.数据哪里来？(集合) 2.删除条件? (键盘录入)】
                    gco.deleteInfo(sc,gcs);
                    break;
                case "5":
                    // 结束方法，回到方法调用处！
                    return ;
                default:
                    System.out.println("您的选择有误，请重写输入！");
                    break;
            }
        }


    }
}
