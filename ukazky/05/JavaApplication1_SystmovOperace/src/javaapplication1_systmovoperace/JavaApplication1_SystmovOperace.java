/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1_systémovéoperace;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author musil19
 */
public class JavaApplication1_SystémovéOperace {
    
    public static void example_1() {
        System.out.println("" + "PathSeparator as string and as char: " 
                + "'" + File.pathSeparator + "'" + '\t' + "'" + File.pathSeparatorChar + "'");
        System.out.println("" + "Separator as string and as char: " 
                + "'" + File.separator + "'" + '\t' + "'" + File.separatorChar + "'");

        String s_sep = File.pathSeparator;
        char c_sep = File.separatorChar;

        // -----

        File file0 = new File("java");
        if (file0.exists()) {
            file0.delete();
            System.out.println("" + "java " + "deleted.");
        }

        File file1 = new File("a.txt");

        if (file1.exists()) {
            file1.delete();
            System.out.println("" + "Soubor " + file1.getName() + " odstranen.");
        }

        System.out.println("" + "Exists :" + file1.exists());
        try {
            boolean created1 = file1.createNewFile();
            System.out.println("" + "Created: " + created1);
        }
        catch (IOException e) {
            System.out.println("" + e.getMessage());
        }
        System.out.println("" + "Exists :" + file1.exists());        

        System.out.println("" + "Path: " + file1.getPath());
        System.out.println("" + "AbsolutePath: " + file1.getAbsolutePath());
        System.out.println("" + "Name: " + file1.getName());
        System.out.println("" + "Exists :" + file1.exists());
        System.out.println("" + "IsFile: " + file1.isFile());
        System.out.println("" + "IsDirectory: " + file1.isDirectory());
        System.out.println("" + "Parent: " + file1.getAbsoluteFile().getParent());
        System.out.println("" + file1.getAbsoluteFile().getParentFile());


        File file2 = file1.getAbsoluteFile().getParentFile();//file1.getParentFile();

        System.out.println("" + "Path: " + file2.getPath());
        System.out.println("" + "AbsolutePath: " + file2.getAbsolutePath());
        System.out.println("" + "Name: " + file2.getName());
        System.out.println("" + "Exists :" + file2.exists());
        System.out.println("" + "IsFile: " + file2.isFile());
        System.out.println("" + "IsDirectory: " + file2.isDirectory());
        System.out.println("" + "Parent: " + file2.getAbsoluteFile().getParent());
        System.out.println("" + file2.getAbsoluteFile().getParentFile());


        File file3 = file2.getAbsoluteFile().getParentFile();

        System.out.println("" + "Path: " + file3.getPath());
        System.out.println("" + "AbsolutePath: " + file3.getAbsolutePath());
        System.out.println("" + "Name: " + file3.getName());
        System.out.println("" + "Exists :" + file3.exists());
        System.out.println("" + "IsFile: " + file3.isFile());
        System.out.println("" + "IsDirectory: " + file3.isDirectory());
        System.out.println("" + "Parent: " + file3.getAbsoluteFile().getParent());
        System.out.println("" + file3.getAbsoluteFile().getParentFile());


        File file4 = new File(file2, "java");

        boolean created4 = file4.mkdir();
        System.out.println("" + "Created: " + created4);
    }

    public static void example_2() {

        File file = new File("info.txt");

        if (file.exists()) {
            System.out.println("" + "Soubor " + file.getAbsolutePath() + " existuje.");

            System.out.println("" + "CanRead: " + file.canRead());
            System.out.println("" + "CanWrite: " + file.canWrite());
            System.out.println("" + "LastModified: " + new Date(file.lastModified()));
        }        
    }

    public static void example_3() {
        File dir = new File(System.getProperty("user.dir"));

        String[] list_string_file = dir.list();
        File[] list_file_file = dir.listFiles();

        for (String it : list_string_file)
           System.out.println("" + it);

        System.out.println();

        for (File it : list_file_file)
            System.out.println("" + it);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //example_1();
        //example_2();
        example_3();
        
    }
    
}
