package no.sintef.cvl.ui.observer;

import java.util.ArrayList;

public interface Observer {

	public void update(Subject subject);
	
	public ArrayList<Subject> getSubjects();
}
