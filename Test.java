import java.util.*;


public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] zhuangTai = new int[]{2,1,1,0,0,0};
		String[] name = new String[]{"罗马假日","白雪公主","葫芦兄弟","null","null","null"};
		int[] date = new int[]{1,0,0,0,0,0};
		int[] time = new int[]{15,12,30,0,0,0};
		int a =0;
		int b =0;
		do{
			do{
				System.out.println("欢迎使用迷你图书馆里器");
				System.out.println("-----------------------------");
				System.out.println("1、新增图书");
				System.out.println("2、查看图书");
				System.out.println("3、删除图书");
				System.out.println("4、借出图书");
				System.out.println("5、归还图书");
				System.out.println("6、退出图书");
				System.out.println("-----------------------------");
				System.out.print("请选择：");
				int shuZi = input.nextInt();				
				if(shuZi>=1 && shuZi<=6){
					a = shuZi;
					break;
				}else{
					System.out.println("输入数字不正确，请输入正确数字!");
					System.out.println();
				}
			}while(true);
			switch(a){
			case 1:
				System.out.println("-->新增图书");
				System.out.println();
				if(zhuangTai[zhuangTai.length-1] != 0){
					System.out.println("图书馆图书已满，不能添加图书！");
				}else{
					System.out.print("请输入图书名称：");					
					String k = input.next();
					for(int m=0;m<name.length;m++){						
						if(name[m].equals(k)){
							System.out.println("该书已经保存在图书馆！");
							break;
						}else if(zhuangTai[m]==0){
							zhuangTai[m] = 1;							
							System.out.println("新增《"+name[m]+"》成功！");
							break;
						}
					}
				}
				break;
			case 2:
				System.out.println("-->查看图书");
				System.out.println();
				System.out.println("序号\t状态\t名称\t借出日期\t\t借出次数");
				for(int i=0;i<name.length;i++){
					if(zhuangTai[i]==0){
						break;
					}else{
						System.out.print(i+1+"             ");
						String zhuang = zhuangTai[i]==1?"可借阅":"已借出";
						System.out.print(zhuang+"    ");
						System.out.print(name[i]+"          ");
						if(zhuangTai[i]==1){
							System.out.print("\t\t");
						}else{
						System.out.print(+date[i]+"日\t");
						}
						System.out.println(time[i]+"次");
					}
				}
				break;
			case 3:
				System.out.println("-->删除图书");
				System.out.println();
				System.out.print("请输入删除图书名称：");
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
						System.out.println("图书删除成功!");
					}else{
						System.out.print("图书馆没有这本书，请重新输入需要删除的书籍：");
					}
				}while(flag5==false);
				break;
			case 4:
				System.out.println("-->借出图书");
				System.out.println();
				System.out.print("请输入图书名称：");
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
								System.out.print("该书已被借出，不能借阅，重新输入需要借阅的书籍：");
								flag7=true;
							}
						}
					}
					if(flag7==false){
						if(flag==true){
							zhuangTai[d]=2;
							time[d] += 1;						
							System.out.print("请输入借出日期：");
							do{
								int e = input.nextInt();
								if(e<1 && e>31){
									System.out.print("必须输入大于等于1且小于等于31的数字，请重新输入：");
								}else{
									flag2 = true;
									date[d]=e;
									break;
								}
							}while(flag==false);
							System.out.println("借出《"+name[d]+"》成功！");
						}else{
							System.out.print("没有该图书，请重新输入图书名称：");
						}
					}
					flag7=false;
				}while(flag2==false);
				break;
			case 5:
				System.out.println("-->归还图书");
				System.out.println();
				System.out.print("请输入图书名称：");
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
								System.out.print("该书没有借出，请重新输入归还书籍名称：");
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
								System.out.print("请输入归还日期：");
								int e = input.nextInt();
								g = e;
								if(e<1 && e>31){
									System.out.print("必须输入大于等于1且小于等于31的数字，请重新输入：");
								}else{
									if(e<=date[d1]){
										System.out.print("归还日期必须大于借出日期，请重新输入：");
									}else{
									flag3 = true;
									break;
									}
								}
							}while(flag3==false);
							System.out.println();
							System.out.println("归还《"+c+"》成功！");
							System.out.println("借出日期为："+date[d1]+"日");						
							System.out.println("归还日期为："+g+"日");
							System.out.println("应付租金（元）："+(g-date[d1]));
							date[d1]=0;
						}else{
							System.out.print("没有该图书，请重新输入图书名称：");
						}
					}
					flag4 = false;
				}while(flag1==false);
				break;
			case 6:
				System.out.println("谢谢使用！");
				return;
			}
			System.out.println("***************************************");
			
			do{
				System.out.print("输入0返回：");
				int fanHui = input.nextInt();
				b = fanHui;
				if(b!=0){
					System.out.println("输入错误，请重新输入0");
				}else{
					System.out.println();
				}
			}while(b!=0);
		}while(b==0);
	}
}
