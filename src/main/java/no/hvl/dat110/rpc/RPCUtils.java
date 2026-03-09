package no.hvl.dat110.rpc;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class RPCUtils {

    public static byte[] encapsulate(byte rpcid, byte[] payload) {

        byte[] rpcmsg = null;

        if (payload == null) {
            payload = new byte[0];
        }

        rpcmsg = new byte[payload.length + 1];
        rpcmsg[0] = rpcid;

        for (int i = 0; i < payload.length; i++) {
            rpcmsg[i + 1] = payload[i];
        }

        return rpcmsg;
    }

    public static byte[] decapsulate(byte[] rpcmsg) {

        byte[] payload = null;

        payload = Arrays.copyOfRange(rpcmsg, 1, rpcmsg.length);

        return payload;

    }

    // convert String to byte array
    public static byte[] marshallString(String str) {

        byte[] encoded = null;

        if (str == null) {
            str = "";
        }

        encoded = str.getBytes();

        return encoded;
    }

    // convert byte array to a String
    public static String unmarshallString(byte[] data) {

        String decoded = null;

        decoded = new String(data);

        return decoded;
    }

    public static byte[] marshallVoid() {

        byte[] encoded = null;

        encoded = new byte[0];

        return encoded;

    }

    public static void unmarshallVoid(byte[] data) {

        return;

    }

    // convert boolean to a byte array representation
    public static byte[] marshallBoolean(boolean b) {

        byte[] encoded = new byte[1];

        if (b) {
            encoded[0] = 1;
        } else
        {
            encoded[0] = 0;
        }

        return encoded;
    }

    // convert byte array to a boolean representation
    public static boolean unmarshallBoolean(byte[] data) {

        return (data[0] > 0);

    }

    // integer to byte array representation
    public static byte[] marshallInteger(int x) {

        byte[] encoded = null;

        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.putInt(x);
        encoded = buffer.array();

        return encoded;
    }

    // byte array representation to integer
    public static int unmarshallInteger(byte[] data) {

        int decoded = 0;

        ByteBuffer buffer = ByteBuffer.wrap(data);
        decoded = buffer.getInt();

        return decoded;

    }
}