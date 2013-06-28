package no.sintef.cvl.ui.primitive;

public interface ExecutionRequest extends Request {

	public Object getDataField(String name);

	public void setDataField(String string, Object object);
}
