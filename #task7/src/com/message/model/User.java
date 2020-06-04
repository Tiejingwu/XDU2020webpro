package com.message.model;

import java.util.Date;

public class User {
    private Integer userid;

    private String qq;

    private String username;

    private String password;

    private String headpic;

    private Integer sex;

    private Date birthday;
    private String birthdayString;

    private Integer state;

    private String nowaddress;

    private String hometown;

    private Integer ismarry;

    private Date lastvisit;
    private String lastvisitString;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic == null ? null : headpic.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getNowaddress() {
        return nowaddress;
    }

    public void setNowaddress(String nowaddress) {
        this.nowaddress = nowaddress == null ? null : nowaddress.trim();
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown == null ? null : hometown.trim();
    }

    public Integer getIsmarry() {
        return ismarry;
    }

    public void setIsmarry(Integer ismarry) {
        this.ismarry = ismarry;
    }

    public Date getLastvisit() {
        return lastvisit;
    }

    public void setLastvisit(Date lastvisit) {
        this.lastvisit = lastvisit;
    }

	public String getBirthdayString() {
		return birthdayString;
	}

	public void setBirthdayString(String birthdayString) {
		this.birthdayString = birthdayString;
	}

	public String getLastvisitString() {
		return lastvisitString;
	}

	public void setLastvisitString(String lastvisitString) {
		this.lastvisitString = lastvisitString;
	}
    
}