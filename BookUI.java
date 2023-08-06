package com.example.myIO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public class BookUI {
    private BufferedReader br;
    public BookUI(){
        br=new BufferedReader(new InputStreamReader(System.in));
    }

    public int menu(){
        System.out.println("1. 도서 등록");
        System.out.println("2. 도서 목록보기");
        System.out.println("3. 특정도서 할인");
        System.out.println("4. 도서 판매하기");
        System.out.println("5. 도서 판매수익 보기"); // 판매수익 보기 메뉴 추가
        System.out.println("6. 종료");
        int menuId=-1;
        try {
            String line = br.readLine();
            menuId=Integer.parseInt(line); //문자열을 정수로 바꿔줌.
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return menuId;
    }
    //4번 도서판매:도서명 입력받기
    public String inputSoldOutTitle(){
        System.out.println("판매할 도서명을 입력하세요");
        String title1="";

        try{
            title1 = br.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return title1;
    }


    //3번 특정도서 할인 : 단계1.도서명 입력받기
    public String inputDCTitle(){
        System.out.println("할인할 도서명을 입력하세요");
        String title="";
        try {
            title= br.readLine();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return title;
    }
    //3번 특정도서 할인 : 단계2. 입력한 도서명과 일치하는 해당 도서 가격 수정하기(할인 적용)
    public Book inputBook(String title){
        try {
            System.out.println(title+" 해당 도서에 대한 할인을 적용합니다.");
            System.out.println("저자 제목을 입력하세요");
            String writer = br.readLine();
            System.out.println("할인이 적용된 도서 가격을 입력하세요");
            String temporaryprice = br.readLine();
            int price=Integer.parseInt(temporaryprice);

            Book book=new Book(title, writer, price);
            return book;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    //1번. 등록
    public Book regBook(){
        try {
            System.out.println("도서 제목을 입력하세요");
            String title = br.readLine();
            System.out.println("저자 제목을 입력하세요");
            String writer = br.readLine();
            System.out.println("도서 가격을 입력하세요");
            String temporaryprice = br.readLine();
            int price=Integer.parseInt(temporaryprice);

            Book book=new Book(title, writer, price);
            return book;

        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    //2번. 도서 목록
    public void printBookList(List<Book> books){
        System.out.println("도서 제목              저자      가격      할인금액");
        System.out.println("=================================================");
        for(int i=0; i< books.size();i++){
            Book book=books.get(i);
            System.out.print(book.getTitle());
            System.out.print("              ");
            System.out.print(book.getWriter());
            System.out.print("      ");
            System.out.print(book.getPrice());

            // 할인 금액
            System.out.print("      ");
            System.out.print(book.getDiscPrice());

            System.out.println();
        }
    }
//5번 판매수익보기
    public void printSoldBookList(List<Book> books){
        // 지금은 판매된 도서 목록과 총 판매 금액을 출력함
        // 만약 수익 금액 출력이 필요하면 수익금액을 계산하는 로직 추가 필요
        // 도서 판매가 - 원금 - 할인 = 마진 ?

        int totalSoldPrice = 0;

        System.out.println("도서 제목      가격     판매가격");
        System.out.println("==================================");
        for(int i=0; i< books.size();i++){
            Book book = books.get(i);
            int soldPrice = book.getSoldPrice();
            totalSoldPrice += soldPrice;

            System.out.print(book.getTitle());
            System.out.print("      ");
            System.out.print(book.getPrice());
            System.out.print("      ");
            System.out.print(soldPrice);
            System.out.println();
        }
        System.out.println("==================================");
        System.out.println("총 판매금액: " + totalSoldPrice);
    }
}
