package org.study.crm;

import java.util.Arrays;
import java.util.Scanner;

public class MainApp {
	static final int MAX_CUSTOMER_NUM = 1000;
	
	static String[] nameList = new String[MAX_CUSTOMER_NUM];
	static char[] genderList = new char[MAX_CUSTOMER_NUM];
	static String[] emailList = new String[MAX_CUSTOMER_NUM];
	static int[] birthYearList = new int[MAX_CUSTOMER_NUM];
	
	static int currentEmptyIndex = 0;
	
	public static void main(String[] args) {

		printGuide();
		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("명령어: ");
			String command = scanner.next();
			
			char c = command.toLowerCase().charAt(0);
			switch (c) {
			case 'i':
				insertCustomer();
				break;
			case 'l':
				listCustomers(null);
				break;
			case 'u':
				System.out.println("고객정보 수정");
				break;
			case 'd':	
				removeCustomer();
				break;
			case 'q':
				System.out.println("Good bye!!!");
				System.exit(0);
				break;
			case 'g':
				printGuide();
				break;
			default:
				System.out.println("알수 없는 명령입니다. 다시 입력");
				break;
			}	
		}	
	}

	// 사용자로 부터 삭제할 고객의 정보를 입력받아
	// 해당 사용자를 배열에서 삭제처리
	private static void removeCustomer() {
		System.out.println("고객정보 삭제");
		
		// 사용자로 부터 삭제할 고객 이름을 입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("삭제할 고객이름: ");
		String name = scanner.next();
		
		// 해당 고객의 정보를 추출
		int[] customers = findCustomer(name);
		// 주소값 --> { 0, 1 , 5}
		
		// 찾고자 하는 고객의 이름이 고객 리스트에 없는 경우,
		if (customers[0] == -1) {
			System.out.println("해당고객이 없습니다.");
			return;
		} else if (customers.length == 1) { // 해당 고객이 한명
			int index = customers[0];
			String tempName = nameList[index];
			nameList[index] = null;
			genderList[index] = 0;
			emailList[index] = null;
			birthYearList[index] = 0;
			
			System.out.println(tempName + " 고객을 삭제하였습니다.");
		} else { // 해당 고객이 여러명일 경우,
			System.out.println(name + " 고객이 여러명입니다.");
			listCustomers(customers);
			System.out.print("삭제 고객 인덱스: ");
			int foundIndex = scanner.nextInt();
			int index = customers[foundIndex];
			
			nameList[index] = null;
			genderList[index] = 0;
			emailList[index] = null;
			birthYearList[index] = 0;
			
			System.out.println("해당 고객을 삭제하였습니다.");
		}
	}

	// nameList배열에서 name에 주어진 이름과 동일한 인덱스를
	// 배열로 만들어 리턴
	// 만약, 없으면 [-1]
	private static int[] findCustomer(String name) {
		int count = 0;
		// 해당 이름을 가진 고객이 몇명인지?
		for (int i = 0; i < nameList.length; i++) {
			if (name.equals(nameList[i])) {
				count++;
			}
 		}
		
		//System.out.println("Count: " + count);
		
		if (count == 0) {
			int[] customers = {-1};
			return customers;
		} else {
			int[] customers = new int[count];
			int index = 0;
			for (int i = 0; i < nameList.length; i++) {
				if (name.equals(nameList[i])) {
					customers[index] = i;
					index++;
				}
	 		}
			
			return customers;
		}
	}

	private static void insertCustomer() {
		System.out.println("고객정보 입력");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름: ");
		String name = scanner.next();
		System.out.print("성별(M/F): ");
		char gender = scanner.next().charAt(0);
		System.out.print("이메일: ");
		String email = scanner.next();
		System.out.print("출생년도: ");
		int birthYear = scanner.nextInt();
		
		nameList[currentEmptyIndex] = name;
		genderList[currentEmptyIndex] = gender;
		emailList[currentEmptyIndex] = email;
		birthYearList[currentEmptyIndex] = birthYear;
		
		currentEmptyIndex++;
	}

	private static void listCustomers(int[] customerIndexes) {
		System.out.println("고객정보 출력");
		System.out.println("----(  )----" );
		
		if (customerIndexes == null) {
			for (int i = 0; i < MAX_CUSTOMER_NUM; i++) {
				if (nameList[i] != null) {
					System.out.println(i + " : " 
							+ nameList[i] + "\t" 
							+ genderList[i] + "\t" 
							+ emailList[i] + "\t" 
							+ birthYearList[i]);
				}
			}
		} else {
			for (int i = 0; i < customerIndexes.length; i++) {
				int index = customerIndexes[i];
				System.out.println(i + " : " 
						+ nameList[index] + "\t" 
						+ genderList[index] + "\t" 
						+ emailList[index] + "\t" 
						+ birthYearList[index]);
			}
		}	
	}

	private static void printGuide() {
		System.out.println("고객관리프로그램");
		System.out.println("----------------");
		System.out.println("(I)nsert, (L)ist, (U)pdate, (D)elete");
		System.out.println("(Q)uit, (G)uide");
		System.out.println("----------------");
	}

}
