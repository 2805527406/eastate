package com.util;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.*;

/**
 * Created by cgy on 2016/12/21.
 */
public class Base {
    /**
     * @param imgStr base64缂栫爜瀛楃涓�
     * @param path   鍥剧墖璺緞-鍏蜂綋鍒版枃浠�
     * @return
     * @Description: 灏哹ase64缂栫爜瀛楃涓茶浆鎹负鍥剧墖
     * @Author:
     * @CreateTime:
     */
    public static boolean generateImage(String imgStr, String path) {
        if(imgStr == null){
            return false;
        }
        BASE64Decoder decoder = new BASE64Decoder();
        try{
            //瑙ｅ瘑
            byte[] b = decoder.decodeBuffer(imgStr);
            //澶勭悊鏁版嵁
            for (int i = 0;i<b.length;++i){
                if(b[i]<0){
                    b[i]+=256;
                }
            }
            OutputStream out = new FileOutputStream(path);
            out.write(b);
            out.flush();
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * @Description: 鏍规嵁鍥剧墖鍦板潃杞崲涓篵ase64缂栫爜瀛楃涓�
     * @Author:
     * @CreateTime:
     * @return
     */
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 鍔犲瘑
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
   
}