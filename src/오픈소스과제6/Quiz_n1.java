package ���¼ҽ�����6;
import java.util.Scanner;
import java.util.Vector;
public class Quiz_n1 {
	private Vector<Nation> store = new Vector<Nation>();
	private Scanner scanner = new Scanner(System.in);
	
	public Quiz_n1() {
		store.add(new Nation("�ѱ�", "����"));
		store.add(new Nation("�߱�", "����¡"));
		store.add(new Nation("�Ϻ�", "����"));
		store.add(new Nation("�̱�", "������DC"));
		store.add(new Nation("����", "����"));
		store.add(new Nation("������", "������"));
		store.add(new Nation("��Ż����", "�θ�"));
		store.add(new Nation("ü��", "������"));
		store.add(new Nation("����", "������"));
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
	private boolean contains(String country) {
		for(int i=0; i<store.size(); i++) {
			if(store.get(i).getCountry().equals(country)) {
				return true;
			}
		}
		
		return false;
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
			if(contains(country)) {
				System.out.println(country + "�� �̹� �ֽ��ϴ�!");
				continue;
			}
				
			store.add(new Nation(country, capital));
			n++;
		}
	}
	private void quiz() {
		while(true) {
			int index = (int)(Math.random()*store.size());
			
			Nation nation = store.get(index);
			String question = nation.getCountry();
			String answer = nation.getCapital();
			
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
		Quiz_n1 game = new Quiz_n1();
		game.run();
	}
}
class Nation {
	private String country;
	private String capital;
	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}
	public String getCountry() {
		return country;
	}
	public String getCapital() {
		return capital;
	}
}