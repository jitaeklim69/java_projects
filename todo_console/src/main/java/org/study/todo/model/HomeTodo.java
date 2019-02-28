package org.study.todo.model;

import java.util.Date;

public class HomeTodo extends Todo {

	private Date doneDate;
	
	public HomeTodo() { }

	public Date getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(Date doneDate) {
		this.doneDate = doneDate;
	}

	@Override
	public String toString() {
		return "HomeTodo [" + "Description: " + getDesc() 
				+ ", CreateDate: " + getCreateDate()
				+ ", isDone: " + isDone() 
				+ ", Id: " + getId() 
				+ ", doneDate: " + getDoneDate() 
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
		return -(this.getId() - o.getId());
	}
	
}
