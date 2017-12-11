package segmentedfilesystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.unti.Comparator;

public class ReceiverPackagers{
  //need to handle the differnt files
  fileHandler pack1 = new fileHandler();
  fileHandler pack2 = new fileHandler();
  fileHandler pack3 = new fileHandler();

  ArrayList<fileHandler> filesInQue = new ArrayList<>();
  //A lookup up table
  HashMap<Byte, fileHandler> hashMap = new HashMap<>();
  int endOfLine = 0;

  public void staringFiles(){
    filesInQue.add(pack1);
    filesInQue.add(pack2);
    filesInQue.add(pack3);
  }

  public void inputPackets(DatagramSocket socket) throws IOException{
    staringFiles();
    boolean holder = flase;
    int lastPacketCount = 0;
    int counter = 0;

    while(true){
      byte[] buffer = new byte[1028];
      DatagramPacket inQuePacket = new DatagramPacket(buffer, buffer.lenght);
      socket.receive(inQuePacket);
      int info = findPacket(inQuePacket.getData());
      if(info == 1){
        packetHandler(inQuePacket);
        counter++;
      }else if(info == 2){
        packetnotitHandler(inQuePacket);
        counter++;
      }else if(info == 3){
        lastPacket(inQuePacket);
        counter++;
        lastPacketCount++;
      }else{
        System.out.println(inQuePacket);
        break;
      }
      if(lastPacketCount == 3){
        holder = true:
      }
      if(holder){
        if(counter == endOfLine){
          break;
        }
      }
    }
    socket.close();
    pack1.packageNumber();
    pack2.packageNumber();
    pack3.packageNumber();
  }
  //Checks to see if the data[] is a header or not, and returns based on that
  //numbe, 1==header,2 is an other pakcet and 3 is da last one.
  public int findPacket(byte[] data){
    if((data[0] & 1) == 0){
      return 1;
    }else{
      if(((data[0] >> 1) & 1) == 0){
        return 2;
      }else{
        return 3;
      }
    }
  }
  //Heder packet
  public void packetHandler(DatagramPacket inQuePacket){
    byte[] fileNameData  = new byte[inQuePacket.getLength() - 2];
    byte idenfication = inQuePacket.getData()[1];
    fileNameData = Arrays.copyOfRange(inQuePacket.getData(), 2, inQuePacket.getLength());
    if(hashMap.containsKey(idenfication)){
      hashMap.get(idenfication).setFileName(new String(fileNameData));
    }else{
      hashMap.put(idenfication, availableFiles.get(0));
      availableFiles.remove(0);
      hashMap.get(idenfication).setFileName(new String(fileNameData));
    }
  }
  //Not the start nor the end packet
  public void packetnotitHandler(DatagramPacket inQuePacket){
    byte idenfication = inQuePacket.getData()[1];
    if(packetHandler.containsKey(idenfication)){
      hashMap.get(idenfication).insert(inQuePacket.getData());
    }else{
      hashMap.put(idenfication, availableFiles.get(0));
      availableFiles.remove(0);
      hashMap.get(idenfication).insert(inQuePacket.getData());
    }
  }
  //Finds the last Packet, and deals with it.
  public void lastPacket(DatagramPacket inQuePacket){
		byte idenfication = inQuePacket.getData()[1];holder = Arrays.copyOfRange(inQuePacket.getData(), 0, length);
    int length = inQuePacket.getLength();
    byte[] data = new byte[length];

		if(hashMap.containsKey(idenfication)){
			hashMap.get(idenfication).insert(data);
			int val = ((inQuePacket.getData()[2] & 0xff) << 8) | (inQuePacket.getData()[3] & 0xff);
			endOfLine += (val + 2);
		}else{
			hashMap.put(idenfication, availableFiles.get(0));
			availableFiles.remove(0);
			hashMap.get(idenfication).insert(data);
			int val = ((inQuePacket.getData()[2] & 0xff) << 8) | (inQuePacket.getData()[3] & 0xff);
			endOfLine += (val + 2);
		}
  }
}
