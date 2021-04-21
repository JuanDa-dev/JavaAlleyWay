/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author mateo
 */
public class PlaySounds {

    private Clip clip;

    public PlaySounds(String filePath) {
        URL musicUrl;
        try {
            musicUrl = new File(filePath).toURI().toURL();
            AudioInputStream ms = AudioSystem.getAudioInputStream(musicUrl);
            this.clip = AudioSystem.getClip();
            clip.open(ms);

        } catch (Exception e) {
            System.out.println("Error al reproducir");
        }
    }

    public Clip getClip() {
        return clip;
    }

}
