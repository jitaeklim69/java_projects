package org.study.todo.service;

import java.util.Date;

import org.study.todo.model.Todo;

public class TodoServiceImpl implements TodoService {
	private static int id_seq = 1;
	
	@Override
	public void AddTodo(Todo todo) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeTodo(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ListTodo(String todoType) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Todo[] searchTodo(Date createDate, Date doneDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo[] searchTodo(String desc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Todo[] searchTodoByOrder(String orderName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateTodo(Todo todo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getUniqueId() {
		// TODO Auto-generated method stub
		int id = id_seq;
		id_seq++;
		return id;
	}

}
