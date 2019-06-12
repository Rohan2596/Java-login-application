package com.bridgelabz.fundoo.elasticSearch;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.fundoo.notes.model.Notes;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class ElasticSearch implements IElasticSearch {
	    String INDEX = "notedb";
	    String TYPE = "notetype";  

	    @Autowired
	    private RestHighLevelClient client;

	    @Autowired
   private ObjectMapper objectMapper;
	    
	@Override
	public Notes create(Notes notes)   {
	       @SuppressWarnings("unchecked")
	        Map<String, Object> dataMap = objectMapper.convertValue(notes, Map.class);
	        IndexRequest indexRequest = new IndexRequest(INDEX,TYPE,String.valueOf(notes.getId())).source(dataMap);
	   
	            try {
					client.index(indexRequest, RequestOptions.DEFAULT);
				} catch (IOException e) {
		
					e.printStackTrace();
				}
	   
	        return notes;
		
	}

	@Override
	public Notes updateNote(Notes notes) {
		   @SuppressWarnings("unchecked")
	        Map<String, Object> dataMap = objectMapper.convertValue(notes, Map.class);
	        UpdateRequest updateRequest = new UpdateRequest(INDEX,TYPE,String.valueOf(notes.getId()));
	      
	        	updateRequest.doc(dataMap);
	        	 try {
	        		 @SuppressWarnings("unchecked")
					UpdateResponse updateResponse =    client.update(updateRequest, RequestOptions.DEFAULT);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	      

	        return notes;
	}

	@Override
	public void deleteNote(Long NoteId) {
	  DeleteRequest deleteRequest=new DeleteRequest(INDEX,TYPE,String.valueOf(NoteId));   
		try {
	            client.delete(deleteRequest, RequestOptions.DEFAULT);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	        return;
	}

	@Override
	public List<Notes> searchData(String query, long userId) {
	
		return null;
	}

}