package de.unknownreality.dataframe.type.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringType extends ComparableType<String> {
    private Charset charSet = StandardCharsets.UTF_8;

    @Override
    public Class<String> getType() {
        return String.class;
    }


    @Override
    public String read(DataInputStream dis) throws IOException {
        int length = dis.readInt();
        byte[] data = new byte[length];
        dis.read(data);
        return new String(data, charSet);
    }

    @Override
    public String read(ByteBuffer buf) {
        int length = buf.getInt();
        byte[] data = new byte[length];
        return new String(data, charSet);
    }

    @Override
    public String parse(String s) {
        return s;
    }

    @Override
    public void write(Writer writer, String value) throws IOException {
        writer.write(value);
    }

    @Override
    public String toString(String value) {
        return value;
    }


    @Override
    public int write(DataOutputStream dos, String value) throws IOException {
        byte[] data = value.getBytes(charSet);
        dos.writeInt(data.length);
        dos.write(data);
        return Integer.BYTES + data.length;
    }
}
