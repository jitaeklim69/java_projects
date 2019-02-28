일정관리 프로그램

 - Todo class (Abstract)
  . HomeTodo (상속)
  . BusinessTodo (상속)
  . virtual method
  
 - Todo class
  . 속성:
    Description(설명)
    생성일
    완료여부
    
 - HomeTodo class
  . 속성:
    완료일
    
 - BusinesTodo
  . 속성:
    완료일
   OrderPersonName
   DetailDescription
   
 - Service Interface
  . AddTodo
  . RemoveTodo
  . ListTodo
  	- HomeTodo / BusinessTodo
  . SearchTodo
    - 생성일/완료일
    - Description
    - OrderPersonName
  . UpdateTodo
  
 - Service class
  Set collection(list / set / map)
  
 - 테스트 코드
  . Main
  . Test folder