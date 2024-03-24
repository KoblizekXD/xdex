package lol.koblizek.xdex.io.sections;

import java.nio.ByteBuffer;

public record FieldIdSection(short classIdx, short typeIdx, int nameIdx) implements Section {
    @Override
    public int getSize() {
        return 8;
    }

    @Override
    public byte[] getBytes() {
        return ByteBuffer.allocate(8)
            .putShort(classIdx)
            .putShort(typeIdx)
            .putInt(nameIdx)
            .array();
    }
}
