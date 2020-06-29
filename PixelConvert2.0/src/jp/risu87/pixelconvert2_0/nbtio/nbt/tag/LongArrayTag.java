package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.util.List;
import java.util.function.Function;

public class LongArrayTag extends Tag implements Tag.TagArray {
	
	private List<Long> larray;
	
	public LongArrayTag(String par1name) {
		super(par1name);
	}

	@Override
	public type setType() {
		return type.LONG_ARRAY;
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
		return 0;
	}

	@Override
	public <T> T tagComponent() {
		return null;
	}

	@Override
	public int arraySize() {
		return 8;
	}

	@Override
	public int primitiveSize() {
		return 8;
	}

}
