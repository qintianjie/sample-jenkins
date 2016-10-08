package com.colorcc.sample.netty.seri;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ServerHandler extends ChannelInboundHandlerAdapter  {
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		
		System.out.println("server channelRead");
		SeriObject obj = (SeriObject) msg;
		
		System.out.println(obj);
		ctx.write(msg);
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


//	@Override
//	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//		System.out.println("server channelRead");
//		SeriObject obj = (SeriObject) msg;
//		
//		System.out.println(obj);
//		ctx.write(msg);
//	}
//
//	@Override
//	protected void channelRead0(ChannelHandlerContext ctx, Serializable msg) throws Exception {
//		System.out.println("server channelRead0");
//		ctx.writeAndFlush(msg);
//	}
//
////	@Override
////	public void channelActive(ChannelHandlerContext ctx) throws Exception {
////		System.out.println("server channelActive");
////	}
//
//	@Override
//	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		System.out.println("server channelReadComplete");
//		ctx.flush();
//	}
//
////	@Override
////	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
////		System.out.println("server userEventTriggered");
////		super.userEventTriggered(ctx, evt);
////	}
//
//	@Override
//	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
//		System.out.println("server exceptionCaught");
//		cause.printStackTrace();
//		ctx.close();
//	}

	

}
