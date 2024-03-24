package lol.koblizek.xdex.io.sections;

import lol.koblizek.xdex.util.ByteUtils;

public record TypeIdSection(int idxDescriptor) implements Section {
    @Override
    public int getSize() {
        return 4;
    }

    @Override
    public byte[] getBytes() {
        return ByteUtils.asBytes(idxDescriptor);
    }
}
