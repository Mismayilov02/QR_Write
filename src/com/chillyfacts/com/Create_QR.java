package com.chillyfacts.com;
import java.util.Random;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
public class Create_QR {
    public static void main(String[] args) {
            Random random = new Random();
        String qr = "a";
        int r;
          String lis [] = new String[]{"a" , "s" , "d" , "f" , "g" , "h" , "j" , "k" , "l" , "z" , "x" , "c" , "v" , "b"
          ,"n" , "m" , "q", "w" , "e" , "r" , "t" , "y" , "u" , "i" , "o" , "p" , "1" , "2" , "3", "4" , "5" , "6" , "7"
          , "8" , "9" , "A" , "S" , "D" , "F" , "G" , "H" , "J" , "K" , "L" , "Z" , "X" , "C" , "V", "B", "N" , "M" , "Q"
          , "Q" , "W" , "E" , "R" , "T" , "Y" , "U" , "I" , "O" , "P"};

          for (int i= 0; i<12 ; i++){
              r = random.nextInt(62);
              qr  = qr + lis[r];
          }
           qr = qr.substring(1, qr.length());
        try {
            String qrCodeData = "Amcix";
            String filePath = "C:\\Users\\ismay\\Desktop\\qr.png";
            String charset = "UTF-8"; // or "ISO-8859-1"
            Map < EncodeHintType, ErrorCorrectionLevel > hintMap = new HashMap < EncodeHintType, ErrorCorrectionLevel > ();
            hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            BitMatrix matrix = new MultiFormatWriter().encode(
                    new String(qrCodeData.getBytes(charset), charset),
                    BarcodeFormat.QR_CODE, 500, 500, hintMap);
            MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath
                    .lastIndexOf('.') + 1), new File(filePath));
            System.out.println(qr);
            System.out.println(qr.length());
            System.out.println("QR Code image created successfully!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}