package project2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image gameInfo = new ImageIcon(Main.class.getResource("/images/gameInfoImage.png")).getImage();
	private Image layout = new ImageIcon(Main.class.getResource("/images/layoutUI.png")).getImage();
	private Image layoutIn = new ImageIcon(Main.class.getResource("/images/layoutUI-in.png")).getImage();
	private Image judmentLine = new ImageIcon(Main.class.getResource("/images/judBar.png")).getImage();
	private Image inputImage = new ImageIcon(Main.class.getResource("/images/inputImage.png")).getImage();
	private Image inputSpace = new ImageIcon(Main.class.getResource("/images/inputSpace.png")).getImage();
	private Image judeImage ;


	private boolean isInputA = false;
	private boolean isInputS = false;
	private boolean isInputD = false;
	private boolean isInputSpace = false;
	private boolean isInputJ = false;
	private boolean isInputK = false;
	private boolean isInputL = false;
	
	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music playMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		playMusic = new Music(this.musicTitle, false);
		
	}

	public void screenDraw(Graphics2D g) {
				
		g.drawImage(layoutIn, 500, 0, null);
		g.drawImage(judmentLine, 502, 904, null);
		
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(note.getY() > 954) {
				judeImage = new ImageIcon(Main.class.getResource("/images/miss1.png")).getImage();	
			}
			if(!note.isPlaying()) {
				noteList.remove(i);
				i--;
			}else {
				note.screenDraw(g);
				
			}
		}
		g.drawImage(gameInfo, 0, 1140, null);
		g.drawImage(layout, 430, 0, null);

		if (isInputA) {
			g.drawImage(inputImage, 505, 0, null);}
		if (isInputS) {
			g.drawImage(inputImage, 625, 0, null);}
		if (isInputD) {
			g.drawImage(inputImage, 745, 0, null);}
		if (isInputSpace) {
			g.drawImage(inputSpace, 869, 0, null);}
		if (isInputJ) {
			g.drawImage(inputImage, 1109, 0, null);}
		if (isInputK) {
			g.drawImage(inputImage, 1230, 0, null);}
		if (isInputL) {
			g.drawImage(inputImage, 1351, 0, null);}
		
		g.setColor(Color.CYAN);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 30, 1210);
		g.drawString(difficulty, 1600, 1210);
		g.setColor(Color.DARK_GRAY);

		g.drawString("A", 555, 996);
		g.drawString("S", 675, 996);
		g.drawString("D", 795, 996);
		g.drawString("Space Bar", 919, 996);
		g.drawString("J", 1160, 996);
		g.drawString("K", 1280, 996);
		g.drawString("L", 1400, 996);

		g.setFont(new Font("Elephant", Font.BOLD, 15));
		g.drawString("00000", 1380, 1040);
		g.drawImage(judeImage, 430, 450, null);


	}

	public void inputA() {
		judge("A");
		isInputA = true;
		new Music("kick1.mp3", false).start();

	}

	public void releaseA() {
		isInputA = false;
	}

	public void inputS() {
		judge("S");
		isInputS = true;
		new Music("snare2.mp3", false).start();
	}

	public void releaseS() {
		isInputS = false;
	}

	public void inputD() {
		judge("D");
		isInputD = true;
		new Music("drum1.mp3", false).start();
	}

	public void releaseD() {
		isInputD = false;
	}

	public void inputSpace() {
		judge("Space");
		isInputSpace = true;
		new Music("space1.mp3", false).start();
	}

	public void releaseSpace() {
		isInputSpace = false;
	}

	public void inputJ() {
		judge("J");
		isInputJ = true;
		
		new Music("drum2.mp3", false).start();
	}

	public void releaseJ() {
		isInputJ = false;
	}

	public void inputK() {
		judge("K");
		isInputK = true;
		new Music("snare3.mp3", false).start();
	}

	public void releaseK() {
		isInputK = false;
	}

	public void inputL() {
		judge("L");
		isInputL = true;
		new Music("kick1.mp3", false).start();
	}

	public void releaseL() {
		isInputL = false;
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}
	
	public void close() {
		playMusic.close();
		this.interrupt();
	}
	
	public void dropNotes(String titleName) {
		
		Beat[] beat = null;
		if(titleName.equals("Invincible - Deaf Kev") && difficulty.equals("Easy Mode")){
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int bpm = 50;
			
			beat = new Beat[] {
					// + 14 = 16 beat 
					new Beat(startTime + bpm * 6, "J"),
					new Beat(startTime + bpm * 20, "S"),
					new Beat(startTime + bpm * 30, "K"),
					new Beat(startTime + bpm * 51, "D"),
					new Beat(startTime + bpm * 55, "Space"),
					new Beat(startTime + bpm * 59, "S"),
					new Beat(startTime + bpm * 70, "D"),
					new Beat(startTime + bpm * 73, "L"),
					new Beat(startTime + bpm * 77, "L"),
					new Beat(startTime + bpm * 126, "A"),
					new Beat(startTime + bpm * 126, "Space"),
					new Beat(startTime + bpm * 126, "L"),
					new Beat(startTime + bpm * 135, "S"),
					new Beat(startTime + bpm * 144, "K"),
					new Beat(startTime + bpm * 158, "A"),
					new Beat(startTime + bpm * 170, "L"),
					new Beat(startTime + bpm * 282, "J"),
					new Beat(startTime + bpm * 282, "D"),
					new Beat(startTime + bpm * 300, "S"),
					new Beat(startTime + bpm * 300, "K"),
					new Beat(startTime + bpm * 400, "S"),
					new Beat(startTime + bpm * 500, "K"),
					new Beat(startTime + bpm * 600, "A"),
					new Beat(startTime + bpm * 700, "L"),
					new Beat(startTime + bpm * 800, "Space"),
					new Beat(startTime + bpm * 900, "Space"),
					new Beat(startTime + bpm * 900, "D"),
					new Beat(startTime + bpm * 900, "J"),
					new Beat(startTime + bpm * 1000, "K"),
					new Beat(startTime + bpm * 1100, "L"),
					new Beat(startTime + bpm * 1200, "L"),
					new Beat(startTime + bpm * 1300, "L"),
					new Beat(startTime + bpm * 1400, "K"),
					new Beat(startTime + bpm * 1500, "L"),
					new Beat(startTime + bpm * 1600, "L"),
					new Beat(startTime + bpm * 1700, "L"),
					new Beat(startTime + bpm * 1800, "K"),
					new Beat(startTime + bpm * 1900, "L"),
					new Beat(startTime + bpm * 2000, "L"),
					new Beat(startTime + bpm * 2100, "L"),
					new Beat(startTime + bpm * 2200, "K"),
					new Beat(startTime + bpm * 2300, "L"),
					new Beat(startTime + bpm * 2400, "L"),
					new Beat(startTime + bpm * 2500, "L"),
					new Beat(startTime + bpm * 2600, "K"),
					new Beat(startTime + bpm * 2700, "L"),
					new Beat(startTime + bpm * 2800, "L"),
					new Beat(startTime + bpm * 2900, "L"),
					new Beat(startTime + bpm * 3000, "K"),
					new Beat(startTime + bpm * 3100, "L"),
					new Beat(startTime + bpm * 3200, "L"),
					new Beat(startTime + bpm * 3300, "L"),
					
					
					
					
					
			};
		}else if(titleName.equals("Invincible - Deaf Kev")&& difficulty.equals("Hard Mode")){
			int startTime = 1000;
			int bpm = 70;
			beat = new Beat[] {
					new Beat(startTime, "Space"),
					new Beat(startTime + bpm * 6, "J"),
					new Beat(startTime + bpm * 20, "Space"),
					new Beat(startTime + bpm * 30, "K"),
					new Beat(startTime + bpm * 51, "Space"),
					new Beat(startTime + bpm * 55, "Space"),
					new Beat(startTime + bpm * 59, "S"),
					new Beat(startTime + bpm * 70, "D"),
					new Beat(startTime + bpm * 73, "L"),
					new Beat(startTime + bpm * 77, "L"),
					new Beat(startTime + bpm * 126, "A"),
					new Beat(startTime + bpm * 126, "Space"),
					new Beat(startTime + bpm * 126, "L"),
					new Beat(startTime + bpm * 135, "S"),
					new Beat(startTime + bpm * 144, "K"),
					new Beat(startTime + bpm * 158, "A"),
					new Beat(startTime + bpm * 170, "L"),
			};
		}else if(titleName.equals("Blasters - Infraction")&& difficulty.equals("Easy Mode")){
			int startTime = 1000;
			beat = new Beat[] {
					new Beat(startTime, "Space")
			};
		}else if(titleName.equals("Blasters - Infraction")&& difficulty.equals("Hard Mode")){
			int startTime = 1000;
			beat = new Beat[] {
					new Beat(startTime, "Space")
			};
		}
		else if(titleName.equals("Aggressive Phonk - Alexi Action")&& difficulty.equals("Easy Mode")){
			int startTime = 1000;
			beat = new Beat[] {
					new Beat(startTime, "Space")
			};
		}else if(titleName.equals("Aggressive Phonk - Alexi Action") && difficulty.equals("Hard Mode")){
			int startTime = 1000;
			beat = new Beat[] {
					new Beat(startTime, "Space")
			};
		}

		
		int i = 0;
		playMusic.start();
		while(i < beat.length && ! isInterrupted()) {
			boolean dropped = false;
			if(beat[i].getTime() <= playMusic.getTime()) {
				Note note = new Note(beat[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if(!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
	public void judge (String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}
	
	public void judgeEvent (String judge) {
		if(judge.equals("Miss")) {
			judeImage = new ImageIcon(Main.class.getResource("/images/miss1.png")).getImage();			
		}else if(judge.equals("Great")) {
			judeImage = new ImageIcon(Main.class.getResource("/images/great1.png")).getImage();
		}else if(judge.equals("Perfect")) {
			judeImage = new ImageIcon(Main.class.getResource("/images/perfect1.png")).getImage();
		}else if(judge.equals("Early")) {
			judeImage = new ImageIcon(Main.class.getResource("/images/early1.png")).getImage();
		}else if(judge.equals("Late")) {
			judeImage = new ImageIcon(Main.class.getResource("/images/late1.png")).getImage();
		}
	}
}
