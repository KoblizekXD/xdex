package lol.koblizek.xdex.io.sections;

import lol.koblizek.xdex.io.DexOutputStream;
import lol.koblizek.xdex.util.ByteUtils;
import lol.koblizek.xdex.util.Constants;

import java.nio.ByteBuffer;
import java.util.Arrays;

// I want to die just form this record tbh
public record HeaderSection(int fileSize, int linkSize, int linkOff, int mapOff, int stringIdsSize, int stringIdsOff,
                            int typeIdsSize, int typeIdsOff, int protoIdsSize, int protoIdsOff, int fieldIdsSize,
                            int fieldIdsOff, int methodIdsSize, int methodIdsOff, int classDefsSize, int classDefsOff,
                            int dataSize, int dataOff) implements Section {

    /**
     * Returns the size of the section in bytes
     * according to <a href="https://source.android.com/docs/core/runtime/dex-format#header-item">Header format</a>
     *
     * @return the size of the section in bytes
     */
    @Override
    public int getSize() {
        return 0x70;
    }

    /**
     * This method returns the bytes of this section which can be constantly retrieved.
     *
     * @apiNote It won't return Magic, Checksum or Signature bytes, for that, use {@link #getBytes(Section...)} instead.
     * @return the bytes of this section
     */
    @Override
    public byte[] getBytes() {
        // Too lazy to count the size
        ByteBuffer buffer = ByteBuffer.allocate(getSize());
        buffer.putInt(fileSize);
        buffer.putInt(0x70);
        buffer.putInt(Constants.ENDIAN_CONSTANT);
        buffer.putInt(linkSize);
        buffer.putInt(linkOff);
        buffer.putInt(mapOff);
        buffer.putInt(stringIdsSize);
        buffer.putInt(stringIdsOff);
        buffer.putInt(typeIdsSize);
        buffer.putInt(typeIdsOff);
        buffer.putInt(protoIdsSize);
        buffer.putInt(protoIdsOff);
        buffer.putInt(fieldIdsSize);
        buffer.putInt(fieldIdsOff);
        buffer.putInt(methodIdsSize);
        buffer.putInt(methodIdsOff);
        buffer.putInt(classDefsSize);
        buffer.putInt(classDefsOff);
        buffer.putInt(dataSize);
        buffer.putInt(dataOff);
        buffer.compact();
        return buffer.array();
    }

    // This better be working...
    public byte[] getBytes(Section... sections) {
        byte[] hashed = ByteUtils.hashBytes(ByteUtils.concat(getBytes(), Arrays.stream(sections).map(Section::getBytes).toArray(byte[][]::new)));
        int checksum = DexOutputStream.adler32(ByteUtils.concat(ByteUtils.concat(ByteUtils.concat(hashed, getBytes())), ByteUtils.concat(Arrays.stream(sections).map(Section::getBytes))));
        return ByteBuffer.allocate(0x70)
                .putInt(checksum)
                .put(hashed)
                .put(getBytes())
                .array();
    }

    public static final class Builder {
        private int fileSize;
        private int linkSize;
        private int linkOff;
        private int mapOff;
        private int stringIdsSize;
        private int stringIdsOff;
        private int typeIdsSize;
        private int typeIdsOff;
        private int protoIdsSize;
        private int protoIdsOff;
        private int fieldIdsSize;
        private int fieldIdsOff;
        private int methodIdsSize;
        private int methodIdsOff;
        private int classDefsSize;
        private int classDefsOff;
        private int dataSize;
        private int dataOff;

        private Builder() {
        }

        public static Builder aHeaderSection() {
            return new Builder();
        }

        public Builder fileSize(int fileSize) {
            this.fileSize = fileSize;
            return this;
        }

        public Builder linkSize(int linkSize) {
            this.linkSize = linkSize;
            return this;
        }

        public Builder linkOff(int linkOff) {
            this.linkOff = linkOff;
            return this;
        }

        public Builder mapOff(int mapOff) {
            this.mapOff = mapOff;
            return this;
        }

        public Builder stringIdsSize(int stringIdsSize) {
            this.stringIdsSize = stringIdsSize;
            return this;
        }

        public Builder stringIdsOff(int stringIdsOff) {
            this.stringIdsOff = stringIdsOff;
            return this;
        }

        public Builder typeIdsSize(int typeIdsSize) {
            this.typeIdsSize = typeIdsSize;
            return this;
        }

        public Builder typeIdsOff(int typeIdsOff) {
            this.typeIdsOff = typeIdsOff;
            return this;
        }

        public Builder protoIdsSize(int protoIdsSize) {
            this.protoIdsSize = protoIdsSize;
            return this;
        }

        public Builder protoIdsOff(int protoIdsOff) {
            this.protoIdsOff = protoIdsOff;
            return this;
        }

        public Builder fieldIdsSize(int fieldIdsSize) {
            this.fieldIdsSize = fieldIdsSize;
            return this;
        }

        public Builder fieldIdsOff(int fieldIdsOff) {
            this.fieldIdsOff = fieldIdsOff;
            return this;
        }

        public Builder methodIdsSize(int methodIdsSize) {
            this.methodIdsSize = methodIdsSize;
            return this;
        }

        public Builder methodIdsOff(int methodIdsOff) {
            this.methodIdsOff = methodIdsOff;
            return this;
        }

        public Builder classDefsSize(int classDefsSize) {
            this.classDefsSize = classDefsSize;
            return this;
        }

        public Builder classDefsOff(int classDefsOff) {
            this.classDefsOff = classDefsOff;
            return this;
        }

        public Builder dataSize(int dataSize) {
            this.dataSize = dataSize;
            return this;
        }

        public Builder dataOff(int dataOff) {
            this.dataOff = dataOff;
            return this;
        }

        public HeaderSection build() {
            return new HeaderSection(fileSize, linkSize, linkOff, mapOff, stringIdsSize, stringIdsOff, typeIdsSize, typeIdsOff, protoIdsSize, protoIdsOff, fieldIdsSize, fieldIdsOff, methodIdsSize, methodIdsOff, classDefsSize, classDefsOff, dataSize, dataOff);
        }
    }

    public static Builder builder() {
        return Builder.aHeaderSection();
    }
}
