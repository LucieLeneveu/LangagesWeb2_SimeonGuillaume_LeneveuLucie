package model;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Liste {
	private List<STB> stbs;

	public List<STB> getStbs() {
		return stbs;
	}

	public void setStbs(List<STB> stbs) {
		this.stbs = stbs;
	}
}
