package untref.aydoo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirMonitor {

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

}
