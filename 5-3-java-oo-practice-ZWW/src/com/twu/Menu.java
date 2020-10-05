package com.twu;

import java.util.Scanner;

public class Menu {
    // 创建Scanner类的实例，获得键盘输入
    static Scanner keyboardInput = new Scanner(System.in);

    // 主菜单及管理员菜单、用户菜单
    public static void menuOption() {
        boolean mainMenuExit = false; // 主菜单退出标志
         // 退出主菜单则中止
        while (!mainMenuExit) { 
            String mainOption = Menu.mainMenuOption(); // 获得主菜单输入选项
            Integer mainOptionMin = 1; // 设置主菜单最小选项
            Integer mainOptionMax = 3; // 设置主菜单最大选项
            Menu.checkOption(mainOption, mainOptionMin, mainOptionMax); // 检查选项是否合法
            String hotSearchName = "";
            switch (mainOption) {
                case "1": // 管理员选项
                    boolean adminExit = false; // 管理员菜单退出标志
                    String adminId = "admin";  // 设置管理员账号
                    String adminKey = "123456"; // 设置管理员密码
                    Admin admin = new Admin(adminId, adminKey); // 设置管理员账号与密码
                    String adminIdInput = Menu.input("账号"); // 获得账号输入
                    String adminKeyInput = Menu.input("密码"); // 获得密码输入
                    boolean adminLogin = admin.check(adminIdInput, adminKeyInput); // 检查管理员登陆是否成功标志
                    Menu.judgeState("登录", adminLogin); // 显示管理员登陆是否成功
                    // 登陆失败则不能进入管理员菜单
                    if (!adminLogin) {
                        adminExit = true;
                    }
                    // 进入管理员菜单
                    while (!adminExit) {
                        String adminOption = Menu.adminMenuOption(admin.getAdminId()); // 获得管理员菜单输入选项
                        Integer adminOptionMin = 1; // 设置最小选项
                        Integer adminOptionMax = 4; // 设置最大选项
                        Menu.checkOption(adminOption, adminOptionMin, adminOptionMax); // 检查选项是否合法
                        switch (adminOption) {
                            case "1": // 查看热搜排行
                                HotSearch.showHotSearchList();
                                break;
                            case "2": // 添加热搜
                                hotSearchName = Menu.input("热搜");
                                Menu.judgeState("添加热搜", HotSearch.addHotSearch(hotSearchName)); // 显示添加热搜结果
                                break;
                            case "3": // 添加超级热搜
                                String superHotSearchName = Menu.input("热搜");
                                Menu.judgeState("添加超级热搜", HotSearch.addSuperHotSearch(superHotSearchName)); // 显示添加超级热搜结果
                                break;
                            case "4": // 退出
                                adminExit = true;
                                Menu.menuExit(); // 显示退出提示
                                break;
                        }
                    }
                    break;
                case "2":// 用户选项
                    boolean userExit = false; // 用户菜单退出标志
                    String userId = Menu.input("账号");
                    User user = new User(userId);
                    // 进入用户菜单
                    while (!userExit) {
                        String userOption = Menu.userMenuOption(user.getUserId());
                        Integer userOptionMin = 1; // 设置最小选项
                        Integer userOptionMax = 5; // 设置最大选项
                        Menu.checkOption(mainOption, userOptionMin, userOptionMax); // 检查选项是否合法
                        switch (userOption) {
                            case "1": // 查看热搜排行
                                HotSearch.showHotSearchList();
                                break;
                            case "2": // 给热搜投票
                                hotSearchName = Menu.input("热搜");
                                int voteNum = Integer.parseInt(Menu.input("投票数"));
                                Menu.judgeState("投票", user.userVoteHotSearch(hotSearchName, voteNum));
                                break;
                            case "3": // 添加热搜
                                hotSearchName = Menu.input("热搜");
                                Menu.judgeState("添加热搜", HotSearch.addHotSearch(hotSearchName));
                                break;
                            case "4": // 购买热搜
                                hotSearchName = Menu.input("热搜");
                                double hotSearchRankPrice = Double.parseDouble(Menu.input("金额"));
                                int hotSearchRankNumToBuy = Integer.parseInt(Menu.input("序号"));
                                Menu.judgeState("购买", user.userBuyHotSearch(hotSearchName, hotSearchRankPrice, hotSearchRankNumToBuy));
                                break;
                            case "5": // 退出
                                userExit = true;
                                Menu.menuExit(); // 显示退出提示
                                break;
                        }
                    }
                    break;
                case "0": // 退出选项
                    mainMenuExit = true;
                    Menu.menuExit(); // 显示退出提示
            }
        }
    }

    // 主菜单选项显示
    public static String mainMenuOption() {
        // 显示并换行
        System.out.println("欢迎使用热搜排行！");
        System.out.println("请选择：");
        System.out.println("1. 管理员菜单");
        System.out.println("2. 用户菜单");
        System.out.println("3. 退出");
        // 返回输入值
        return keyboardInput.nextLine();
    }

    // 管理员菜单选项显示
    public static String adminMenuOption(String adminName) {
        System.out.println("管理员" + adminName + "，您好！");
        System.out.println("请选择：");
        System.out.println("1. 查看热搜排行");
        System.out.println("2. 添加热搜");
        System.out.println("3. 添加超级热搜");
        System.out.println("4. 退出");
        return keyboardInput.nextLine();
    }

    // 用户菜单选项显示
    public static String userMenuOption(String userName) {
        System.out.println("用户" + userName + "，您好！");
        System.out.println("请选择：");
        System.out.println("1. 查看热搜排行");
        System.out.println("2. 给热搜投票");
        System.out.println("3. 添加热搜");
        System.out.println("4. 购买热搜");
        System.out.println("5. 退出");
        return keyboardInput.nextLine();
    }

    // 获得输入
    public static String input(String inputPrompt) {
        System.out.println("请输入"+ inputPrompt +"：");
        return keyboardInput.nextLine();
    }

    // 显示结果
    public static void judgeState(String outputPrompt, boolean state) {
        if (state) {
            System.out.println(outputPrompt + "成功");
        }
        else {
            System.out.println(outputPrompt + "失败");
        }
        System.out.println();
    }

    // 判断选项是否合法
    public static void checkOption(String option, int optionMin, int optionMax) {
        if (Integer.valueOf(option) > optionMax || Integer.valueOf(option) < optionMin) {
            System.out.println("非法选项");
        }
    }

    // 显示退出提示
    public static void menuExit() {
        System.out.println("退出");
        System.out.println();
    }
}
