import java.io.*;
public class TestSetLastModified{
	//修改文件最后修改时间。(总感觉这句话有点绕口=-=)
	public static void main(String[] args)throws Exception{
		File file = new File("E:\\one.txt");	//修改的文件的路径
		long time = System.currentTimeMillis();
		//System.out.println(time);
		file.setLastModified(time-3653L*24*60*60*1000);	//修改为十年之前
	}
}

