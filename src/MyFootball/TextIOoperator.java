package MyFootball;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.AbstractList;
import java.util.LinkedList;
import java.util.Scanner;

public class TextIOoperator<T extends ITextFileOutput> implements IOoperator<T> {

	public AbstractList<T> loadCollection(String path, Factory<T> f) throws IOException, ClassNotFoundException {
		Scanner in = new Scanner(new File(path));
		AbstractList<T> collection = new LinkedList<T>();
		while(in.hasNext())
		{
			String line = in.next();
			T t = f.create(line);
			collection.add(t);
		}
		in.close();
		return collection;
	}

	public void saveCollection(String path, AbstractList<T> collection) throws FileNotFoundException, IOException {
		PrintWriter writer = new PrintWriter(new File(path));
		for(T t: collection)
		{
			writer.println(t.textToSaveInFile());
		}
		writer.close();
	}
}
