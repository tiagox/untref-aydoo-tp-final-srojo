import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ReadZipContentWithoutExtactExample {
	public static void main(String[] args) throws IOException {
		ZipFile zipFile = new ZipFile("resourcesTests/dirWithZips/recorridosB.zip");
		String line;
		Enumeration<? extends ZipEntry> entries = zipFile.entries();

		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			InputStream stream = zipFile.getInputStream(entry);
			BufferedReader buffer = new BufferedReader(new InputStreamReader(stream));
			System.out.println(entry.getName());
			while ((line = buffer.readLine()) != null) {
				System.out.println(line);				
			}
		}
		
		zipFile.close();
	}
}
