package day_16;

import java.util.Scanner;

/*
 * # 배열 컨트롤러[2단계] : 벡터(Vector)
 * 1. 추가
 * . 값을 입력받아 순차적으로 추가
 * 2. 삭제(인덱스)
 * . 인덱스를 입력받아 해당 위치의 값 삭제
 * 3. 삭제(값)
 * . 값을 입력받아 삭제
 * . 없는 값 입력 시 예외처리
 * 4. 삽입
 * . 인덱스와 값을 입력받아 삽입
 */
public class ArrayEx36_정답 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] score = null;
		int count = 0;
		
		while(true) {
			
			for(int i=0; i<count; i++) {
				System.out.print(score[i] + " ");
			}
			System.out.println();
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(count == 0) {
					score = new int[count + 1];
				}else if(count > 0){					//2)temp 배열을 만들어주는 이유가 뭘까?
					int[] temp = score;
					score = new int[count + 1];
					
					for(int i=0; i<count; i++) {
						score[i] = temp[i];				//score배열 공간 만드는 만큼 temp공간도 만들어준다.
					}
					temp = null;						//temp배열을 null로 초기화 해준다. -> 1)왜 초기화 해줄까?
				}
				System.out.print("[추가]성적 입력 : ");
				int data = sc.nextInt();
				
				System.out.println("count: "+count);
														//count -> 인덱스 번호 처럼 사용
				score[count] = data;					//data에 10을 처음 입력하면 score[0] = 10;
				count += 1;
			}
			else if(sel == 2) {
				System.out.print("[삭제]인덱스 입력 : ");
				int delIdx = sc.nextInt();
				
				System.out.println("count: "+count);
				if(count-1 < delIdx || delIdx < 0) {					//3)처음 값 입력후 count = 1; 만약 delIdx에 0을 입력하면 1-1 < 0 인데 왜 안걸리지?, delIdx도 0인데
					System.out.println("[메세지]해당 위치는 삭제할 수 없습니다.");
					continue;
				}
				
				if(count == 1) {			//처음 값 입력 하면 count = 1 -> 삭제 누르면 지금 if문에서 초기화 시켜버린다.
					score = null;
				}else if(count > 1) {
					int[] temp = score;
					score = new int[count - 1];
					
					for(int i=0; i<delIdx; i++) {
						score[i] = temp[i];			//score[]배열이 temp[]배열을 참조하게 만든다-> 같은 것을 가리킨다.
					}
					for(int i=delIdx; i<count-1; i++) {
						score[i] = temp[i + 1];
					}
					temp = null;
				}
				
				count -= 1;
			}
			else if(sel == 3) {
				System.out.print("[삭제]값 입력 : ");
				int delData = sc.nextInt();
				
				int delIdx = -1;
				for(int i=0; i<count; i++) {
					if(score[i] == delData) {
						delIdx = i;
					}
				}
				
				if(delIdx == -1) {
					System.out.println("[메세지]입력하신 값은 존재하지 않습니다.");
					continue;
				}
				
				if(count == 1) {
					score = null;
				}else if(count > 1) {
					int[] temp = score;
					score = new int[count - 1];
					
					int j = 0;
					for(int i=0; i<count; i++) {
						if(i != delIdx) {
							score[j] = temp[i];
							j += 1;
						}
					}
					
					temp = null;
				}
				
				count -= 1;				
			}
			else if(sel == 4) {
				System.out.print("[삽입]인덱스 입력 : ");
				int insertIdx = sc.nextInt();
				
				if(count < insertIdx || insertIdx < 0) {
					System.out.println("[메세지]해당 위치는 삽입할 수 없습니다.");
					continue;
				}
				
				System.out.print("[삽입]값 입력 : ");
				int insertData = sc.nextInt();
				
				if(count == 0) {
					score = new int[count + 1];
				}else if(count > 0) {
					int[] temp = score;
					score = new int[count + 1];
					
					int j = 0;
					for(int i=0; i<count + 1; i++) {
						if(i != insertIdx) {
							score[i] = temp[j];
							j += 1;
						}
					}
					temp = null;
				}
				
				score[insertIdx] = insertData;
				count += 1;
			}
			else if(sel == 0) {
				break;
			}
		}
		
	}
}