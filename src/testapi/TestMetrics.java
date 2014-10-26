package testapi;

import java.util.Collection;
import java.util.Iterator;

import jdepend.framework.JavaPackage;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import jdepend.framework.JDepend;


public class TestMetrics {
	
	public static void main(String[] args) throws IOException {
		
		 PrintStream ps = new PrintStream(new File("metrics.txt"));
		 JDepend jdepend = new JDepend();
		 jdepend.addDirectory("C://Users//Owner//Documents//WebApp//TestMetric");
		 Collection<JavaPackage> packages = jdepend.analyze();
		 
		 Iterator<JavaPackage> i = packages.iterator();
		 while (i.hasNext()) {
		     JavaPackage jPackage = i.next();
		     String name = jPackage.getName();
		     double I = jPackage.instability();
		     ps.printf("package name:   %s\n", name);
		     ps.printf("package instability: %f\n", I);
		     Collection<JavaPackage> c = jPackage.getEfferents();
		     for (JavaPackage jp: c) {
		    	 ps.printf("dependencies: %s%n", jp.getName());
		     }
		 }
		 
	     //System.out.println(jdepend.countPackages());
		 
	     ClassInfo ci = new ClassInfo(ps);
	     String[] arg = {"C://Users//Owner//Documents//WebApp//TestMetric"};
	     ci.execute(arg);
	}
	
}
