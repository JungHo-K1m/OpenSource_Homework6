package 오픈소스과제6;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class Quiz_n2 {
	private HashMap<String, String> store = new HashMap<String, String>();
	private Scanner scanner = new Scanner(System.in);
	
	public Quiz_n2() {
		store.put("한국", "서울");
		store.put("중국", "베이징");
		store.put("일본", "도쿄");
		store.put("미국", "위싱턴DC");
		store.put("영국", "런던");
		store.put("스페인", "리스본");
		store.put("이탈리아", "로마");
		store.put("체코", "프라하");
		store.put("독일", "베를린");
	}
	
	private void error(String msg) {
		System.out.println(msg);
	}
	
	public void run() {
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
		while(true) {
			System.out.print("입력:1, 퀴즈:2, 종료:3>> ");
			int menu = scanner.nextInt();
			switch(menu) {
				case 1: input(); break;
				case 2: quiz(); break;
				case 3: finish(); return;
				default: 
					error("잘못된 입력입니다.");
			}
		}
		
	}
	
	private void input() {
		int n = store.size();
		System.out.println("현재 " + n + "개 나라와 수도가 입력되어 있습니다.");
		n++;
		while(true) {
			System.out.print("나라와 수도 입력" + n + ">> ");
			String country = scanner.next();
			if(country.equals("그만")) {
				break;
			}
			String capital = scanner.next();
			if(store.containsKey(country)) {
				System.out.println(country + "는 이미 있습니다");
				continue;
			}
			store.put(country, capital);
			n++;
		}
	}
	private void quiz() {
		Set<String> keys = store.keySet();
		Object [] array = (keys.toArray());
		while(true) {
			int index = (int)(Math.random()*array.length);
			
			String question = (String)array[index];
			String answer = store.get(question);
			
			System.out.print(question + "의 수도는? ");
			
			String capitalFromUser = scanner.next();
			if(capitalFromUser.equals("그만")) {
				break;
			}
			if(capitalFromUser.equals(answer))
				System.out.println("정답!!");
			else
				System.out.println("아닙니다!!");				
		}	
		
	}
	private void finish() {
		System.out.println("게임을 종료합니다.");	
	}
	public static void main(String[] args) {
		Quiz_n2 game = new Quiz_n2();
		game.run();
	}
}