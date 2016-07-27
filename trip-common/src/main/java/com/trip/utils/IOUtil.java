package com.trip.utils;

import org.apache.commons.io.IOUtils;

import java.io.*;

/**
 * 流相关的操作方法
 */
public class IOUtil {

    public static String toString(InputStream in) throws IOException {
        return IOUtils.toString(in);
    }

    public static String toString(InputStream in, String encoding) throws IOException {
        return IOUtils.toString(in, encoding);
    }

    public static byte[] toByte(InputStream in) throws IOException {
        return IOUtils.toByteArray(in);
    }

    public static void close(Closeable closeable) {
        IOUtils.closeQuietly(closeable);
    }

    public static void saveAsFile(InputStream in, File target) throws IOException {
        IOUtils.copy(in, new FileOutputStream(target));
    }

}