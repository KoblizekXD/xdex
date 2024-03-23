package lol.koblizek.xdex.io;

import lol.koblizek.xdex.util.Constants;

import java.io.DataOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.Adler32;

public class DexOutputStream extends DataOutputStream {
    /**
     * Creates a new data output stream to write data to the specified
     * underlying output stream. The counter {@code written} is
     * set to zero.
     *
     * @param out the underlying output stream, to be saved for later
     *            use.
     * @see FilterOutputStream#out
     */
    public DexOutputStream(OutputStream out) {
        super(out);
    }

    public void writeUleb128(int value) {
        do {
            int part = value & 0x7F;
            value >>>= 7;
            if (value != 0) {
                part |= 0x80;
            }
            try {
                writeByte(part);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } while (value != 0);
    }

    public void writeHeader() {
        try {
            writeBytes(new String(Constants.DEX_FILE_MAGIC));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int adler32(byte[] data) {
        Adler32 adler32 = new Adler32();
        adler32.update(data);
        return (int) adler32.getValue();
    }
}
