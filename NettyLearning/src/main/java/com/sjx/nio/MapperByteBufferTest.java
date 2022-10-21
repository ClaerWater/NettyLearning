package com.sjx.nio;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 1.MapperByteBuffer可以上文件直接在内存(堆外内存)中进行修改,操作系统不需要进行拷贝
 */
public class MapperByteBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("1.txt", "rw");

        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();

        /**
         * 参数1： 使用的是读写模式
         * 参数2    可以直接修改的起始位置
         * 参数3     是映射到内存的大小,也就是将1.txt的多少个字节映射到内存里面去,可以修改的范围[0,5)
         */
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0,(byte) 'j');
        map.put(4,(byte) 'h');
        map.put(2,(byte) 'j');


    }
}
