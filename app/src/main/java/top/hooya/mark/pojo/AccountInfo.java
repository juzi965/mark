package top.hooya.mark.pojo;

import java.util.Date;

public class AccountInfo {

    private String accountName;

    private String userName;

    private String password;

    private String note;

    private Date createTime;

    private int delFlag;

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(int delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "accountName='" + accountName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                ", createTime=" + createTime +
                ", delFlag=" + delFlag +
                '}';
    }
}
