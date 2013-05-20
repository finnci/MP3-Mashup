import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;


public class MashUp {
	static int mod = 100;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Filename of song to mash:");
		Scanner scan = new Scanner(System.in);
		String s_name = scan.next();
		Random rand = new Random();
		System.out.println("What do you want to call the mashed song:");
		String m_name = scan.next();	
		//declare files
		File song = new File(s_name);
		File mashed_song = new File(m_name + ".mp3");
		//set up streams
		FileInputStream file = new FileInputStream(song); 
		FileOutputStream mash = new FileOutputStream(mashed_song); 

		boolean eof = false;
		int count = 0;
		while(!eof){
			int in = file.read();
			if(in == -1){
				//end of file
				eof = true;
			}
			else{
				count++;
				if(count % mod == 0){
					int newinput = in + rand.nextInt(10);
					if(newinput > 255){
						newinput = newinput - 255; //fix if too large
						}
					mash.write(newinput);
				}
				else{
					mash.write(in);
				}
			}
			
		}
		file.close();
		mash.close();
		System.out.println("Mashed mp3 is completed");


	}

}
