package com.sjx.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class NOIFileChannel04 {
    public static void main(String[] args) throws Exception {


        FileInputStream fileInputStream = new FileInputStream("d:\\a.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("d:\\a2.jpg");

        FileChannel channel1 = fileInputStream.getChannel();
        FileChannel channel2 = fileOutputStream.getChannel();

        long l = channel2.transferFrom(channel1, 0, channel1.size());
        channel1.close();;
        channel2.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
