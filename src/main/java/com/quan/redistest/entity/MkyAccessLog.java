package com.quan.redistest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mky_access_log")
public class MkyAccessLog implements java.io.Serializable {

    private static final long serialVersionUID = -1943961352036134112L;

    @Id
	@Column(name="id")
    private String id;
    
    @Column(name="count")
    private String count;

    @Column(name="create_datetime")
    private String createDatetime;
    
    @Column(name="type")
    private String type;

    @Column(name="del_flag")
    private String delFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getCreateDatetime() {
		return createDatetime;
	}

	public void setCreateDatetime(String createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
    
}
