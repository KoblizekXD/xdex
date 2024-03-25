package lol.koblizek.xdex.io.items;

import lol.koblizek.xdex.util.ByteUtils;

public record CallSiteIdItem(int callSiteOff) implements Item {
    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public byte[] getBytes() {
        return ByteUtils.asBytes(callSiteOff);
    }
}
