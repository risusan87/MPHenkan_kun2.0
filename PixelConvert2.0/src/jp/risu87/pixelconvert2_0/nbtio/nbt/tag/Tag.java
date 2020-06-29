package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.util.List;
import java.util.function.Function;

/**
 * The super class of all known NBT tag types,
 * supporting add, edit, and delete(only for compound tags) functions
 * @author risusan87
 */
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
	protected abstract Function<Tag, byte[]> _toByteArrayFunction();
	protected abstract byte getTagID();
	
	/**
	 * Returns corresponding content of this tag, allowing to edit its data.
	 * @return 
	 */
	public abstract <T>T tagComponent();
	
	/**
	 * Interface to be implemented on compound attributed tags
	 * @author risusan87
	 */
	protected static interface TagCompound {
		public int getElementCount();
	}
	
	/**
	 * Interface to be implemented on array attributed tags
	 * @author risusan87
	 */
	protected static interface TagArray {
		public int arraySize();
		public int primitiveSize();
	}
	
	/**
	 * Converts this tag into unzipped NBT byte form.
	 * @return byte array of NBT tag
	 */
	public byte[] toByteArray() {
		return this._toByteArrayFunction().apply(this);
	}
	
	/**
	 * Returns allocated byte size depending on if used for list or not
	 * @return
	 */
	public int getCorrespondedAllocatedByteSize() {
		return this.Tag_name == null ? this.getSizelessAllocatedByteSize()
				: this.getAllocatedByteSize();
	}
	/**
	 * Returns byte size of this whole tag allocated
	 * @return byte size
	 */
	public int getAllocatedByteSize() {
		int size = 3 + this.Tag_name.length();
		switch (this.Type) {
			case END: case BYTE: return size + 1;
			case SHORT: return size + 2;
			case INT: case FLOAT: return size + 4;
			case LONG: case DOUBLE: return size + 8;
			case STRING: return size + 2 + ((StringTag)this).tagComponent().length();
			case BYTE_ARRAY: case INT_ARRAY: case LONG_ARRAY:
				int balements = ((TagArray)this).arraySize();
				int allobyte = ((TagArray)this).primitiveSize();
				return size + (balements * allobyte) + 4;
			case LIST:
				List<Tag> list_list = this.tagComponent();
				int list_contentByte = 5;
				for (Tag t : list_list)
					list_contentByte += t.getAllocatedByteSize() - size;
				return size + list_contentByte;
			case COMPOUND:
				List<Tag> comp_list = this.tagComponent();
				int comp_contentByte = 1;
				for (Tag t : comp_list)
					comp_contentByte += t.getAllocatedByteSize();
				return size + comp_contentByte;
					
			default: return -1;
		}
	}
	
	/**
	 * Returns byte size of this whole tag allocated, regardless tag id and name
	 * @return byte size
	 */
	public int getSizelessAllocatedByteSize() {
		switch (this.Type) {
			case END: case BYTE: return 1;
			case SHORT: return 2;
			case INT: case FLOAT: return 4;
			case LONG: case DOUBLE: return 8;
			case STRING: return 2 + ((StringTag)this).tagComponent().length();
			case BYTE_ARRAY: case INT_ARRAY: case LONG_ARRAY:
				int balements = ((TagArray)this).arraySize();
				int allobyte = ((TagArray)this).primitiveSize();
				return (balements * allobyte) + 4;
			case LIST:
				@SuppressWarnings("unchecked")
				List<? extends Tag> list_list = (List<? extends Tag>) this.tagComponent();
				int list_contentByte = 5;
				for (Tag t : list_list)
					list_contentByte += t.getSizelessAllocatedByteSize();
				return list_contentByte;
			case COMPOUND:
				List<Tag> comp_list = this.tagComponent();
				int comp_contentByte = 1;
				for (Tag t : comp_list)
					comp_contentByte += t.getSizelessAllocatedByteSize();
				return comp_contentByte;
					
			default: return -1;
		}
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

