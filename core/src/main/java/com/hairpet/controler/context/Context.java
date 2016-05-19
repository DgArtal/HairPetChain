package com.hairpet.controler.context;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Context {

	public PropertyChangeSupport pcs = new PropertyChangeSupport(this);
	    
	    public void fireEvent(String propertyName, Object oldValue, Object newValue) {
	    	pcs.firePropertyChange(propertyName, oldValue, newValue);
		}


		public void addPropertyChangeListener(PropertyChangeListener pcl) {
			pcs.addPropertyChangeListener(pcl);
		}
}
