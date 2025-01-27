import java.io.File;

public class STLHelper {
	public static String getFileSize(String name)
	{
		String inputDir = "res/";
		
		File f = new File(inputDir +name);
		
		String output = (f.length() / 1024) + "KB";
		
		return output;
	}
}
