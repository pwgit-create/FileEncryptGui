package encrypt.Crypto;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class AppKeyGenerator extends CryptoBase {


    public AppKeyGenerator() {
    }

    public SecretKeySpec GenerateSecretKeySpec() throws NoSuchAlgorithmException {

        final KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(aesKeySize);
        SecretKey key = keyGenerator.generateKey();

        final byte[] aesKey = key.getEncoded();
        SecretKeySpec aesKeySpec = new SecretKeySpec(aesKey, AES);

        return aesKeySpec;
    }

    public KeyPair generateNewKeyPair() throws NoSuchAlgorithmException {


        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA);

        keyPairGen.initialize(rsaKeySize);


        return keyPairGen.generateKeyPair();

    }
}
