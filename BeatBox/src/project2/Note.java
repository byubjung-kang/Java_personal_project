package project2;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

public class Note extends Thread {

    private static Image noteBImage = new ImageIcon(Main.class.getResource("/images/noteB.png")).getImage();
    private static Image noteWImage = new ImageIcon(Main.class.getResource("/images/noteW.png")).getImage();
    private static Image noteRImage = new ImageIcon(Main.class.getResource("/images/noteR.png")).getImage();
	private boolean playing = true;
	
	
    
    private static final Map<String, Integer> NOTE_X_COORDS = new HashMap<>();
    static {
        NOTE_X_COORDS.put("A", 505);
        NOTE_X_COORDS.put("S", 625);
        NOTE_X_COORDS.put("D", 745);
        NOTE_X_COORDS.put("Space", 869);
        NOTE_X_COORDS.put("J", 1109);
        NOTE_X_COORDS.put("K", 1230);
        NOTE_X_COORDS.put("L", 1351);
    }

    private static final Map<String, Image> NOTE_IMAGES = new HashMap<>();
    static {
        try {
			NOTE_IMAGES.put("Space", noteRImage);
			NOTE_IMAGES.put("A", noteBImage);
			NOTE_IMAGES.put("D", noteBImage);
			NOTE_IMAGES.put("J", noteBImage);
			NOTE_IMAGES.put("L", noteBImage);
			NOTE_IMAGES.put("S", noteWImage);
			NOTE_IMAGES.put("K", noteWImage);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			
		}
    }

    private int x, y = 904 - (1000/ Main.SLEEP_TIME  * Main.NOTE_SPEED) * Main.REACH_TIME;
    private String noteType;
    
    public boolean isPlaying() {
    	return playing;
    }
    
    public String getNoteType() {
    	return noteType;
    }
    
    public void close() {
    	playing = false;
    }

    public Note(String noteType) {
        this.noteType = noteType;
        this.x = NOTE_X_COORDS.getOrDefault(noteType, 0);
    }

    public void screenDraw(Graphics2D g) {
        g.drawImage(NOTE_IMAGES.get(noteType), x, y, null);
    }

    public void drop() {
        y += Main.NOTE_SPEED;
        if(y > 954) {
        	System.out.println("Miss");
        	close();
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                drop();
                if(playing) {
                	Thread.sleep(Main.SLEEP_TIME);
                }else {
                	interrupt();
                	break;
                }                
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    public String judge() {
        

        if (y >= 934) {
        	System.out.println("Late");
        	close();
        	return "Late";            
        } else if (y >= 884) {
        	System.out.println("Perfect");
        	close();
             return "Perfect";
        } else if (y >= 864) {
        	System.out.println("Great");
        	close();
             return "Great";
        } else if (y >= 844) {
        	System.out.println("Early");
        	close();
        	return "Early";
        } else {
        	return "None";
        }
    }
    
    public int getY() {
    	return y;
    }

}