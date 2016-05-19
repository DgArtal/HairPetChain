package com.hairpet.view;

import javax.swing.JButton;

public abstract class OkCancelButtons {

	private JButton accept;
	private JButton cancel;

	private boolean viewAcceptButton;
	private boolean viewCancelButton;

	public OkCancelButtons(String aceptar, String cancelar) {
		super();
		initButtons(aceptar, cancelar);
	}

	private void initButtons(String aceptar, String cancelar) {
		if (aceptar != null) {
			this.accept = new JButton(aceptar);
			viewAcceptButton = true;
		} else {
			this.accept = null;
			viewAcceptButton = false;
		}
		if (cancelar != null) {
			this.cancel = new JButton(cancelar);
			viewCancelButton = true;
		} else {
			this.cancel = null;
			viewCancelButton = false;
		}
	}

	public abstract void addActionAcceptButton();

	public abstract void addActionCancelButton();

	public void addActions() {
		this.addActionAcceptButton();
		this.addActionCancelButton();
	}

	/**
	 * @return the accept
	 */
	public JButton getAccept() {
		return accept;
	}

	/**
	 * @param accept
	 *            the accept to set
	 */
	public void setAccept(JButton accept) {
		this.accept = accept;
	}

	/**
	 * @return the cancel
	 */
	public JButton getCancel() {
		return cancel;
	}

	/**
	 * @param cancel
	 *            the cancel to set
	 */
	public void setCancel(JButton cancel) {
		this.cancel = cancel;
	}

}
