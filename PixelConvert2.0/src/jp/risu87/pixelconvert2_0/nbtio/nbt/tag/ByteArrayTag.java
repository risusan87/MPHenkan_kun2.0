package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

public class ByteArrayTag extends Tag {

	public ByteArrayTag(String par1name) {
		super(par1name);
	}

	@Override
	public type setType() {
		return type.BYTE_ARRAY;
	}

	@Override
	public byte[] toByteArray() {
		return null;
	}

}
