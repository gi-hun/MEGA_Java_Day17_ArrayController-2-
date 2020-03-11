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
package day_16;

import java.util.Scanner;

public class ArrayEx36 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[] score = null;
		int count = 0;			//�迭�� �ε���ó�� ����Ѵ�.
		int check = -1;
		
		while(true) {
			System.out.println("==============");
			for(int i=0; i< count; i++)
			{
				System.out.print(score[i] + " ");
			}
			System.out.println();
			System.out.println("==============");
			
			System.out.println("[���� ��Ʈ�ѷ�]");
			System.out.println("[1]�߰�");
			System.out.println("[2]����(�ε���)");
			System.out.println("[3]����(��)");
			System.out.println("[4]����");
			System.out.println("[0]����");
			
			System.out.print("�޴� ���� : ");
			int sel = sc.nextInt();
			
			if(sel == 1) {			//�߰�
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
						score[i] = temp[i];			//score[] �迭�� temp[] �迭�� �����Ѵ�.
					}
					temp = null;			//�̰� ���� �ǹ� �ϱ�?//�ܼ��� �ʱ�ȭ �ǹ�?
				}
				System.out.println("���� �Է�");
				int data = sc.nextInt();

				score[count] = data;
				count++;

				System.out.println(count);
			}
			else if(sel == 2) {			//����(�ε���)
				if(count == 0)
				{
					System.out.println("�ε����� �߰��� �� �־��ּ���");
				}
				else if(count>0)
				{
					System.out.println("������ �ε����� �Է����ּ���(0���� ����)");
					int idx = sc.nextInt();
					
					for(int i=idx;i<count-1;i++)
					{
						score[i] = score[i+1];
					}
					count--;
				}
			}
			else if(sel == 3) {			//����(��)
				if(count == 0)
				{
					System.out.println("���� �߰��� �� �־��ּ���");
				}
				else if(count>0)
				{
					System.out.println("������ ���� �Է����ּ���");
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
						System.out.println("�������� �ʴ� ���̴�.");
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
			else if(sel == 4) {			//����
				System.out.println("������ �ε����� �Է����ּ���");
				int idx = sc.nextInt();
				System.out.println("������ �� �Է����ּ���");
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
				System.out.println("���α׷��� �����ϰڽ��ϴ�.");
				break;
			}
		}

	}
}
