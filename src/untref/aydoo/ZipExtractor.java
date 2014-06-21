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

public class ZipExtractor {

	public List<String> extract(String zipFile, String outputPath) {
		ZipInputStream zis;
		ZipEntry ze;
		OutputStream os = null;
		List<String> fileList = new ArrayList<String>();

		outputPath = createDir(outputPath);

		try {
			zis = new ZipInputStream(new BufferedInputStream(
					new CheckedInputStream(new FileInputStream(zipFile),
							new Adler32())));

			while ((ze = zis.getNextEntry()) != null) {
				os = new FileOutputStream(outputPath + File.separator
						+ ze.getName());
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

}
