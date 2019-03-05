package org.study.todo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTimeComparator;
import org.study.todo.model.BusinessTodo;
import org.study.todo.model.HomeTodo;
import org.study.todo.model.Todo;

public class TodoServiceImpl implements TodoService {
	private static int id_seq = 1;
	
	private Set<Todo> todoSet = new HashSet<> ();
	
	@Override
	public void AddTodo(Todo todo) {
		todoSet.add(todo);
	}

	@Override
	public Todo removeTodo(int id) {
		Todo removeItem = null;
		for (Todo temp : todoSet) {
			if (temp.getId() == id) {
				if (todoSet.remove(temp)) {
					removeItem = temp;
				}
			}
		}
	
		return removeItem;
	}

	@Override
	public void ListTodo(String todoType) {
		int index = 0;
		if (todoType == null) {
			Iterator<Todo> iter = todoSet.iterator();
			while (iter.hasNext()) {
				System.out.println(index + ": " + iter.next());
				index++;
			}
		} else if (todoType.equalsIgnoreCase("home")) {
			Iterator<Todo> iter = todoSet.iterator();
			while (iter.hasNext()) {
				Todo temp = iter.next();
				if (temp instanceof HomeTodo) {
					System.out.println(index + ": " + temp);
					index++;
				}
			}
		} else if (todoType.equalsIgnoreCase("business")) {
			Iterator<Todo> iter = todoSet.iterator();
			while (iter.hasNext()) {
				Todo temp = iter.next();
				if (temp instanceof BusinessTodo) {
					System.out.println(index + ": " + temp);
					index++;
				}
			}
		} else {
			System.out.println("조건에 맞는 일정이 없습니다");
		}

	}

	@Override
	public Todo[] searchTodo(Date createDate, Date doneDate) {
		List<Todo> list = new ArrayList<> ();
		
		/*
		for (Todo todo : todoSet) {
			if (createDate != null && doneDate != null) {
				if (todo.getCreateDate().equals(createDate) &&
						todo.getDoneDate().equals(doneDate)) {
					list.add(todo);
				}
			} else if (createDate != null) {
				if (todo.getCreateDate().equals(createDate)) {
					list.add(todo);
				}
			} else if (doneDate != null) {
				if (todo.getDoneDate().equals(doneDate)) {
					list.add(todo);
				}
			}
		}
		*/
		
		// Time부분은 무시하고 비교하는 로직
		DateTimeComparator dateComparator = 
				DateTimeComparator.getDateOnlyInstance();
		
		for (Todo todo : todoSet) {
			if (createDate != null && doneDate != null) {
				if (dateComparator
							.compare(todo.getCreateDate(), createDate) == 0 
						&&
						dateComparator
							.compare(todo.getDoneDate(), doneDate) == 0 
						) {
					list.add(todo);
				}
			} else if (createDate != null) {
				if (dateComparator
						.compare(todo.getCreateDate(), createDate) == 0) {
					list.add(todo);
				}
			} else if (doneDate != null) {
				if (dateComparator
						.compare(todo.getDoneDate(), doneDate) == 0) {
					list.add(todo);
				}
			}
		}
		
		return list.toArray(new Todo[0]);
	}

	@Override
	public Todo[] searchTodo(String desc) {
		List<Todo> list = new ArrayList<> ();
		
		for (Todo todo : todoSet) {
			if (todo.getDesc().equalsIgnoreCase(desc)) {
				list.add(todo);
			}
		}
		
		return list.toArray(new Todo[0]);
	}

	@Override
	public Todo[] searchTodoByOrder(String orderName) {
		List<Todo> list = new ArrayList<> ();
		
		for (Todo todo : todoSet) {
			if (todo instanceof BusinessTodo) {
				BusinessTodo bTodo = (BusinessTodo)todo;
				if (bTodo.getOrderName().equalsIgnoreCase(orderName)) {
					list.add(bTodo);
				}
			}
		}
		
		return list.toArray(new Todo[0]);
	}

	@Override
	public boolean updateTodo(Todo todo) {
		Todo target = null;
		/*
		for (Todo currentTodo : todoSet) {
			if (currentTodo.getId() == todo.getId()) {
				target = currentTodo;
				break;
			}
		}
		*/
		Iterator<Todo> iter = todoSet.iterator();
		while (iter.hasNext()) {
			Todo currentTodo = iter.next();
			if (currentTodo.getId() == todo.getId()) {
				iter.remove();
				break;
			}
		}
		
		//todoSet.remove(target);
		todoSet.add(todo);
		
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
