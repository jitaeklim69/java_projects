package org.study.todo.model;

import java.util.Date;

import org.study.todo.service.TodoService;
import org.study.todo.service.TodoServiceImpl;

public abstract class Todo implements Comparable<Todo> {
	
	private static TodoService service = new TodoServiceImpl();
	
	// id 속성은 생성자에서 자동 고유하게 부여
	private int id;	// primary key
	private String desc;
	private Date createDate;
	private boolean isDone;
	
	public Todo() {
		id = service.getUniqueId();
		createDate = new Date();
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public abstract Date getDoneDate() ;

	@Override
	public String toString() {
		return "Todo [id=" + id + ", desc=" + desc + ", createDate=" + createDate + ", isDone=" + isDone + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
