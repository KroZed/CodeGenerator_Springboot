package com.prj.util;
import com.prj.common.FileHelper;
import org.apache.commons.codec.binary.Base64;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
public class Base64Util {
    private static final char[] intToBase64 = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/' };
    private static final char[] intToAltBase64 = { '!', '"', '#', '$', '%', '&', '\'', '(', ')', ',', '-', '.', ':',
            ';', '<', '>', '@', '[', ']', '^', '`', '_', '{', '|', '}', '~', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2',
            '3', '4', '5', '6', '7', '8', '9', '+', '?' };
    private static final byte[] base64ToInt = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1,
            -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8,
            9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29,
            30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51 };
    private static final byte[] altBase64ToInt = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, -1, 62, 9, 10,
            11, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 12, 13, 14, -1, 15, 63, 16, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 17, -1, 18, 19, 21, 20, 26, 27, 28,
            29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 22, 23, 24,
            25 };
    public static String getBASE64(String s) throws UnsupportedEncodingException {
        if (s == null){return null;}
        return Base64.encodeBase64String(s.getBytes("UTF-8"));
    }
    public static String getBASE64ByCodec(String s) {
        Base64 b64 = new Base64();
        return b64.encodeToString(s.getBytes());
    }
    public static String getBASE64ByByte(byte[] by) {
        Base64 b64 = new Base64();
        return b64.encodeToString(by);
    }
    public static byte[] getFromBASE64(String s) {
        if (s == null) {return null;}
        return Base64.decodeBase64(s);
    }
    public static String getFromBASE64Str(String s) throws IOException {
        return new String(Base64.encodeBase64String(s.getBytes("utf-8")));
    }
    public static String getImageStr(String imgFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Base64.encodeBase64String(data);
    }
    public static String generateImage(String imgStr, String fileName, String filePath) { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) {
            return null;
        }
        try {
            byte[] b = Base64.decodeBase64(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {// 调整异常数据
                    b[i] += 256;
                }
            }
            String imgFilePath = filePath + fileName + ".jpg";// 新生成的图片
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            return imgFilePath;
        } catch (Exception e) {
            return null;
        }
    }
    public static String getImageStrByCodec(String imgFile) throws IOException {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        Base64 b64 = new Base64();
        File file = new File(imgFile);
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[(int) file.length()];
        fis.read(buffer);
        fis.close();
        return b64.encodeToString(buffer);
    }
    public static String generateImageByCodec(String imgStr, String dir, String fileName) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
        Base64 b64 = new Base64();
        byte[] buffer = b64.decode(imgStr);
        String imgFilePath = FileHelper.getPath("static" + dir) + fileName;// 新生成的图片
        OutputStream out = new FileOutputStream(imgFilePath);
        out.write(buffer);
        out.flush();
        out.close();
        resizeImage(imgFilePath, 300, 300);
        return imgFilePath;
    }
    public static void generateImageByCodec2(String imgStr, String file) throws IOException { // 对字节数组字符串进行Base64解码并生成图片
        Base64 b64 = new Base64();
        byte[] buffer = b64.decode(imgStr);
        OutputStream out = new FileOutputStream(file);
        out.write(buffer);
        out.flush();
        out.close();
        return;
    }
    public static void resizeImage(String srcImgPath, int width, int height) throws IOException {
        String subfix = "jpg";
        subfix = srcImgPath.substring(srcImgPath.lastIndexOf(".") + 1, srcImgPath.length());
        File srcFile = new File(srcImgPath);
        Image srcImg = ImageIO.read(srcFile);
        BufferedImage buffImg = null;
        if (subfix.equals("png")) {
            buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        } else {
            buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        }
        Graphics2D graphics = buffImg.createGraphics();
        graphics.setBackground(Color.WHITE);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, width, height);
        graphics.drawImage(srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH), 0, 0, null);
        ImageIO.write(buffImg, subfix, new File(srcImgPath));
    }
    public static String ioToBase64(InputStream in) throws IOException {
        String strBase64 = null;
        try {
            byte[] bytes = new byte[in.available()];
            in.read(bytes);
            strBase64 = Base64.encodeBase64String(bytes);
            in.close();
        } catch (FileNotFoundException fe) {
            fe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return strBase64;
    }
    static String getPDFBinary(InputStream fin) {
        BufferedInputStream bin = null;
        ByteArrayOutputStream baos = null;
        BufferedOutputStream bout = null;
        try {
            bin = new BufferedInputStream(fin);
            baos = new ByteArrayOutputStream();
            bout = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024];
            int len = bin.read(buffer);
            while (len != -1) {
                bout.write(buffer, 0, len);
                len = bin.read(buffer);
            }
            bout.flush();
            byte[] bytes = baos.toByteArray();
            return Base64.encodeBase64String(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fin.close();
                bin.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    static void base64StringToPDF(String base64sString) {
        BufferedInputStream bin = null;
        FileOutputStream fout = null;
        BufferedOutputStream bout = null;
        try {
            byte[] bytes = Base64.decodeBase64(base64sString);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            bin = new BufferedInputStream(bais);
            File file = new File("E://test.pdf");
            fout = new FileOutputStream(file);
            bout = new BufferedOutputStream(fout);
            byte[] buffers = new byte[1024];
            int len = bin.read(buffers);
            while (len != -1) {
                bout.write(buffers, 0, len);
                len = bin.read(buffers);
            }
            bout.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bin.close();
                fout.close();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static String byteArrayToBase64(byte[] a) {
        return byteArrayToBase64(a, false);
    }
    public static String byteArrayToAltBase64(byte[] a) {
        return byteArrayToBase64(a, true);
    }
    private static String byteArrayToBase64(byte[] a, boolean alternate) {
        int aLen = a.length;
        int numFullGroups = aLen / 3;
        int numBytesInPartialGroup = aLen - 3 * numFullGroups;
        int resultLen = 4 * ((aLen + 2) / 3);
        StringBuffer result = new StringBuffer(resultLen);
        char[] intToAlpha = alternate ? intToAltBase64 : intToBase64;
        int inCursor = 0;
        for (int i = 0; i < numFullGroups; i++) {
            int byte0 = a[(inCursor++)] & 0xFF;
            int byte1 = a[(inCursor++)] & 0xFF;
            int byte2 = a[(inCursor++)] & 0xFF;
            result.append(intToAlpha[(byte0 >> 2)]);
            result.append(intToAlpha[(byte0 << 4 & 0x3F | byte1 >> 4)]);
            result.append(intToAlpha[(byte1 << 2 & 0x3F | byte2 >> 6)]);
            result.append(intToAlpha[(byte2 & 0x3F)]);
        }
        if (numBytesInPartialGroup != 0) {
            int byte0 = a[(inCursor++)] & 0xFF;
            result.append(intToAlpha[(byte0 >> 2)]);
            if (numBytesInPartialGroup == 1) {
                result.append(intToAlpha[(byte0 << 4 & 0x3F)]);
                result.append("==");
            }
            else {
                int byte1 = a[(inCursor++)] & 0xFF;
                result.append(intToAlpha[(byte0 << 4 & 0x3F | byte1 >> 4)]);
                result.append(intToAlpha[(byte1 << 2 & 0x3F)]);
                result.append('=');
            }
        }
        return result.toString();
    }
    public static byte[] base64ToByteArray(String s) {
        return base64ToByteArray(s, false);
    }
    public static byte[] altBase64ToByteArray(String s) {
        return base64ToByteArray(s, true);
    }
    private static byte[] base64ToByteArray(String s, boolean alternate) {
        byte[] alphaToInt = alternate ? altBase64ToInt : base64ToInt;
        int sLen = s.length();
        int numGroups = sLen / 4;
        if (4 * numGroups != sLen) {
            throw new IllegalArgumentException("String length must be a multiple of four.");
        }
        int missingBytesInLastGroup = 0;
        int numFullGroups = numGroups;
        if (sLen != 0) {
            if (s.charAt(sLen - 1) == '=') {
                missingBytesInLastGroup++;
                numFullGroups--;
            }
            if (s.charAt(sLen - 2) == '=') {
                missingBytesInLastGroup++;
            }
        }
        byte[] result = new byte[3 * numGroups - missingBytesInLastGroup];
        int inCursor = 0; int outCursor = 0;
        for (int i = 0; i < numFullGroups; i++) {
            int ch0 = base64toInt(s.charAt(inCursor++), alphaToInt);
            int ch1 = base64toInt(s.charAt(inCursor++), alphaToInt);
            int ch2 = base64toInt(s.charAt(inCursor++), alphaToInt);
            int ch3 = base64toInt(s.charAt(inCursor++), alphaToInt);
            result[(outCursor++)] = (byte)(ch0 << 2 | ch1 >> 4);
            result[(outCursor++)] = (byte)(ch1 << 4 | ch2 >> 2);
            result[(outCursor++)] = (byte)(ch2 << 6 | ch3);
        }
        if (missingBytesInLastGroup != 0) {
            int ch0 = base64toInt(s.charAt(inCursor++), alphaToInt);
            int ch1 = base64toInt(s.charAt(inCursor++), alphaToInt);
            result[(outCursor++)] = (byte)(ch0 << 2 | ch1 >> 4);
            if (missingBytesInLastGroup == 1) {
                int ch2 = base64toInt(s.charAt(inCursor++), alphaToInt);
                result[(outCursor++)] = (byte)(ch1 << 4 | ch2 >> 2);
            }
        }
        return result;
    }
    private static int base64toInt(char c, byte[] alphaToInt){
        int result = alphaToInt[c];
        if (result < 0) {
            throw new IllegalArgumentException("Illegal character " + c);
        }
        return result;
    }
}
