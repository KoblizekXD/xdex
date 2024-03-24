package lol.koblizek.xdex.io.items;

public interface Item {
    /**
     * @return the size of the item in bytes
     */
    int getSize();
    byte[] getBytes();
}
