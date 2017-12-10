package segmentedfilesystem;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class Main {


	public static void main(String[] args) throws IOException {
		int portNumber = 6014;
		InetAddress ipAddress = InetAddress.getByName("146.57.33.55");

		DatagramSocket socket = new DatagramSocket();

		//Pinging the server
		byte[] upBuffer = new byte[1028];
		DatagramPacket upPacket = new DatagramPacket(upBuffer, upBuffer.length, ipAddress, portNumber);
		socket.send(upPacket);

		ReceiverPackagers pack_receiver = new ReceiverPackagers();

		pack_receiver.startReceivingPackets(socket);
	}
}
