/*
 * Copyright (C) 2012 A3like zaze8736@163.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.handy.base.utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * <pre>
 *  author: Handy
 *  blog  : https://github.com/liujie045
 *  time  : 2017-4-18 10:14:23
 *  desc  : AES加密解密工具类
 * </pre>
 */
public final class AesUtils {

    private static final byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 0};
    private static String DEFAULT_KEY = "HANDY_SECRET_KEY";

    private AesUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static String getDEFAULT_KEY() {
        return DEFAULT_KEY;
    }

    public static void setDEFAULT_KEY(String default_key) {
        if (EmptyUtils.isEmpty(default_key)) {
            LogUtils.d("密钥为空");
        } else if (default_key.length() != 16) {
            LogUtils.d("密钥长度必须为16位");
        } else {
            DEFAULT_KEY = default_key;
        }
    }

    /**
     * AES 加密
     *
     * @param src 明文
     * @return 密文
     */
    public static String encrypt(String src) {
        try {
            return encrypt(DEFAULT_KEY, src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String encrypt(String key, String src) {
        try {
            byte[] keyByte = key.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
            //“算法/模式/补码方式”。
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            //使用CBC模式，需要一个向量iv，可增加加密算法的强度。
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            //加密。
            byte[] srcByte = src.getBytes();
            byte[] encrypted = cipher.doFinal(srcByte);
            //Base64转码。
            return Base64Utils.encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * AES 解密
     *
     * @param src 密文
     * @return 明文
     */
    public static String decrypt(String src) {
        try {
            return decrypt(DEFAULT_KEY, src);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String decrypt(String key, String src) {
        try {
            byte[] keyByte = key.getBytes();
            SecretKeySpec keySpec = new SecretKeySpec(keyByte, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            //Base64转码。
            byte[] srcByte = Base64Utils.decode(src);
            //解密。
            byte[] decrypted = cipher.doFinal(srcByte);
            return new String(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
