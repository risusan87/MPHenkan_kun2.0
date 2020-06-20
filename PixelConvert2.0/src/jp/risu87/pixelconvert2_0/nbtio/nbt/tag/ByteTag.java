package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

public class ByteTag extends Tag {

	public ByteTag(String par1name) {
		super(par1name);
	}

	@Override
	public type setType() {
		return type.BYTE;
	}

	@Override
	public byte[] toByteArray() {
		return null;
	}
	
}