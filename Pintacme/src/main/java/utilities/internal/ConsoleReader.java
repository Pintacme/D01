package utilities.internal;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.commons.lang.StringUtils;

public class ConsoleReader {
	private InputStreamReader stream;
	private BufferedReader reader;

	public ConsoleReader() {
		stream = new InputStreamReader(System.in);
		reader = new BufferedReader(stream);
	}

	public String readCommand() throws Throwable {
		String result;
		StringBuilder buffer;
		String line;
		String prompt;
			
		prompt = "> ";
		buffer = new StringBuilder();
		do {
			System.out.printf(prompt);
			line = reader.readLine();
			line = StringUtils.trim(line);
			buffer.append(line);
			buffer.append(' ');
			prompt = "\t> ";
		} while (line != null && !line.endsWith(";"));
		
		if (line != null && line.endsWith(";") && buffer.length() >= 2)
			buffer.deleteCharAt(buffer.length() - 2);
		
		result = StringUtils.trim(buffer.toString());
		
		return result;
	}

	public String readLine() throws Throwable {
		String result;
		
		System.out.printf("> ");
		result = reader.readLine();
		result = StringUtils.trim(result);
		
		return result;
	}

}
