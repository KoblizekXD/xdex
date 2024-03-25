package lol.koblizek.xdex.io.items;

import lol.koblizek.xdex.util.ByteUtils;

public record ClassDefItem(
        int classIdx,
        int accessFlags,
        int superclassIdx,
        int interfacesOff,
        int sourceFileIdx,
        int annotationsOff,
        int classDataOff,
        int staticValuesOff
) implements Item {
    @Override
    public int getSize() {
        return 8 * 4;
    }

    @Override
    public byte[] getBytes() {
        return ByteUtils.asBytes(classIdx, accessFlags, superclassIdx, interfacesOff, sourceFileIdx, annotationsOff, classDataOff, staticValuesOff);
    }
}
