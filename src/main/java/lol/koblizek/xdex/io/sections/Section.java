package lol.koblizek.xdex.io.sections;

import lol.koblizek.xdex.io.DexOutputStream;

import java.nio.ByteBuffer;

public interface Section {
    /**
     * @return the size of the section in bytes
     */
    int getSize();
    byte[] getBytes();

    default int getAdler32Checksum() {
        return DexOutputStream.adler32(getBytes());
    }
}
