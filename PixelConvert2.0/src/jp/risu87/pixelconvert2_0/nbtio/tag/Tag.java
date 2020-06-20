package jp.risu87.pixelconvert2_0.nbtio.tag;

import java.util.List;

public abstract class Tag {
	public String Tag_name;
	public enum type {
		END, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, BYTE_ARRAY,
		STRING, LIST, COMPOUND, INT_ARRAY, LONG_ARRAY
	}
	public final type Type;
	
	public Tag(String par1name) {
		this.Tag_name = par1name;
		this.Type = this.setType();
	}
	
	public abstract type setType();
	public abstract byte[] toByteArray();
	
	static interface ITag {
		public void addTag(Tag par1tag);
		public void removeTag(Tag par1tag);
		public void replaceTag(Tag par1src, Tag par2dst);
	}
	
	static interface IByteTag {
		public byte[] toByteTag(int par1size);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Tag))
			return false;
		Tag t = (Tag)obj;
		return (this.Type == t.Type) && (this.Tag_name.equals(t.Tag_name));
	}
}

