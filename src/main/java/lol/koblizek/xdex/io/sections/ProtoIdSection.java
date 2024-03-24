package lol.koblizek.xdex.io.sections;

import lol.koblizek.xdex.util.ByteUtils;

public record ProtoIdSection(int shortyIdx, int returnTypeIdx, int paramsOff) implements Section {
    @Override
    public int getSize() {
        return 12;
    }

    @Override
    public byte[] getBytes() {
        return ByteUtils.asBytes(shortyIdx, returnTypeIdx, paramsOff);
    }
}
