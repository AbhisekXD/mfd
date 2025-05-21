package com.cyfrifpro.util;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Random;

public class NSEEncryptionUtil {

    public static String generateEncryptedPassword(String apiSecret, String licenseKey) throws Exception {
        // Generate random IV and salt with correct length (32 hex characters => 16 bytes)
        String salt = generateRandomHex(32);
        String iv = generateRandomHex(32);
        String plainText = apiSecret + "|" + generateRandomNumber();

        // Encrypt the plain text using AES-128
        IvParameterSpec ivParameterSpec = new IvParameterSpec(hexToBytes(iv));
        SecretKeySpec secretKeySpec = new SecretKeySpec(hexToBytes(licenseKey), "AES");

        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);

        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes("UTF-8"));
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);

        // Construct encrypted password
        String encryptedPassword = Base64.getEncoder().encodeToString((iv + "::" + salt + "::" + encryptedText).getBytes("UTF-8"));
        return encryptedPassword;
    }

    private static String generateRandomHex(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(Integer.toHexString(random.nextInt(16)));
        }
        return sb.toString();
    }

    private static String generateRandomNumber() {
        return String.valueOf(new Random().nextInt(1000000));
    }

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
