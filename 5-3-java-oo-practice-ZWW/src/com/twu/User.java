package com.twu;

public class User {
    private String userId; // 用户账号
    private int voteTot = 10; // 用户初始票数

    // 构造函数
    public User(String userId){
        this.userId = userId;
    }

    // 返回用户账号
    public String getUserId() {
        return this.userId;
    }

    // 用户给热搜投票
    public boolean userVoteHotSearch(String hotSearchName, int voteNum) {
        if (voteNum > this.voteTot) {
            return false;
        } else {
            this.voteTot -= voteNum;
            return HotSearch.hotSearchVoteNumAdd(hotSearchName, voteNum);
        }
    }

    // 用户购买热搜
    public boolean userBuyHotSearch(String hotSearchName, double hotSearchRankPrice, int hotSearchRankIsBuy) {
        return HotSearch.hotSearchBuyRank(hotSearchName, hotSearchRankPrice, hotSearchRankIsBuy);
    }
}
