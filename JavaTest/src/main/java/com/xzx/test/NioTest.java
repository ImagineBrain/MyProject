package com.xzx.test;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest {

	public static void readFile(String filePath) {
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println("File Is Not Exists!");
			return;
		}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
			FileChannel inChannel = raf.getChannel();
			ByteBuffer bf = ByteBuffer.allocate(1);
			ByteBuffer tmpBf = ByteBuffer.allocate(1024);
			int bytesRead = inChannel.read(bf);
			while (bytesRead != -1) {
				bf.flip();
				while (bf.hasRemaining()) {
					tmpBf.put(bf);
				}
				bf.clear();
				bytesRead = inChannel.read(bf);
			}
			System.out.println(new String(tmpBf.array()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void writeFile(String str, String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(file, "rw");
			FileChannel inChannel = raf.getChannel();
			ByteBuffer bf = ByteBuffer.wrap(str.getBytes());
			inChannel.write(bf);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void copyFileByBuffer(String srcFilePath, String targetFilePath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File srcFile = new File(srcFilePath);
		if (!srcFile.exists()) {
			System.out.println("File Is Not Exists!");
			return;
		}
		File targetFile = new File(targetFilePath);
		if (targetFile.exists()) {
			targetFile.delete();
		}
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(targetFile);
			FileChannel inFileChannel = fis.getChannel();
			FileChannel outFileChannel = fos.getChannel();
			ByteBuffer bf = ByteBuffer.allocate(1);
			int readedBytes = inFileChannel.read(bf);
			while (readedBytes != -1) {
				bf.flip();
				while (bf.hasRemaining()) {
					outFileChannel.write(bf);
				}
				bf.clear();
				readedBytes = inFileChannel.read(bf);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public static void copyFileByChannel(String srcFilePath, String targetFilePath) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		File srcFile = new File(srcFilePath);
		if (!srcFile.exists()) {
			System.out.println("File Is Not Exists!");
			return;
		}
		File targetFile = new File(targetFilePath);
		if (targetFile.exists()) {
			targetFile.delete();
		}
		try {
			fis = new FileInputStream(srcFile);
			fos = new FileOutputStream(targetFile);
			FileChannel inFileChannel = fis.getChannel();
			FileChannel outFileChannel = fos.getChannel();
			int length = 1; // ??ζ?length byte
			while (inFileChannel.position() < inFileChannel.size()) {
				if (inFileChannel.size() - inFileChannel.position() < length) {
					length = (int) (inFileChannel.size() - inFileChannel.position());
				}
				inFileChannel.transferTo(inFileChannel.position(), length, outFileChannel);
				inFileChannel.position(inFileChannel.position() + length);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Test
	public void readWriteFileTest() {
		// TODO Auto-generated method stub
		String str = "Hello NIO!\nHello NIO!\nHello NIO!";
		String filePath = "E:/Java/NIO.txt";
		NioTest.writeFile(str, filePath);
		NioTest.readFile(filePath);
	}

	@Test
	public void copyFileByBufferTest() {
		String srcFilePath = "E:/Java/NIO.txt";
		String targetFilePath = "E:/Java/NIO_COPY.txt";
		copyFileByBuffer(srcFilePath, targetFilePath);
	}

	@Test
	public void copyFileByChannelTest() {
		String srcFilePath = "E:/Java/NIO.txt";
		String targetFilePath = "E:/Java/NIO_COPY1.txt";
		copyFileByBuffer(srcFilePath, targetFilePath);
	}
}
