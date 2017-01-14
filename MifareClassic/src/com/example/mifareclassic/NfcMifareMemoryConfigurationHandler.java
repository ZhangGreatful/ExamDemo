/**
 * 
 */
package com.example.mifareclassic;


/**
 * @author haoxinyue Handle XML configuration file
 */
public class NfcMifareMemoryConfigurationHandler extends NfcMemoryConfigurationHandler {

	@Override
	protected INfcItem CreateIntItem(String key) {
		return new NfcMifareIntItem(key);
	}

	@Override
	protected INfcItem CreateStringItem(String key, short byteCount) {
		return new NfcMifareStringItem(key, byteCount);
	}
}
