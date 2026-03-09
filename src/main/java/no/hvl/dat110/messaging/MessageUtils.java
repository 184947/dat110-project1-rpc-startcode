package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {
		
		byte[] segment = new byte[SEGMENTSIZE];
		byte[] data = message.getData();

        segment[0] = (byte) data.length;
        for (int i = 0; i < data.length; i++){
            segment[i +1] = data[i];
        }


		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;
		int len = segment[0];

        byte[] data = Arrays.copyOfRange(segment, 1,1 + len);

		return new Message(data);
		
	}
	
}
