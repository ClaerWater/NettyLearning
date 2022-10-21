package com.sjx.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NOIOFileChannel {
    public static void main(String[] args) throws Exception {


        FileInputStream fileInputStream = new FileInputStream("/1.txt");
        FileChannel channel1 = fileInputStream.getChannel();

        FileOutputStream fileOutputStream = new FileOutputStream("/2.txt");
        FileChannel channel2 = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);

        while (true) {
            byteBuffer.clear();//很重要！！！！
            int read = channel1.read(byteBuffer);
            if (read == -1) break;
            //将buff中的数据写到数据通道下面
            byteBuffer.flip();
            channel2.write(byteBuffer);
        }

        //关闭资源
        fileInputStream.close();
        fileOutputStream.close();
    }
}
