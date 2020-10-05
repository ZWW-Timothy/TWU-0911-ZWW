package com.twu;

public class Admin {
    private String adminId; // 管理员账号
    private String adminKey; // 管理员密码

    // 构造函数
    public Admin(String adminId, String adminKey) {
        this.adminId = adminId;
        this.adminKey = adminKey;
    }

    // 返回管理员账号
    public String getAdminId() {
        return this.adminId;
    }

    // 管理员登录验证
    public boolean check(String adminIdInput, String adminKeyInput) {
        return adminIdInput.equals(this.adminId) && adminKeyInput.equals(this.adminKey);
    }
}
