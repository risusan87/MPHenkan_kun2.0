package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

public class StringTag extends Tag {
	
	private String str;
	
	public StringTag(String par1name, String par2setstr) {
		super(par1name);
		this.str = par2setstr;
	}
	
	public static final byte[] toNBTByteTag(String par1str) {
		ByteBuffer strtag = ByteBuffer.allocate(2 + par1str.length());
		strtag.putShort((short)par1str.length());
		strtag.put(par1str.getBytes(StandardCharsets.UTF_8));
		return strtag.array();
	}

	@Override
	public type setType() {
		return type.STRING;
	}
	
	@Override
	public byte[] toByteArray() {
		return null;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return null;
	}

	@Override
	protected byte getTagID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String tagComponent() {
		return this.str;
	}

}
