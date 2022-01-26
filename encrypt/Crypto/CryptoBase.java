package encrypt.Crypto;

public abstract class CryptoBase {

    protected final String AES = "AES";
    protected final String RSA = "RSA";

    protected final byte[] ivBytes = new byte[]{0x15, 0x14, 0x13, 0x12, 0x11, 0x10, 0x09, 0x08, 0x07, 0x06, 0x05, 0x04, 0x03, 0x02, 0x01, 0x00};

    protected final int AES_KEY_SIZE = 256;
    protected final int RSA_KEY_SIZE = 4096;
}
