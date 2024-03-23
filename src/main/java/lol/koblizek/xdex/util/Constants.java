package lol.koblizek.xdex.util;

public interface Constants {

    // Bytecode reference version 039
    byte[] DEX_FILE_MAGIC = new byte[]{0x64, 0x65, 0x78, 0x0A, 0x30, 0x33, 0x39, 0x00};
    int ENDIAN_CONSTANT = 0x12345678;
    int REVERSE_ENDIAN_CONSTANT = 0x78563412;
    int NO_INDEX = -1;
}
