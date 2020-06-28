package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

/**
 *One of nbt tags. Holds int
 * @author risusan87
 */
public class IntTag extends Tag {
	
	private int i;
	
	public IntTag(String par1name, int par2setint) {
		super(par1name);
		this.i = par2setint;
	}

	@Override
	public type setType() {
		return type.INT;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getAllocatedByteSize());
			nbt.put((byte)0x03)
			.put(StringTag.toNBTByteTag(tag.Tag_name))
			.putInt(this.i);
			return nbt.array();
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer tagComponent() {
		return this.i;
	}
	
}
