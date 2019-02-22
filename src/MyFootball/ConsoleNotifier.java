package MyFootball;

public class ConsoleNotifier implements INotifier {

	@Override
	public void notifyUser(String message) {
		System.out.println(message);

	}

}
