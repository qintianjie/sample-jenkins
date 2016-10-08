package com.colorcc.sample.netty.seri;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
	
	

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		SeriObject so = new SeriObject();
		so.setAge(20);
		so.setName("jack.");
		Map<String, String> map =new HashMap<>();
		map.put("k1", "v1");
		map.put("k2", null);
		
		List<String> list = new ArrayList<String>();
		list.add("item1");
		list.add("item2");
		so.setMap(map);
		so.setList(list);
		
		ctx.writeAndFlush(so);
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
		SeriObject so = new SeriObject();
		so.setAge(20);
		so.setName("jack.");
		Map<String, String> map =new HashMap<>();
		map.put("k1", "v1");
		map.put("k2", null);
		
		List<String> list = new ArrayList<String>();
		list.add("item1");
		list.add("item2");
		so.setMap(map);
		so.setList(list);
		
		ctx.write(so);
	}

}
