/*
 * Copyright (c) 2006, 2012 Igor Katkov, Anatoly Rybalchenko
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

import petrsu.smartroom.android.blogclient.xmlrpcclient.LJHelpers;
import petrsu.smartroom.android.blogclient.xmlrpcclient.Util;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represent blog entry
 */
public class BlogEntry {
    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("yyyy'-'MM'-'dd' 'HH:mm:ss");

    public static final String ITEMID = "itemid";
    public static final String PERMALINK = "url";
    public static final String ANUM = "anum";
    public static final String BODY = "event";
    public static final String DATE = "eventtime";
    public static final String SUBJECT = "subject";
    public static final String REPLY_COUNT = "reply_count";
    public static final String POSTER = "poster";
    public static final String JOURNAL = "journal";


    private int itemid;
    private String permalink;
    private Integer anum;
    private String body;
    private Date date;
    private String subject;
    private Integer reply_count;
    private String poster;
    private String journal;


    //TODO: implement support for: props (metadata)


    public BlogEntry(Map map, String journal) throws UnsupportedEncodingException, ParseException {
        itemid = (Integer) map.get(ITEMID);
        permalink = (String) map.get(PERMALINK);
        anum = (Integer) map.get(ANUM);
        subject = LJHelpers.getUnicodeText(map.get(SUBJECT));
        body = LJHelpers.getUnicodeText(map.get(BODY));
        date = LJHelpers.parseDate((String) map.get(DATE), DATEFORMAT);
        reply_count = (Integer) map.get(REPLY_COUNT);
//        security = SecurityType.getInstance((String) map.get("security"));
//        allowmask = (Integer) map.get("allowmask");
        poster = Util.nullString((String) map.get(POSTER));
        this.journal = journal;
    }

    /**
     * The unique integer ItemID of the blog entry
     *
     * @return itemId
     */
    public int getItemid() {
        return itemid;
    }

    /**
     * Permanent URL of the entry
     *
     * @return url
     */
    public String getPermalink() {
        return permalink;
    }

    /**
     * No idea what that means, Livejournal XML RPC documentation is very silent about this
     *
     * @return anum
     */
    public Integer getAnum() {
        return anum;
    }

    /**
     * The event text itself. it is URL-encoded (alphanumerics stay the same, weird symbols to %hh, and spaces to + signs,
     * just like URLs or post request). This allows posts with line breaks to come back on one line.
     *
     * @return The text itself
     */
    public String getBody() {
        return body;
    }

    public String getHTMLBody() {
        return Util.toHTML(body);
    }

    /**
     * The time the user posted (or said they posted, rather, since users can back-date posts) the item being returned.
     *
     * @return The time the user posted
     */
    public Date getDate() {
        return date;
    }

    /**
     * The subject of the journal entry
     *
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    public Integer getReply_count() {
        return reply_count;
    }

//
//
//    /**
//     * If this variable is null, then the security of the post is public, otherwise this value will be private or usemask.
//     *
//     * @return security
//     */
//    public SecurityType getSecurity() {
//        return security;
//    }

//
//    /**
//     * If security is usemask then this is defined with the 32-bit unsigned int bit-mask of who is allowed to access this post.
//     *
//     * @return mask
//     */
//    public Integer getAllowmask() {
//        return allowmask;
//    }
//
//    /**
//     * If the poster of this event is different from the user value sent above, then this will be not null and will
//     * specify the username of the poster of this event. If this key is not present, then it is safe to assume that
//     * the poster of this event is none other than user.
//     *
//     * @return name
//     */
//    public String getPoster() {
//        return poster;
//    }

    /**
     * Some kind of if id, required for getcomments
     * @return ditemid
     */
    public Integer getDItemId() {
        return BlogEntry.getDItemId(this.itemid, this.anum);
    }

    public String getPoster() {
        return poster;
    }

    public String getJournal() {
        return journal;
    }

    public static Integer getDItemId(int entryId, int anum) {
        return entryId * 256 + anum;
    }

    public String toString() {
        return "BlogEntry{" +
                "itemid=" + itemid +
                ", permalink='" + permalink + '\'' +
                ", anum=" + anum +
                ", body='" + body + '\'' +
                ", date=" + date +
                ", subject='" + subject + '\'' +
                ", jouranl='" + journal + '\'' +
//                ", security=" + security +
//                ", allowmask=" + allowmask +
//                ", poster='" + poster + '\'' +
                '}';
    }



}
