package edu.matc.entity.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TournamentList {

	@JsonProperty("Files")
	private int files;

	@JsonProperty("Date")
	private List<String> date;

	@JsonProperty("Result")
	private String result;

	@JsonProperty("Name")
	private List<String> name;

	public void setFiles(int files){
		this.files = files;
	}

	public int getFiles(){
		return files;
	}

	public void setDate(List<String> date){
		this.date = date;
	}

	public List<String> getDate(){
		return date;
	}

	public void setResult(String result){
		this.result = result;
	}

	public String getResult(){
		return result;
	}

	public void setName(List<String> name){
		this.name = name;
	}

	public List<String> getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Response{" + 
			"files = '" + files + '\'' + 
			",date = '" + date + '\'' + 
			",result = '" + result + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}