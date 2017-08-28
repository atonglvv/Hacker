import java.io.*;
public class WTF{
	public static void main(String[] args)throws Exception{
		st:for(int i = 0;i < 9999;i++){
			String password = i + "";
			while(password.length()<4){
				password = "0" + password;
			}
			System.out.print("\r正在尝试："+password);	//\r ： return 到当前行的最左边。
			Process p = Runtime.getRuntime().exec("rar x -p" + password + " hacker.rar .");	//解压文件用的相对路径  "."表示解压到当前目录
			p.waitFor();

			InputStream is = p.getInputStream();	//得到process的标准输入流
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String str;
			while((str = br.readLine())!=null){
				if(str.contains("正常")){
					System.out.println();
					System.out.println("正确密码："+password);
					break st;	//goto语句
				}
			}
			br.close();

		}
	}
}