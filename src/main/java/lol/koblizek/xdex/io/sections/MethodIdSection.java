package lol.koblizek.xdex.io.sections;

import java.nio.ByteBuffer;

public record MethodIdSection(short classIdx, short protoIdx, int nameIdx) implements Section {
    @Override
    public int getSize() {
        return 8;
    }

    @Override
    public byte[] getBytes() {
        return ByteBuffer.allocate(8)
                .putShort(classIdx)
                .putShort(protoIdx)
                .putInt(nameIdx)
                .array();
    }
}
