package org.study.todo.app;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import org.study.todo.model.Todo;
import org.study.todo.service.TodoService;
import org.study.todo.service.TodoServiceImpl;
import org.study.todo.utility.TodoUtility;


public class MainApp {

	final static String fileName = ".todo_sav.dat";
	
	static Scanner scanner = new Scanner(System.in);
	static TodoService service = new TodoServiceImpl();
	
	public static void main(String[] args) {

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
				Todo[] findTodos = procSearch();
				System.out.println(Arrays.toString(findTodos));
				break;
			case 'a':
				System.out.println("일정 정보 파일에 저장");
				if (saveToFile(fileName)) {
					System.out.println("File: " + fileName + " 저장 성공...");
				} else {
					System.out.println("저장에 실패하였습니다");
				}
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

	private static boolean saveToFile(String fName) {
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(fName);
			DataOutputStream out = new DataOutputStream(fout);
			
			return service.saveToFile(out);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	private static Todo[] procSearch() {
		System.out.print("날짜(1), 설명(2), 지시자(3): ");
		int mode = Integer.parseInt(scanner.nextLine());
		Todo[] todos = null;
		
		if (mode == 1) {
			System.out.print("생성일(YYYY-MM-DD): ");
			String cDateStr = scanner.nextLine();
			Date cDate = null;
			if (cDateStr.length() != 0) {
				SimpleDateFormat dateFormat = 
						new SimpleDateFormat("yyyy-MM-dd");
				try {
					cDate = dateFormat.parse(cDateStr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.print("완료일(YYYY-MM-DD): ");
			String dDateStr = scanner.nextLine();
			Date dDate = null;
			if (dDateStr.length() != 0) {
				SimpleDateFormat dateFormat = 
						new SimpleDateFormat("yyyy-MM-dd");
				try {
					dDate = dateFormat.parse(dDateStr);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			System.out.println("생성일: " + cDate
					+ ", 완료일: " + dDate);
			
			todos = service.searchTodo(cDate, dDate);
		} else if (mode == 2) {
			System.out.print("설명입력: ");
			String desc = scanner.nextLine();
			
			todos = service.searchTodo(desc);
		} else if (mode == 3) {
			
		} else {
			System.out.println("알수없는 모드입니다");
		}
		
		return todos;
	}

}
