package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds double
 * 
 * @author risusan87
 *
 */
public class DoubleTag extends Tag {
	
	private Double d = null;
	
	/**
	 * Creates new tag of double.
	 * give null as its name to declare as use for list
	 * 
	 * @param par1name - tag name
	 * @param par2setdouble - double to be set
	 */
	public DoubleTag(@Nullable String par1name, Double par2setdouble) {
		super(par1name);
		if (par2setdouble != null)
			this.d = par2setdouble;
		else
			this.isNull = true;
	}

	@Override
	public tagID setType() {
		return tagID.DOUBLE;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getCorrespondedAllocatedByteSize());
			if (tag.Tag_name != null) {
				nbt.put(tag.getTagID());
				if (tag.Tag_name.equals(""))
					nbt.putInt(0x00)
					.put(new EndTag().toByteArray());
				else
					nbt.put(StringTag.toNBTByteTag(tag.Tag_name));
			}
			if (!tag.isNull)
				nbt.putDouble((double)tag.tagComponent());
			else
				nbt.put(new EndTag().toByteArray());
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
		return (byte)0x06;
	}

}
