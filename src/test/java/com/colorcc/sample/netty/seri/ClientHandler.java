package com.colorcc.sample.netty.seri;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SimpleChannelInboundHandler 通常是指定泛型类型，如 SeriObject
 * 对于 read 请求，所有请求都经过  channelRead， 
 * 	如果发现 msg 跟泛型匹配上，则 <T> msg 后调用 channelRead0， 通常可以自己 fireChannel 继续给后续 channel handler 处理
 *  否则，默认直接用 channelRead 处理完毕返回。 自定义可以写 fireChannel 给后续 channel handler 继续处理。
 *  
 *  channelRead 默认自动 release msg,  channelRead0 没有
 * Date: 2016年10月13日 上午10:08:01
 * @author qintianjie
 *
 */
public class ClientHandler extends SimpleChannelInboundHandler<SeriObject> {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		SeriObject so = new SeriObject();
		so.setAge(20);
		so.setName("jack.");
		Map<String, String> map = new HashMap<>();
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
	protected void channelRead0(ChannelHandlerContext ctx, SeriObject msg) throws Exception {
		try {
			System.out.println("cr0: " + msg);
			ctx.fireChannelRead(msg);
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		System.out.println("client read: " + msg);
		super.channelRead(ctx, msg);
	}

}
