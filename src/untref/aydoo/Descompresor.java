package untref.aydoo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class Descompresor {

	public List<String> extract(String zipFile, String outputPath) {
		List<String> fileList = new ArrayList<String>();
		
		try {
			FileInputStream fis = new FileInputStream(zipFile);
			CheckedInputStream cis = new CheckedInputStream(fis, new Adler32());
			BufferedInputStream bis = new BufferedInputStream(cis);
			ZipInputStream zis = new ZipInputStream(bis);
			ZipEntry ze;
			OutputStream os = null;
			
			outputPath = createDir(outputPath);
			
			while ((ze = zis.getNextEntry()) != null) {
				os = new FileOutputStream(outputPath + File.separator + ze.getName());
				fileList.add(outputPath + File.separator + ze.getName());
				int chunk;
				while ((chunk = zis.read()) != -1) {
					os.write(chunk);
				}
			}

			os.close();
			zis.close();
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return fileList;
	}

	private String createDir(String dirName) {
		File dir = new File(dirName);

		if (!dir.exists()) {
			dir.mkdir();
		}
		
		return dir.getAbsolutePath();
	}

//	private String getDirName(String zipFile) {
//		return zipFile.substring(0, zipFile.lastIndexOf('.'));
//	}

}
