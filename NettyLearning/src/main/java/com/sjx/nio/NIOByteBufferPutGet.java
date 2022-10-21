package com.sjx.nio;

import java.nio.ByteBuffer;

public class NIOByteBufferPutGet {
    public static void main(String[] args) {
        //创建bugger
        ByteBuffer byteBuffer = ByteBuffer.allocate(520);

        //按照类型化放入数据
        byteBuffer.putInt(100);
        byteBuffer.putLong(9);
        byteBuffer.putChar('宋');
        byteBuffer.putShort((short) 4);


        //取出数据
        byteBuffer.flip();
        System.out.println("=====================================");
        System.out.println(byteBuffer.getInt());
        System.out.println(byteBuffer.getLong());
        //System.out.println(byteBuffer.getChar());
        //需要按照顺序来合理取出数据,不符合的话可能会抛出异常,或者是数据错位
        System.out.println(byteBuffer.getChar());
        System.out.println(byteBuffer.getShort());
    }
}
