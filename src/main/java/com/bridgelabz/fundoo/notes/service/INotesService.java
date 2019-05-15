package com.bridgelabz.fundoo.notes.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.bridgelabz.fundoo.exception.UserException;
import com.bridgelabz.fundoo.notes.dto.NotesDto;
import com.bridgelabz.fundoo.notes.model.Notes;
import com.bridgelabz.fundoo.response.Response;

public interface INotesService {
Response create(NotesDto notesDto,String token ) throws UserException, UnsupportedEncodingException;
List<Notes> read(String token) throws UserException, UnsupportedEncodingException;
Response update(NotesDto notesDto,String token,long id) throws UserException, UnsupportedEncodingException;
Response delete(String token,int id) throws UserException, UnsupportedEncodingException;
Response trash(String token,int id) throws UserException, UnsupportedEncodingException;
Response pin(String token,int id) throws UserException, UnsupportedEncodingException;
Response archieve(String token,int id) throws UserException, UnsupportedEncodingException;
Response addNotetolabel(long labelid,String token,long noteid) throws UserException, UnsupportedEncodingException;
Response removeNotetolabel(long labelid,String token,long noteid) throws UserException, UnsupportedEncodingException;
List<Notes> trashnotes(String token) throws UserException, UnsupportedEncodingException;
List<Notes> archivenotes(String token) throws UserException, UnsupportedEncodingException;

List<Notes> pinnotes(String token) throws UserException, UnsupportedEncodingException;}
