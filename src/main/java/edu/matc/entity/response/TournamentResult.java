package edu.matc.entity.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TournamentResult{

	@JsonProperty("Start")
	private int start;

	@JsonProperty("Data")
	private List<String> data;

	@JsonProperty("Count")
	private int count;

	@JsonProperty("Result")
	private String result;

	public void setStart(int start){
		this.start = start;
	}

	public int getStart(){
		return start;
	}

	public void setData(List<String> data){
		this.data = data;
	}

	public List<String> getData(){
		return data;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"TournamentResult{" + 
			"start = '" + start + '\'' + 
			",data = '" + data + '\'' + 
			",count = '" + count + '\'' + 
			",result = '" + result + '\'' + 
			"}";
		}
}