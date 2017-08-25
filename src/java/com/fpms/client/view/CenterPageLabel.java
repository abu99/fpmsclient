package com.fpms.client.view;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;

public class CenterPageLabel extends Composite {
	private final HTML label = new HTML();
	private static final CenterPageLabel singleton = new CenterPageLabel();
	
	private CenterPageLabel() {
		initWidget(label);
	}
	
	public static CenterPageLabel get() {
		return singleton;
	}
	
	public void setLabel(String label) {

	    String headerHtml = "<b class='b1f'></b><b class='b2f'></b><b class='b3f'></b>" +
		"<b class='b4f'></b><div class='contentf'> <div style='padding:6px;'>" + label + "</div>" +
		"</div><b class='b4f'></b><b class='b3f'></b><b class='b2f'></b><b class='b1f'></b>";
	    
	    this.label.setHTML(headerHtml);
	}
}
