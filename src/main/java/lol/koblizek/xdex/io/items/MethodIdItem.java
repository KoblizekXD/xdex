package lol.koblizek.xdex.io.items;

import java.nio.ByteBuffer;

public record MethodIdItem(short classIdx, short protoIdx, int nameIdx) implements Item {
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
