package com.yaorange.pojo;

import java.util.ArrayList;
import java.util.List;

public class EUTreeNode {
	 private long id;
	 private long pid;
	 private String  text;
	 private List<EUTreeNode> children  = new ArrayList<>(0);

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<EUTreeNode> getChildren() {
		return children;
	}
	public void setChildren(List<EUTreeNode> children) {
		this.children = children;
	}

}
