package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

/**
 * One of nbt tags. Holds double
 * @author risusan87
 *
 */
public class DoubleTag extends Tag {
	
	private double d;
	
	public DoubleTag(String par1name, double par2setdouble) {
		super(par1name);
		this.d = par2setdouble;
	}

	@Override
	public type setType() {
		return type.DOUBLE;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getAllocatedByteSize());
			nbt.put((byte)0x06)
			.put(StringTag.toNBTByteTag(tag.Tag_name))
			.putDouble(this.d);
			return nbt.array();
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public Double tagComponent() {
		return this.d;
	}

}
