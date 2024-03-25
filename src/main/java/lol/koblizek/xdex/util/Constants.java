package lol.koblizek.xdex.util;

public interface Constants {

    // Bytecode reference version 039
    byte[] DEX_FILE_MAGIC = new byte[]{0x64, 0x65, 0x78, 0x0A, 0x30, 0x33, 0x39, 0x00};
    int ENDIAN_CONSTANT = 0x12345678;
    int REVERSE_ENDIAN_CONSTANT = 0x78563412;
    int NO_INDEX = -1;

    short  METHOD_HANDLE_TYPE_STATIC_PUT = 0x00;
    short  METHOD_HANDLE_TYPE_STATIC_GET = 0x01;
    short  METHOD_HANDLE_TYPE_INSTANCE_PUT = 0x02;
    short  METHOD_HANDLE_TYPE_INSTANCE_GET = 0x03;
    short  METHOD_HANDLE_TYPE_INVOKE_STATIC = 0x04;
    short  METHOD_HANDLE_TYPE_INVOKE_INSTANCE = 0x05;
    short  METHOD_HANDLE_TYPE_INVOKE_CONSTRUCTOR = 0x06;
    short  METHOD_HANDLE_TYPE_INVOKE_DIRECT = 0x07;
    short  METHOD_HANDLE_TYPE_INVOKE_INTERFACE = 0x08;
}
