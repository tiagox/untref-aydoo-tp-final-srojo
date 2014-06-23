package untref.aydoo;

import java.io.File;
import java.util.List;

public class FileManager {

	private static final String ZIP_EXTENSION = "ZIP";
	private static final String CSV_EXTENSION = "CSV";
	private String tempDir;

	public List<String> prepareFiles(String inputDir) {
		DirManager monitor = new DirManager();
		ZipExtractor extractor = new ZipExtractor();

		tempDir = createTempDir(inputDir);

		for (String filePath : monitor.getFilesByExtension(inputDir,
				ZIP_EXTENSION)) {
			extractor.extract(filePath, tempDir);
		}

		return monitor.getFilesByExtension(tempDir, CSV_EXTENSION);
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

	public void cleanFiles() {
		File dir = new File(tempDir);
		for (File file : dir.listFiles()) {
			file.delete();
		}
		dir.delete();
	}

}
