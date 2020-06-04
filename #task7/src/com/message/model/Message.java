package com.message.model;

import java.util.Date;

public class Message {
    private Integer messageid;

    private Integer receiveid;

    private Integer senderid;

    private Date messagetime;
    private String timestring;

    private Integer parentmessageid;

    private String content;
    
    private String pic;

    public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public Integer getReceiveid() {
        return receiveid;
    }

    public void setReceiveid(Integer receiveid) {
        this.receiveid = receiveid;
    }

    public Integer getSenderid() {
        return senderid;
    }

    public void setSenderid(Integer senderid) {
        this.senderid = senderid;
    }

    public Date getMessagetime() {
        return messagetime;
    }

    public void setMessagetime(Date messagetime) {
        this.messagetime = messagetime;
    }

    public Integer getParentmessageid() {
        return parentmessageid;
    }

    public void setParentmessageid(Integer parentmessageid) {
        this.parentmessageid = parentmessageid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

	public String getTimestring() {
		return timestring;
	}

	public void setTimestring(String timestring) {
		this.timestring = timestring;
	}
    
}