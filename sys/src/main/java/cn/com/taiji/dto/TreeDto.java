package cn.com.taiji.dto;

import java.util.List;

import cn.com.taiji.domain.Menu;

public class TreeDto {

	private String id;
	
	private String url;
	
	private String Text;
	
	private List<Menu> nodes;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public List<Menu> getNodes() {
		return nodes;
	}

	public void setNodes(List<Menu> nodes) {
		this.nodes = nodes;
	}

	
	
}
