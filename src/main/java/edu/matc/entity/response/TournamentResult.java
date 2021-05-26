package edu.matc.entity.response;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Tournament result.
 */
public class TournamentResult{

	@JsonProperty("Start")
	private int start;

	@JsonProperty("Data")
	private List<String> data;

	@JsonProperty("Count")
	private int count;

	@JsonProperty("Result")
	private String result;

	/**
	 * Set start.
	 *
	 * @param start the start
	 */
	public void setStart(int start){
		this.start = start;
	}

	/**
	 * Get start int.
	 *
	 * @return the int
	 */
	public int getStart(){
		return start;
	}

	/**
	 * Set data.
	 *
	 * @param data the data
	 */
	public void setData(List<String> data){
		this.data = data;
	}

	/**
	 * Get data list.
	 *
	 * @return the list
	 */
	public List<String> getData(){
		return data;
	}

	/**
	 * Set count.
	 *
	 * @param count the count
	 */
	public void setCount(int count){
		this.count = count;
	}

	/**
	 * Get count int.
	 *
	 * @return the int
	 */
	public int getCount(){
		return count;
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