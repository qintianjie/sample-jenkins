package com.colorcc.sample.netty.echo;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class MyObjDecoder extends ByteToMessageDecoder{

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		ByteBufToBytes read = new ByteBufToBytes();
		Object obj = ByteObjConverter.byteToObject(read.read(in));
		out.add(obj);
	}

}
