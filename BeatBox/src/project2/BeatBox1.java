package project2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BeatBox1 extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon playBtnBase = new ImageIcon(Main.class.getResource("/images/playBtnBase.png"));
	private ImageIcon playBtnHover = new ImageIcon(Main.class.getResource("/images/playBtnHover.png"));
	private ImageIcon exitBtnBase = new ImageIcon(Main.class.getResource("/images/exitBtnBase.png"));
	private ImageIcon exitBtnHover = new ImageIcon(Main.class.getResource("/images/exitBtnHover.png"));
	private ImageIcon leftBtnBase = new ImageIcon(Main.class.getResource("/images/leftBtnBase.png"));
	private ImageIcon leftBtnHover = new ImageIcon(Main.class.getResource("/images/leftBtnHover.png"));
	private ImageIcon rightBtnBase = new ImageIcon(Main.class.getResource("/images/rightBtnBase.png"));
	private ImageIcon rightBtnHover = new ImageIcon(Main.class.getResource("/images/rightBtnHover.png"));
	private ImageIcon ezBtnBase = new ImageIcon(Main.class.getResource("/images/ezBtnBase.png"));
	private ImageIcon ezBtnHover = new ImageIcon(Main.class.getResource("/images/ezBtnHover.png"));
	private ImageIcon hdBtnBase = new ImageIcon(Main.class.getResource("/images/hdBtnBase.png"));
	private ImageIcon hdBtnHover = new ImageIcon(Main.class.getResource("/images/hdBtnHover.png"));
	private ImageIcon backBtnBase = new ImageIcon(Main.class.getResource("/images/leftBtnBase.png"));
	private ImageIcon backBtnHover = new ImageIcon(Main.class.getResource("/images/leftBtnHover.png"));
	private ImageIcon closeBtnBase = new ImageIcon(Main.class.getResource("/images/closeBtnBase.png"));
	private ImageIcon closeBtnHover = new ImageIcon(Main.class.getResource("/images/closeBtnHover.png"));

	private Image introBG = new ImageIcon(Main.class.getResource("/images/mainBG1.jpg")).getImage();

	private JButton playBtn = new JButton(playBtnBase);
	private JButton exitBtn = new JButton(exitBtnBase);
	private JButton leftBtn = new JButton(leftBtnBase);
	private JButton rightBtn = new JButton(rightBtnBase);
	private JButton ezBtn = new JButton(ezBtnBase);
	private JButton hdBtn = new JButton(hdBtnBase);
	private JButton backBtn = new JButton(backBtnBase);
	private JButton closeBtn = new JButton(closeBtnBase);
	private boolean isPlayScreen = false;
	private boolean isGameScreen = false;
	

	ArrayList<Track> trackList = new ArrayList<Track>();

	private Music selectedMusic;
	private Image selectedMImage;
	private Image titleImage;
	private Music introMusic = new Music("Outside-Ikson.mp3", true);
	private int nowSelected = 0;

	public static Game game;

	public BeatBox1() {
		trackList.add(new Track("invicible_N.png", "Invincible.png", "invicible_playBG.png",
				"DEAF KEV-Invincible-demo.mp3", "DEAF KEV-Invincible.mp3", "Invincible - Deaf Kev"));
		trackList.add(new Track("blasters_N.png", "blasters.png", "blasters_playBG.png", "Infraction-Blasters-demo.mp3",
				"Infraction-Blasters.mp3", "Blasters - Infraction"));
		trackList.add(new Track("Alexi Action-Aggressive Phonk_N.png", "Aggressive Phonk.png", "Aggressive Phonk-playBG.png",
				"Alexi Action-Aggressive Phonk-demo.mp3", "Alexi Action-Aggressive Phonk.mp3", "Aggressive Phonk - Alexi Action"));
		
		setUndecorated(true);
		setTitle("Beat Box");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		addKeyListener(new InputListener());

		introMusic.start();


		playBtn.setBounds(820, 700, 250, 100);
		playBtn.setBorderPainted(false);
		playBtn.setContentAreaFilled(false);
		playBtn.setFocusPainted(false);
		playBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playBtn.setIcon(playBtnHover);
				playBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music BtnHoveredMusic = new Music("BtnHovered.mp3", false);
				BtnHoveredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				playBtn.setIcon(playBtnBase);
				playBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music BtnPressedMusic = new Music("BtnPressed.mp3", false);
				BtnPressedMusic.start();
				gameMain();

			}
		});
		add(playBtn);

		exitBtn.setBounds(820, 830, 250, 100);
		exitBtn.setBorderPainted(false);
		exitBtn.setContentAreaFilled(false);
		exitBtn.setFocusPainted(false);
		exitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitBtn.setIcon(exitBtnHover);
				exitBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music BtnHoveredMusic = new Music("BtnHovered.mp3", false);
				BtnHoveredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitBtn.setIcon(exitBtnBase);
				exitBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music BtnPressedMusic = new Music("BtnPressed.mp3", false);
				BtnPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitBtn);

		leftBtn.setVisible(false);
		leftBtn.setBounds(400, 500, 250, 200);
		leftBtn.setBorderPainted(false);
		leftBtn.setContentAreaFilled(false);
		leftBtn.setFocusPainted(false);
		leftBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftBtn.setIcon(leftBtnHover);
				leftBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music BtnHoveredMusic = new Music("BtnHovered.mp3", false);
				BtnHoveredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftBtn.setIcon(leftBtnBase);
				leftBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music BtnPressedMusic = new Music("BtnPressed.mp3", false);
				BtnPressedMusic.start();
				selectLeft();
			}
		});
		add(leftBtn);

		rightBtn.setVisible(false);
		rightBtn.setBounds(1260, 500, 250, 200);
		rightBtn.setBorderPainted(false);
		rightBtn.setContentAreaFilled(false);
		rightBtn.setFocusPainted(false);
		rightBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightBtn.setIcon(rightBtnHover);
				rightBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music BtnHoveredMusic = new Music("BtnHovered.mp3", false);
				BtnHoveredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightBtn.setIcon(rightBtnBase);
				rightBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music BtnPressedMusic = new Music("BtnPressed.mp3", false);
				BtnPressedMusic.start();
				selectRight();

				//
			}
		});
		add(rightBtn);

		ezBtn.setVisible(false);
		ezBtn.setBounds(730, 800, 165, 65);
		ezBtn.setBorderPainted(false);
		ezBtn.setContentAreaFilled(false);
		ezBtn.setFocusPainted(false);
		ezBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				ezBtn.setIcon(ezBtnHover);
				ezBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music BtnHoveredMusic = new Music("BtnHovered.mp3", false);
				BtnHoveredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				ezBtn.setIcon(ezBtnBase);
				ezBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music BtnPressedMusic = new Music("BtnPressed.mp3", false);
				BtnPressedMusic.start();
				gameStart(nowSelected, "Easy Mode");

				//
			}
		});
		add(ezBtn);

		hdBtn.setVisible(false);
		hdBtn.setBounds(1030, 800, 165, 65);
		hdBtn.setBorderPainted(false);
		hdBtn.setContentAreaFilled(false);
		hdBtn.setFocusPainted(false);
		hdBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hdBtn.setIcon(hdBtnHover);
				hdBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music BtnHoveredMusic = new Music("BtnHovered.mp3", false);
				BtnHoveredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hdBtn.setIcon(hdBtnBase);
				hdBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music BtnPressedMusic = new Music("BtnPressed.mp3", false);
				BtnPressedMusic.start();
				gameStart(nowSelected, "Hard Mode");			
			}
		});
		add(hdBtn);
		
		closeBtn.setVisible(false);
		closeBtn.setBounds(1800, 50, 70, 70);
		closeBtn.setBorderPainted(false);
		closeBtn.setContentAreaFilled(false);
		closeBtn.setFocusPainted(false);
		closeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				closeBtn.setIcon(closeBtnHover);
				closeBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music BtnHoveredMusic = new Music("BtnHovered.mp3", false);
				BtnHoveredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				closeBtn.setIcon(closeBtnBase);
				closeBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music BtnPressedMusic = new Music("BtnPressed.mp3", false);
				BtnPressedMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(closeBtn);


		backBtn.setVisible(false);
		backBtn.setBounds(20, 20, 250, 200);
		backBtn.setBorderPainted(false);
		backBtn.setContentAreaFilled(false);
		backBtn.setFocusPainted(false);
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backBtn.setIcon(backBtnHover);
				backBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music BtnHoveredMusic = new Music("BtnHovered.mp3", false);
				BtnHoveredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backBtn.setIcon(backBtnBase);
				backBtn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music BtnPressedMusic = new Music("BtnPressed.mp3", false);
				BtnPressedMusic.start();
				gameMain();
			}
		});
		add(backBtn);

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(introBG, 0, 0, null); // base image
		if (isPlayScreen) {
			g.drawImage(selectedMImage, 730, 400, null);
			g.drawImage(titleImage, 500, 200, null);
		}
		if (isGameScreen) {

			game.screenDraw(g);
		}
		printComponents(g); // fixed image
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		this.repaint();

	}

	public void selectedTrack(int nowSelected) {

		if (selectedMusic != null) {
			selectedMusic.close();
		}
		titleImage = new ImageIcon(Main.class.getResource("/images/" + trackList.get(nowSelected).getTitleImage()))
				.getImage();
		selectedMImage = new ImageIcon(Main.class.getResource("/images/" + trackList.get(nowSelected).getStartImage()))
				.getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() {
		if (nowSelected == 0) {
			nowSelected = trackList.size() - 1;
		} else {
			nowSelected--;
		}
		selectedTrack(nowSelected);

	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectedTrack(nowSelected);
	}

	public void gameStart(int nowSelected, String difficulty) {
		if (selectedMusic != null)
			selectedMusic.close();

		isPlayScreen = false;
		leftBtn.setVisible(false);
		rightBtn.setVisible(false);
		ezBtn.setVisible(false);
		hdBtn.setVisible(false);
		introBG = new ImageIcon(Main.class.getResource("/images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backBtn.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty, trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
	}

	public void gameMain() {
		if (nowSelected != 0) {
			selectedTrack(nowSelected);
		} else {
			selectedTrack(0);
		}
		isPlayScreen = true;
		playBtn.setVisible(false);
		exitBtn.setVisible(false);
		backBtn.setVisible(false);
		introBG = new ImageIcon(Main.class.getResource("/images/playBG.jpg")).getImage();
		leftBtn.setVisible(true);
		rightBtn.setVisible(true);
		ezBtn.setVisible(true);
		hdBtn.setVisible(true);
		closeBtn.setVisible(true);
		isGameScreen = false;
		introMusic.close();
		if(game != null) {
			game.close();			
		}

	}

}
