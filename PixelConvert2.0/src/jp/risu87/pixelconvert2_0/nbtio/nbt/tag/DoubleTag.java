package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds double
 * 
 * @author risusan87
 *
 */
public class DoubleTag extends Tag {
	
	private double d;
	
	/**
	 * Creates new tag of double.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setbyte - double to be set
	 */
	public DoubleTag(@Nullable String par1name, @Nonnull double par2setdouble) {
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

	@Override
	protected byte getTagID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <T> T tagComponent() {
		// TODO Auto-generated method stub
		return null;
	}

}
