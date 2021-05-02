package imageStuff;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageTr {
	
//	static String inFile = "Book.txt";
//	static String outFile = "Bookt.txt";
	
	public static void fileCopyNotBuffer() {
		System.out.println("\n Inside FCNB method");
		long startTime, elapsedTime; //for speed benchmarking
		
		//Print File length
		File fileIn = new File("Photo.jpg");
		System.out.println("the file size is " + fileIn.length() + "bytes");
		
		try(FileInputStream in = new FileInputStream("Photo.jpg");
				FileOutputStream out = new FileOutputStream("Photo-out.jpg")){
			startTime = System.nanoTime();
			int byteRead;
			//Read a raw byte and return int from 0 to 255 since read functuin reads individual byte
			while((byteRead = in.read()) != -1) {
				out.write(byteRead);
			}
			elapsedTime = System.nanoTime() - startTime;
			System.out.println("ElapsedTime is  " + (elapsedTime/1000000.0) + " msec");
		}
		catch (IOException e)
		{
			System.out.println("This did not work right I suppose");
		}
	}
	
	public static void fileCopyBuffer() {
		System.out.println("inside File Copy using the buffer");
		long start, end;
		start = System.nanoTime();
		try (BufferedInputStream in = new BufferedInputStream(new FileInputStream("Photo.jpg")) ;
				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("Photo-out.jpg"))){
			byte[] byteBuf = new byte[4000];
			int numBytesRead;
			while((numBytesRead = in.read(byteBuf)) != -1) {
				out.write(byteBuf, 0, numBytesRead);
			} }
			catch (IOException e)
			{
				System.out.println("Also an error here");
			}
		end = System.nanoTime() - start;
		System.out.println("time is: " + (end/1000000.0));
		
	}
	
	public static void main(String[] args)
	{
		fileCopyNotBuffer();
		fileCopyBuffer();
	}

}
