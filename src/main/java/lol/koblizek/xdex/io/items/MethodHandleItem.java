package lol.koblizek.xdex.io.items;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public record MethodHandleItem(short methodHandleType, short fieldOrMethodId) implements Item {
    @Override
    public int getSize() {
        return 8;
    }

    @Override
    public byte[] getBytes() {
         return ByteBuffer.allocate(8)
                 .order(ByteOrder.LITTLE_ENDIAN)
                 .putShort(methodHandleType)
                 .putShort(fieldOrMethodId)
                 .array();
    }
}
