package com.xzx.test;

import java.io.*;

public class SerializableTest implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = -6426551506719404687L;

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
    public String toString() {
        return "SerializableTest [name=" + name + ", value=" + value + "]";
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SerializableTest test = new SerializableTest();
        test.setName("Alice");
        test.setValue("Lover");
        // 序列化
        ObjectOutputStream os = null;
        File file = new File("E:/Java/SerializableTest.txt");
        try {
            os = new ObjectOutputStream(new FileOutputStream(file));
            os.writeObject(test);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.flush();
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
            SerializableTest obj = (SerializableTest) in.readObject();
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
