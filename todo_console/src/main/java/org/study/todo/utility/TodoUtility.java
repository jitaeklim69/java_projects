package org.study.todo.utility;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.study.todo.model.BusinessTodo;
import org.study.todo.model.HomeTodo;
import org.study.todo.model.Todo;

public class TodoUtility {
	public static String[] homeTodoDesc = {
			"빨래하기", "청소하기", "장보기",
			"영화보기", "강아지돌보기", "마당쓸기"
	};
	
	public static String[] businessTodoDesc = {
		"미팅하기", "보고서작성", "코딩하기",
		"문서작성", "설계서작성", "회의하기",
		"테스트수행",
	};
	
	public static String[] detailDesc = {
			"세부사항1", "세부사항2", "세부사항3",
			"세부사항4"
	};
	
	public static Todo generateTodo() {
		Todo tempTodo = null;
		// HomeTodo객체
		if (getRandomInt(0, 2) == 0) {
			tempTodo = new HomeTodo();
			
			tempTodo.setId(getRandomInt(0, 99999));
			int descIndex = getRandomInt(0, homeTodoDesc.length);
			tempTodo.setDesc(homeTodoDesc[descIndex]);
			
			Date createDate = getRandomDate(null);
			tempTodo.setCreateDate(createDate);
			
			tempTodo.setDone(getRandomInt(0, 2) == 0 ? true : false);
			
			Date doneDate = getRandomDate(createDate);		
			((HomeTodo)tempTodo).setDoneDate(doneDate);
		} else { // BusinessTodo
			tempTodo = new BusinessTodo();
			tempTodo.setId(getRandomInt(0, 99999));
			
			int descIndex = getRandomInt(0, businessTodoDesc.length);
			tempTodo.setDesc(businessTodoDesc[descIndex]);
			
			Date createDate = getRandomDate(null);
			tempTodo.setCreateDate(createDate);
			
			tempTodo.setDone(getRandomInt(0, 2) == 0 ? true : false);
			
			Date doneDate = getRandomDate(createDate);		
			((BusinessTodo)tempTodo).setDoneDate(doneDate);
			
			descIndex = getRandomInt(0, detailDesc.length);
			((BusinessTodo)tempTodo).setDetailDesc(detailDesc[descIndex]);
		}
		
		return tempTodo;
	}

	public static int getRandomInt(int min, int max) {
		return min + (int)(Math.random() * (max - min) );
	}

	private static Date getRandomDate(Date createDate) {
		int year, createYear;
		int month;
		int day;
		
		// year 범위
		// Year of createDate ~ 오늘의 년도 ( createDate 년도)	
		if (createDate != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(createDate);
			
			createYear = cal.get(Calendar.YEAR); 
		} else {
			createYear = 2000;
		}
		 
		// year
		year = getRandomInt(createYear, 2019);  
		month = getRandomInt(0, 12);
		day = getRandomInt(1, 29);
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, day);
		return cal.getTime();
	}
}
