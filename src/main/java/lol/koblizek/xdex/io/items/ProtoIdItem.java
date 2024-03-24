package lol.koblizek.xdex.io.items;

import lol.koblizek.xdex.util.ByteUtils;

public record ProtoIdItem(int shortyIdx, int returnTypeIdx, int paramsOff) implements Item {
    @Override
    public int getSize() {
        return 12;
    }

    @Override
    public byte[] getBytes() {
        return ByteUtils.asBytes(shortyIdx, returnTypeIdx, paramsOff);
    }
}
