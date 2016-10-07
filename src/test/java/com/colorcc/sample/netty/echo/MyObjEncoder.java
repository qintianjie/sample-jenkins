package com.colorcc.sample.netty.echo;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyObjEncoder extends MessageToByteEncoder<MyObj> {

	@Override
	protected void encode(ChannelHandlerContext ctx, MyObj msg, ByteBuf out) throws Exception {
		byte[] datas = ByteObjConverter.objectToByte(msg);
		out.writeBytes(datas);
		ctx.flush();		
	}

}
