import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;


public class Test {

	static int[] ORDER = {3, 1, 4, 2, 6, 7, 5};
	static JFrame[] FRAMES = {
		new JFrame(),
		new JFrame(),
		new JFrame(),
		new JFrame(),
		new JFrame(),
		new JFrame(),
		new JFrame()
	};
	static JLabel[] LABELS = {
		new JLabel("",null,JLabel.CENTER),
		new JLabel("",null,JLabel.CENTER),
		new JLabel("",null,JLabel.CENTER),
		new JLabel("",null,JLabel.CENTER),
		new JLabel("",null,JLabel.CENTER),
		new JLabel("",null,JLabel.CENTER),
		new JLabel("",null,JLabel.CENTER)
	};


	public static void main(String[] args) {
		try {

			for(int i = 0; i<FRAMES.length; i++){
				FRAMES[i].add(LABELS[i]);
			}

			Multimedia m = new Imagen("QRRZHIT.jpg",1,5,3);
			Multimedia m2 = new Texto("Una prueba de texto para la presentación",4,5,3);
			Multimedia m3 = new Video("videoFrame.mp4",1,40,3);
			Multimedia m4 = new Imagen("wallpaper-stark-1600.jpg",1,5,3);
			Multimedia m5 = new Imagen("QRRZHIT.jpg",3,5,3);
			Multimedia m6 = new Audio("ringtone.mp3",1,5,3);
			
			runElement(m);
			runElement(m2);
			runElement(m3);
			runElement(m4);
			runElement(m5);
			runElement(m6);
			runElement(m3);
			System.exit(0);
		}
		catch (Exception ioe) {
			
		}
	}

	public static void runElement(Multimedia m){
		try{
			if( m instanceof Imagen) {

				Imagen i = (Imagen)m;
				FRAMES[i.getPantalla()].add(LABELS[i.getPantalla()]);
				BufferedImage img = ImageIO.read(new File(i.getNombre()));
				ImageIcon icon = new ImageIcon(img);
				LABELS[i.getPantalla()].setIcon(icon);
				showOnScreen(i.getPantalla(),FRAMES[i.getPantalla()]);
				Thread.sleep(i.getDuracion());

			}else if(m instanceof Texto){
				Texto t = (Texto)m;
				FRAMES[t.getPantalla()].add(LABELS[t.getPantalla()]);
				//LABELS[t.getPantalla()].setFont(new Font("Arial", Font.PLAIN, 200));
				LABELS[t.getPantalla()].setText(t.getNombre());
				showOnScreen(t.getPantalla(),FRAMES[t.getPantalla()]);
				Thread.sleep(t.getDuracion());
			}else if(m instanceof Video){

				 JFXPanel jfxPanel = new JFXPanel();


				System.out.println("En video");
				
				FRAMES[m.getPantalla()].add(LABELS[m.getPantalla()]);
				FRAMES[m.getPantalla()].add(jfxPanel);


				File file = new File(m.getNombre());
				System.out.println(file.toURI().toString());
				Media media = new Media(file.toURI().toString());                                  
				MediaPlayer oracleVid = new MediaPlayer(media);
				jfxPanel.setScene(new Scene(new Group(new MediaView(oracleVid))));                    
				oracleVid.setVolume(0.7);
				oracleVid.play();
				showOnScreen(m.getPantalla(),FRAMES[m.getPantalla()]);
				int duration = (int)Math.floor(media.getDuration().toSeconds());
				Thread.sleep(duration*1000);
				jfxPanel.setVisible(false);

			}else if(m instanceof Audio){
				 JFXPanel jfxPanel = new JFXPanel();
				FRAMES[m.getPantalla()].add(jfxPanel);

				File file = new File("ringtone.mp3");
				System.out.println(file.toURI().toString());
				Media media = new Media(file.toURI().toString());                                  
				MediaPlayer oracleVid = new MediaPlayer(media);
				jfxPanel.setScene(new Scene(new Group(new MediaView(oracleVid))));                    
				oracleVid.setVolume(0.7);//volumen//repite video
				oracleVid.play();//play video
				showOnScreen(m.getPantalla(),FRAMES[m.getPantalla()]);
				int duration = (int)Math.floor(media.getDuration().toSeconds());
				Thread.sleep(duration*1000);
				jfxPanel.setVisible(false);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void showOnScreen(int screen, Frame frame) {
		GraphicsEnvironment ge = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		if(!frame.isVisible()){
			frame.setVisible(true);
		}
		System.out.println(gs.length);
		if (screen > -1 && screen < gs.length) {
			gs[screen].setFullScreenWindow(frame);
		} else if (gs.length > 0) {
			gs[0].setFullScreenWindow(frame);
		} else {
			throw new RuntimeException("No Screens Found");
		}
	}

}