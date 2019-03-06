package org.study.todo.service;

import java.io.DataOutputStream;
import java.util.Date;

import org.study.todo.model.Todo;

public interface TodoService {

	public int getUniqueId();
	public void AddTodo(Todo todo);
	public Todo removeTodo(int id);
	// todoType이 Null이면 모든 일정
	// "home" --> HomeTodos
	// "business" --> BusinessTodos
	public void ListTodo(String todoType);
	public Todo[] searchTodo(Date createDate, Date doneDate);
	public Todo[] searchTodo(String desc);
	public Todo[] searchTodoByOrder(String orderName);
	public boolean updateTodo(Todo todo);
	
	public boolean saveToFile(DataOutputStream out);
	
}
