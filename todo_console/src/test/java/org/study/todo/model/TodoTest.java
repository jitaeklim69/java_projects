package org.study.todo.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TodoTest {

	public static void main(String[] args) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date tempDate = null;
		try {
			tempDate = format.parse("2019-1-1");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Todo todo = new HomeTodo();
		todo.setDesc("일정1");
		todo.setCreateDate(tempDate);
		
		Todo todo2 = new HomeTodo();
		todo2.setDesc("일정2");
		
		try {
			tempDate = format.parse("2019-1-5");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		todo2.setCreateDate(tempDate);
		
		Todo todo3 = new HomeTodo();
		todo3.setDesc("일정3");
		try {
			tempDate = format.parse("2019-2-1");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		todo3.setCreateDate(tempDate);
		
		BusinessTodo todo4 = new BusinessTodo();
		todo4.setDesc("회사일1");
		todo4.setDetailDesc("보고서 작성");
		todo4.setOrderName("김부장");
		try {
			tempDate = format.parse("2019-2-5");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		todo4.setCreateDate(tempDate);
		
		BusinessTodo todo5 = new BusinessTodo();
		todo5.setDesc("회사일2");
		todo5.setDetailDesc("임원미팅");
		try {
			tempDate = format.parse("2019-3-1");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		todo5.setCreateDate(tempDate);
		
		/*
		System.out.println(todo);
		System.out.println(todo2);
		System.out.println(todo3);
		System.out.println(todo4);
		System.out.println(todo5);
		*/
		
		Set<Todo> set = new HashSet<> ();
		set.add(todo);
		set.add(todo2);
		set.add(todo3);
		set.add(todo4);
		set.add(todo5);
		
		todo.setDesc("일정변경");
		todo5.setDone(true);
		
		set.add(todo);
		set.add(todo5);

		List<Todo> list = new ArrayList<> (set);
		//compartor 객체를 통해 정렬
		/*
		TodoCreateDateComparator com = new TodoCreateDateComparator();
		//list.sort(com);
		list.sort(new TodoDescComparator());
		*/
		
		// comparable 인터페이스를 통한 정렬
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

}

class TodoCreateDateComparator implements Comparator<Todo> {

	@Override
	// o1 객체가 크다고 생각하면, 양수를 
	// 같으면, 0
	// 작으면, 음수를 리턴
	public int compare(Todo o1, Todo o2) {
		Date firstDate = o1.getCreateDate();
		Date lastDate = o2.getCreateDate();
		
		/*
		if (firstDate.compareTo(lastDate) > 0) {
			return 1;
		} else if (firstDate.compareTo(lastDate) == 0) {
			return 0;
		} else {
			return -1;
		}
		*/
		return firstDate.compareTo(lastDate);
	}
	
}

class TodoDescComparator implements Comparator<Todo> {

	@Override
	public int compare(Todo o1, Todo o2) {
		String firstDesc = o1.getDesc();
		String lastDesc = o2.getDesc();
		
		return firstDesc.compareTo(lastDesc);
	}
	
}


