package com.systraweb.restful;

import java.util.List;

public class ClassJsonOutput<k>  {
	private List<k> results ;

	public List<k> getResults() {
		return results;
	}

	public void setResults(List<k> results) {
		this.results = results;
	}

	public ClassJsonOutput() {
		super();
		// TODO Auto-generated constructor stub
	}
}
