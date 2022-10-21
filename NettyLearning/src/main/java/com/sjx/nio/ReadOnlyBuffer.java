package com.sjx.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class ReadOnlyBuffer {
    public static void main(String[] args) {
        ByteBuffer allocate = ByteBuffer.allocate(520);

        for (int i = 0; i < 64; i++) {
            allocate.put((byte) i);
        }
        allocate.flip();
        //得到一个只读 的buffer
        ByteBuffer byteBuffer = allocate.asReadOnlyBuffer();
        //这个只能读取
        System.out.println(byteBuffer.getClass());

        while (byteBuffer.hasRemaining()){
            System.out.println(byteBuffer.get());
        }
       // byteBuffer.putShort((short) 10); 这个就会抛出异常
    }
}
