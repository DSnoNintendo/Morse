/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.io.File; 
import java.io.IOException; 
import java.util.Scanner; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 

public class Audio  
{ 
  String path;
  Clip clip;
  
  void open() {
      try {
          File Music = new File(path);
          //if (Music.exists()) {
              AudioInputStream audioInput = AudioSystem.getAudioInputStream(Music);
              clip = AudioSystem.getClip();
              clip.open(audioInput);
          //}
          /*else {
              System.out.print("Could not open file");
          }*/
      }
      catch(Exception ex) {
          ex.printStackTrace();
      }
  }
  
  void play() {
       
      try {
              clip.start();      
              
      }
      catch(Exception ex) {
          ex.printStackTrace();
      }
      
  }
  void stop() {
       
      try {
              clip.stop(); 
              clip.setMicrosecondPosition(0);
              
      }
      catch(Exception ex) {
          ex.printStackTrace();
      }
      
  }
  
}
  