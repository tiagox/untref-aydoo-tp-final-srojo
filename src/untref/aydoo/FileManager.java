package untref.aydoo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	private static final String ZIP_EXTENSION = "ZIP";
	private static final String CSV_EXTENSION = "CSV";
	private String tempDir;

	public List<String> prepareFiles(String inputDir) {
		ZipExtractor extractor = new ZipExtractor();

		tempDir = createTempDir(inputDir);

		for (String filePath : getFilesByExtension(inputDir,
				ZIP_EXTENSION)) {
			extractor.extract(filePath, tempDir);
		}

		return getFilesByExtension(tempDir, CSV_EXTENSION);
	}

	private String createTempDir(String baseDir) {
		String name = "" + System.currentTimeMillis() / 1000L;
		File dir = new File(baseDir + File.separator + name);
		while (dir.exists()) {
			name += "_";
			dir = new File(baseDir + File.separator + name);
		}
		dir.mkdir();
		return baseDir + File.separator + name;
	}

	public List<String> getFilesByExtension(String dir, String ext) {
		File folder = new File(dir);

		if (!folder.exists()) {
			return null;
		}

		String name;
		List<String> fileNames = new ArrayList<String>();

		for (File file : folder.listFiles()) {
			name = file.getName();
			if (file.isFile() && hasExtension(name, ext)) {
				fileNames.add(dir + File.separator + name);
			}
		}
		return fileNames;
	}

	private boolean hasExtension(String name, String ext) {
		return name.toLowerCase().endsWith("." + ext.toLowerCase());
	}

	public void cleanFiles() {
		File dir = new File(tempDir);
		for (File file : dir.listFiles()) {
			file.delete();
		}
		dir.delete();
	}

}
