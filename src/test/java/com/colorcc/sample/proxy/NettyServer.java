package com.colorcc.sample.proxy;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.ReferenceCountUtil;

public class NettyServer {

	private int port;

	public NettyServer(int port) {
		this.port = port;
	}

	public void run() throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap(); // (2)
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class) // (3)
					.childHandler(new ChannelInitializer<SocketChannel>() { // (4)
								@Override
								public void initChannel(SocketChannel ch) throws Exception {
									ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {

										@Override
										public void channelActive(final ChannelHandlerContext ctx) { // (1)
											final ByteBuf time = ctx.alloc().buffer(4); // (2)
											time.writeInt((int) (System.currentTimeMillis() / 1000L + 2208988800L));

											final ChannelFuture f = ctx.writeAndFlush(time); // (3)
											f.addListener(new ChannelFutureListener() {
												@Override
												public void operationComplete(ChannelFuture future) {
													assert f == future;
													ctx.close();
												}
											}); // (4)
										}

										@Override
										public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
											ByteBuf in = (ByteBuf) msg;
											try {
												while (in.isReadable()) { // (1)
													System.out.print("server out: " + (char) in.readByte());
													System.out.flush();
												}
											} finally {
												ReferenceCountUtil.release(msg); // (2)
											}
										}

										@Override
										public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
											super.exceptionCaught(ctx, cause);
										}

									});
								}
							}).option(ChannelOption.SO_BACKLOG, 128) // (5)
					.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

			// Bind and start to accept incoming connections.
			System.out.println("start linsten port : " + port);
			ChannelFuture f = b.bind(port).sync(); // (7)
			f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {

		int port;
		if (args.length > 0) {
			port = Integer.parseInt(args[0]);
		} else {
			port = 8080;
		}
		new NettyServer(port).run();

		// Consumer consumer = new Consumer();
		// System.out.println("start server ...");
		// Thread t = new Thread(consumer);
		// t.start();
		// t.join();
		// System.out.println("end.");
	}

}
