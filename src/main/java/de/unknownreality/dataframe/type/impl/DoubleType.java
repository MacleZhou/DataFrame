package de.unknownreality.dataframe.type.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.nio.ByteBuffer;

public class DoubleType extends NumberType<Double> {
    @Override
    public Class<Double> getType() {
        return Double.class;
    }


    @Override
    public Double read(DataInputStream dis) throws IOException {
        return dis.readDouble();
    }

    @Override
    public Double read(ByteBuffer buf) {
        return buf.getDouble();
    }

    @Override
    public Double parse(String s) {
        return Double.parseDouble(s);
    }

    @Override
    public void write(Writer writer, Double value) throws IOException {
        writer.write(toString(value));
    }

    @Override
    public String toString(Double value) {
        return Double.toString(value);
    }


    @Override
    public int write(DataOutputStream dos, Double value) throws IOException {
        dos.writeDouble(value);
        return Double.BYTES;
    }
}
