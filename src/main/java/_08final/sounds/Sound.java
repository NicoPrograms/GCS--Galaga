package _08final.sounds;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.*;

public class Sound {
	private static float volume = 0.5f;

    /**
     * Plays an individual sound file once.
     * @param strPath the path to the sound file.
     * @cite: http://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
     * */
	public static synchronized void playSound(final String strPath) {
	    new Thread(new Runnable() {
	      public void run() {
	        try {
	          Clip clp = AudioSystem.getClip();

	          AudioInputStream aisStream =
					  AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream(strPath));
	          clp.open(aisStream);

			  setVolume(clp);

	          clp.start();
	        } catch (Exception e) {
	          System.err.println(e.getMessage());
	        }
	      }
	    }).start();
	  }


    /**
     * Continuously plays a sound file.
     * @param strPath the path to the sound file.
     * @cite: http://stackoverflow.com/questions/4875080/music-loop-in-java
     * */
	public static Clip clipForLoopFactory(String strPath){

		Clip clp = null;

		// this line caused the original exceptions
		try {
			AudioInputStream aisStream =
					  AudioSystem.getAudioInputStream(Sound.class.getResourceAsStream(strPath));
			clp = AudioSystem.getClip();
		    clp.open( aisStream );
			setVolume(clp);

		} catch (UnsupportedAudioFileException exp) {
			exp.printStackTrace();
		} catch(Exception exp){
			System.out.println("error");
		}

		return clp;

	}

	public static void setVolume(float value) {
		volume = value;
	}

	private static void setVolume(Clip clip) {
		if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
			FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
			float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
			gainControl.setValue(dB);
		}
	}


}
