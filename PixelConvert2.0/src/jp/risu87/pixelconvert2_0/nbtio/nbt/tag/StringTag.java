package jp.risu87.pixelconvert2_0.nbtio.nbt.tag;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

import javax.annotation.Nullable;

/**
 * One of nbt tags. Holds String
 * 
 * @author risusan87
 */
public class StringTag extends Tag {
	
	private String str;
	
	/**
	 * Creates new tag of byte.
	 * give null as its name to declare as use for list
	 * @param par1name - tag name
	 * @param par2setstr - string to be set
	 */
	public StringTag(@Nullable String par1name, String par2setstr) {
		super(par1name);
		if (par2setstr != null)
			this.str = par2setstr;
		else
			this.isNull = true;
	}
	
	public static final byte[] toNBTByteTag(String par1str) {
		ByteBuffer strtag = ByteBuffer.allocate(2 + par1str.length());
		strtag.putShort((short)par1str.length());
		strtag.put(par1str.getBytes(StandardCharsets.UTF_8));
		return strtag.array();
	}

	@Override
	public tagID setType() {
		return tagID.STRING;
	}

	@Override
	protected Function<Tag, byte[]> _toByteArrayFunction() {
		return tag -> {
			ByteBuffer nbt = ByteBuffer.allocate(tag.getCorrespondedAllocatedByteSize());
			if (tag.Tag_name != null) {
				nbt.put(tag.getTagID());
				if (tag.Tag_name.equals(""))
					nbt.putInt(0x00)
					.put(new EndTag().toByteArray());
				else
					nbt.put(StringTag.toNBTByteTag(tag.Tag_name));
			}
			if (!tag.isNull)
				nbt.put(toNBTByteTag((String)tag.tagComponent()));
			else
				nbt.putInt(0x00)
				.put(new EndTag().toByteArray());
			return nbt.array();
		};
	}

	@Override
	protected byte getTagID() {
		return (byte)0x08;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String tagComponent() {
		return this.str;
	}

}
