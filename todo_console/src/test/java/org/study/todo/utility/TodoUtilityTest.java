package org.study.todo.utility;

import java.util.HashSet;
import java.util.Set;

import org.study.todo.model.Todo;

public class TodoUtilityTest {

	public static void main(String[] args) {
		Set<Todo> set = new HashSet<> ();
		
		for (int i = 0; i < 100; i++) {
			Todo todo = TodoUtility.generatorTodo();
			set.add(todo);
		}
		
		for (Todo todo : set) {
			System.out.println(todo);
		}
	}

}
