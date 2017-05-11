package plugins;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Class used to  find the plugins
 * 
 * @author Maxime Opsommer
 * @author Damien Toulouse
 */
public class PluginFinder{
	
	// Fields

	private final File dir;
	private PluginFilter filter;
	private Set<File> knownFiles = new HashSet<File>();
	
	// Methods
	
	/**
	 * Constructor for the finder
	 * @param dir
	 */
	public PluginFinder(File dir) {
		this.dir = dir;
		this.filter = new PluginFilter();
		this.knownFiles = listFiles();
	}
	
	/**
	 * Returns a Set containing the files in the directory
	 * 
	 * @return a Set containing the files in the directory
	 */
	private Set<File> listFiles() {
		return new HashSet<File>(Arrays.asList(dir.listFiles(filter)));		
	}
	
	
	public Set<File> getKnownFiles() {
		return knownFiles;
	}
	
}
