/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class AESCrypto {
  public static void main(String[] args) throws Exception {
//    String key = "E1BB465D57CAE7ACDBBE8091F9CE83DF";
 //     System.out.println(key.length());
//  	String plaintext = "<xml><tpPago>C</tpPago><amount>3441.16</amount><urlResponse>www.catwebuat.com.mx/corpora/auto/resultadoMIT.asp?webpay=1</urlResponse><referencia>645331840000</referencia><moneda>MXN</moneda><date_hour> 2013-07-10T14:49:24-05:00<date_hour>";
//  	String crp = encrypt(plaintext, key);
//  	String dec = decrypt(crp, key);
  	
  String key =getRandomHexString(32);    // "605bd70efed2c6374823b54bbc560b58";
     System.out.println(key.length());
  	String plaintext = "5454545454545454";
  	String crp = encrypt(plaintext, key);
  	String dec = decrypt(crp, key);
  	System.out.println("Encrypt:" + crp );
  	System.out.println("Decrypt:" + dec);
  }
  
  private static final String ALGORITMO = "AES/CBC/PKCS5Padding";
private static final String CODIFICACION = "UTF-8";

 public static String getRandomHexString(int numchars){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0, numchars);
    }

public static String encrypt(String plaintext, String key)throws NoSuchAlgorithmException, NoSuchPaddingException,InvalidKeyException, IllegalBlockSizeException,BadPaddingException, IOException{
	byte[] raw = DatatypeConverter.parseHexBinary(key);
	SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
	Cipher cipher = Cipher.getInstance(ALGORITMO);
	cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
	byte[] cipherText = cipher.doFinal(plaintext.getBytes(CODIFICACION));
	byte[] iv = cipher.getIV();
	ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	outputStream.write(iv);
	outputStream.write(cipherText);
	byte[] finalData = outputStream.toByteArray();
	String encodedFinalData = DatatypeConverter.printBase64Binary(finalData);
	return encodedFinalData;
}

public static String decrypt(String encodedInitialData, String key)throws InvalidKeyException, IllegalBlockSizeException,BadPaddingException, UnsupportedEncodingException,NoSuchAlgorithmException, NoSuchPaddingException,InvalidAlgorithmParameterException{
	byte[] encryptedData = DatatypeConverter.parseBase64Binary(encodedInitialData);
	byte[] raw = DatatypeConverter.parseHexBinary(key);
	SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
	Cipher cipher = Cipher.getInstance(ALGORITMO);
	byte[] iv = Arrays.copyOfRange(encryptedData, 0, 16);
	byte[] cipherText = Arrays.copyOfRange(encryptedData, 16, encryptedData.length);
	IvParameterSpec iv_specs = new IvParameterSpec(iv);
	cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv_specs);
	byte[] plainTextBytes = cipher.doFinal(cipherText);
	String plainText = new String(plainTextBytes);
	return plainText;
	}
}
 


