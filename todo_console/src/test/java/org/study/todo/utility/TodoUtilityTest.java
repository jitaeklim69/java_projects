package org.study.todo.utility;

import java.util.HashSet;
import java.util.Set;

import org.study.todo.model.Todo;

public class TodoUtilityTest {

	public static void main(String[] args) {
		Set<Todo> set = new HashSet<> ();
		/*
		for (int i = 0; i < 100; i++)
			System.out.println(TodoUtility.getRandomInt(0, 12));
		*/
		
		for (int i = 0; i < 100; i++) {
			Todo todo = TodoUtility.generateTodo();
			set.add(todo);
		}
		
		int index = 0;
		for (Todo todo : set) {
			System.out.println(String.valueOf(index) + ": " + todo);
			index++;
		}
		
	}

}
