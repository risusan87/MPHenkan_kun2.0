package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

public class FloatTag extends Tag {

	public FloatTag(String par1name) {
		super(par1name);
	}

	@Override
	public type setType() {
		return type.FLOAT;
	}

	@Override
	public byte[] toByteArray() {
		return null;
	}

}
