package ���¼ҽ�����6;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
public class Quiz_n2 {
	private HashMap<String, String> store = new HashMap<String, String>();
	private Scanner scanner = new Scanner(System.in);
	
	public Quiz_n2() {
		store.put("�ѱ�", "����");
		store.put("�߱�", "����¡");
		store.put("�Ϻ�", "����");
		store.put("�̱�", "������DC");
		store.put("����", "����");
		store.put("������", "������");
		store.put("��Ż����", "�θ�");
		store.put("ü��", "������");
		store.put("����", "������");
	}
	
	private void error(String msg) {
		System.out.println(msg);
	}
	
	public void run() {
		System.out.println("**** ���� ���߱� ������ �����մϴ�. ****");
		while(true) {
			System.out.print("�Է�:1, ����:2, ����:3>> ");
			int menu = scanner.nextInt();
			switch(menu) {
				case 1: input(); break;
				case 2: quiz(); break;
				case 3: finish(); return;
				default: 
					error("�߸��� �Է��Դϴ�.");
			}
		}
		
	}
	
	private void input() {
		int n = store.size();
		System.out.println("���� " + n + "�� ����� ������ �ԷµǾ� �ֽ��ϴ�.");
		n++;
		while(true) {
			System.out.print("����� ���� �Է�" + n + ">> ");
			String country = scanner.next();
			if(country.equals("�׸�")) {
				break;
			}
			String capital = scanner.next();
			if(store.containsKey(country)) {
				System.out.println(country + "�� �̹� �ֽ��ϴ�");
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
			
			System.out.print(question + "�� ������? ");
			
			String capitalFromUser = scanner.next();
			if(capitalFromUser.equals("�׸�")) {
				break;
			}
			if(capitalFromUser.equals(answer))
				System.out.println("����!!");
			else
				System.out.println("�ƴմϴ�!!");				
		}	
		
	}
	private void finish() {
		System.out.println("������ �����մϴ�.");	
	}
	public static void main(String[] args) {
		Quiz_n2 game = new Quiz_n2();
		game.run();
	}
}