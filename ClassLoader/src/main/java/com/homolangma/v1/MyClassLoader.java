package com.homolangma.v1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author: Mr.Harry
 * @date : 2020/5/24 16:42
 * @title :
 */
public class MyClassLoader extends ClassLoader {

    private final static String DEFAULT_DIR = "E:\\idea\\project\\DesignPatterns\\ClassLoader\\target";

    private String dir = DEFAULT_DIR;
    private String classLoaderName;

    public MyClassLoader() {
        super();
    }

    /**
     * @param name xxx.xxx.xxx.AAA
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        File classFile = new File(dir, classPath + ".class");
        if (!classFile.exists()) {
            throw new ClassNotFoundException("文件不存在");
        }
        byte[] classBytes = loadClassBytes(classFile);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("空");
        }
        return this.defineClass(name, classBytes, 0, classBytes.length);

    }

    private byte[] loadClassBytes(File classFile) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            FileInputStream fileInputStream = new FileInputStream(classFile);
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(buffer)) != -1) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public MyClassLoader(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }

    public MyClassLoader(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public static String getDefaultDir() {
        return DEFAULT_DIR;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getClassLoaderName() {
        return classLoaderName;
    }

    public void setClassLoaderName(String classLoaderName) {
        this.classLoaderName = classLoaderName;
    }
}
