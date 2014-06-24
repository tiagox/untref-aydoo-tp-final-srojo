package untref.aydoo.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

	private String tempDir;

	public String prepareFiles(String baseDir, List<String> zipList) {
		ZipExtractor extractor = new ZipExtractor();

		tempDir = createTempDir(baseDir);

		for (String filePath : zipList) {
			extractor.extract(filePath, tempDir);
		}

		return tempDir;
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

	public void clean(String dirPath) {
		File dir = new File(dirPath);
		for (File file : dir.listFiles()) {
			file.delete();
		}
		dir.delete();
	}

	public File moveFileTo(File sourceFile, File destFolder) {
		File newFile = new File(destFolder.getAbsolutePath() + File.separator + sourceFile.getName());
		sourceFile.renameTo(newFile);
		return newFile;
	}

	public File createSubDir(String dirName, String subDirName) {
		File subDir = new File(dirName + File.separator + subDirName);

		if (!subDir.exists()) {
			subDir.mkdir();
		}

		return subDir;
	}

}
