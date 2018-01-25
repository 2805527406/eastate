package com.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Picture {
	 public static void main(String[] args) {
		    // 娴嬭瘯浠嶣ase64缂栫爜杞崲涓哄浘鐗囨枃浠�
		    String strImg = "鑷繁鍐欏搱";
		   // GenerateImage(strImg, "D:\\1.png");
		      
		    // 娴嬭瘯浠庡浘鐗囨枃浠惰浆鎹负Base64缂栫爜
		    System.out.println(GetImageStr("D:\\1.png"));
		  }

	 
	  public static String GetImageStr(String imgFilePath) {// 灏嗗浘鐗囨枃浠惰浆鍖栦负瀛楄妭鏁扮粍瀛楃涓诧紝骞跺鍏惰繘琛孊ase64缂栫爜澶勭悊
	    byte[] data = null;
	      
	    // 璇诲彇鍥剧墖瀛楄妭鏁扮粍
	    try {
	      InputStream in = new FileInputStream(imgFilePath);
	      data = new byte[in.available()];
	      in.read(data);
	      in.close();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	      
	    // 瀵瑰瓧鑺傛暟缁凚ase64缂栫爜
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);// 杩斿洖Base64缂栫爜杩囩殑瀛楄妭鏁扮粍瀛楃涓�
	  }
	  
	  public static boolean GenerateImage(String imgStr, String imgFilePath) {// 瀵瑰瓧鑺傛暟缁勫瓧绗︿覆杩涜Base64瑙ｇ爜骞剁敓鎴愬浘鐗�
	    if (imgStr == null) // 鍥惧儚鏁版嵁涓虹┖
	      return false;
	    BASE64Decoder decoder = new BASE64Decoder();
	    try {
	      // Base64瑙ｇ爜
	      byte[] bytes = decoder.decodeBuffer(imgStr);
	      for (int i = 0; i < bytes.length; ++i) {
	        if (bytes[i] < 0) {// 璋冩暣寮傚父鏁版嵁
	          bytes[i] += 256;
	        }
	      }
	      // 鐢熸垚jpeg鍥剧墖
	      OutputStream out = new FileOutputStream(imgFilePath);
	      out.write(bytes);
	      out.flush();
	      out.close();
	      return true;
	    } catch (Exception e) {
	      return false;
	    }
	  }
}
