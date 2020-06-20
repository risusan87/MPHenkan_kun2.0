package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

public class DoubleTag extends Tag {

	public DoubleTag(String par1name) {
		super(par1name);
	}

	@Override
	public type setType() {
		return type.DOUBLE;
	}

	@Override
	public byte[] toByteArray() {
		return null;
	}

}
