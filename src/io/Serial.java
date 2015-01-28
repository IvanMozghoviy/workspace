/**
 * 
 */
package io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author user
 *
 */
public class Serial {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		Object objSave = new String("Hello world");
		//Object objSave = new Integer(1);
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(objSave);
		//Результат сериализации Вы можете увидеть вызвав метод toByteArray():

		byte[] bArray = os.toByteArray();
		//А чтобы восстановить объект, его нужно десериализовать из этого массива:

		ByteArrayInputStream is = new ByteArrayInputStream(bArray);
		ObjectInputStream ois = new ObjectInputStream(is);
		Object objRead = ois.readObject();
	//	Теперь можно убедиться, что восстановленный объект идентичен исходному:

		System.out.println("readed object is: " + objRead.toString());
		System.out.println("Object equality is: " + (objSave.equals(objRead)));
		System.out.println("Reference equality is: " + (objSave==objRead));
	}

}
