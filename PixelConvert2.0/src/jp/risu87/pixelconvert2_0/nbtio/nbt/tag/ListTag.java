package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

public class ListTag extends Tag {

	public ListTag(String par1name) {
		super(par1name);
	}

	@Override
	public type setType() {
		return type.LIST;
	}

	@Override
	public byte[] toByteArray() {
		return null;
	}

}
