/*
 * Copyright (c) 2014, Roman Kolomenskii
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided
 * that the following conditions are met:
 *
 *     * Redistributions of source code must retain the above copyright notice, this list of conditions
 *       and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *       and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *     * The name of the author may not be used may not be used to endorse or
 *       promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
 * OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT
 * OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY,
 * WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package petrsu.smartroom.android.blogclient.results;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import petrsu.smartroom.android.blogclient.xmlrpcclient.LJHelpers;
import petrsu.smartroom.android.blogclient.xmlrpcclient.Util;

public class CommentPostResult {

	
	public static final String DTALKID = "dtalkid";
	public static final String STATUS = "status";
	public static final String COMMENTLINK = "commentlink";
	
	private int dtalkid;
	private String status;
	private String commentlink;
	
	public CommentPostResult(Map map) throws UnsupportedEncodingException, ParseException {
        dtalkid = (Integer) map.get(DTALKID);
        commentlink = (String) map.get(COMMENTLINK);
        status = (String) map.get(STATUS);
        
    }
	
	/**
     * 
     * @return Comment posting status, "OK" if posting was successful
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * 
     * @return Comment link in URL format
     */
    public String getCommentLink() {
        return commentlink;
    }
    
    /**
     * 
     * @return Commentid
     */
    public int getDtalkid() {
        return dtalkid;
    }
	
}
