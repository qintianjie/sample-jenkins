package com.colorcc.sample.netty.echo;

import io.netty.buffer.ByteBuf;

public class ByteBufToBytes {
	public byte[] read(ByteBuf datas) {
		byte[] bytes = new byte[datas.readableBytes()];
		datas.readBytes(bytes);
		return bytes;
	}
}
