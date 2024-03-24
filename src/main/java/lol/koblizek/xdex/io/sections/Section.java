package lol.koblizek.xdex.io.sections;

public interface Section {
    /**
     * @return the size of the section in bytes
     */
    int getSize();
    byte[] getBytes();
}
