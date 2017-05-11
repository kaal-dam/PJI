package genHacker;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import genGrid.Starter;
import grid.Cell;
import grid.Grid;
import grid.Solution;
import plugins.Plugin;
import plugins.PluginFinder;
import rules.Rule;

public class Hacker {

	protected final File dropins = new File("bin/testRules");
	protected final PluginFinder finder;
	Grid grille;
	List<Plugin> colorRules= new ArrayList<>();
	List<Plugin> shapeRules= new ArrayList<>();
	List<Plugin> valueRules= new ArrayList<>();
	List<Plugin> policeRules= new ArrayList<>();
	
	
	public Hacker() {
		if(!this.dropins.exists()){
			this.dropins.mkdir();
		}
		finder = new PluginFinder(this.dropins);
		for(File f : finder.getKnownFiles()){
			Plugin p = loadPlugin(f);
			colorRules.add(p);
			shapeRules.add(p);
			valueRules.add(p);
			policeRules.add(p);
		}
		System.out.println(policeRules.size()+""+shapeRules.size()+""+valueRules.size()+""+colorRules.size());
	}
	
	public void initialize(Grid grille){
		this.grille=grille;
		Cell[][] tab = this.grille.getGrid();
		Solution s = this.grille.solution;
		
		for (Plugin plugin : colorRules) {
			plugin.initPlugin(tab, s);
		}
		
		for (Plugin plugin : shapeRules) {
			plugin.initPlugin(tab, s);
		}
		
		for (Plugin plugin : valueRules) {
			plugin.initPlugin(tab, s);
		}
		
		for (Plugin plugin : policeRules) {
			plugin.initPlugin(tab, s);
		}
	}
	
	public void hack(){
		List<Plugin> tmp= new ArrayList<>();
		for (Plugin plugin : colorRules) {
			if(!plugin.isPossibleColor())
				tmp.add(plugin);
		}
		colorRules.removeAll(tmp);
		tmp.clear();
		
		for (Plugin plugin : shapeRules) {
			if(!plugin.isPossibleShape())
				tmp.add(plugin);
		}
		shapeRules.removeAll(tmp);
		tmp.clear();
		
		for (Plugin plugin : valueRules) {
			if(!plugin.isPossibleValue())
				tmp.add(plugin);
		}
		valueRules.removeAll(tmp);
		tmp.clear();
		
		for (Plugin plugin : policeRules) {
			if(!plugin.isPossiblePolice())
				tmp.add(plugin);
		}
		policeRules.removeAll(tmp);
		tmp.clear();
	}
	
	public Plugin loadPlugin(File f){
		Class<?> plugin;
		Plugin instance=null;
		if(f == null || !f.exists())
			return null;
		try {
			String pluginName = f.getName().replaceFirst(".class", "");
			URL[] classLoaderUrls = new URL[]{new URL(f.toURI().toURL().toString())};
			URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);
			plugin = urlClassLoader.loadClass("testRules." + pluginName);
			instance = (Plugin) plugin.newInstance();
			urlClassLoader.close();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return instance;
	}
	
	public void getSolution(){
		System.out.println("shape : "+ shapeRules);
		System.out.println("color : "+ colorRules);
		System.out.println("value : "+ valueRules);
		System.out.println("police : "+ policeRules);
	}
	
	public int countRules(){
		return colorRules.size()*shapeRules.size()*valueRules.size()*policeRules.size();
	}
	
}
