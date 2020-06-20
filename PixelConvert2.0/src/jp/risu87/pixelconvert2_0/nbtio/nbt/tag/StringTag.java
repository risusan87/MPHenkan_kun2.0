package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

public class StringTag extends Tag {

	public StringTag(String par1name) {
		super(par1name);
	}

	@Override
	public type setType() {
		return type.STRING;
	}

	@Override
	public byte[] toByteArray() {
		return null;
	}

}
