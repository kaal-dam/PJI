package plugins;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Class used to determine if a plugin is acceptable or not
 */
public class PluginFilter implements FilenameFilter {

	/**
	 * @see FilenameFilter#accept(File, String)
	 */
	@Override
	public boolean accept(File dir, String name) {
		if(!fileExtensionIsClass(name))
			return false;
		Class<?> c = getClass(dir, name);
		if(c == null){
			return false;
		}
			
		return inheritFromPlugin(c) && classHaveCorrectConstructor(c);
	}

	/**
	 * Returns true if the file extension is ".class"
	 * 
	 * @param name : the file name to analyze
	 * @return true if the file extension is ".class"
	 */
	public boolean fileExtensionIsClass(String name) {
		return name.endsWith(".class");
	}
	
	/**
	 * Returns the class of the plugin
	 * 
	 * @param dir : the directory where the plugins are
	 * @param className : the name of the file to analyze
	 * @return the class of the plugin
	 */
	public Class<?> getClass(File dir, String className) {
		className = className.substring(0, className.length()-6);
		try {
			URL[] classLoaderUrls = new URL[]{new URL(dir.toURI().toURL().toString())};
			URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);
			Class<?> res = urlClassLoader.loadClass("testRules." + className);
			urlClassLoader.close();
			return res;
		} catch (ClassNotFoundException e) {
			return null;
		} catch (MalformedURLException e) {
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns true if the class inherits from the plugin interface
	 * 
	 * @param c : the class to analyze
	 * @return true if the class inherits from the plugin interface
	 */
	protected boolean inheritFromPlugin(Class<?> c) {
		return Plugin.class.isAssignableFrom(c);
	}
	
	protected boolean classHaveCorrectConstructor(Class<?> c){
		for(Constructor<?> constr : c.getConstructors()) {
			if(constr.getParameterTypes().length == 0)
				return true;
		}
		return false;
	}
}
