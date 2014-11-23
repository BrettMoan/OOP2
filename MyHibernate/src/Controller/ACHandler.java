package Controller;

import java.util.ArrayList;
import java.util.HashMap;

public abstract interface ACHandler {
	public boolean requiresParameters = false;
	public void handleIt(ArrayList data);
}
