package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

public class EndTag extends Tag {
	
	public EndTag() {
		super(null);
	}

	@Override
	public type setType() {
		return type.END;
	}

	@Override
	public byte[] toByteArray() {
		return new byte[]{0};
	}
	
}