package com.colorcc.sample.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class EchoServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		MyObj obj = (MyObj) msg;
		
		System.out.println(obj);
//		ByteBuf  in = (ByteBuf) msg;
//		System.out.println("Server received: " + in.toString(CharsetUtil.UTF_8));
//		ctx.write(in);
		ByteBuf bb = Unpooled.buffer();  
		bb.writeBytes(("server hello : " + obj.toString()).getBytes());
		ctx.write(bb);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

}
