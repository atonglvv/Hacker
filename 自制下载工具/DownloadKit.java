import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.net.*;
public class DownloadKit{
	JFrame frame;//窗体
	JTextField jtf;//单行文本框
	JButton bt;//按钮
	JProgressBar jpb;//进度条
	public DownloadKit(){
		frame = new JFrame("青大的迅雷");
		jtf = new JTextField();
		jtf.setFont(new Font("宋体",1,20));
		bt = new JButton("开始下载");
		bt.addActionListener(new DownloadListener());
		jpb = new JProgressBar();
		jpb.setStringPainted(true);
		jpb.setFont(new Font("宋体",1,20));
		frame.add(jtf);
		frame.add(bt,"East");
		frame.add(jpb,"South");
		frame.setSize(400,100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(3);

	}
	public static void main(String[] args){
		new DownloadKit();
	}
	class DownloadListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ae){
			new DownloadThread().start();
		}
	}
	class DownloadThread extends Thread{
		@Override
		public void run(){
			try{
				String target = jtf.getText();
				URL url = new URL(target);
				URLConnection uc = url.openConnection();
				//得到目标的总共大小
				int total = uc.getContentLength();
				InputStream is = uc.getInputStream();
				String mb = target.substring(target.lastIndexOf("/")+1);
				OutputStream os = new FileOutputStream(mb);
				byte[] data = new byte[65536];
				int len;
				int current = 0;
				while((len = is.read(data))!=-1){
					os.write(data,0,len);
					current += len;
					int percent = current *100 / total;
					jpb.setValue(percent);
				}
				is.close();
				os.close();
				JOptionPane.showMessageDialog(frame,"Congratulations:"+mb+"下载完成");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}