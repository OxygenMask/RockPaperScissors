import java.util.Random;
import java.util.Scanner;  // Import the Scanner class
import java.io.*;
import javax.sound.sampled.*;
import java.awt.Desktop;
import java.io.File;

public class RPS{
	
	public static void main(String args[]) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		//Scanner
		Scanner scanner = new Scanner(System.in);
		
		//retry
		boolean valid = false;
		
		//instance of random
		Random rand = new Random();
		//create scanner object
		Scanner myObj = new Scanner(System.in);
		
		//Generate 0 -2
		int opponent = rand.nextInt(3);
		
		//Audio
		File file = new File("Audio/Gun.wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioStream);
		
		//Image
		File f = new File("Image/gun.png");
		Desktop d = Desktop.getDesktop();
		//d.open(f);
		
		
		do{
			//user input
			System.out.println("Type in 'Rock', 'Paper', or 'Scissor': ");
			//playAudio("Audio/Gun.wav");
			String player = myObj.nextLine();
			player = player.toLowerCase();
			
			if(player.equals("gun")){
				valid = true;
				System.out.println("Wait a minute");
				clip.start();
				d.open(f);
				
				//String response = scanner.next();
				//delay for audio to load
				try {
                    Thread.sleep(2000); // Delay in milliseconds (e.g., 4000ms = 2 seconds)
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
				System.out.println("*BANG*");
				
				
			}//end of if
			
			//if user picks rock, paper, or scissors
			else if(player.equals("rock") || player.equals("paper") || player.equals("scissor")){
				valid = true;
			
				//display result
				switch(opponent){//displays what the computer chose
					case 0:
						System.out.println("Opponent chose Rock");
						break;
					case 1:
						System.out.println("Opponent chose Paper");
						break;
					case 2:
						System.out.println("Opponent chose Scissor");
						break;
				}//end of switch
				
				//decides if player wins
				if(player.equals("rock")){
					if(opponent == 0){
						System.out.println("It's a Tie");
					}
					else if(opponent == 1){
						System.out.println("You Lose");
					}
					else if(opponent == 2){
						System.out.println("You Win");
					}
				}
				else if(player.equals("paper")){
					if(opponent == 0){
						System.out.println("You Win");
					}
					else if(opponent == 1){
						System.out.println("It's a Tie");
					}
					else if(opponent == 2){
						System.out.println("You Lose");
					}
				}
				else if(player.equals("scissor")){
					if(opponent == 0){
						System.out.println("You Lose");
					}
					else if(opponent == 1){
						System.out.println("You Win");
					}		
					else if(opponent == 2){
						System.out.println("It's a Tie");
					}
				}
				
			}//end of if
			else{
				System.out.println("Invalid input");
				System.out.println("Try again");
			}		
		} while (!valid);//repeat until valid input
		
	}//end of main
	
}//end of class