package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import jp.risu87.pixelconvert2_0.nbtio.nbt.Tag;

public class EndTag extends Tag {
	public EndTag() {
		super(null);
	}

	@Override
	public type setType() {
		return type.END;
	}

	@Override
	public void removeTag(Tag par1tag) {}

	@Override
	public void replaceTag(Tag par1src, Tag par2dst) {}
}