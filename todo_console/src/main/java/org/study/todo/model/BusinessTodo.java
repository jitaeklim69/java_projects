package org.study.todo.model;

import java.util.Date;

public class BusinessTodo extends Todo {

	private Date doneDate;
	private String orderName;
	private String detailDesc;
	
	public BusinessTodo() {}

	public Date getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getDetailDesc() {
		return detailDesc;
	}

	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}

	@Override
	public String toString() {
		return "BusinessTodo [" 
				+ super.toString()
				+ ", doneDate=" + doneDate + ", orderName=" 
				+ orderName + ", detailDesc=" + detailDesc
				+ "]";
	}

	@Override
	public int compareTo(Todo o) {
		/*
		if (this.getId() > o.getId() ) {
			return 1;
		} else if (this.getId() == o.getId()) {
			return 0;
		} else {
			return -1;
		}
		*/
		return this.getId() - o.getId();
	}
	
	
}
