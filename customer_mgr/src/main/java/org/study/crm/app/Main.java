package org.study.crm.app;

import java.util.Scanner;

import org.study.crm.entity.Customer;
import org.study.crm.service.CRMService;
import org.study.crm.service.CRMServiceImpl;
import org.study.crm.service.CustomerUtility;

public class Main {

	public static void main(String[] args) {
		
		CRMService service = new CRMServiceImpl();
		CustomerUtility utility = new CustomerUtility();
		
		service.printGuide();
		
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.print("명령어: ");
			String command = scanner.nextLine();
			Customer customer = null;
			int index = -1;
			char c = command.toLowerCase().charAt(0);
			switch (c) {
			case 'i':
				customer = utility.createCustomer(); 
				System.out.println(customer);
				service.insertCustomer(customer);
				break;
			case 'l':
				service.listCustomers();
				break;
			case 'u':
				System.out.println("고객정보 수정");
				index = utility.updateCustomer();
				customer = service.findCustomer(index);
				customer = utility.updateCustomer(customer);
				service.updateCustomer(index, customer);
				break;
			case 'd':	
				index = utility.removeCustomer();
				//System.out.println("지울 인덱스: " + index);
				customer = service.removeCustomer(index);
				
				if (customer == null) {
					System.out.println("잘못된 인덱스입니다.");
				} else {
					System.out.println(customer.getName() 
							+ " 이 삭제되었습니다.");
				}
				break;
			case 'q':
				System.out.println("Good bye!!!");
				System.exit(0);
				break;
			case 'g':
				service.printGuide();
				break;
			default:
				System.out.println("알수 없는 명령입니다. 다시 입력");
				break;
			}	
		}

	}

}
