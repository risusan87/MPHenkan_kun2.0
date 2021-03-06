package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

/**
 * One of nbt tags. Holds float
 * @author risusan87
 */
public class FloatTag extends Tag {

	private float f;
	
	public FloatTag(String par1name, float par2setfloat) {
		super(par1name);
		this.f = par2setfloat;
	}

	@Override
	public type setType() {
		return type.FLOAT;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getAllocatedByteSize());
			nbt.put((byte)0x05)
			.put(StringTag.toNBTByteTag(tag.Tag_name))
			.putFloat(this.f);
			return nbt.array();
		};
	}

	@SuppressWarnings("unchecked")
	@Override
	public Float tagComponent() {
		return this.f;
	}

}
