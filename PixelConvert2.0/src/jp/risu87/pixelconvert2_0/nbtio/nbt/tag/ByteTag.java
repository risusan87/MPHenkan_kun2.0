package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

/**
 * One of nbt tags. Holds Byte
 * @author risusan87
 */
public class ByteTag extends Tag {

	private byte b;
	
	public ByteTag(String par1name, byte par2setbyte) {
		super(par1name);
		this.b = par2setbyte;
	}

	@Override
	public type setType() {
		return type.BYTE;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getAllocatedByteSize());
			nbt.put((byte)0x01)
			.put(StringTag.toNBTByteTag(tag.Tag_name))
			.put(b);
			return nbt.array();
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public synchronized Byte tagComponent() {
		return b;
	}
	
}