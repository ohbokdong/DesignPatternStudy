package week11.minj0i.virtualProxy;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ImageProxy implements Icon {
	ImageIcon imageIcon;
	URL imageURL;
	Thread retrievalThread;
	boolean retrieving = false;
	
	public ImageProxy(URL url) { imageURL = url; }
	
	@Override
	public int getIconWidth() {
		if(imageIcon !=null) {
			return imageIcon.getIconWidth();
		} else {
			return 800;
		}
	}
	
	@Override
	public int getIconHeight() {
		if (imageIcon != null) {
			return imageIcon.getIconHeight();
		} else {
			return 600;
		}
	}
	
	
	//아이콘을 화면에 표시할 때 이 메소드를 호출
	@Override
	public void paintIcon(final Component c, Graphics g, int x, int y) {
		if(imageIcon != null) {
			//이미 준비되어있으면 그 아이콘 객체의 메소드를 호출
			imageIcon.paintIcon(c, g, x, y);
		} else {
			g.drawString("Loading CD cover, please wait...", x+300, y+190);
			if (!retrieving) {
				retrieving = true;
				retrievalThread = new Thread(new Runnable() {
					public void run() {
						try {
							imageIcon = new ImageIcon(imageURL, "CD Cover");
							c.repaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				retrievalThread.start();
			}
		}
	}


}
