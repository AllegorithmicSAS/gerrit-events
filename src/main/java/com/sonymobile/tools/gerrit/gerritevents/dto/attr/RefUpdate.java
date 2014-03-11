/*
 *  The MIT License
 *
 *  Copyright 2012 Hewlett-Packard Development Company, L.P.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package com.sonymobile.tools.gerrit.gerritevents.dto.attr;

import com.sonymobile.tools.gerrit.gerritevents.dto.GerritJsonDTO;
import static com.sonymobile.tools.gerrit.gerritevents.GerritJsonEventFactory.getString;
import net.sf.json.JSONObject;

import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.PROJECT;
import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.REFNAME;
import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.OLDREV;
import static com.sonymobile.tools.gerrit.gerritevents.dto.GerritEventKeys.NEWREV;

/**
 * Represents a Gerrit JSON Reference Updated DTO.
 * @author James E. Blair &lt;jeblair@hp.com&gt;
 */
public class RefUpdate implements GerritJsonDTO {

    private static final String REFS_HEADS = "refs/heads/";
    /**
     * Project path in Gerrit.
     */
    private String project;
    /**
     * Ref name within project.
     */
    private String refName;
    /**
     * Old revision at ref.
     */
    private String oldRev;
    /**
     * New revision at ref.
     */
    private String newRev;

    /**
     * Default constructor.
     */
    public RefUpdate() {
    }

    /**
     * Constructor that fills with data directly.
     * @param json the JSON Object with corresponding data.
     * @see #fromJson(net.sf.json.JSONObject)
     */
    public RefUpdate(JSONObject json) {
        this.fromJson(json);
    }

    @Override
    public void fromJson(JSONObject json) {
        project = getString(json, PROJECT);
        refName = getString(json, REFNAME);
        oldRev = getString(json, OLDREV);
        newRev = getString(json, NEWREV);
    }

    /**
     * Name of project.
     * @return the project.
     */
    public String getProject() {
        return project;
    }

    /**
     * Change name of project.
     * @param project the project.
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * Ref name within project.
     * @return the ref.
     */
    public String getRefName() {
        return refName;
    }

    /**
     * Ref name within project.
     * @param refName the ref.
     */
    public void setRefName(String refName) {
        this.refName = refName;
    }

    /**
     * Old revision.
     * @return the rev.
     */
    public String getOldRev() {
        return oldRev;
    }

    /**
     * Change old revision.
     * @param oldRev the rev.
     */
    public void setOldRev(String oldRev) {
        this.oldRev = oldRev;
    }

    /**
     * New revision.
     * @return the rev.
     */
    public String getNewRev() {
        return newRev;
    }

    /**
     * Change new Revision.
     * @param newRev the rev.
     */
    public void setNewRev(String newRev) {
        this.newRev = newRev;
    }

    @Override
    public int hashCode() {
        //CS IGNORE MagicNumber FOR NEXT 7 LINES. REASON: Autogenerated Code.
        //CS IGNORE AvoidInlineConditionals FOR NEXT 7 LINES. REASON: Autogenerated Code.
        final int prime = 31;
        int result = 1;
        result = prime * result + ((newRev == null) ? 0 : newRev.hashCode());
        result = prime * result + ((oldRev == null) ? 0 : oldRev.hashCode());
        result = prime * result + ((project == null) ? 0 : project.hashCode());
        result = prime * result + ((refName == null) ? 0 : refName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        //CS IGNORE NeedBraces FOR NEXT 28 LINES. REASON: Autogenerated Code.
        //CS IGNORE NoWhitespaceAfter FOR NEXT 28 LINES. REASON: Autogenerated Code.
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RefUpdate other = (RefUpdate) obj;
        if (newRev == null) {
            if (other.newRev != null)
                return false;
        } else if (!newRev.equals(other.newRev))
            return false;
        if (oldRev == null) {
            if (other.oldRev != null)
                return false;
        } else if (!oldRev.equals(other.oldRev))
            return false;
        if (project == null) {
            if (other.project != null)
                return false;
        } else if (!project.equals(other.project))
            return false;
        if (refName == null) {
            if (other.refName != null)
                return false;
        } else if (!refName.equals(other.refName))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RefUpdate: " + getNewRev() + " " + getProject() + " " + getRefName();
    }

    /**
     * Returns the ref (refspec) representing this RefUpdate.
     * @return the ref
     */
    public String getRef() {
        if (refName != null) {
            return REFS_HEADS + refName;
        }
        return null;
    }
}
