package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.util.List;
import java.util.function.Function;

public abstract class Tag {
	
	public String Tag_name;
	protected enum type {
		END, BYTE, SHORT, INT, LONG, FLOAT, DOUBLE, BYTE_ARRAY,
		STRING, LIST, COMPOUND, INT_ARRAY, LONG_ARRAY
	}
	public final type Type;
	
	/**
	 * Creates a new tag with specified name
	 * @param par1name - name of the tag
	 */
	protected Tag(String par1name) {
		this.Tag_name = par1name;
		this.Type = this.setType();
	}
	
	protected abstract type setType();
	protected abstract Function<Tag, byte[]> settoByteArrayFunction();
	
	protected static interface ITag {
		public void addTag(Tag par1tag);
		public void removeTag(Tag par1tag);
		public void replaceTag(Tag par1src, Tag par2dst);
	}
	
	/**
	 * Converts this tag into unzipped NBT byte form.
	 * @return byte array of NBT tag
	 */
	public byte[] toByteArray() {
		return this.settoByteArrayFunction().apply(this);
	}
	
	/**
	 * Conditions are if given object is an instance of {@code Tag}, their {@code Tag.type} matches,
	 * and their {@code Tag.Tag_name} matches.
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Tag))
			return false;
		Tag t = (Tag)obj;
		return (this.Type == t.Type) && (this.Tag_name.equals(t.Tag_name));
	}
	
}

