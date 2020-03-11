package day_16;

import java.util.Scanner;

/*
 * # �迭 ��Ʈ�ѷ�[2�ܰ�] : ����(Vector)
 * 1. �߰�
 * . ���� �Է¹޾� ���������� �߰�
 * 2. ����(�ε���)
 * . �ε����� �Է¹޾� �ش� ��ġ�� �� ����
 * 3. ����(��)
 * . ���� �Է¹޾� ����
 * . ���� �� �Է� �� ����ó��
 * 4. ����
 * . �ε����� ���� �Է¹޾� ����
 */
public class ArrayEx36_���� {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] score = null;
		int count = 0;
		
		while(true) {
			
			for(int i=0; i<count; i++) {
				System.out.print(score[i] + " ");
			}
			System.out.println();
			
			System.out.println("[���� ��Ʈ�ѷ�]");
			System.out.println("[1]�߰�");
			System.out.println("[2]����(�ε���)");
			System.out.println("[3]����(��)");
			System.out.println("[4]����");
			System.out.println("[0]����");
			
			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {
				if(count == 0) {
					score = new int[count + 1];
				}else if(count > 0){					//2)temp �迭�� ������ִ� ������ ����?
					int[] temp = score;
					score = new int[count + 1];
					
					for(int i=0; i<count; i++) {
						score[i] = temp[i];				//score�迭 ���� ����� ��ŭ temp������ ������ش�.
					}
					temp = null;						//temp�迭�� null�� �ʱ�ȭ ���ش�. -> 1)�� �ʱ�ȭ ���ٱ�?
				}
				System.out.print("[�߰�]���� �Է� : ");
				int data = sc.nextInt();
				
				System.out.println("count: "+count);
														//count -> �ε��� ��ȣ ó�� ���
				score[count] = data;					//data�� 10�� ó�� �Է��ϸ� score[0] = 10;
				count += 1;
			}
			else if(sel == 2) {
				System.out.print("[����]�ε��� �Է� : ");
				int delIdx = sc.nextInt();
				
				System.out.println("count: "+count);
				if(count-1 < delIdx || delIdx < 0) {					//3)ó�� �� �Է��� count = 1; ���� delIdx�� 0�� �Է��ϸ� 1-1 < 0 �ε� �� �Ȱɸ���?, delIdx�� 0�ε�
					System.out.println("[�޼���]�ش� ��ġ�� ������ �� �����ϴ�.");
					continue;
				}
				
				if(count == 1) {			//ó�� �� �Է� �ϸ� count = 1 -> ���� ������ ���� if������ �ʱ�ȭ ���ѹ�����.
					score = null;
				}else if(count > 1) {
					int[] temp = score;
					score = new int[count - 1];
					
					for(int i=0; i<delIdx; i++) {
						score[i] = temp[i];			//score[]�迭�� temp[]�迭�� �����ϰ� �����-> ���� ���� ����Ų��.
					}
					for(int i=delIdx; i<count-1; i++) {
						score[i] = temp[i + 1];
					}
					temp = null;
				}
				
				count -= 1;
			}
			else if(sel == 3) {
				System.out.print("[����]�� �Է� : ");
				int delData = sc.nextInt();
				
				int delIdx = -1;
				for(int i=0; i<count; i++) {
					if(score[i] == delData) {
						delIdx = i;
					}
				}
				
				if(delIdx == -1) {
					System.out.println("[�޼���]�Է��Ͻ� ���� �������� �ʽ��ϴ�.");
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
				System.out.print("[����]�ε��� �Է� : ");
				int insertIdx = sc.nextInt();
				
				if(count < insertIdx || insertIdx < 0) {
					System.out.println("[�޼���]�ش� ��ġ�� ������ �� �����ϴ�.");
					continue;
				}
				
				System.out.print("[����]�� �Է� : ");
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