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
package day_16;

import java.util.Scanner;

public class ArrayEx36 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = null;
		int count = 0;			//배열의 인덱스처럼 사용한다.
		int check = -1;
		
		while(true) {
			System.out.println("==============");
			for(int i=0; i< count; i++)
			{
				System.out.print(score[i] + " ");
			}
			System.out.println();
			System.out.println("==============");
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(값)");
			System.out.println("[4]삽입");
			System.out.println("[0]종료");
			
			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {			//추가
				if(count == 0)
				{
					score = new int[count+1];
				}
				else if(count>0)
				{
					int[] temp = score;
					score = new int[count+1];
					
					for(int i=0; i< count; i++)
					{
						score[i] = temp[i];			//score[] 배열은 temp[] 배열을 참조한다.
					}
					temp = null;			//이게 무슨 의미 일까?//단순히 초기화 의미?
				}
				System.out.println("성적 입력");
				int data = sc.nextInt();

				score[count] = data;
				count++;

				System.out.println(count);
			}
			else if(sel == 2) {			//삭제(인덱스)
				if(count == 0)
				{
					System.out.println("인덱스를 추가한 후 넣어주세요");
				}
				else if(count>0)
				{
					System.out.println("삭제할 인덱스를 입력해주세요(0부터 시작)");
					int idx = sc.nextInt();
					
					for(int i=idx;i<count-1;i++)
					{
						score[i] = score[i+1];
					}
					count--;
				}
			}
			else if(sel == 3) {			//삭제(값)
				if(count == 0)
				{
					System.out.println("값을 추가한 후 넣어주세요");
				}
				else if(count>0)
				{
					System.out.println("삭제할 값을 입력해주세요");
					int data = sc.nextInt();
					
					for(int i=0;i<count;i++)
					{
						if(data == score[i])
						{
							check = i;
						}
						else if(data != score[i])
						{
							check = -1;
						}
					}
					
					if(check == -1)
					{
						System.out.println("존재하지 않는 값이다.");
					}
					else
					{
						for(int i=check;i<count-1;i++)
						{
							score[i] = score[i+1];
						}
						count--;
					}
				}
			}
			else if(sel == 4) {			//삽입
				System.out.println("삽입할 인덱스를 입력해주세요");
				int idx = sc.nextInt();
				System.out.println("삽입할 값 입력해주세요");
				int data = sc.nextInt();
				
				int[] temp = score;
				score = new int[count+1];
				
				int j = 0;
				for(int i=0;i<count+1;i++)
				{
					if(i != idx)
					{
						score[i] = temp[j];
						j++;
					}
				}
				score[idx] = data;
				count++;
			}
			else if(sel == 0) {
				System.out.println("프로그램을 종료하겠습니다.");
				break;
			}
		}

	}
}
