import java.util.*;


public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] zhuangTai = new int[]{2,1,1,0,0,0};
		String[] name = new String[]{"�������","��ѩ����","��«�ֵ�","null","null","null"};
		int[] date = new int[]{1,0,0,0,0,0};
		int[] time = new int[]{15,12,30,0,0,0};
		int a =0;
		int b =0;
		do{
			do{
				System.out.println("��ӭʹ������ͼ�������");
				System.out.println("-----------------------------");
				System.out.println("1������ͼ��");
				System.out.println("2���鿴ͼ��");
				System.out.println("3��ɾ��ͼ��");
				System.out.println("4�����ͼ��");
				System.out.println("5���黹ͼ��");
				System.out.println("6���˳�ͼ��");
				System.out.println("-----------------------------");
				System.out.print("��ѡ��");
				int shuZi = input.nextInt();				
				if(shuZi>=1 && shuZi<=6){
					a = shuZi;
					break;
				}else{
					System.out.println("�������ֲ���ȷ����������ȷ����!");
					System.out.println();
				}
			}while(true);
			switch(a){
			case 1:
				System.out.println("-->����ͼ��");
				System.out.println();
				if(zhuangTai[zhuangTai.length-1] != 0){
					System.out.println("ͼ���ͼ���������������ͼ�飡");
				}else{
					System.out.print("������ͼ�����ƣ�");					
					String k = input.next();
					for(int m=0;m<name.length;m++){						
						if(name[m].equals(k)){
							System.out.println("�����Ѿ�������ͼ��ݣ�");
							break;
						}else if(zhuangTai[m]==0){
							zhuangTai[m] = 1;							
							System.out.println("������"+name[m]+"���ɹ���");
							break;
						}
					}
				}
				break;
			case 2:
				System.out.println("-->�鿴ͼ��");
				System.out.println();
				System.out.println("���\t״̬\t����\t�������\t\t�������");
				for(int i=0;i<name.length;i++){
					if(zhuangTai[i]==0){
						break;
					}else{
						System.out.print(i+1+"             ");
						String zhuang = zhuangTai[i]==1?"�ɽ���":"�ѽ��";
						System.out.print(zhuang+"    ");
						System.out.print(name[i]+"          ");
						if(zhuangTai[i]==1){
							System.out.print("\t\t");
						}else{
						System.out.print(+date[i]+"��\t");
						}
						System.out.println(time[i]+"��");
					}
				}
				break;
			case 3:
				System.out.println("-->ɾ��ͼ��");
				System.out.println();
				System.out.print("������ɾ��ͼ�����ƣ�");
				boolean flag5 = false;
				int z = 0;
				do{
					String h = input.next();
					for(int i=0;i<=name.length;i++){
						if(name[i].equals(h)){
							flag5 = true;
							z=i;
							break;
						}
					}
					if(flag5==true){
						for(int i=z;i<name.length-1;i++){
							name[i]=name[i+1];
							zhuangTai[i]=zhuangTai[i+1];
							date[i]=date[i+1];
							time[i]=time[i+1];													
						}
						name[name.length-1]=null;
						zhuangTai[name.length-1]=0;
						date[name.length-1]=0;
						time[name.length-1]=0;	
						System.out.println("ͼ��ɾ���ɹ�!");
					}else{
						System.out.print("ͼ���û���Ȿ�飬������������Ҫɾ�����鼮��");
					}
				}while(flag5==false);
				break;
			case 4:
				System.out.println("-->���ͼ��");
				System.out.println();
				System.out.print("������ͼ�����ƣ�");
				boolean flag = false;
				boolean flag2 = false;
				boolean flag7 = false;
				int d = 0;
				do{
					String c = input.next();
					for(int i=0;i<name.length;i++){
						if(name[i].equals(c)){
							if(zhuangTai[i]==1){
								flag = true;
								d=i;
								break;
							}else{
								System.out.print("�����ѱ���������ܽ��ģ�����������Ҫ���ĵ��鼮��");
								flag7=true;
							}
						}
					}
					if(flag7==false){
						if(flag==true){
							zhuangTai[d]=2;
							time[d] += 1;						
							System.out.print("�����������ڣ�");
							do{
								int e = input.nextInt();
								if(e<1 && e>31){
									System.out.print("����������ڵ���1��С�ڵ���31�����֣����������룺");
								}else{
									flag2 = true;
									date[d]=e;
									break;
								}
							}while(flag==false);
							System.out.println("�����"+name[d]+"���ɹ���");
						}else{
							System.out.print("û�и�ͼ�飬����������ͼ�����ƣ�");
						}
					}
					flag7=false;
				}while(flag2==false);
				break;
			case 5:
				System.out.println("-->�黹ͼ��");
				System.out.println();
				System.out.print("������ͼ�����ƣ�");
				boolean flag1 = false;
				boolean flag3 = false;
				boolean flag4 = false;
				int d1 = 0;
				int g =0;
				do{
					String c = input.next();
					for(int i=0;i<name.length;i++){
						if(name[i].equals(c)){
							if(zhuangTai[i]!=2){
								System.out.print("����û�н��������������黹�鼮���ƣ�");
								flag4 = true;
							}else{
								flag1 = true;
								d1=i;
							}
						}
					}
					if(flag4==false){
						if(flag1==true){
							zhuangTai[d1]=1;
							do{
								System.out.print("������黹���ڣ�");
								int e = input.nextInt();
								g = e;
								if(e<1 && e>31){
									System.out.print("����������ڵ���1��С�ڵ���31�����֣����������룺");
								}else{
									if(e<=date[d1]){
										System.out.print("�黹���ڱ�����ڽ�����ڣ����������룺");
									}else{
									flag3 = true;
									break;
									}
								}
							}while(flag3==false);
							System.out.println();
							System.out.println("�黹��"+c+"���ɹ���");
							System.out.println("�������Ϊ��"+date[d1]+"��");						
							System.out.println("�黹����Ϊ��"+g+"��");
							System.out.println("Ӧ�����Ԫ����"+(g-date[d1]));
							date[d1]=0;
						}else{
							System.out.print("û�и�ͼ�飬����������ͼ�����ƣ�");
						}
					}
					flag4 = false;
				}while(flag1==false);
				break;
			case 6:
				System.out.println("ллʹ�ã�");
				return;
			}
			System.out.println("***************************************");
			
			do{
				System.out.print("����0���أ�");
				int fanHui = input.nextInt();
				b = fanHui;
				if(b!=0){
					System.out.println("�����������������0");
				}else{
					System.out.println();
				}
			}while(b!=0);
		}while(b==0);
	}
}
