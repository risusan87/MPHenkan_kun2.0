package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

public class LongArrayTag extends Tag {

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

}
