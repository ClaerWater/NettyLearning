package com.sjx.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * Scatter:将数据写入到buffer,可以采用buffer数组,依次写入(分散)
 * Gathering:从buffer读取数据的时候,可以采用buffer数组,依次读
 */
public class ScatterAndGatheringTest {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress = new InetSocketAddress(7000);

        //绑定端口到socket并启动
        serverSocketChannel.socket().bind(inetSocketAddress);

        //创建buffer数组
        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(5);
        byteBuffers[1] = ByteBuffer.allocate(3);

        //等客户端连接
        SocketChannel socketChannel = serverSocketChannel.accept();

        int messageLen = 8;//假定从客户端接收8个字节
        //循环读取
        while (true) {
            int byteread = 0;
            while (byteread < messageLen) {
                long r = socketChannel.read(byteBuffers);
                byteread += r;
                System.out.println("读取到的字节数" + byteBuffers);

                //使用流打印,看看当前的这个buffer的position和limit
                Arrays.asList(byteBuffers).stream().map(byteBuffer -> "postion= " + byteBuffer.position()
                        + "," + byteBuffer.limit()).forEach(System.out::println);
            }
            //将所有的buffer进行翻转
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.flip());
            //将数据读出显示到我们的客户端
            long byteWrite = 0;
            while (byteWrite < messageLen) {
                long l = socketChannel.write(byteBuffers);
                byteWrite += l;
            }

            //将所有的buffer进行clear
            Arrays.asList(byteBuffers).forEach(byteBuffer -> byteBuffer.clear());
        }
    }
}
