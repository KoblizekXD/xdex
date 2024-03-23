package lol.koblizek.xdex.io.sections;

import lol.koblizek.xdex.util.ByteUtils;

public interface Section {
    /**
     * @return the size of the section in bytes
     */
    int getSize();
    byte[] getBytes();

    default int getAdler32Checksum() {
        return ByteUtils.adler32(getBytes());
    }
}
