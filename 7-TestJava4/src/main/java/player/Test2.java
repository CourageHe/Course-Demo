package player;

import java.io.File;  
import java.io.IOException;  
  
import javax.sound.sampled.AudioFormat;  
import javax.sound.sampled.AudioInputStream;  
import javax.sound.sampled.AudioSystem;  
import javax.sound.sampled.DataLine;  
import javax.sound.sampled.SourceDataLine;  
   
public class Test2 {  
   
    public static void main(String[] args) {  
         Test2 player = new Test2 (); 
//        String[] strSongNames={ "song1.wav","song2.wav","song3.wav","song4.wav","song5.flac","song6.ape"};
        player.play("resources/songs/song1.wav");  
//        player.play("songs/song5.flac"); 
//         player.play("songs/song6.ape");
//        player.play("songs/song7.mp3");  
        
    }  
//    https://baike.xsoftlab.net/view/737.html
//    https://mvnrepository.com/artifact/javax.security.auth.message/jmac
//    https://www.iteye.com/blog/xpenxpen-2170947
    public void play(String filePath) {  
        final File file = new File(filePath);  
   
        try {  
            final AudioInputStream in = AudioSystem.getAudioInputStream(file);  
               
            final AudioFormat outFormat = getOutFormat(in.getFormat());  
            final DataLine.Info info = new DataLine.Info(SourceDataLine.class, outFormat);  
   
            final SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);  
   
            if (line != null) {  
                line.open(outFormat);  
                line.start();  
                stream(AudioSystem.getAudioInputStream(outFormat, in), line);  
                line.drain();  
                line.stop();  
            }  
   
        } catch (Exception e) {  
            throw new IllegalStateException(e);  
        }  
    }  
   
    private AudioFormat getOutFormat(AudioFormat inFormat) {  
        final int ch = inFormat.getChannels();  
        final float rate = inFormat.getSampleRate();  
        return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);  
    }  
   
    private void stream(AudioInputStream in, SourceDataLine line)  
        throws IOException {  
        final byte[] buffer = new byte[65536];  
        for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {  
            line.write(buffer, 0, n);  
        }  
    }  
}  