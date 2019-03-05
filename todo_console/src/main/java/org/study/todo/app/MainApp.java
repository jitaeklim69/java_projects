package org.study.todo.app;

import java.util.Scanner;

import org.study.todo.model.Todo;
import org.study.todo.service.TodoService;
import org.study.todo.service.TodoServiceImpl;
import org.study.todo.utility.TodoUtility;


public class MainApp {

	public static void main(String[] args) {
		TodoService service = new TodoServiceImpl();
		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("명령어: ");
			String command = scanner.nextLine();
			Todo todo = null;
			int index = -1;
			char c = command.toLowerCase().charAt(0);
			switch (c) {
			case 'i':
				// Todo 일정을 사용자로 부터 입력받아
				// Todo 객체를 생성
				System.out.println("일정 추가");
				todo = TodoUtility.generateTodo();
				service.AddTodo(todo);
				break;
			case 'l':
				System.out.println("일정 출력");
				service.ListTodo(null);;
				break;
			case 'u':
				System.out.println("일정 수정");
				// 수정을 위한 UI
				// 수정을 위한 todo
				service.updateTodo(todo);
				break;
			case 'd':	
				System.out.println("일정 삭제");
				System.out.print("삭제 인덱스: ");
				index = Integer.parseInt(scanner.nextLine());
				service.removeTodo(index);
				break;
			case 's':
				System.out.println("일정 검색");
				
			
			case 'q':
				System.out.println("Good bye!!!");
				System.exit(0);
				break;
			
			default:
				System.out.println("알수 없는 명령입니다. 다시 입력");
				break;
			}	
		}

	}

}
