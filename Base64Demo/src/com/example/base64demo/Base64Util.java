package com.example.base64demo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import android.util.Base64;

public class Base64Util {
//	private static final char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
//			'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
//			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0',
//			'1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
//
//	private static byte[] base64DecodeChars = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
//			-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
//			-1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4,
//			5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26,
//			27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1,
//			-1, -1, -1 };
//
//	/**
//	 * 将字节数组编码为字符串
//	 * 
//	 * @param data
//	 */
//	public static String encode(byte[] data) {
//		StringBuffer sb = new StringBuffer();
//		int len = data.length;
//		int i = 0;
//		int b1, b2, b3;
//
//		while (i < len) {
//			b1 = data[i++] & 0xff;
//			if (i == len) {
//				sb.append(base64EncodeChars[b1 >>> 2]);
//				sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
//				sb.append("==");
//				break;
//			}
//			b2 = data[i++] & 0xff;
//			if (i == len) {
//				sb.append(base64EncodeChars[b1 >>> 2]);
//				sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
//				sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
//				sb.append("=");
//				break;
//			}
//			b3 = data[i++] & 0xff;
//			sb.append(base64EncodeChars[b1 >>> 2]);
//			sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
//			sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
//			sb.append(base64EncodeChars[b3 & 0x3f]);
//		}
//		return sb.toString();
//	}
//
//	/**
//	 * 将base64字符串解码为字节数组
//	 * 
//	 * @param str
//	 */
//	public static byte[] decode(String str) {
//		byte[] data = str.getBytes();
//		int len = data.length;
//		ByteArrayOutputStream buf = new ByteArrayOutputStream(len);
//		int i = 0;
//		int b1, b2, b3, b4;
//
//		while (i < len) {
//
//			/* b1 */
//			do {
//				b1 = base64DecodeChars[data[i++]];
//			} while (i < len && b1 == -1);
//			if (b1 == -1) {
//				break;
//			}
//
//			/* b2 */
//			do {
//				b2 = base64DecodeChars[data[i++]];
//			} while (i < len && b2 == -1);
//			if (b2 == -1) {
//				break;
//			}
//			buf.write((int) ((b1 << 2) | ((b2 & 0x30) >>> 4)));
//
//			/* b3 */
//			do {
//				b3 = data[i++];
//				if (b3 == 61) {
//					return buf.toByteArray();
//				}
//				b3 = base64DecodeChars[b3];
//			} while (i < len && b3 == -1);
//			if (b3 == -1) {
//				break;
//			}
//			buf.write((int) (((b2 & 0x0f) << 4) | ((b3 & 0x3c) >>> 2)));
//
//			/* b4 */
//			do {
//				b4 = data[i++];
//				if (b4 == 61) {
//					return buf.toByteArray();
//				}
//				b4 = base64DecodeChars[b4];
//			} while (i < len && b4 == -1);
//			if (b4 == -1) {
//				break;
//			}
//			buf.write((int) (((b3 & 0x03) << 6) | b4));
//		}
//		return buf.toByteArray();
//	}

	
private static final int CACHE_SIZE = 1024;
    
    /**
     * <p>
     * BASE64字符串解码为二进制数据
     * </p>
     * 
     * @param base64
     * @return
     * @throws Exception
     */
    public static byte[] decode(String base64) throws Exception {
        return Base64.decode(base64.getBytes(), Base64.DEFAULT);
    }
    
    /**
     * <p>
     * 二进制数据编码为BASE64字符串
     * </p>
     * 
     * @param bytes
     * @return
     * @throws Exception
     */
    public static String encode(byte[] bytes) throws Exception {
        return new String(Base64.encode(bytes,Base64.DEFAULT));
    }
    
    /**
     * <p>
     * 将文件编码为BASE64字符串
     * </p>
     * <p>
     * 大文件慎用，可能会导致内存溢出
     * </p>
     * 
     * @param filePath 文件绝对路径
     * @return
     * @throws Exception
     */
    public static String encodeFile(String filePath) throws Exception {
        byte[] bytes = fileToByte(filePath);
        return encode(bytes);
    }
    
    /**
     * <p>
     * BASE64字符串转回文件
     * </p>
     * 
     * @param filePath 文件绝对路径
     * @param base64 编码字符串
     * @throws Exception
     */
    public static void decodeToFile(String filePath, String base64) throws Exception {
        byte[] bytes = decode(base64);
        byteArrayToFile(bytes, filePath);
    }
    
    /**
     * <p>
     * 文件转换为二进制数组
     * </p>
     * 
     * @param filePath 文件路径
     * @return
     * @throws Exception
     */
    public static byte[] fileToByte(String filePath) throws Exception {
        byte[] data = new byte[0];
        File file = new File(filePath);
        if (file.exists()) {
            FileInputStream in = new FileInputStream(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream(2048);
            byte[] cache = new byte[CACHE_SIZE];
            int nRead = 0;
            while ((nRead = in.read(cache)) != -1) {
                out.write(cache, 0, nRead);
                out.flush();
            }
            out.close();
            in.close();
            data = out.toByteArray();
         }
        return data;
    }
    
    /**
     * <p>
     * 二进制数据写文件
     * </p>
     * 
     * @param bytes 二进制数据
     * @param filePath 文件生成目录
     */
    public static void byteArrayToFile(byte[] bytes, String filePath) throws Exception {
        InputStream in = new ByteArrayInputStream(bytes);   
        File destFile = new File(filePath);
        if (!destFile.getParentFile().exists()) {
            destFile.getParentFile().mkdirs();
        }
        destFile.createNewFile();
        OutputStream out = new FileOutputStream(destFile);
        byte[] cache = new byte[CACHE_SIZE];
        int nRead = 0;
        while ((nRead = in.read(cache)) != -1) {   
            out.write(cache, 0, nRead);
            out.flush();
        }
        out.close();
        in.close();
    }
}