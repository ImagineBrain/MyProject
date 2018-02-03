package com.xzx.test;

import java.io.*;

public class SerializableTest2 implements Externalizable {

	private String name;
	private String value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		// TODO Auto-generated method stub
		out.writeObject(name);
		out.writeObject(value);
	}

	@Override
	public String toString() {
		return "SerializableTest2 [name=" + name + ", value=" + value + "]";
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		name = (String) in.readObject();
		value = (String) in.readObject();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SerializableTest2 test = new SerializableTest2();
		test.setName("Alice2");
		test.setValue("Lover2");
		// 序列化
		ObjectOutputStream os = null;
		File file = new File("E:/Java/SerializableTest2.txt");
		try {
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(test);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// 反序列化
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream(new FileInputStream(file));
			SerializableTest2 obj = (SerializableTest2) in.readObject();
			System.out.println(obj.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
