package net.qinghr.qingwa.common;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

public class CodeAction {
	//��֤��
			public void verification()
			{
				//��֤��
						HttpServletRequest request=ServletActionContext.getRequest();
						HttpServletResponse response=ServletActionContext.getResponse();
						response.setHeader("Pargma", "No-cache");
						response.setHeader("Cache-Control","No-cache");
						response.setDateHeader("Expires", 0);
						
						int width=100,height=40;
						BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
						Random random=new Random();
						Graphics g=image.getGraphics();
						g.setColor(this.getRandColor(200, 250));
						g.fillRect(0, 0, width, height);
						GraphicsEnvironment ge=GraphicsEnvironment.getLocalGraphicsEnvironment();
						String[] fontNames=ge.getAvailableFontFamilyNames();
						g.setFont(new Font("������κ",Font.BOLD+Font.ITALIC,25));
						g.setColor(new Color(52,66,80));
						g.drawRect(0, 0, width-1, height-1);
						g.setColor(getRandColor(100, 150));
						for(int i=0;i<50;i++)
						{
							int x=random.nextInt(width);
							int y=random.nextInt(height);
							int x1=random.nextInt(50);
							int y1=random.nextInt(50);
							g.drawLine(x, y, x1, y1);
						}
						String s="QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjkzxcvbnm023456789";
						String code="";
						for(int i=0;i<4;i++)
						{
							String sc=String.valueOf(s.charAt(random.nextInt(s.length())));
							code+=sc;
							g.setColor(getRandColor(30, 60));
							g.drawString(sc, 20 * i + 10, 30);
						}
						//����֤��ŵ�session��
						HttpSession session=ServletActionContext.getRequest().getSession();
						session.setAttribute("CheckCode", code);
						g.dispose();
						try {
							ImageIO.write(image, "JPEG", response.getOutputStream());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							System.out.println("������֤�����:adminAction��changCode����"+e);
						}
			}
			//�ı���֤�뱳����ɫ
			private Color getRandColor(int fc,int bc)
			{
				Random random=new Random();
				if(fc>255)
				{
					fc=255;
				}
				if(bc>255)
				{
					fc=255;
				}
				int r=fc+random.nextInt(bc-fc);
				int g=fc+random.nextInt(bc-fc);
				int b=fc+random.nextInt(bc-fc);
				return new Color(r,g,b);
			}
}
