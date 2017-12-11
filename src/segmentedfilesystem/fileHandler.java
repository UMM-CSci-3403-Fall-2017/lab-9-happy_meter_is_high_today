package segmentedfilesystem;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class fileHandler{
  //An Array that takes in a list of bytes
  ArrayList<byte[]> packet = new ArrayList<>();
  //Setting the name of the packet.
  String packet = "";
  //INsets the bytes into the Array
  public void insert(byte[] bitbybit){
    file.add(bitbybit);
  }
  public void pasrePacketName(string packet){
    this.packet = packet;
  }
  public void packageNumber() throws IOException{
    byte[][] arrayofBytes = new byte[file.size()][];
    for(int i=0;i<arrayofBytes.length; i++){
      arrayofBytes[i] = file.get(i);
    }
    Arrays.sort(arrayofBytes, new toSortFile());

    FileOutputStream Package = new FileOutputStream("./" + packet);

    for(int i=0;i<arrayofBytes.length; i++){
      Package.write(arrayofBytes[], 4, arrayofBytes[i].length-4);
    }
    //Closeing and flushign to stream to preap for a new one
    Package.flush();
    Package.close();
  }

  public static class toSortFile implements Comparator<byte[]>{
    @Override
    public int compare (byte[] p1, byte[] p2){
      int package1 = parsePackaet(p1);
      int package2 = parsePackaet(p2);
      int trfl = 0;
      if(package1 < package2){
        trfl = -1;
      } else if(package1 > package2){
        trtl = 1;
      }
      return trtl;
    }

    //Need to parse for the Packet Number
    public int getPackageNumber(byte[] packet){
      int assignedNumber = ((data[2] & 0xff) | (packet[3] & 0xff));
      return assignedNumber;
    }
  }

}
