package com.twu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 使用Comparable接口
public class HotSearch implements Comparable<HotSearch>{
    // 记录热搜排行
    static List<HotSearch> hotSearchList = new ArrayList<>();
    // 记录热搜排行购买价格
    static List<Double> hotSearchRankPriceList = new ArrayList<>();

    private String hotSearchName; // 热搜名称
    private int hotSearchVoteNum; // 热搜票数
    private boolean superHotSearch; // 超级热搜标志
    private double hotSearchRankPrice; // 热搜购买价格
    private int hotSearchRankNumToBuy; // 购买的热搜排行序号

    // 构造函数
    public HotSearch(String hotSearchName) {
        this.hotSearchName = hotSearchName;
        this.hotSearchVoteNum = 0;
        this.superHotSearch = false;
        this.hotSearchRankPrice = 0.0;
        this.hotSearchRankNumToBuy = Integer.MAX_VALUE; // 设置购买序号的初始值为理论最大
    }

    // 查看热搜排行
    public static void showHotSearchList() {
        if (hotSearchList.isEmpty()) {
            System.out.println("当前没有热搜");
            System.out.println();
            return;
        }
        int hotSearchRankNum = 1; // 当前打印的热搜排行序号
        int hotSerchRankNumToReplace = 0; // 替换的热搜排行序号
        // 遍历
        for (HotSearch hotSearch : hotSearchList) {
            // 购买同一序号的热搜中只显示金额最高的
            if (hotSearch.hotSearchRankNumToBuy != hotSerchRankNumToReplace || hotSearch.hotSearchRankNumToBuy == Integer.MAX_VALUE) {
                System.out.println(hotSearchRankNum + " " + hotSearch.hotSearchName + " " + hotSearch.hotSearchVoteNum);
                hotSearchRankNum++;
                hotSerchRankNumToReplace = hotSearch.hotSearchRankNumToBuy;
            }
        }
        System.out.println();
    }

    // 添加热搜
    public static boolean addHotSearch(String hotSearchName) {
        for (HotSearch hotSearch : hotSearchList) {
            if (hotSearch.hotSearchName.equals(hotSearchName)) {
                return false;
            }
        }
        HotSearch newHotSearch = new HotSearch(hotSearchName);
        double initHotSearchRankPrice = 0.0;
        hotSearchList.add(newHotSearch);
        hotSearchRankPriceList.add(initHotSearchRankPrice);
        return true;
    }

    // 添加超级热搜
    public static boolean addSuperHotSearch(String hotSearchName) {
        for (HotSearch hotSearch : hotSearchList) {
            if (hotSearchName.equals(hotSearch.hotSearchName)) {
                hotSearch.superHotSearch = true;
                return true;
            }
        }
        return false;
    }

    // 给热搜投票
    public static boolean hotSearchVoteNumAdd(String hotSearchName, int voteNum) {
        for(HotSearch hotSearch : hotSearchList){
            if (hotSearchName.equals(hotSearch.hotSearchName)) {
                // 超级热搜的新增票数为投票数的两倍
                if (hotSearch.superHotSearch) {
                    voteNum *= 2;
                }
                hotSearch.hotSearchVoteNum += voteNum;
                hotSearchRank();
                return true;
            }
        }
        return false;
    }

    // 购买热搜
    public static boolean hotSearchBuyRank(String hotSearchName, double hotSearchRankPrice, int hotSearchRankNumToBuy) {
        if(hotSearchRankPriceList.get(hotSearchRankNumToBuy) > hotSearchRankPrice || hotSearchRankPrice <= 0) {
            return false;
        }
        // 设置热搜排行序号对应的购买价格
        hotSearchRankPriceList.set(hotSearchRankNumToBuy, hotSearchRankPrice);
        for(HotSearch hotSearch : hotSearchList){
            if(hotSearchName.equals(hotSearch.hotSearchName)){
                hotSearch.hotSearchRankPrice = hotSearchRankPrice;
                hotSearch.hotSearchRankNumToBuy = hotSearchRankNumToBuy;
                hotSearchRank();
                return true;
            }
        }
        return false;
    }

    // 热搜排序
    private static void hotSearchRank() {
        Collections.sort(hotSearchList);
    }

    // 重写compareTo方法
    @Override
    public int compareTo(HotSearch hotSearch){
        // 购买了热搜
        if(this.hotSearchRankNumToBuy < hotSearch.hotSearchRankNumToBuy) {
            return -1; // Collections.sort(List)方法降序
        }
        else if(this.hotSearchRankNumToBuy > hotSearch.hotSearchRankNumToBuy) {
            return 1; // Collections.sort(List)方法升序
        }
        // 购买了同一热搜序号
        else if(this.hotSearchRankPrice != 0 || hotSearch.hotSearchRankPrice != 0) {
            // 比较热搜购买金额
            if (this.hotSearchRankPrice > hotSearch.hotSearchRankPrice) {
                return -1; // Collections.sort(List)方法降序
            }
            else {
                return 1; // Collections.sort(List)方法升序
            }
        }
        // 未购买热搜
        else {
            // 比较热搜票数
            if (this.hotSearchVoteNum > hotSearch.hotSearchVoteNum) {
                return -1; // Collections.sort(List)方法降序
            }
            else {
                return 1; // Collections.sort(List)方法升序
            }
        }
    }
}
