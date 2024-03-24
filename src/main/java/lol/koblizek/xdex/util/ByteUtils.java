package lol.koblizek.xdex.util;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.Adler32;

public class ByteUtils {
    public static byte[] remove(byte[] array, int ...indexes) {
        byte[] newArray = new byte[array.length - indexes.length];
        for (int i = 0; i < array.length; i++) {
            boolean remove = false;
            for (int index : indexes) {
                if (i == index) {
                    remove = true;
                    break;
                }
            }
            if (!remove) {
                newArray[i] = array[i];
            }
        }
        return newArray;
    }

    public static byte[] concat(byte[] array1, byte[] array2) {
        byte[] newArray = new byte[array1.length + array2.length];
        System.arraycopy(array1, 0, newArray, 0, array1.length);
        System.arraycopy(array2, 0, newArray, array1.length, array2.length);
        return newArray;
    }

    public static byte[] concat(byte[] arr, byte[]... arrays) {
        byte[] newArray = new byte[Arrays.stream(arrays).mapToInt(b -> b.length).sum() + arr.length];
        int index = 0;
        System.arraycopy(arr, 0, newArray, index, arr.length);
        index += arr.length;
        for (byte[] array : arrays) {
            System.arraycopy(array, 0, newArray, index, array.length);
            index += array.length;
        }
        return newArray;
    }

    public static byte[] insert(byte[] array, byte[] insert, int index) {
        byte[] newArray = new byte[array.length + insert.length];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(insert, 0, newArray, index, insert.length);
        System.arraycopy(array, index, newArray, index + insert.length, array.length - index);
        return newArray;
    }

    public static byte[] concat(Stream<byte[]> stream) {
        List<byte[]> list = stream.toList();
        byte[] newArray = new byte[list.stream().mapToInt(b -> b.length).sum()];
        int index = 0;
        for (byte[] array : list) {
            System.arraycopy(array, 0, newArray, index, array.length);
            index += array.length;
        }
        return newArray;
    }

    public static byte[] hashBytes(byte[] bytes) {
        try
        {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(bytes);
            return crypt.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static int adler32(byte[] data) {
        Adler32 adler32 = new Adler32();
        adler32.update(data);
        return (int) adler32.getValue();
    }

    public static byte[] asBytes(int n) {
        return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(n).array();
    }

    public static byte[] asBytes(int... n) {
        ByteBuffer b = ByteBuffer.allocate(n.length * 4).order(ByteOrder.LITTLE_ENDIAN);
        for (int i : n) {
            b.putInt(i);
        }
        return b.array();
    }
}
