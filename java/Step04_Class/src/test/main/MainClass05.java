package test.main;

import test.mypac.News;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		// 뉴스 하나를 News 클래스를 이용해서 담고싶다.
		News.title = "얀센 백신 추가 접종";
		News.content = "1차 접종 예약 오늘부터 받아요";
		News.writer = "김구라 기자";
		
		// 뉴스가 하나 더 있다면?
		
		System.out.println(News.title);
		System.out.println(News.content);
		System.out.println(News.writer);
		*/
		
		// 뉴스 하나를 News 클래스를 이용해서 담고싶다.
		News n1 = new News();
		n1.title = "얀센 백신 추가 접종";
		n1.content = "1차 접종 예약 오늘부터 받아요";
		n1.writer = "김구라 기자";
		
		// 뉴스가 하나 더 있다면?
		News n2 = new News();
		n2.title = "xxx";
		n2.content = "xxxxx";
		n2.writer = "xxx 기자";
		
		n1.showInfo();
		n2.showInfo();
	}
}
