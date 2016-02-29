import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;

import javax.swing.JFrame;

public class Mousey {
	int slp1 = 500;
	int moveX = 1;
	int moveTimes = 3;
	int currentMove = 0;
	Robot robo;
	JFrame frm = null;

	public Mousey(String[] args) {
		int mx = 892;
		int mi = 888;
		try {
			robo = new Robot();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Mx " + mx + "  Min " + mi);
//		for (int i = mi; i <= mx; i++) {
//			int j = intRotate(i, mx, mi, 1);
//			System.out.println("i " + i + "  j " + j);
//		}
		frm = new JFrame ("Mouse move close to stop 1.1");
		frm.setSize(650,600);
		frm.setVisible(true);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		PointerInfo poi = MouseInfo.getPointerInfo();
		Point where = null;
		int x, y;
		while (true) {
			poi = MouseInfo.getPointerInfo();
			where = poi.getLocation();
			x = (int) where.getX();
			y = (int) where.getY();
			currentMove = intRotate(currentMove, moveTimes, 0, 1);
			if (currentMove % 4 == 0) {
				x = (int) (where.getX() + 1);
			} else if (currentMove % 4 == 1) {
				x = (int) (where.getX() - 1);
			} else if (currentMove % 4 == 2) {
				y = (int) (where.getY() + 1);
			} else if (currentMove % 4 == 3) {
				y = (int) (where.getY() - 1);
			}
			robo.mouseMove(x, y);
			SoundUtils.toneit(300, 90);
			slp(8000);
		}

	}

	int intRotate(int i, int max, int min, int by) {
		int j = i + by;
		if (j < min)
			j = min;// edge case to check
		if (j > max) {
			// TODO other cases like negative and non 1 increment
			j = min;
		}
		return j;
	}

	public static void main(String[] args) {
		// SoundUtils.toneit(900, 140);
		System.out.println("Start main");
		Mousey app = new Mousey(args);

	}

	public static void slp(int s) {
		try {
			Thread.sleep(s);
		} catch (Exception e) {
			// ig
		}
	}

}
