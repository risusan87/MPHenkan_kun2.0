package jp.risu87.pixelconvert2_0.nbtio.tag;

import java.util.ArrayList;
import java.util.List;

public class CompoundTag extends Tag implements Tag.ITag {
	private final List<Tag> tags;
	
	public CompoundTag(String par1name) {
		super(par1name);
		this.tags = new ArrayList<Tag>();
	}
	
	@Override
	public type setType() {
		return type.COMPOUND;
	}
	
	@Override
	public byte[] toByteArray() {
		Tag.IByteTag rt = size -> {
			byte[] b = new byte[size];
			
			return null;
		};
		return rt.toByteTag(this.tags.size());
	}
	
	@Override
	public void addTag(Tag par1tag) {
		this.tags.add(par1tag);
	}
	
	@Override
	public void removeTag(Tag par1tag) {
		for (Tag c : this.tags)
			if (c.equals(par1tag)) {
				this.tags.remove(c);
				break;
			}
	}
	
	@Override
	public void replaceTag(Tag par1src, Tag par2dst) {
	}
}
