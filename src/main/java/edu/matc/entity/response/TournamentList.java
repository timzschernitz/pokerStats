package edu.matc.entity.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Tournament list.
 */
public class TournamentList {

	@JsonProperty("Files")
	private int files;

	@JsonProperty("Date")
	private List<String> date;

	@JsonProperty("Result")
	private String result;

	@JsonProperty("Name")
	private List<String> name;

	/**
	 * Set files.
	 *
	 * @param files the files
	 */
	public void setFiles(int files){
		this.files = files;
	}

	/**
	 * Get files int.
	 *
	 * @return the int
	 */
	public int getFiles(){
		return files;
	}

	/**
	 * Set date.
	 *
	 * @param date the date
	 */
	public void setDate(List<String> date){
		this.date = date;
	}

	/**
	 * Get date list.
	 *
	 * @return the list
	 */
	public List<String> getDate(){
		return date;
	}

	/**
	 * Set result.
	 *
	 * @param result the result
	 */
	public void setResult(String result){
		this.result = result;
	}

	/**
	 * Get result string.
	 *
	 * @return the string
	 */
	public String getResult(){
		return result;
	}

	/**
	 * Set name.
	 *
	 * @param name the name
	 */
	public void setName(List<String> name){
		this.name = name;
	}

	/**
	 * Get name list.
	 *
	 * @return the list
	 */
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