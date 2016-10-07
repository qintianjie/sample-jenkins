package com.colorcc.sample.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

import java.util.ArrayList;
import java.util.List;

public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
	
	

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		MyObj mo  = new MyObj();
		mo.setName("client_moobj");
		mo.setAge(20);
		List<String> attrs = new ArrayList<String>();
		attrs.add("first");
		attrs.add("second");
		mo.setAttrs(attrs);
		
		
		ctx.writeAndFlush(mo);
//		ctx.writeAndFlush(Unpooled.copiedBuffer("Client hello!", CharsetUtil.UTF_8));
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		System.out.println("Client received : " + msg.toString(CharsetUtil.UTF_8));
	}

}
