package encrypt.Crypto;


import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;


public class AsymmetricCryptography extends CryptoBase {

    private final String FILE_CRYPT_ALGORITHM = "AES/CFB8/NoPadding";

    private final String ENCODING = "UTF-8";

    public AsymmetricCryptography() throws NoSuchAlgorithmException, NoSuchPaddingException {
    }


    private IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public String Encrypt(PublicKey pubKey, SecretKeySpec aesKeySpec) {

        try {

            final String encodedKey = Base64.encodeBase64String(aesKeySpec.getEncoded());
            final byte[] plainBytes = encodedKey.getBytes(ENCODING);
            final Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            final byte[] encrypted = cipher.doFinal(plainBytes);
            String encryptedString = new String(Base64.encodeBase64(encrypted));

            return encryptedString;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public SecretKeySpec Decrypt(PrivateKey privateKey, String cipherText) {
        SecretKeySpec aesKeySpec = null;
        try {
            final byte[] plainBytes = Base64.decodeBase64(cipherText.getBytes(ENCODING));
            final Cipher cipher = Cipher.getInstance(RSA);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            final byte[] decrypted = cipher.doFinal(plainBytes);
            final String DecryptedString = new String(decrypted, ENCODING);

            byte[] decodedKey = Base64.decodeBase64(DecryptedString);
            aesKeySpec = new SecretKeySpec(decodedKey, 0, decodedKey.length, AES);
            return aesKeySpec;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return aesKeySpec;
    }


    public boolean EncryptFile(final File in, final File out, final SecretKeySpec secretKey) {

        try {
            final Cipher cipher = Cipher.getInstance(FILE_CRYPT_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, generateIv());

            FileInputStream is = new FileInputStream(in);
            CipherOutputStream os = new CipherOutputStream(new FileOutputStream(out), cipher);

            copy(is, os);


            is.close();
            os.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            return false;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return false;
        }

        return true;

    }

    public boolean DecryptFile(final File in, final File out, final SecretKeySpec secretKeySpec) {
        try {
            final Cipher aesCipher = Cipher.getInstance(FILE_CRYPT_ALGORITHM);
            aesCipher.init(Cipher.DECRYPT_MODE, secretKeySpec, generateIv());

            CipherInputStream is = new CipherInputStream(new FileInputStream(in), aesCipher);
            FileOutputStream os = new FileOutputStream(out);

            copy(is, os);

            is.close();
            os.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
            return false;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return false;
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
            return false;
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public SecretKeySpec RetrieveSymmetricKey(PrivateKey privateKey, String encryptedAesKey) {

        return Decrypt(privateKey, encryptedAesKey);
    }

    public String RetrieveEncryptedSymmetricKey(PublicKey publicKey, SecretKeySpec secretKeySpec) {
        return Encrypt(publicKey, secretKeySpec);
    }


    private void copy(InputStream is, OutputStream os) throws IOException {
        int i;
        final byte[] b = new byte[8192];
        while ((i = is.read(b)) != -1) {
            os.write(b, 0, i);
            os.flush();
        }
        os.close();
        is.close();
    }

    public String ENCODING() {
        return ENCODING;
    }
}
