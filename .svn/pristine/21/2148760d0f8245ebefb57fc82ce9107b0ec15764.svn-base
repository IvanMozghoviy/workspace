/**
 * 
 */
package io;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author user
 *
 */
public class UpperCaseConvertor extends FilterReader {
	
	public UpperCaseConvertor(Reader reader) {
		super(reader);
	}

	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toUpperCase((char) c));
	}

	public int read(char[] buf, int offset, int count) throws IOException {
		int nread = super.read(buf, offset, count);
		int last = offset + nread;
		for (int i = offset; i < last; i++) {
			buf[i] = Character.toUpperCase(buf[i]);
		}
		return nread;
	}
}
