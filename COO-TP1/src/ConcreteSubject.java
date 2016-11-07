import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConcreteSubject extends Subject {

	Object subjectState;
	
	public Object GetSate() {
		return subjectState;
	}
	
	public void SetState() {
		JPanel radiotchat = new JPanel();
		radiotchat.add(new JTextField());
	}
}
