package com.example.mifareclassic;

public interface INfcMemoryContainer {
	public short[] AllocateItem(int byteCount) throws NfcException;
}
