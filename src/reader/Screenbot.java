package reader;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
//import java.util.logging.Logger;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class Screenbot {

	private static BufferedImage screen = null;
	private static BufferedImage image = null;
//	private static Logger logger = Logger.getLogger("Screenbot");
	
	public Screenbot() {}

	public static int[] search(BufferedImage img) {
//		
		
		try {
			screen  = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (int x1=0; x1<screen.getWidth();x1++) {
			for (int y1=0; y1<screen.getHeight();y1++) {
				boolean invalid = false;
				int x2=x1, y2=y1;
				for (int a=0;a<img.getWidth();a++) {
					y2 = y1;
					for (int b=0;b<img.getHeight();b++) {
						if(img.getRGB(a, b) != screen.getRGB(x2, y2)) {
							invalid = true;
							break;
						} else {y2++;}
					}
					if(invalid) {
						break;
					} else {
						x2++;
					}
				}
				
				if(!invalid) {
					int[] arr={1,x1,y1,x2,y2};
					return arr;
				}
			}
		}
		int[] arr={0,0,0,0,0};
		return arr;
	}
	
	public static int[] getNumbers(int x, int y) {
		
		BufferedImage codeScr = null;
//		File outputFile = null;
		int[] numbers = {0,0,0,0};

		try {
			codeScr = new Robot().createScreenCapture(new Rectangle(x-255,y-269,60,15));
		} catch (AWTException e) {e.printStackTrace();}
		
		Tesseract ocr = new Tesseract();
		ocr.setDatapath("");
		ocr.setLanguage("eng");
		
		try {
			codeScr = new Robot().createScreenCapture(new Rectangle(x-255,y-269,43,15));
		} catch (AWTException e) {e.printStackTrace();}
		
		try {
			File outputFile = new File ("Resources/last_output.bmp");
			Start.log("Path: "+outputFile.getPath());
			Start.log("AbsPath: "+outputFile.getAbsolutePath());
			Start.log("CanPath: "+outputFile.getCanonicalPath());
			ImageIO.write(codeScr, "bmp", outputFile);
		} catch (IOException e) {e.printStackTrace();}
		
		try {
			String result = ocr.doOCR(codeScr);
//			String result = ocr.doOCR(outputFile);
			for (int i = 0; i < numbers.length; i++) {
				if(Character.isDigit(result.charAt(i))) {
					numbers[i] = Character.getNumericValue(result.charAt(i));
					} else {
					Start.err("OCR-Fehler: Konnte "+(i+1)+". Ziffer nicht lesen");
				};

			}
//		} catch (TesseractException e) {Start.err(e.getMessage());}
		} catch (TesseractException e) {Start.err("OCR-Fehler");}
		
		return numbers;
		
	}
	
	public static void clickOn(int num) {
		
		switch(num) {
		case 0:
			try {
				image = ImageIO.read((new File("Resources/e0.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e0");
			} break;
		case 1:
			try {
				image = ImageIO.read((new File("Resources/e1.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e1");
			} break;
		case 2:
			try {
				image = ImageIO.read((new File("Resources/e2.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e2");
			} break;
		case 3:
			try {
				image = ImageIO.read((new File("Resources/e3.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e3");
			} break;
		case 4:
			try {
				image = ImageIO.read((new File("Resources/e4.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e4");
			} break;
		case 5:
			try {
				image = ImageIO.read((new File("Resources/e5.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e5");
			} break;
		case 6:
			try {
				image = ImageIO.read((new File("Resources/e6.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e6");
			} break;
		case 7:
			try {
				image = ImageIO.read((new File("Resources/e7.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e7");
			} break;
		case 8:
			try {
				image = ImageIO.read((new File("Resources/e8.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e8");
			} break;
		case 9:
			try {
				image = ImageIO.read((new File("Resources/e9.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for e9");
			} break;
		case 10:
			for (int i = 1; i<6; i++) {
				String nr = String.valueOf(i);
				String src="Resources/abfrage"+nr+".bmp";
				try {
					image = ImageIO.read((new File(src)));
			    } catch (IOException e) {e.printStackTrace();}
				int[] pingCheck = search(image);
				if (pingCheck[0]==1) {
					break;
				} else {
					if(i<5) {continue;
					} else {
						Start.err("Absendefeld nicht erkannt");
					}
				}
			}
/*
		case 11:
			try {
				image = ImageIO.read((new File("Resources/abfrage1.bmp")));
			} catch (IOException e) {
				Start.err("IO Error: Could not read File for \"Absenden\"");
			} break;
*/
		}
		
		try {
			int[] loc = search(image);
			Robot clicker = new Robot();
			clicker.mouseMove(loc[1],loc[2]);
			clicker.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			try{Thread.sleep(250);} catch(InterruptedException e) {e.printStackTrace();}
			clicker.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		    
		} catch (AWTException e) {e.printStackTrace();}

	}

	public static void solveCode(boolean repeated) {
		
		for (int i = 1; i<6; i++) {
		    String nr = String.valueOf(i);
			String src="Resources/abfrage"+nr+".bmp";
			try {
				image = ImageIO.read((new File(src)));
		    } catch (IOException e) {e.printStackTrace();}
			int[] pingCheck = search(image);
			if (pingCheck[0]==1) {
				int[] code = getNumbers(pingCheck[1],pingCheck[2]);
				Start.log("Abfragefeld erkannt (abfrage"+i+".bmp)");
				Start.log("Code: "+code[0]+code[1]+code[2]+code[3]);
				clickOn(code[0]);
				clickOn(code[1]);
				clickOn(code[2]);
				clickOn(code[3]);
				clickOn(10);
				break;
			} else {
				if(i<5) {continue;
				} else {
					if(repeated==false) {
						Start.err("Kein Abfragefeld erkannt");
					} else {}
				}
			}
		}
	}
}
